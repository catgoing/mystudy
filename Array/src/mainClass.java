
public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	array : 배열
		 			변수의 확장 기능.
		 			정의: 같은 자료형 변수의 묶음.
		 			관리의 목적
		 			
		 			관리요소: index number = 숫자
		 					0 ~ (n-1) n: 배열의 개수
		 	
		 	int num1, num2, num3, num4, num5;
		  	int num[] = new int[5];
		 	
		 	*형식: 자료형 배열변수명[] = new 자료형[배열의 수];		번지
		 			int array[] = new int[10]; -> array[0]~array[9]
		 							동적할당
		 			정적: static - 정해진 만큼
		 			동적:	 dynamic - 원하는 만큼
		 		
		 	메모리 종류 : 	stack		heap			static		sys
		 				array[]		new int[5]		
		 				메인함수에서	
		 				빠지면 자동 삭제
		 		
		 	초기화 방식:	int num = 12;
		 				
		 				int num;
		 				num = 12; => 이 방식은 안 됨
		 				
		 				int array[] = { 1, 2, 3 };
		 				
		 				int array[];
		 				array = { 1, 2, 3 }; ===> X 
		 				
		 					 	
		 */
		
		int array[] = new int[3];
		// = int []array = new int[3];
		// = int[] array = new int[3];
		
		array[0] = 11;
		array[1] = 22;
		array[2] = 33;
		
		array[2] = array[1] + array[0];  // 연산도 가능
		
		int array1[] = {111, 222, 333};
		/* = int array1[] = new int[3];
		array1[0] = 111;
		array1[1] = 222;
		array1[2] = 333;
		
		int array1[];
		array1 = {111, 222, 333}; ====> X 
		 
		 */
		
		int array2[];
		array2 = new int[5];
		array2[0] = 1;
		
		// int num;
		System.out.println(array2[0]);
		System.out.println(array2[1]);  // 세팅 안 하면 자동으로 0으로 잡음
		
		
		
		int num = 0;   // 일반변수 초기화
		// int array3[] = 0; 이건 불가
		int array3[] = null;  // 배열 초기화, null = 0, = 0x00000000
		
		char charArr[] = {'A','B','C'};
		System.out.println(charArr.length);
		System.out.println(array2.length);
		System.out.println(charArr[2]);
		
		char charArr1[] = new char[5];
		System.out.println(charArr1);   // 빈글자
		charArr1[0] = 'h';
		charArr1[1] = 'e';
		charArr1[2] = 'l';
		charArr1[3] = 'l';
		charArr1[4] = 'o';
		System.out.println(charArr1);  // hello
		
		int io1[] = new int[3];
		System.out.println(io1);   // 빈글자
		io1[0] = '1';
		io1[1] = '2';
		io1[2] = '4';
	
		System.out.println(io1[0] + io1[2]);
		
		
		System.out.println(charArr1[0]);
		System.out.println((int)charArr1[0]);  // ASCII 코드로 변환해서 출력
		
		
		/*
		 * CRUD
		 * READ
		 * DELETE
		 */
		
		
		
		

	}

}
