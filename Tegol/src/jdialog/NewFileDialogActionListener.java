package jdialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import zeichnen.PicturePanel;

public class NewFileDialogActionListener implements ActionListener{

	NewFileDialog newFileDialog;
	
	public NewFileDialogActionListener(NewFileDialog newFileDialog) {
		this.newFileDialog = newFileDialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		newFileDialog.dispose();
		newFileDialog.setIntHeight();
		newFileDialog.setIntWidth();
		int height = newFileDialog.getIntHeight();
		int width = newFileDialog.getIntWidth();
		PicturePanel picturePanel = new PicturePanel(newFileDialog.getMainFrame(), height, width);
		newFileDialog.getMainFrame().addPictureTab(picturePanel);
	}

}
