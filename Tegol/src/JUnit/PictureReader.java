package JUnit;

import java.util.List;

import shape.TegolShape;

public class PictureReader {

	public static void main(String[] args) {
		FigurFileDAO dao = new FigurFileDAO();
		FigurParser fp = new FigurParser(dao);
		List<TegolShape> shapes = fp.parse();
		System.out.println(shapes);
		dao.close();
	}

}
