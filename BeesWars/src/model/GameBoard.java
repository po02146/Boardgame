package model;

import java.util.ArrayList;

public class GameBoard {
	private int[][] board;
	private int num;
	private ArrayList<Point> stickedPoint = new ArrayList<Point>();

	// 게임보드 기본생성자 : 기본값 7임
	public GameBoard() {
		this(7);
	}

	// 게임보드 생성자
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

	// 배열 0으로 초기화
	public void init() {
		for (int[] idx : this.board) {
			for (int idx_ : idx) {
				idx_ = 0;
			}
		}
	}

	// 인접한 행렬 포인트 어레이리스트에 넣음
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

	// 인접좌표 출력
	public void printStickedPoint(Point point) {
		getStickedPoint(new Point(point.x, point.y));
		for (int i = 0; i < stickedPoint.size(); i++) {
			System.out.printf("(%d,%d)\n", stickedPoint.get(i).x, stickedPoint.get(i).y);
		}
	}

	public boolean isStick(Point point, Point point2) {
		getStickedPoint(point);
		if (stickedPoint.contains(point2)) {
			return true;
		}
		return false;
	}

	// 게임보드 디버그용
	@Deprecated
	public void debugGameBoard() {
		System.out.println(isStick(new Point(1, 2), new Point(1, 4)));
	}

	// 덩어리 분류
	// 덩어리 별 최대최소값 반환하는 함수
}


