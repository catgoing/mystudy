package exercise1105;

import java.util.Scanner;

public class base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		
			
			// 선언
		int r[]=null;	//	랜덤 3개 저장배열, 1, 3번째 방법
		//int r[] = {1,2,3,4,5, 6,7,8,9,10}; // 2번째 방법
		int u[]=null;	//	입력 3개 저장배열
		boolean cl;
		int strike, ball;
		int loop;
		
		boolean swit[] = new boolean[10];  // 3번째 방법
		
			// TODO: 초기화
		r = new int[3]; //2, 3번째 방법
		u = new int[3];
		cl = false;
		loop = 0;
		for (int i = 0; i < swit.length; i++) {
			swit[i] = false; 	// 스위치 off
		}
		
		

		 	// 1. random 10개 설정
		
		/* 1번째 방법
		while(true) {
			for (int i = 0; i < r.length; i++) {
				r[i] = (int)(Math.random()*10) + 1;
			}
			if(r[0] != r[1] && r[0] != r[2] && r[1] != r[2] && r[2] != r[3]) {
				break;
			}
		}
		*/
		
		/*
		// 2번째 방법 .... 재확인
		int r1, r2;
		
		for (int i = 0; i < 1000; i++) {
			r1 = (int)(Math.random()*10);
			r2 = (int)(Math.random()*10);
			
			int temp = r[r1];
			r[r1] = r[r2];
			r[r2] = temp;
		}
		
		for (int i = 0; i < r.length; i++) {
			System.out.println("r[" + i + "]" + " = " + r[i]);
		}
		*/
		
		
		//3번째 방법
		
		int r1, w;
		w = 0;
		
		while(w< r.length) {
			r1 = (int)(Math.random()*10); 	// 0~9
			if(swit[r1] == false) {
				swit[r1] = true;
				r[w] = r1 + 1;				// 1~10
				w++;
			}
		}
		
		for (int i = 0; i < r.length; i++) {
			System.out.println("r[" + i + "]" + " = " + r[i]);
		}
		
		// r[0]~r[2]
		
			// ---------------------------루프
 	 while(loop<10) {
		 	// 2. TODO: 번호 입력 3개 
		
		while(true) {
		
			w = 0;
			while(w < 3) {
				System.out.print((w+1) + "번째 수: ");
				u[w] = sc.nextInt();
				w++;
			}
			/* // 다른 방법
			if(u[0] != u[1] &&
					u[0] != u[2] &&
					u[2] != u[1]) {
				}
				*/ 
			
			if(u[0] == u[1] ||
					u[0] == u[2] ||
					u[2] == u[1]) {
					System.out.println("각각 다른 숫자를 입력하세요");
					continue;
			}
			break;
			
		}
		 			 			 	
		 	// 3. 판정
	strike = ball = 0;
		// ball
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				if(u[i] == r[j] && i != j) {
					ball++;
				}
			}
		}
		
		
		
		// strike
		for (int i = 0; i < r.length; i++) {
			if(u[i] == r[i])  {
				strike++;
			}
			}
		
		// loop 탈출
		if(strike ==3) {
			cl = true;
			break;
		}
 	 
		 			 	
		 	// 4. 메세지
		System.out.println(strike + "스트라이크 " + ball + "볼입니다");
		loop++;
 	 }
 			// ---------------------------루프
		 	 
		 	// 5. 결과 
		 	 if(cl) {
		 		 System.out.println("게임 클리어");
		 	 }else {
		 		 System.out.println("게임 오버");
		 	 }
		 	 
 	  	 
		

	}

}
