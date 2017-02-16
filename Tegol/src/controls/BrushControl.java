package controls;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BrushControl extends JPanel{
	
	private JSpinner sizeSpinner;
	private JSlider sizeSlider;
	private int brushSize = 20;
	
	public BrushControl(){
		sizeSpinner = new JSpinner(new SpinnerNumberModel(20, 1, 300,  1));
		sizeSpinner.addChangeListener(new ChangeListener()
		{
	        @Override
	        public void stateChanged(ChangeEvent e)
	        {
	        	brushSize = (int) sizeSpinner.getValue();
	            sizeSlider.setValue(brushSize);
	            System.out.println(brushSize);
	        }
	    });
		sizeSlider = new JSlider(JSlider.HORIZONTAL, 1, 300, 20);
		sizeSlider.addChangeListener(new ChangeListener()
		{
	        @Override
	        public void stateChanged(ChangeEvent e)
	        {
	        	brushSize = (int) sizeSlider.getValue();
	            sizeSpinner.setValue(brushSize);
	            System.out.println(brushSize);
	        }
	    });
		this.add(sizeSpinner);
		this.add(sizeSlider);
	}

	public int getBrushSize() {
		return brushSize;
	}

	public void setBrushSize(int brushSize) {
		this.brushSize = brushSize;
	}
}
