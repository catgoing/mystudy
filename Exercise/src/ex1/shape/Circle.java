package ex1.shape;

public class Circle extends Shape {

	private double r;
	
	public Circle() {
		
	}
	
	public Circle(double r) {
		this.r = r;
	}

	@Override
	public double calcArea() {
		double c = r * r * Math.PI; // math.pi 대신 3.141592로 적어도 됨
		
		return c;
	}
	

}
