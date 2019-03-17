package model;

public class GameBoard {
	int[][] board;
	
	//게임보드 기본생성자
	public GameBoard() {
		this(7);
	}
	
	//게임보드 생성자
	public GameBoard(int num) {
		int idx = 0;
		int[][] gameBoard = new int[num*2-1][];
		
		for(int i=0;i<num*2-1;i++) {
			gameBoard[i] = new int[num+idx];
			if(i<num-1)
				idx++;
			else
				idx--;
		}
		this.board = gameBoard;
		init();
	}
	
	//배열 0으로 초기화
	public void init() {
		for(int[] idx : this.board) {
			for(int idx_ : idx) {
				idx_ = 0;
				//System.out.print(idx_);
			}
			System.out.println();
		}
	}
	
	//게임보드 배열 출력용
	public void debugGameBoardSize() {
		for(int i=0;i<this.board.length;i++) {
			System.out.println(board[i].length);
		}
	}
}
