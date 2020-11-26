package main;

import cls.Ballpen;
import cls.MyClass;
import cls.Pencil;
import cls.WriterClass;
import inter.MyInterface;
import inter.WriteMode;

public class Interfacemainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
			abstract class:	추상메소드 + 일반메소드
			interface: 	메소드가 선언만 되어 있다
						단독 생성은 불가능. 상속 후에 정의를 한 후 생성 가능
						변수 선언 불가
						다중상속이 가능(원래 자바에서는 다중상속이 불가)
 
		 */
		
		MyClass mycls = new MyClass();	// 1
		mycls.method();
		mycls.func();
		
		MyInterface myint = new MyClass(); // 2		// 1이나 2나 거의 비슷함
			myint.method();
			myint.func();
			
		MyInterface inter = new MyInterface() { // 이렇게 바로 생성하는 것도 가능 다 같은 것
			
			@Override
			public void method() {
				System.out.println("Myclass method()");
				
			}
			
			@Override
			public void func() {
				System.out.println("Myclass func()");
				
			}
		};
		
		WriterClass wc = new WriterClass();
		wc.writerMethod(new Ballpen());
		wc.writerMethod(new Pencil());
		
		WriteMode mode[] = new WriteMode[5];
		
		mode[0] = new Pencil();
		mode[1] = new Ballpen();
		mode[2] = new Ballpen();
		mode[3] = new Pencil();
		mode[4] = new Pencil();
		
		for (int i = 0; i < mode.length; i++) {
			wc.writerMethod(mode[i]);
		}
				

	}

}
