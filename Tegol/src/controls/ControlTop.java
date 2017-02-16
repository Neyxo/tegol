package controls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlTop extends JPanel implements MouseListener
{
	private ImageIcon icon;
	private JLabel brush;
	private JLabel spray;
	private JLabel eraser;
	private JLabel cut;
	private JLabel circle;
	private JLabel rectangle;
	private JLabel line;
	private JLabel text;
	private JLabel zoomOut;
	private JLabel zoomIn;
	private JLabel newFile;
	private JLabel saveFile;
	private JLabel loadFile;
	private int selectedTool;
	
	public ControlTop() 
	{
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
		this.setBackground(Color.GRAY);
		
		icon = new ImageIcon("src\\zeichnen\\img\\brush.png");
        brush = new JLabel("", icon, JLabel.CENTER);
        brush.addMouseListener(this);
        
        icon = new ImageIcon("src\\zeichnen\\img\\brush2.png");
        spray = new JLabel("", icon, JLabel.CENTER);
        spray.addMouseListener(this);
        
        icon = new ImageIcon("src\\zeichnen\\img\\rollerbrush.png");
        eraser = new JLabel("", icon, JLabel.CENTER);
        eraser.addMouseListener(this);
        
        icon = new ImageIcon("src\\zeichnen\\img\\spray.png");
        cut = new JLabel("", icon, JLabel.CENTER);
        cut.addMouseListener(this);
        
        icon = new ImageIcon("src\\zeichnen\\img\\squirrel.png");
        circle = new JLabel("", icon, JLabel.CENTER);
        circle.addMouseListener(this);
        
        icon = new ImageIcon("src\\zeichnen\\img\\squirrel.png");
        rectangle = new JLabel("", icon, JLabel.CENTER);
        rectangle.addMouseListener(this);
        
        icon = new ImageIcon("src\\zeichnen\\img\\squirrel.png");
        line = new JLabel("", icon, JLabel.CENTER);
        line.addMouseListener(this);
        
        icon = new ImageIcon("src\\zeichnen\\img\\squirrel.png");
        text = new JLabel("", icon, JLabel.CENTER);
        text.addMouseListener(this);
        
        icon = new ImageIcon("src\\zeichnen\\img\\squirrel.png");
        zoomOut = new JLabel("", icon, JLabel.CENTER);
        zoomOut.addMouseListener(this);
        
        icon = new ImageIcon("src\\zeichnen\\img\\squirrel.png");
        zoomIn = new JLabel("", icon, JLabel.CENTER);
        zoomIn.addMouseListener(this);
        
        icon = new ImageIcon("src\\zeichnen\\img\\squirrel.png");
        newFile = new JLabel("", icon, JLabel.CENTER);
        newFile.addMouseListener(this);
        
        icon = new ImageIcon("src\\zeichnen\\img\\squirrel.png");
        saveFile = new JLabel("", icon, JLabel.CENTER);
        saveFile.addMouseListener(this);
        
        icon = new ImageIcon("src\\zeichnen\\img\\squirrel.png");
        loadFile = new JLabel("", icon, JLabel.CENTER);
        loadFile.addMouseListener(this);
        
        this.add(brush);
        this.add(spray);
        this.add(eraser);
        this.add(cut);
        this.add(circle);
        this.add(rectangle);
        this.add(line);
        this.add(text);
        this.add(zoomOut);
        this.add(zoomIn);
        this.add(newFile);
        this.add(saveFile);
        this.add(loadFile);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(e.getSource() == brush)
		{
			selectedTool = 1;
		}
		else if(e.getSource() == spray)
		{
			selectedTool = 2;
		}
		else if(e.getSource() == eraser)
		{
			selectedTool = 3;
		}
		else if(e.getSource() == cut)
		{
			selectedTool = 4;
		}
		else if(e.getSource() == circle)
		{
			selectedTool = 5;
		}
		else if(e.getSource() == rectangle)
		{
			selectedTool = 6;
		}
		else if(e.getSource() == line)
		{
			selectedTool = 7;
		}
		else if(e.getSource() == text)
		{
			selectedTool = 8;
		}
		else if(e.getSource() == zoomOut)
		{
			selectedTool = 9;
		}
		else if(e.getSource() == zoomIn)
		{
			selectedTool = 10;
		}
		else if(e.getSource() == newFile)
		{
			selectedTool = 11;
		}
		else if(e.getSource() == saveFile)
		{
			selectedTool = 12;
		}
		else if(e.getSource() == loadFile)
		{
			selectedTool = 13;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public int getSelectedTool() {
		return selectedTool;
	}

	public void setSelectedTool(int selectedTool) {
		this.selectedTool = selectedTool;
	}

}
