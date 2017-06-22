package JUnit;

public class FigurDAOStub implements FigurDAO {

	private String[] testFiguren = {
			"Rechteck,30,30,30,30",
			"Rechteck,30,30,30,30"
	};
	private int currentFigur = 0;
	
	@Override
	public String[] readNextFigurData() {
		if(currentFigur < testFiguren.length){
		String[] figurData = testFiguren[currentFigur].split(",");
		currentFigur++;
		return figurData;
		}
		return null;
	}

}
