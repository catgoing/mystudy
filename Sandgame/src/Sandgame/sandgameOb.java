package Sandgame;

import java.util.Scanner;

public class sandgameOb {

	
	/*
	 	숫자 15~100 중 랜덤 수 하나 설정
	 	
	 	유저가 입력할 수 있는 수 : 1~5
	
	 	
	 	
	 */
	
	int ran, inp1;
	String input;
	boolean b = false;
	

	public void rand() {
		ran = (int)((Math.random()*86) +15);
		System.out.println("랜덤숫자가 설정되었습니다(15~100)");
		System.out.println(ran);
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 수(1~5): ");
	while(b==false) {
		
		while(b==false) {
			b = true;
			input = sc.next();
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				int n = (int)c;
				if (n<49 || n>54){
					b = false;
					System.out.println("1~5의 숫자만 입력 가능합니다");
					System.out.print("다음 차례(1~5): ");
					break;
				}
			}if(b==false)	continue;
			break;
		}  inp1 = Integer.parseInt(input);
				if((ran-inp1)>0) {
					ran = ran - inp1;
					System.out.print("다음 차례(1~5): ");
					b=false;
					}
				else {System.out.println("걸리셨습니다");}
	}
		
		
		
	}
	
			
	
	
}
