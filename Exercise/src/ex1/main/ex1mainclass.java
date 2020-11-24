package ex1.main;


import ex1.shape.Circle;
import ex1.shape.Point;
import ex1.shape.Rectangle;
import ex1.shape.Shape;

public class ex1mainclass {

	public static void main(String[] args) {
		
		
		Shape circle = new Circle(3.0);
		System.out.println(circle.calcArea());
		
		Shape rect = new Rectangle(5, 5);
		System.out.println(rect.calcArea());
		System.out.println("정사각형 여부: " + ((Rectangle)rect).isSquare());
		
//		Point p = new Point(10, 12);
//		
//		Shape base = new Shape() {
//		public double calcArea() {
//			return(p.getX() * p.getY()) / 2;
//			
//		}
//			
//		};
//		System.out.println(base.calcArea());

	}

}
