package main;

public class myclass {
	
	private int membervar;		// 멤버변수
	static int staticvar;		// 정적변수, 전역변수
	
	public void method() {
		int localvar=0;			// 지역변수
		localvar++;
		membervar++;
		staticvar++;
		
		System.out.println("지역변수 " + localvar);
		System.out.println("멤버변수 " + membervar);
		System.out.println("스테틱변수 " + staticvar);
	}
	
	public void func() {
		
	}
		
	public static void staticmethod() {
		System.out.println("staticmethod");
	}
	
	public static myclass getinstance() {
		myclass c = new myclass();
/*
		 	처리1
		 	처리2
		 	처리3
		 	처리4
 */		return c;
	}		

}
