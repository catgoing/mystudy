package forClass;

public class forMainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	loop문,	순환문
		 	지정된 횟수만큼 반복하는 제어문
		 	
		 	* 형식
		 	for(선언or초기화 ; 조건식 ; 연산식){
		 		처리
		 	}
		 	
		 	int num = 0;
		 	num = num + 1;
		 	
		 	* (순서) 2회 조건이 맞는 경우
		 	for(초기화(1) ; 조건식(2)(5)(8) ; 연산식(4)(7)){
		 		처리(3)(6)
		 	}
		 	(9)
		 */

		int n;
		for(n = 8; n<10; n++) {  // n++ or n=n+1
			System.out.println(n);
		}
		System.out.println(n);
		
		int num = 0;
		num = num + 1;
		num = num + 2;
		num = num + 3;
		num = num + 4;
		num = num + 5;
		num = num + 6;
		num = num + 7;
		num = num + 8;
		num = num + 9;
		num = num + 10;
		System.out.println(num);
		
		int num1 = 0;
		for(n =1; n<101; n++) {
			num1 = num1 + n;
		}
		System.out.println(num1);
		
		for(int i=0; i<10; i++) {  // 여기의 i는 루프가 끝나면 이후 main함수에는 적용되지 않음
			System.out.println(i);
		}
		
		for(int i = 10; i>0; i--) {
			System.out.println("i = " + i);
		}
		
		
		for(int i2 = 0; i2 < 10; i2 = i2 + 2) {
			System.out.println("i2 = " + i2);
		} 			
		
		int _num = 0;
		for(	;_num < 10;	) {
			System.out.println("_num = " + _num);
			_num++;
		}

		for(int i = 0, j = 0; i < 10; i++, j++) {
			System.out.println("i = " + i);
			System.out.println("j = " + j);
		}
		
		int n1, n2;
		n1 = 0;
		n2 = 0;
		for(int i = 0; i<10; i++) {
			System.out.println("n1 = " + n1);
			System.out.println("n2 = " + n2);
			n1++;
			n2++;
		}
		
		// 2중 for문
		for(int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
			for(int j = 0; j<5; j++) {
				System.out.println("  j = " + j);
				
			}
		}
		
		
	}

}
