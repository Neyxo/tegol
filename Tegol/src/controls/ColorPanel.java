package controls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorPanel extends JPanel implements MouseListener{
	private boolean active = false;
	private JLabel activeLabel;
	private FlatColors flatColors;
	private Color color;
	public ColorPanel(FlatColors flatColors, Color color) {
		this.flatColors = flatColors;
		this.color = color;
		this.setPreferredSize(new Dimension(100, 100));
		this.setMinimumSize(new Dimension(50, 50));
		this.setBackground(this.color);
        ImageIcon icon = new ImageIcon("src\\zeichnen\\img\\brush.png");
        activeLabel = new JLabel("", icon, JLabel.CENTER);
        activeLabel.setBackground(new Color(0, 0, 0));
        this.addMouseListener(this);
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
		changeActive();
	}
	private void changeActive() {
		if(active == true){
			this.add(activeLabel);
		}
		else{
			this.remove(activeLabel);
		}
		flatColors.repaint();
		repaint();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(active==false){
			flatColors.removeActive(this);
			this.setActive(true);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// Auto-generated method stub
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
