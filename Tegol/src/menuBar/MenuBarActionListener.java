package menuBar;

import java.awt.PageAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

import jdialog.NewFileDialog;
import zeichnen.PicturePanel;
import zeichnen.TegolMain;

public class MenuBarActionListener implements ActionListener{
	
	TegolMain mainFrame;

	public MenuBarActionListener(TegolMain mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		NewFileDialog newFileDialog = new NewFileDialog(mainFrame);
	}
}
