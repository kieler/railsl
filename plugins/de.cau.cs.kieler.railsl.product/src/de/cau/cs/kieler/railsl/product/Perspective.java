package de.cau.cs.kieler.railsl.product;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
        // Bottom Row - Left: Project Explorer, Right: Console
        // Top Row - Editor
	    

        String editor = layout.getEditorArea();
        IFolderLayout bottomLeft =
                layout.createFolder("bottomLeft", IPageLayout.BOTTOM, PerspectiveHelper.BIG, editor);

        IFolderLayout bottomRight =
                layout.createFolder("bottomRight", IPageLayout.RIGHT, PerspectiveHelper.SMALL,
                        "bottomLeft");

        PerspectiveHelper.addViewIfExists(bottomRight, PerspectiveHelper.CONSOLE_ID);
        PerspectiveHelper.addViewIfExists(bottomLeft, PerspectiveHelper.PACKAGE_EXPLORER_ID);

        // Activate editor
        layout.setEditorAreaVisible(true);
		layout.setFixed(true);
	}

}
