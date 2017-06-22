package JUnit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

import shape.TegolShape;

public class FigurParserTest {
	
	private FigurDAO dao;
	private FigurParser fp;
	
	@Before
	public void setup(){
		dao = new FigurDAOStub();
		fp = new FigurParser(dao);
	}
	
	@Test
	public void test() {
		List<TegolShape> shapes = fp.parse();
		assertEquals(2, shapes.size());
		assertEquals(30, shapes.get(0).getX());
		assertEquals(30, shapes.get(0).getY());
		assertEquals(30, shapes.get(1).getX());
		assertEquals(30, shapes.get(1).getY());
	}
}
