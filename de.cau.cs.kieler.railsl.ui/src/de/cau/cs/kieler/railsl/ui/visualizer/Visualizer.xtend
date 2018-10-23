/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 * 
 * http://rtsys.informatik.uni-kiel.de/kieler
 * 
 * Copyright ${year} by
 * + Kiel University
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 */
package de.cau.cs.kieler.railsl.ui.visualizer

import de.cau.cs.kieler.simulation.core.DataPool
import de.cau.cs.kieler.simulation.core.Model
import de.cau.cs.kieler.simulation.core.Variable
import de.cau.cs.kieler.railsl.railSL.Statement
import de.cau.cs.kieler.railsl.railSL.TrackStatement
import de.cau.cs.kieler.railsl.railSL.PointStatement
import de.cau.cs.kieler.railsl.railSL.LightStatement
import de.cau.cs.kieler.railsl.extensions.RailSLExtensions
import de.cau.cs.kieler.railsl.compilation.RailSLTransformation
import de.cau.cs.kieler.kivis.ui.views.KiVisView
import org.eclipse.swt.widgets.Display
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.ui.editor.utils.EditorUtils
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.eclipse.jface.text.TextSelection
import org.eclipse.emf.ecore.EObject
import com.google.inject.Inject

import org.eclipse.jface.text.IDocumentListener
import org.eclipse.jface.text.DocumentEvent
import com.google.inject.Injector
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.ui.IPartListener2
import org.eclipse.ui.IWorkbenchPartReference
import org.eclipse.xtend.lib.annotations.Accessors
import de.cau.cs.kieler.railsl.railSL.ContactWaitStatement
import de.cau.cs.kieler.railsl.railSL.ConditionalStatement
import de.cau.cs.kieler.railsl.railSL.ConditionalLine
import de.cau.cs.kieler.railsl.railSL.Block
import java.util.List
import org.eclipse.ui.internal.Workbench

/**
 * Show on-the-fly info about the model being edited.
 * 
 * @author Philip Eumann (peu) - stu121235@mail.uni-kiel.de
 */
class Visualizer {

    /*************************************************************************
     * I N J E C T I O N S ***************************************************
     *************************************************************************/
    // For parsing helpers and speed constants
    @Inject extension RailSLExtensions

    // To determine the EObject generated from a certain cursor position in the XText editor
    @Inject EObjectAtOffsetHelper eObjectAtOffsetHelper

    /*************************************************************************
     * F I E L D S ***********************************************************
     *************************************************************************/
    /**
     * The singleton instance to be used for all behalfs
     */
    private static var Visualizer instance

    /**
     * The editor being currently monitored by the Visualizer
     */
    private var XtextEditor registeredEditor

    /**
     * The currently registered DocumentListener
     */
    @Accessors
    private var IDocumentListener listener

    /**
     * The DataPool object maintained by this object.
     * It is passed to the KVis view whenever updateView is called.
     * 
     * @see Visualizer#updateView
     */
    private var DataPool pool

    /**
     * A basic pool with no statements applied to it.
     * Used as base for cloning.
     */
    private val DataPool emptyPool = createEmptyPool()

    /*************************************************************************
     * C O N S T R U C T O R *************************************************
     *************************************************************************/
    /**
     * Default constructor.
     * Registers listeners to keep track of the currently used XText Editor.
     */
    new() {

        // Default pool with no statements applied
        pool = emptyPool.clone
        
        // Register a ChangeListener to the currently active XText editor, if available
        registerListenerToEditor

        // Register listener to keep track of changing editors
        Display.getDefault.asyncExec(
            new Runnable() {
                @Override
                override void run() {
                    Workbench.getInstance().getActiveWorkbenchWindow().getPartService().addPartListener(
                        new IPartListener2() {

                            @Override
                            override partActivated(IWorkbenchPartReference partRef) {
                                if (partRef.getPart(false).equals(EditorUtils.activeXtextEditor)) {
                                    Visualizer.instance.registerListenerToEditor
                                }
                            }

                            @Override
                            override partBroughtToTop(IWorkbenchPartReference partRef) {
                                // ignore
                            }

                            @Override
                            override partClosed(IWorkbenchPartReference partRef) {
                                if (partRef.getPart(false).equals(Visualizer.instance.getRegisteredEditor)) {
                                    Visualizer.instance.deactivateListener
                                }
                            }

                            @Override
                            override partDeactivated(IWorkbenchPartReference partRef) {
                                if (partRef.getPart(false).equals(Visualizer.instance.getRegisteredEditor)) {
                                    Visualizer.instance.deactivateListener
                                }
                            }

                            @Override
                            override partHidden(IWorkbenchPartReference partRef) {
                                // ignore
                            }

                            @Override
                            override partInputChanged(IWorkbenchPartReference partRef) {
                                // ignore
                            }

                            @Override
                            override partOpened(IWorkbenchPartReference partRef) {
                                // ignore
                            }

                            @Override
                            override partVisible(IWorkbenchPartReference partRef) {
                                // ignore
                            }
                        })
                }
            })
    }

