package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

public class TegolObject extends TegolShape{
	
	private BufferedImage object;

	public TegolObject(int height, int width, int brushSize, Color color) {
		super(0, 0, brushSize, color);
		object = new BufferedImage(width, height, Transparency.BITMASK);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(this.getColor());
		g.setStroke(new BasicStroke(this.getBrushSize(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.drawImage(object, null, this.getX(), this.getY());
	}

	public BufferedImage getObject() {
		return object;
	}

	public void setObject(BufferedImage object) {
		this.object = object;
	}
}
