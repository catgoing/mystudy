package ex2;

public class Point3D {
	int x, y, z;
	
	public Point3D(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
		}
	
	public Point3D() {
		this(0,0,0);
	}
	public boolean equals(Object obj) {
		
		Point3D pos = (Point3D)obj;
		if(this.x == pos.x && this.y == pos.y && this.z == pos.z) {
			return true;
		}
		return false;
		
	}
	
//	public String toString() {
//		 /*
//		 (2) 인스턴스변수 x, y, z의 내용을 출력하도록 오버라이딩하시오.
//		 */
//		if(true) {
//			
//		} else
//		
//		}
//	}
			
}
