package zeichnen;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

public class PictureTabsActionHandler implements ActionListener {
	
	JTabbedPane tabPane;

    public PictureTabsActionHandler(PictureTabs pictureTabs) {
		tabPane = pictureTabs;
	}

	public void actionPerformed(ActionEvent evt) {

        Component selected = tabPane.getSelectedComponent();
        if (selected != null) {
            tabPane.remove(selected);
        }

    }

}