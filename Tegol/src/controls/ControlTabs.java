package controls;

import javax.swing.JTabbedPane;

public class ControlTabs extends JTabbedPane{
	ColorControl colorControl = new ColorControl();
	BrushControl brushControl = new BrushControl();
	public ControlTabs() {
		this.add(brushControl);
		this.add(colorControl);
	}
	public BrushControl getBrushControl() {
		return brushControl;
	}
	public void setBrushControl(BrushControl brushControl) {
		this.brushControl = brushControl;
	}
}
