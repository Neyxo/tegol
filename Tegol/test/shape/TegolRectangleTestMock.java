package shape;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics2D;

import org.junit.Test;

public class TegolRectangleTestMock {
	private Graphics2D g = mock(Graphics2D.class);
	@Test
	public void test() {
		TegolRectangle tr = new TegolRectangle(20, 20, 20, 20, 20, Color.BLACK);
		tr.draw(g);
		verify(g, times(1)).drawRect(20, 20, 20, 20);
	}

}
