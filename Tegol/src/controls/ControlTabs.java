package controls;

import javax.swing.JTabbedPane;

public class ControlTabs extends JTabbedPane{
	ColorControl colorControl = new ColorControl();
	BrushControl brushControl = new BrushControl();
	FlatColors flatColors = new FlatColors();
	public ControlTabs() {
		this.add(brushControl, "Tool");
		this.add(colorControl, "Color");
		this.add(flatColors, "Color2");
	}
	public BrushControl getBrushControl() {
		return brushControl;
	}
	public void setBrushControl(BrushControl brushControl) {
		this.brushControl = brushControl;
	}
	public ColorControl getColorControl() {
		return colorControl;
	}
	public void setColorControl(ColorControl colorControl) {
		this.colorControl = colorControl;
	}
	public FlatColors getFlatColors() {
		return flatColors;
	}
	public void setFlatColors(FlatColors flatColors) {
		this.flatColors = flatColors;
	}
}
