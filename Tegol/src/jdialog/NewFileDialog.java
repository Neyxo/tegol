package jdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import zeichnen.TegolMain;

public class NewFileDialog extends JDialog{
	private int intHeight;
	private int intWidth;
	private JTextField height;
	private JTextField width;
	private TegolMain mainFrame;

	public NewFileDialog(TegolMain mainFrame){
		super ();
		this.mainFrame = mainFrame;
		setPreferredSize(new Dimension(600, 400));
        setTitle(getClass().getSimpleName());
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        NewFileDialogActionListener actionListener = new NewFileDialogActionListener(this);
        height = new JTextField();
        height.setPreferredSize(new Dimension(200,20));
        width = new JTextField();
        width.setPreferredSize(new Dimension(200,20));
        JButton button = new JButton("Button");
        
        
        JPanel messagePane = new JPanel();
        messagePane.add(height);
        messagePane.add(width);
        getContentPane().add(messagePane);
        JPanel buttonPane = new JPanel(); 
        buttonPane.add(button); 
        button.addActionListener(actionListener);
        getContentPane().add(buttonPane, BorderLayout.SOUTH);


        pack(); 
        setVisible(true);
	}
	
	public void disposeDialog(){
		dispose();
	}
	
	public int getIntHeight() {
		return intHeight;
	}

	public void setIntHeight() {
		this.intHeight = Integer.parseInt(height.getText());
	}

	public int getIntWidth() {
		return intWidth;
	}

	public void setIntWidth() {
		this.intWidth = Integer.parseInt(width.getText());
	}
	
	public TegolMain getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(TegolMain mainFrame) {
		this.mainFrame = mainFrame;
	}
}
