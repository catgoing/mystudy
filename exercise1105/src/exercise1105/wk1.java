package exercise1105;

import java.util.Scanner;

public class wk1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//random number 찾기
		
		/*
		 	1. 랜덤 숫자(1~100)
		 	2. 유저가 입력(1~100)
		 	3. 랜덤숫자와 비교		기회 10번
		 		77  <- 	50입력
		 				너무 작습니다
		 			<-	75입력
	 					너무 작습니다
		 */
		
		Scanner sc = new Scanner(System.in);
		
		/*
		int r, i, n, s;
		n=0;
		s=0;
		int arrNum[]=new int[10];
		
		while(s<9999){
		r =(int)(Math.random() * 100) + 1;
		// System.out.println(r);
		
		
		while(n<10) {
			System.out.print("1~100 중 하나를 입력하세요(남은 기회" + " " + (10-n) + "회): ");
			i=sc.nextInt();
			if(i>100) {
			System.out.println("허용범위 초과");
			continue;
			}
			
			n++;
			if(i>r) {
				System.out.println("너무 큽니다");
			}else if(i<r) {
				System.out.println("너무 작습니다");
			}else if(i==r){
				System.out.println("정답입니다");
				break;
			}else {
			}
		if(n>=10){
			System.out.println("처음부터 다시 시도해보세요");
			s++;}
			
			}
		}
		*/
		
		int r_num, u_num;
		boolean clear;
		int w;
		String replay;
		
		
		
	while(true) {
		
		clear = false;
		w = 0;
		
		// 1. random 수 설정
		r_num = (int)(Math.random() * 100) + 1;
		System.out.println(r_num);
		// 2. 숫자 입력
		
		while(w < 10) {
			
		
			while(true) {
				System.out.print("숫자 입력(1~100): ");
					u_num = sc.nextInt();
				if(u_num>=1 && u_num <=100) {
					break;
				}
				System.out.println("허용범위 초과");
			}
			
			
			
			// 3. 숫자 비교
			int find_num =1;
			
			if(u_num>r_num){
				find_num=1;
			}else if(u_num> r_num){
				find_num=2;
			}else{
				clear = true;
				break;
			}
			
			// 4. 메시지 출력
			switch(find_num){
				case 1: 
					System.out.println("너무 큽니다");
					break;
				case 2: 
					System.out.println("너무 작습니다");
					break;
				
					}
			w++;
			
		}	
		
		// 5. 결과 출력
			if(clear == true) {
				System.out.println("정답입니다");
			}else {
				System.out.println("다시 도전하세요");
			}
		
			while(true) {
			System.out.println("다시 도전하시겠습니까? (y/n)");
			replay = sc.next();
			
			if(replay.equals("n")) {
				System.out.println("안녕히 가세요");
				break;
			}else if(replay.equals("y")) {
				System.out.println("힘내세요");
			}else {
							
			}
			}
		
		}
	}
	
}
