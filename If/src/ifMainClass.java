
public class ifMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	제어문
		 	
		 	*분류
		 	- 조건, 순환
		 	
		 	- 조건
		 		if	
		 			if
		 				else
		 			if
		 			else if
		 			
		 			<, >, <=, >=, ==, !=, &&, ||, !
		 		
		 		switch
		 				case
		 					break
		 	
		 	- 형식
		 			if(조건식(논리)){ 조건식 = true/false
		 				처리
		 			}
		 			if(number > 0){
		 				처리
		 			}
		 			
		 			if(number > 0 && number <= 10 && number != 5){
		 				처리
		 			}
		 			
		 			if(true){
		 			}
		 			
		 			if(조건식){
		 				처리1
		 			}
		 			else{
		 				처리2
		 			}
		 			
		 			if(조건식){
		 				처리1
		 			}
		 			else if(조건식1){
		 				처리2
		 			}
		 			else if(조건식2){
		 				처리3
		 			}
		 				:
		 			else{
		 				처리4
		 			}
		 	
		 	- 순환
		 	- 
		 
		 	
		 			 	
		 */
		
		int number = 6;
		if(number > 5) {
			System.out.println("number는 5보다 크다");
		}
		if(number >= 6) {
			System.out.println("number는 6보다 크거나 같다");
		}
		if(number == 6) {
			System.out.println("number는 6이다");
		}
		if(number !=5) {
			System.out.println("number는 5가 아니다");
		}
		
		if(number>=0 && number<=10) {
			System.out.println("number는 0~10 사이의 숫자이다");
		}
		if(number<5 || number>10) {
			System.out.println("number는 5보다 작거나 10보다 크다");
		}  //  이거는 false이기 때문에 출력되지 않음
		
		if(number > 10) {
			System.out.println("number는 10보다 크다");
		}
		else {
			System.out.println("number는 10보다 작다");
		}
		
		number = 85;
		
		if(number == 100) {
			System.out.println("A+입니다");
		}
		else if(number<100 && number>=90) {
			System.out.println("A입니다");
		}
		else if(number<90 && number>=80) {
			System.out.println("B+입니다");
		}
		else {
			System.out.println("불합격입니다");
		}
		
		
		// 아래는 하나의 조건문
		if(number == 100) 					System.out.println("A+입니다");
		else if(number<100 && number>=90) 	System.out.println("A입니다");
		else if(number<90 && number>=80) 	System.out.println("B+입니다");
		else 								System.out.println("불합격입니다");
		
		if(number == 100) 		System.out.println("A+입니다");
		else if(number>=90) 	System.out.println("A입니다");
		else if(number>=80) 	System.out.println("B+입니다");
		else 					System.out.println("불합격입니다");

		number = 100;  // 1번째 조건에서 처리해버리고 결과가 나와버림, 상위 조건을 먼저 작성할 것
		if(number>=90) 	System.out.println("A입니다");
		else if(number == 100) 	System.out.println("A+입니다");
		else if(number>=80) 	System.out.println("B+입니다");
		else 					System.out.println("불합격입니다");

		
		// 조건문 안의 조건문
		number = 75;
		if(number > 90) {
			
		}
		else if(number > 80) {
			
		}
		else if(number > 70) {
			if(number>=75) {
				System.out.println("합격입니다");
			}
			else {
				System.out.println("다시 해보세요");
			}
		}
		
		boolean b;
		b = false;
		if (b==false) {
			System.out.println("b = false");
		}
		if(!b) {
			System.out.println("b = !b");
		}
		
		b = true;
		if(b) {
			System.out.println("b = true");
		}
		
		/*
		int i = 1;
		if(i) {
			
		}
		*/
		
		
	}

}
