package model;

public class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object po) {
		if(po==this)
			return true;
		
		if(!(po instanceof Point))
			return false;
		
		Point point = (Point)po;
		
		if (this.x == point.x && this.y == point.y)
			return true;
		return false;
	}
}
