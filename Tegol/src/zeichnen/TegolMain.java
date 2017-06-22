package zeichnen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controls.ControlTop;
import controls.ControlWest;
import menuBar.MenuBar;

public class TegolMain extends JFrame
{

	public static JFrame zeichnen;
	private static int screenHeight;
	private static int screenWidth;
	private MenuBar menuBar;
	private ControlTop controlTop;
	private ControlWest controlWest;
	public PictureTabs pictureTabs;
	private JSplitPane centerSplit;
	private JSplitPane mainSplit;
	
	public TegolMain() 
	{
		//Hier könnte später direkt ein Bild geöffnet werden
	}
	
	public void addPictureTab(PicturePanel picturePanel){
		pictureTabs.addPicture(picturePanel);
	}

	public ControlTop getControlTop() {
		return controlTop;
	}

	public void setControlTop(ControlTop controlTop) {
		this.controlTop = controlTop;
	}

	public ControlWest getControlWest() {
		return controlWest;
	}

	public void setControlWest(ControlWest controlWest) {
		this.controlWest = controlWest;
	}
	
	public void openMainWindow(){
		screenWidth = screenWidth + GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDisplayMode().getWidth();
		screenHeight = screenHeight + GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDisplayMode().getHeight();
		
		this.setBounds(0,0,screenWidth / 2, screenHeight / 2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		pictureTabs = new PictureTabs();
		pictureTabs.addPicture(new PicturePanel(this));
		menuBar = new MenuBar(this);
		menuBar.setPreferredSize(new Dimension(0, 15));
		controlTop = new ControlTop();
		controlTop.setPreferredSize(new Dimension(0, 50));
		controlWest = new ControlWest();
		controlWest.setPreferredSize(new Dimension(650,0));	
		
		centerSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, controlTop, pictureTabs);
		centerSplit.setDividerSize(2);
		centerSplit.setBorder(null);
		centerSplit.setEnabled(false);
		
		mainSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, controlWest, centerSplit);
		mainSplit.setDividerSize(8);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.add(menuBar, BorderLayout.NORTH);
		this.add(mainSplit, BorderLayout.CENTER);
		this.setVisible(true);
		this.repaint();
	}

}
