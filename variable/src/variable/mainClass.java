package variable;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 변수의 종류
		// 숫자형
		// 정수
		byte by;	// 1byte -> 8bit = 256개 숫자   제일 앞자리가 0이면 +(양수), 1이면 -(음수)
		by = -128;  // -128~127
		System.out.println("by = " + by);
		
		short sh;	// 2byte
		sh = 11111;
		System.out.println("sh = " + sh);
		
		int i; 		// 4byte
		i = 1111111111;
		System.out.println("i = " + i);
		
		long l;		// 8byte
		l = 1313131313123123131L;		// 뒤에 대문자L을 붙여서 float인 것을 나타내야 함, 소문자 l도 가능하지만 구별이 힘들어서 되도록 대문자
		System.out.println("l = " + l);
		
		// 소수
		float f;	// 4byte, 소수점 생략으로 오차가 있음
		f = 123.44444555f;		// 뒤에 f를 붙여서 float인 것을 나타내야 함, 대문자 F도 가능
		System.out.println("f = " + f);
		
		double d;	// 8byte, 소수를 나타낼 때 주로 사용
		d = 123.45345351242523;
		System.out.println("d = " + d);
		
		
		// 문자형
		// 문자
		char c;		// 2byte, a~z, A~Z, @#$%^, 한글
		c = 'A';
		System.out.println("c = " + c);
		c = '+';
		System.out.println("c = " + c);
		c = '한';
		System.out.println("c = " + c);
		
		// 문자열
		// 문자 + 문자 = 문자열	Array, String
		String str;
		str = "hello";
		System.out.println("str = " + str);
		
		
		// 논리형(참,거짓)
		boolean b;		// 1byte
		b = true;	// 1
		b = false;	// 0
		
		System.out.println("b = " + b);
		
		
	}

}
