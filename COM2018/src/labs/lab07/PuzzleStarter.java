package labs.lab07;

public class PuzzleStarter {

	public static void main(String[] args) {
		SlidePuzzleBoard board = new SlidePuzzleBoard();
		new PuzzleController(board, new PuzzleWriter(board)).play();
	}
}