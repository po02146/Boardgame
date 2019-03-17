package model;

public class GameBoard {
	private int[][] board;
	
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
			//System.out.println();
		}
	}
	
	//게임보드 배열 출력용
	public void debugGameBoard() {
		for(int i=0;i<this.board.length;i++) {
			for(int j=0;j<this.board[i].length;j++) {
				System.out.printf("%2d,%2d ",i,j);
			}
			System.out.println();
		}
	}

	public boolean isStick(int a, int b, int c, int d) {
		if(Math.abs(a-c)<=1 && Math.abs(b-d)<=1 && (a-c)*(b-d)>=0) {
			return true;
		}
		return false;
	}
	
	//덩어리 분류
	
	//덩어리 별 최대최소값 반환하는 함수
}


