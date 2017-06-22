package shape;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics2D;

import org.junit.Test;

public class TegolRectangleTest {
private GraphicsStub g = new GraphicsStub();
	@Test
	public void testDraw() {
		TegolRectangle tr = new TegolRectangle(20, 20, 20, 20, 20, Color.BLACK);
		tr.draw(g);
		assertEquals(1, g.numberOfDrawRectCalls);
		assertEquals(20, g.x);
		assertEquals(20, g.y);
		assertEquals(20, g.width);
		assertEquals(20, g.height);
	}

}
