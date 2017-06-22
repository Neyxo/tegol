package controls;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import info.clearthought.layout.TableLayout;

public class FlatColors extends JPanel{
	ColorPanel[] colorPanels;
	ColorPanel activeColorPanel;
	public FlatColors() {
		this.setLayout(new WrapLayout());
		ColorPanel randomPanel = new ColorPanel(this, new Color(35,35,26));
		randomPanel.setActive(true);
		this.add(randomPanel);
		activeColorPanel = randomPanel;
		Color[] colors = {new Color(255,0,0),new Color(255,255,255),new Color(0,0,255),new Color(55,0,0),new Color(255,25,255),new Color(0,0,25),new Color(25,0,0),new Color(55,255,55),new Color(60,0,255),new Color(25,0,40)};
		for (Color color : colors) {
			ColorPanel colorPanel = new ColorPanel(this, color);
			this.add(colorPanel);
		}
	}

	public void removeActive(ColorPanel colorPanel) {
		activeColorPanel.setActive(false);
		activeColorPanel = colorPanel;
	}

	public ColorPanel getActiveColorPanel() {
		return activeColorPanel;
	}

	public void setActiveColorPanel(ColorPanel activeColorPanel) {
		this.activeColorPanel = activeColorPanel;
	}
}
