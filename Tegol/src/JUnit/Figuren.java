package JUnit;

import java.util.List;

import shape.TegolShape;

public class Figuren {
	  public static void main(String[] args) {
			FigurDAOStub dao = new FigurDAOStub();
			FigurParser fp = new FigurParser(dao);
			List<TegolShape> figuren = fp.parse();
			System.out.println(figuren);
			System.out.println(figuren.get(0).toString());
//			dao.close();
		}
}
