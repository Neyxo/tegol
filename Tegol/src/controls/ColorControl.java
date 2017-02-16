package controls;

import java.awt.Color;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class ColorControl extends JPanel{
	private JColorChooser colorChooser;
	
	public ColorControl() {
		colorChooser = new JColorChooser();
		colorChooser.setColor(Color.WHITE);
		this.setBackground(Color.WHITE);
		this.add(colorChooser);
	}
}