    /**
     * Fill a default data pool with data representing an "empty" track scheme.
     */
    private def DataPool createEmptyPool() {
        val pool = new DataPool()
        val model = new Model()
        model.name = "railway"
        model.pool = pool
        pool.addModel(model)

        // Add tracks at speed 0
        for (constant : RailSLExtensions::constants) {
            model.addVariable(new Variable(constant, 0))
            model.addVariable(new Variable("S0_" + constant, 4))
            model.addVariable(new Variable("S1_" + constant, 4))
            model.addVariable(new Variable("c0_" + constant, 0))
            model.addVariable(new Variable("c1_" + constant, 0))
        }

        // Add points as straight
        for (var i = 0; i < RailSLTransformation::NUM_OF_POINTS; i++) {
            model.addVariable(new Variable("point_" + i, 0))
        }

        // Add lights as off
        for (var i = 0; i < RailSLTransformation::NUM_OF_LIGHTS; i++) {
            model.addVariable(new Variable("light_" + i, "off"))
        }

        return pool
    }

    /**
     * Creates the singleton instance of the Visualizer.
     */
    public static def void initialize(Injector injector) {
        instance = injector.getInstance(Visualizer)
    }

    /*************************************************************************
     * L I S T E N E R S *****************************************************
     *************************************************************************/
    /**
     * Deactivates the IDocumentListener attached to the XtextEditor.
     * 
     * Called by the IPartListener when the active editor is closed or deactivated.
     */
    def void deactivateListener() {
        Display.getDefault.asyncExec(new Runnable() {

            @Override
            override void run() {
                registeredEditor.document?.removeDocumentListener(Visualizer.instance.getListener)
            }

        })
    }

    /**
     * Registers an IDocumentListener to the currently open document in the XTextEditor.
     */
    def void registerListenerToEditor() {

        Display.getDefault.asyncExec(new Runnable() {
            @Override
            override void run() {

                registeredEditor = EditorUtils.activeXtextEditor
                val listener = (new IDocumentListener {

                    @Override
                    override documentAboutToBeChanged(DocumentEvent event) {
                        // ignore
                    }

                    @Override
                    override documentChanged(DocumentEvent event) {
                        Visualizer.instance.updateView
                    }

                })
                registeredEditor?.document?.addDocumentListener(listener)
                Visualizer.instance.listener = listener

            }
        })
    }

    /*************************************************************************
     * U P D A T I N G *******************************************************
     *************************************************************************/
     
    /**
     * Read the current cursor position from the active editor and 
     * display the effects of the currently selected Statement in the KVis View.
     */
    public def void updateView() {

        Display.getDefault().asyncExec(new Runnable() {

            @Override
            override void run() {

                registeredEditor.document.readOnly(new IUnitOfWork<String, XtextResource>() {

                    @Override
                    override exec(XtextResource state) {
                        try {
                            val textSelection = registeredEditor.getSelectionProvider().getSelection() as TextSelection;
                            val object = eObjectAtOffsetHelper.resolveElementAt(state, textSelection.getOffset())
                            updatePool(object)

                            KiVisView.instance?.update(pool, true)

                            return null
                        } catch (Exception e) {
                            e.printStackTrace
                            return null
                        }
                    }
                })
            }
        })
    }

    /**
     * Updates the DataPool according to the object passed as a parameter.
     * 
     * Currently only supports certain kinds of statements.
     * 
     * @param object The EObject generated by the currently selected line in the XText Editor
     */
    def void updatePool(EObject object) {

        // delete previously added variables
        pool = emptyPool.clone()

        val model = pool.getModel("railway");

        // process the EObject passed as a parameter
        if (object instanceof Statement) {
            model.addValues(object as Statement)
//        } else if (object instanceof Block) {
//
//            // For a block, display all statements at once
//            for (statement : (object as Block).statements) {
//                model.addValues(statement)
//            }
//        } else if (object instanceof ConditionalLine) {
//            model.addConditionalLineValues(object as ConditionalLine)
        }
    }

    /**
     * Add data representing the statement to the model.
     * 
     * @param model The model from the DataPool to which the data should be added
     * @param statement The statement to be represented
     */
    def addValues(Model model, Statement statement) {

        if (statement instanceof TrackStatement) {
            model.addTrackValues(statement as TrackStatement)
        } else if (statement instanceof PointStatement) {
            model.addPointValues(statement as PointStatement)
        } else if (statement instanceof LightStatement) {
            model.addLightValues(statement as LightStatement)
        } else if (statement instanceof ContactWaitStatement) {
            model.addContactValue(statement as ContactWaitStatement)
        } else if (statement instanceof ConditionalStatement) {
            model.addConditionalValues(statement as ConditionalStatement)
        }
    }

