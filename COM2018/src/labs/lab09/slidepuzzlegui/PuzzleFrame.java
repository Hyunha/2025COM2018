package labs.lab09.slidepuzzlegui;

import java.awt.*;
import javax.swing.*;

public class PuzzleFrame extends JFrame {
	
	private SlidePuzzleBoard board;
	private PuzzleButton[][] buttonBoard;
	
	public PuzzleFrame(SlidePuzzleBoard b) {
		board = b;
		buttonBoard = new PuzzleButton[4][4];
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(4,4));
		for (int row = 0; row < buttonBoard.length; row++)
			for (int col = 0; col < buttonBoard.length; col++) {
				buttonBoard[row][col] = new PuzzleButton(board,this);
				cp.add(buttonBoard[row][col]);
			}
		update();
		setTitle("Slide Puzzle");
		setSize(250,250);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void update() {
		PuzzlePiece pp;
		for (int row = 0; row < buttonBoard.length; row++)
			for (int col = 0; col < buttonBoard.length; col++) {
				pp = board.getPuzzlePiece(row, col);
				if (pp != null)
					buttonBoard[row][col].setText(Integer.toString(pp.getFaceValue()));
				else
					buttonBoard[row][col].setText("");
			}
	}

}