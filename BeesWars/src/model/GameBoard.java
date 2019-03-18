package model;

import java.util.ArrayList;

public class GameBoard {
	private int[][] board;
	private int num;
	private ArrayList<Point> stickedPoint = new ArrayList<Point>();
	
	//게임보드 기본생성자 : 기본값 7임
	public GameBoard() {
		this(7);
	}
	
	//게임보드 생성자
	public GameBoard(int num) {
		this.num = num;
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
			//System.out.println();
		}
	}
	
	public void getStickedPoint(int x, int y) {
		stickedPoint.clear();
		if(y <= this.num-2) {
			stickedPoint.add(new Point(x+1,y+1));
			stickedPoint.add(new Point(x+1,y));
			if(y!=0) {
				stickedPoint.add(new Point(x-1,y-1));
				stickedPoint.add(new Point(x,x-1));
			}
			if(y!=board[x].length-1) {
				stickedPoint.add(new Point(x,x+1));
				stickedPoint.add(new Point(x-1,y));
			}
		}
	}
	
	//게임보드 디버그용
	@Deprecated
	public void debugGameBoard() {
		for(int i=0;i<this.board.length;i++) {
			for(int j=0;j<this.board[i].length;j++) {
				System.out.printf("%2d,%2d ",i,j);
			}
			System.out.println();
		}
	}

	//입력받은 두 좌표의 값이 보드에서 인접한지 반환함
	@Deprecated
	public boolean isStick(int a, int b, int c, int d) {
		return false;
	}
	
	//덩어리 분류
	//덩어리 별 최대최소값 반환하는 함수
}

class Point {
	int x;
	int y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

