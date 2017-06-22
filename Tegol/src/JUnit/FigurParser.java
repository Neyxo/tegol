package JUnit;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import shape.TegolLine;
import shape.TegolOval;
import shape.TegolRectangle;
import shape.TegolShape;

public class FigurParser {
  private FigurDAO dao;

  public FigurParser(FigurDAO dao) {
    this.dao = dao;
  }

  public List<TegolShape> parse() {
    List<TegolShape> figuren = new ArrayList<TegolShape>();
    String[] figurData = dao.readNextFigurData();
    while (figurData != null) {
      String figurTyp = figurData[0];
      int x = Integer.valueOf(figurData[1]);
      int y = Integer.valueOf(figurData[2]);
      switch (figurTyp) {
      case "Rechteck":
        int breite = Integer.valueOf(figurData[3]);
        int hoehe = Integer.valueOf(figurData[4]);
        figuren.add(new TegolRectangle(x, y, breite, hoehe, 20, Color.BLACK));
        break;
      case "Kreis":
        int radius = Integer.valueOf(figurData[3]);
        figuren.add(new TegolOval(x, y, radius * 2, radius *2, 20, Color.BLACK));
        break;
      case "Linie":
        int endx = Integer.valueOf(figurData[3]);
        int endy = Integer.valueOf(figurData[4]);
        figuren.add(new TegolLine(x, y, endx, endy, 20, Color.BLACK));
        break;
      }
      figurData = dao.readNextFigurData();
    }
    return figuren;
  }
}
