package labs.lab09.slidepuzzlegui;

/** SlidePuzzleBoard models a slide puzzle. */ 
public class SlidePuzzleBoard { 
	private PuzzlePiece[][] board;
	
	// 빈칸의 좌표 
	private int emptyRow;
	private int emptyCol;
	// representation invariant: board[empty_row][empty_col] == null
	
	/** Constructor - SlidePuzzleBoard 초기 퍼즐 보드 설정 - 감소하는 순으로 나열 
	 */
	public SlidePuzzleBoard() {
		// size x size 보드 만들기
		board = new PuzzlePiece[4][4];
        int idx = 0;
        // 퍼즐 조각을 정해진 순서대로 넣기
        int[] numbers = {1,2,3,4,5,6,7,8,9,10,13,14,11,12,15,0};
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                board[row][col] = new PuzzlePiece(numbers[idx]);
                idx++;
            }
        }
		board[3][3] = null;
		emptyRow = 3;
		emptyCol = 3;
	}

	/** contents - 현재 퍼즐 조각을 리턴 
    * @return 퍼즐 조각  */
	public PuzzlePiece getPuzzlePiece(int row, int col) { 
		return board[row][col];
	}
	
	/** 이동이 가능하면, 퍼즐 조각을 빈칸으로 이동 
	 * @param w - 이동하기 원하는 퍼즐 조각 
	 * @return 이동 성공하면 true를 리턴하고, 이동이 불가능하면 false를 리턴 */
	public boolean move(int w) { 
		int row, col; // w의 위치 
		// 빈칸에 주변에서 w의 위치를 찾음 
		if (found(w, emptyRow - 1, emptyCol)) {
			row = emptyRow - 1;
			col = emptyCol;
		}
		else if (found(w, emptyRow + 1, emptyCol)) {
			row = emptyRow + 1;
			col = emptyCol;
		}
		else if (found(w, emptyRow, emptyCol - 1)) {
			row = emptyRow;
			col = emptyCol - 1;
		}
		else if (found(w, emptyRow, emptyCol + 1)) {
			row = emptyRow;
			col = emptyCol + 1;
		}
		else
			return false;
		// w를 빈칸에 복사
		board[emptyRow][emptyCol] = board[row][col];
		// 빈칸 위치를 새로 설정하고, w를 제거
		emptyRow = row;
		emptyCol = col;
		board[emptyRow][emptyCol] = null;
		return true;
	}
	
	/** found - board[row][col]에 퍼즐 조각 v가 있는지 확인  */ 
	private boolean found(int v, int row, int col) { 
		if (row >= 0 && row <= 3 && col >= 0 && col <= 3)
			return board[row][col].getFaceValue() == v;
	    else
	    	return false;
	}
}
	
