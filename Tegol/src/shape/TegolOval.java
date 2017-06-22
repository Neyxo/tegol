package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class TegolOval extends TegolShape{

	private int width;
	private int heigth;

	public TegolOval(int x, int y, int width, int height, int brushSize, Color color) {
		super(x, y);
		this.width = width;
		this.heigth = height;
		this.brushSize = brushSize;
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(this.getColor());
		g.setStroke(new BasicStroke(this.getBrushSize(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.drawOval(this.getX(), this.getY(), this.getWidth(), this.getHeigth());
	}

}
