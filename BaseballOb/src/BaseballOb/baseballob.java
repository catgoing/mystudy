package BaseballOb;

import java.util.Arrays;
import java.util.Scanner;

public class baseballob {
	
	int rnum[], unum[];
	int strike, ball;
	boolean clear;
	
	
	public int[] random() {
		boolean swit[] = new boolean[10];
		int w = 0, r;
		rnum = new int[3];
		
		while(w < 3) {
			r = (int)(Math.random() * 10);
			if(swit[r] == false) {
				swit[r] = true;
				rnum[w] = r + 1;
				w++;
			}
		}	
		
		System.out.println( Arrays.toString(rnum) );
		
		return rnum;
	}
	
	

	public void loop() {
		
		unum = new int[3];
		clear = false;
		int w = 0;
		
		// loop
		while(w < 10) {
			// user input
			userInput();
					
			// find
			strike = strikeCheck();
			ball = ballCheck();
			
			if(strike == 3) {
				clear = true;
				break;
			}
		
			// message
			System.out.println(strike + "스트라이크 " + ball + "볼입니다");
			
			w++;
		}
		
		
	}
	
	
	public void userInput() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			for (int i = 0; i < unum.length; i++) {
				System.out.print((i + 1) + "번째 수 = ");
				unum[i] = sc.nextInt();
			}
			
			if(unum[0] != unum[1] 
				&& unum[0] != unum[2] 
					&& unum[1] != unum[2]) {
				break;
			}			
			System.out.println("같은 숫자를 입력하셨습니다. 다시 입력하세요");
		}		
	}



	public int strikeCheck() {
		strike = 0;
		for (int i = 0; i < rnum.length; i++) {
			if(unum[i] == rnum[i]) {
				strike++;
			}
		}
		return strike;
	}
	
	public int ballCheck() {
		ball = 0;
		for (int i = 0; i < rnum.length; i++) {
			for (int j = 0; j < rnum.length; j++) {
				if(unum[i] == rnum[j] && i != j) {
					ball++;
				}
			}
		}
		return ball;
	}



	
	public void resultPrint() {
		if(clear == true) {
			System.out.println("Game Clear!!!");
		}else {
			System.out.println("Game Over~~~");
		}
	}






}
