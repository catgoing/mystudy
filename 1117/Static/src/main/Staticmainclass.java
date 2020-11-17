package main;

public class Staticmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
	 	static: 정적
	 	
	 			stack	heap	static	system
	 			지역변수	동적할당	정적영역	
	 	
		 */
		
//		myclass mc = new myclass();
//		mc.method();
		
//		myclass.staticvar = 12;		// static 변수는 생성 안 하고도 호출 가능
		
//		myclass c = new myclass();
//		c.method();
//		c.method();
//		c.method();
//		
//		myclass cl = new myclass();
//		cl.method();
		
		myclass.staticmethod();
		
		myclass aaa = myclass.getinstance();
		
		
		
	}

}
