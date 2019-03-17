package model;

public class GameBoard {
	public int[][] GameBoard(int num) {
		int idx = 0;
		int[][] gameBoard = new int[num*2-1][];
		for(int i=0;i<num*2-1;i++) {
			gameBoard[i] = new int[num+idx];
			if(idx<num*2-1) {
				idx++;
			} else {
				idx--;
			}
		}
		return gameBoard;
	}
	
	
}
