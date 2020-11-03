
public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 논리연산자(true/false)
		
		/*
		 	&&	and
		 	||	or
		 	!	not
		 	제어문과 함께 사용(if, while, do while)
		 		 
		 */
		
		/*
		 	and		0 0 > 0
		 			0 1 > 0
		 			1 0 > 0
		 			1 1 > 1
		 */
		
		int number = 0;
		System.out.println(number >= 0 && number < 10);
		
		/*
		  	or		0 0 > 0
		  			0 1 > 1 
		  			1 0 > 1
		  			1 1 > 1
		  			
		 
		 */
		System.out.println(number > 0 || number < 10);
		System.out.println(number < 10 || number > 30);
		
		/*
		 	not		
		 */
		number = 5;
		System.out.println(number == 5);
		System.out.println(number != 5);
		
		System.out.println(!(number < 5));
		
		System.out.println(!(number > 5 && number > 10));
		// = System.out.println(number <= 5 || number <= 10);
		
		
		// 삼항연산자 = if
		/*
		 	value = (조건) ? 값1:값2 -> 조건이 참이면 값1, 거짓이면 값2가 대입
		 	
		 */
		
		char c;
		c = (number > 0) ? 'y':'n';
		System.out.println(c);
		
		int n;
		n = (number > 10) ? 20:10;
		System.out.println(n);
		
		String str;
		str = (number > 5) ? "number는 5보다 크다":"number는 5보다 작거나 같다";
			System.out.println(str);
		
		
	}

}
