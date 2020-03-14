package model;

public class House {
	private double area;
	private int floors;
	private House nextH;
	
	public House(double a, int f) {
		area = a;
		floors = f;
	}

	public House getNextH() {
		return nextH;
	}

	public void setNextH(House nxtH) {
		nextH = nxtH;
	}

	public double getArea() {
		return area;
	}

	public int getFloors() {
		return floors;
	}
}
