package main;

public class Finalmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//		final:	제약
		//		변수, 메소드, 클래스
		final int max = 10;
		
		int num = max;		

	}

}

final class superclass{ // final을 쓰면 상속을 금지함
	public final void method() {  // final을 쓰면 override 금지함
		
	}
}

//class childclass extends superclass{
//	public void method() {
//			
//	}
//}