    /**
     * Add data representing the SetTrackStatement to the model.
     * 
     * @param model The model from the DataPool to which the data should be added
     * @param statement The statement to be represented
     */
    def addTrackValues(Model model, TrackStatement statement) {

        try {
            val direction = statement.parseDirection
            val speed = statement.parseSpeed
            for (segment : statement.segments) {

                var Variable forwardSignal
                var Variable reverseSignal

                var speedVar = new Variable(segment, speed)

                // Determine setting for signals
                if (direction == 1) {
                    if (speed == RailSLExtensions::SPEED_FULL) {
                        forwardSignal = new Variable("S0_" + segment, 1)
                    } else if (speed == RailSLExtensions::SPEED_SLOW) {
                        forwardSignal = new Variable("S0_" + segment, 2)
                    } else {
                        forwardSignal = new Variable("S0_" + segment, 4)
                    }
                    reverseSignal = new Variable("S1_" + segment, 4)
                } else {
                    if (speed == RailSLExtensions::SPEED_FULL) {
                        reverseSignal = new Variable("S1_" + segment, 1)
                    } else if (speed == RailSLExtensions::SPEED_SLOW) {
                        reverseSignal = new Variable("S1_" + segment, 2)
                    } else {
                        reverseSignal = new Variable("S1_" + segment, 4)
                    }
                    forwardSignal = new Variable("S0_" + segment, 4)
                }

                // Add the new variables to the DataPool and log them as newly added 
                model.variables.add(0, forwardSignal)
                model.variables.add(0, reverseSignal)
                model.variables.add(0, speedVar)
            }
        } catch (NullPointerException e) {
            System.out.println("Parsed illegal statement.")
            return
        }
    }

    /**
     * Add data representing the SetPointStatement to the model.
     * 
     * @param model The model from the DataPool to which the data should be added
     * @param statement The statement to be represented
     */
    def addPointValues(Model model, PointStatement statement) {
        try {
            for (index : statement.points) {
                val varName = "point_" + index
                var Variable variable
                for (elem : model.variables) {
                    if (elem.name == varName) {
                        variable = elem
                    }
                }
                variable.value = statement.parsePointSetting
                model.addVariable(variable)
            }
        } catch (NullPointerException e) {
            System.out.println("Parsed illegal statement.")
            return
        }
    }

    /**
     * Add data representing the LightStatement to the model.
     * 
     * @param model The model from the DataPool to which the data should be added
     * @param statement The statement to be represented
     */
    def addLightValues(Model model, LightStatement statement) {

        try { 
            for (index : statement.lights) {
                var Variable variable
                val varName = "light_" + index
                for (elem : model.variables) {
                    if (elem.name == varName) {
                        variable = elem
                    }
                }
                
                variable.value = statement.state
                model.addVariable(variable)
            }
        } catch (NullPointerException e) {
            System.out.println("Parsed illegal statement.")
            return
        }
    }

    /**
     * Add data representing the ContactWaitStatement to the model.
     * 
     * @param model The model from the DataPool to which the data should be added
     * @param statement The statement to be represented
     */
    def addContactValue(Model model, ContactWaitStatement statement) {
        try {
            val varName = "c" + statement.parseContactIndex + "_" + statement.segName
            var Variable variable
            for (elem : model.variables) {
                if (elem.name == varName) {
                    variable = elem
                }
            }
            variable.value = 1
            model.addVariable(variable)
        } catch (NullPointerException e) {
            System.out.println("Parsed illegal statement.")
            return
        }
    }

    /**
     * Add data representing the ConditionalStatement to the model.
     * 
     * @param model The model from the DataPool to which the data should be added
     * @param statement The statement to be represented
     */
    def addConditionalValues(Model model, ConditionalStatement statement) {
        for (line : statement.lines) {
            model.addConditionalLineValues(line)
        }
    }

    /**
     * Add data representing the ConditionalLine to the model.
     * 
     * @param model The model from the DataPool to which the data should be added
     * @param statement The statement to be represented
     */
    def addConditionalLineValues(Model model, ConditionalLine line) {
        try {
            val varName = line.segName + "_C_" + line.parseContactIndex
            var Variable variable
            for (elem : model.variables) {
                if (elem.name == varName) {
                    variable = elem
                }
            }
            variable.value = 1
            model.addVariable(variable)
        } catch (NullPointerException e) {
            System.out.println("Parsed illegal statement.")
            return
        }
    }

    /*************************************************************************
     * G E T T E R S   &   S E T T E R S *************************************
     *************************************************************************/

    /**
     * Returns the currently registered Editor.
     */
    public def XtextEditor getRegisteredEditor() {
        return registeredEditor
    }
    
}
