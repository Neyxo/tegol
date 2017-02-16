package controls;

import javax.swing.JPanel;

public class ControlWest extends JPanel
{
	ControlTabs controlTabs;
	public ControlWest() 
	{
		controlTabs = new ControlTabs();
		controlTabs.setSize(getSize());
		this.add(controlTabs);
	}
	public ControlTabs getControlTabs() {
		return controlTabs;
	}
	public void setControlTabs(ControlTabs controlTabs) {
		this.controlTabs = controlTabs;
	}
}
