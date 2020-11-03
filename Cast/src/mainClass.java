
public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		   	자료형 변환이란	int -> short	short -> int로 바꾸는 것
		  
		    우선순위
		  boolean	1		낮음
		    
		  byte		1
		  short		2
		  int		4
		  long		8
		  
		  float		4
		  double	8		높음
		   
		 */
		
		// auto(자동 형변환)	작은 그릇 -> 큰 그릇
		short sh = 10;
		int num;
		
		num = sh;
		System.out.println("num = " + num);
		
		// cast(강제 형변환)
		num = 34;
		sh = (short)num;
		System.out.println("sh = " + sh);
		
		float f;
		long l = 1234572134541L;
		f = l;
		System.out.println("f = " + f);
		
		// E13 = 10의 13제곱
		// E-3 = 10의 3제곱 분의 1, 1/10의 세제곱
		
		l = 1234572134541L;
		double d;
		
		d = l;
		System.out.println("d = " + d);
		
		d = 1.23e-2;
		System.out.println("d = " + d);
		
		double tag;
		int num1, num2;
		num1 = 3;
		num2 = 2;
		
		tag = (double)num1 / num2;
		System.out.println("tag = " + tag);
		
		double g = 12570.12;
		int result;
		result = (int)g;
		g = result;
		
		
		
		

	}

}
