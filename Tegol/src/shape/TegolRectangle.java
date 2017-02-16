package shape;

public class TegolRectangle extends TegolShape{
	
	private int width;
	private int heigth;

	public TegolRectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.heigth = height;
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

}
