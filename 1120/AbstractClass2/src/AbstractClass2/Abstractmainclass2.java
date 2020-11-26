package AbstractClass2;

import write.Pencil;
import write.Writer;

public class Abstractmainclass2 {

	public static void main(String[] args) {
		/*
		 	볼펜을 쓸지 연필을 쓸지 모르는 상황
		 	
		 */
		
		Writer w = new Pencil();
		
		MyClass cls = new MyClass(w);
		cls.method();
//		MyClass cls = new MyClass(new Pencil());

	}

}
