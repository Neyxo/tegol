package shape;

public class GraphicsStub extends ConcreteGraphics {

	int numberOfDrawRectCalls;
	int x;
	int y;
	int width;
	int height;
	
	@Override
	public void drawRect(int x, int y, int width, int height) {
		numberOfDrawRectCalls++;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

}
