package menuBar;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.MenuItem;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import zeichnen.TegolMain;

public class MenuBar extends JMenuBar{
	
	JMenuItem newMenuItem;

	public MenuBar(TegolMain mainFrame){
//		this.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
	    JMenu menu = new JMenu("File");
	    this.add(menu);
	    
	    newMenuItem = new JMenuItem("New");
	    MenuBarActionListener menuBarActionListener = new MenuBarActionListener(mainFrame);
	    newMenuItem.addActionListener(menuBarActionListener);
	    menu.add(newMenuItem);
	    
	    menu.add(new JSeparator());
	    
	    menu.add(new JMenuItem("Open"));
//	    setJMenuBar(bar);
	    setSize(300, 300);
	    setVisible(true);
	}
}
