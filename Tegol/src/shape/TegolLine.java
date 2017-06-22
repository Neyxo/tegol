package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class TegolLine extends TegolShape{
	
	private int endX;
	private int endY;
	public TegolLine(int x, int y, int endX, int endY, int brushSize, Color color) {
		super(x, y);
		this.endX = endX;
		this.endY = endY;
		this.brushSize = brushSize;
		this.color = color;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(this.getColor());
		g.setStroke(new BasicStroke(this.getBrushSize(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.drawLine(x, y, endX, endY);
	}

}
