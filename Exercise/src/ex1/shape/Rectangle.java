package ex1.shape;

public class Rectangle extends Shape {

	private int width;
	private int height;
	
	public Rectangle() {
	
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double calcArea() {
		return width * height;
	}
	
	public boolean isSquare() {
		if(width == height) {
			return true;
		}
		return false;
	} 
}
