package variable;

public class mainClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1;	// local variable, 지역변수, auto
		
			
		{
			int num2;	// local variable, 중괄호 안에만 기능
			num1 = 23;		// memory : stack, heap, static, sys 4구역으로 나눌 수 있음
			
		}
		
		num1 = 23;
		// num2 = 23;	에러
		
		// 변수
		// 숫자형
		byte b;		// 1byte
		short sh;	// 2byte
		int i;		// 4byte
		long l = 1241241412412414L;		// 8byte
		
		float f = 123.444F;		// 4byte
		double d;	// 8byte
		
		/*
		 * 	app(window) = web(브라우저)
		 
		 *  관리프로그램 
		 *  oracle <- java -> web	
		 *  				  html, javaScript, css
		 *  				  JSP, Vue, React
		 */
		
		// 문자형
		char c = '가';			// 2byte
		String str = "hello";	// Wrapper class
		// = String str1 = new String("hello");
		
		str = str + " world";
		// = str = str.concat(" world");
		
		// 논리형
		boolean b1 = true;	// 1
		b1 = false;			// 0
		
		
		

	}

}
