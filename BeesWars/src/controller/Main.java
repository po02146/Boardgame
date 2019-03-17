package controller;

import model.GameBoard;

public class Main {
	public static void main(String[] args) {
		GameBoard board = new GameBoard();
		board.init();
		board.debugGameBoard();
	}
}
