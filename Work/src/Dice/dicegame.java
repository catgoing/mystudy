package Dice;

import java.util.Scanner;

public class dicegame {

	Scanner sc = new Scanner(System.in);
	int dran1, dran2;
	int n, n2, sd;
	int havecoin=20;
	boolean loop = true;
	String batcoin;
	String dice1, dice2;
	
	
	public void dran() {
		System.out.println("랜덤 주사위가 설정되었습니다");
		dran1 = (int)(Math.random()*6 + 1);
		dran2 = (int)(Math.random()*6 + 1);
		sd = dran1 + dran2;
		System.out.println(dran1 + dran2);
	}
	public void batting() {
		
		
		while(true) {
			boolean b = true;
			System.out.print("배팅할 코인을 입력하세요. " + "현재 소지(" +havecoin+"): ");
			batcoin = sc.next();
			for (int i = 0; i < batcoin.length(); i++) {
				char c = batcoin.charAt(i);
				int n1 = (int)c; 
				if(n1<47 || n1>57) {
					
					b = false;
					break;
				} 
				
			} if(b==false) {
				System.out.println("숫자를 입력하세요");
				continue;
			} else {
			n = Integer.parseInt(batcoin);
			} if(b==true && n>havecoin) {
				System.out.println("소지한 코인을 넘었습니다");
				continue;
			} else if(n<1) {
				System.out.println("0보다 큰 수를 입력하세요");
				continue;
			} else break;
		}
		
	}
	
	public void inputnum() {
		
		
		while(true) {
	
			boolean b = true;
			System.out.print("배팅할 숫자를 선택하세요(3~11): ");
			String batnum = sc.next();
			for (int i = 0; i < batnum.length(); i++) {
				char c = batnum.charAt(i);
				int n1 = (int)c; 
				if(n1<47 || n1>57) {
					b = false;
					break;
				}  
			} if(b==false) {
				System.out.println("숫자를 입력하세요");
				continue;
			} else {n2 = Integer.parseInt(batnum);
			} if(n2>11 || n2<3) {
				System.out.println("3~11의 숫자를 입력하세요");
				continue;
			} else break;
		}
	}
	
	public void adj() {
		if(n2==sd) {
			if(n2==3 || n2==11) {
				havecoin = havecoin + (Integer.parseInt(batcoin)*17);
				System.out.println("축하합니다! 코인 "+(Integer.parseInt(batcoin)*18)+"개를 획득하셨습니다.");
				System.out.println("현재 코인: "+ havecoin);
			} else if(n2==4 || n2==10) {
				havecoin = havecoin + (Integer.parseInt(batcoin)*11);
				System.out.println("축하합니다! 코인 "+(Integer.parseInt(batcoin)*12)+"개를 획득하셨습니다.");
				System.out.println("현재 코인: "+ havecoin);
			}else if(n2==5 || n2==9) {
				havecoin = havecoin + (Integer.parseInt(batcoin)*8);
				System.out.println("축하합니다! 코인 "+(Integer.parseInt(batcoin)*9)+"개를 획득하셨습니다.");
				System.out.println("현재 코인: "+ havecoin);
			}else if(n2==6 || n2==8) {
				havecoin = havecoin + (Integer.parseInt(batcoin)*6);
				System.out.println("축하합니다! 코인 "+(Integer.parseInt(batcoin)*7)+"개를 획득하셨습니다.");
				System.out.println("현재 코인: "+ havecoin);
			}else if(n2==7) {
				havecoin = havecoin + (Integer.parseInt(batcoin)*5);
				System.out.println("축하합니다! 코인 "+(Integer.parseInt(batcoin)*6) +"개를 획득하셨습니다.");
				System.out.println("현재 코인: "+ havecoin);
			}
	
		} if(n2 != sd)  {
			havecoin = havecoin - Integer.parseInt(batcoin);
			System.out.println("적중에 실패하셨습니다.");
			System.out.println("현재 코인: "+ havecoin);
		}
		
	}
	
	public void loopgame() {

		
		while(havecoin>0) {
			dran();
			batting();
			inputnum();
			adj();
			dicenumber();
			System.out.print("계속 하시겠습니까? (y/n): ");
			String loopg = sc.next();
			if(loopg.equals("y")) ;
			else if(loopg.equals("n")) {
				System.out.println("게임을 종료합니다");
				break;
			}
			else {
				System.out.print("계속 하시겠습니까? (y/n): ");
			}
			
		
		}
		System.out.println("game over");
	}
	
	public void dicenumber() {
		System.out.println("주사위 넘버: " + dran1 + " / " + dran2);
		System.out.println();
	}

}
