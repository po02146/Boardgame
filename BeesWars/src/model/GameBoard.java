package model;

public class GameBoard {
	int[][] board;
	
	public GameBoard(int num) {
		int idx = 0;
		int[][] gameBoard = new int[num*2-1][];
		for(int i=0;i<num*2-1;i++) {
			gameBoard[i] = new int[num+idx];
			if(i<num-1) {
				idx++;
			} else {
				idx--;
			}
		}
		this.board = gameBoard;
	}
	
	public void debugGameBoard() {
		for(int i=0;i<this.board.length;i++) {
			System.out.println(board[i].length);
		}
	}
}
