/**
 * generated by Xtext 2.37.0
 */
package de.cau.cs.kieler.railsl.railSL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Point Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.cau.cs.kieler.railsl.railSL.PointStatement#getPoints <em>Points</em>}</li>
 *   <li>{@link de.cau.cs.kieler.railsl.railSL.PointStatement#getOrientation <em>Orientation</em>}</li>
 * </ul>
 *
 * @see de.cau.cs.kieler.railsl.railSL.RailSLPackage#getPointStatement()
 * @model
 * @generated
 */
public interface PointStatement extends SetStatement
{
  /**
   * Returns the value of the '<em><b>Points</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Points</em>' attribute list.
   * @see de.cau.cs.kieler.railsl.railSL.RailSLPackage#getPointStatement_Points()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getPoints();

  /**
   * Returns the value of the '<em><b>Orientation</b></em>' attribute.
   * The literals are from the enumeration {@link de.cau.cs.kieler.railsl.railSL.PointOrientation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Orientation</em>' attribute.
   * @see de.cau.cs.kieler.railsl.railSL.PointOrientation
   * @see #setOrientation(PointOrientation)
   * @see de.cau.cs.kieler.railsl.railSL.RailSLPackage#getPointStatement_Orientation()
   * @model
   * @generated
   */
  PointOrientation getOrientation();

  /**
   * Sets the value of the '{@link de.cau.cs.kieler.railsl.railSL.PointStatement#getOrientation <em>Orientation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Orientation</em>' attribute.
   * @see de.cau.cs.kieler.railsl.railSL.PointOrientation
   * @see #getOrientation()
   * @generated
   */
  void setOrientation(PointOrientation value);

} // PointStatement
