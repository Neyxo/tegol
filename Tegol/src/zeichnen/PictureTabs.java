package zeichnen;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PictureTabs extends JTabbedPane{
	public void addPicture(PicturePanel picturePanel){
		addTab("Tab", picturePanel);
	}
}
