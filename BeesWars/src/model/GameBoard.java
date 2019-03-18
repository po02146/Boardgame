package model;

import java.util.ArrayList;

public class GameBoard {
	private int[][] board;
	private int num;
	private ArrayList<Point> stickedPoint = new ArrayList<Point>();

	// GameBoard Base Constructor = 7
	public GameBoard() {
		this(7);
	}

	// GameBoard Constructor
	public GameBoard(int num) {
		this.num = num;
		int idx = 0;
		int[][] gameBoard = new int[num * 2 - 1][];

		for (int i = 0; i < num * 2 - 1; i++) {
			gameBoard[i] = new int[num + idx];
			if (i < num - 1)
				idx++;
			else
				idx--;
		}
		this.board = gameBoard;
		init();
	}

	// GameBoard Initialize
	public void init() {
		for (int[] idx : this.board) {
			for (int idx_ : idx) {
				idx_ = 0;
			}
		}
	}

	// Put list of Sticked Points into ArrayList
	private ArrayList<Point> getStickedPoint(Point point) {
		int x = point.x;
		int y = point.y;

		stickedPoint.clear();

		if (x <= this.num - 2) {
			stickedPoint.add(new Point(x + 1, y + 1));
			stickedPoint.add(new Point(x + 1, y));
			if (y != 0) {
				if (x != 0)
					stickedPoint.add(new Point(x - 1, y - 1));
				stickedPoint.add(new Point(x, y - 1));
			}
			if (y != board[x].length - 1) {
				if (x != 0)
					stickedPoint.add(new Point(x - 1, y));
				stickedPoint.add(new Point(x, y + 1));
			}
		} else if (x == this.num - 1) {
			if (y != 0) {
				stickedPoint.add(new Point(x - 1, y - 1));
				stickedPoint.add(new Point(x, y - 1));
				stickedPoint.add(new Point(x + 1, y - 1));
			}
			if (y != board[x].length - 1) {
				stickedPoint.add(new Point(x - 1, y));
				stickedPoint.add(new Point(x, y + 1));
				stickedPoint.add(new Point(x + 1, y));
			}
		} else {
			if (y != 0) {
				stickedPoint.add(new Point(x - 1, y));
				stickedPoint.add(new Point(x, y - 1));
				stickedPoint.add(new Point(x + 1, y - 1));
			} else {
				stickedPoint.add(new Point(x - 1, y));
			}
			if (y != board[x].length - 1) {
				stickedPoint.add(new Point(x - 1, y + 1));
				stickedPoint.add(new Point(x, y + 1));
				stickedPoint.add(new Point(x + 1, y));
			} else {
				stickedPoint.add(new Point(x - 1, y + 1));
			}
		}
		return stickedPoint;
	}

	// Print ArrayList
	public void printStickedPoint(Point point) {
		getStickedPoint(new Point(point.x, point.y));
		for (int i = 0; i < stickedPoint.size(); i++) {
			System.out.printf("(%d,%d)\n", stickedPoint.get(i).x, stickedPoint.get(i).y);
		}
	}

	// Get 2 Points and return isSticked
	public boolean isStick(Point point, Point point2) {
		getStickedPoint(point);
		if (stickedPoint.contains(point2)) {
			return true;
		}
		return false;
	}

	public void boardScan() {
		int idx = 0;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j] == 0)
					idx++;
			}
		}
		if(idx == 0) {
			
		}
	}
	
	//return false if it is preoccupied
	public boolean pickPoint(int x, int y, int player) {
		if(board[x][y] != 0) {
			board[x][y] = player;
			return true;
		}
		return false;
	}
	
	// for Debug
	@Deprecated
	public void debugGameBoard() {
		System.out.println(isStick(new Point(1, 2), new Point(1, 4)));
	}
}


