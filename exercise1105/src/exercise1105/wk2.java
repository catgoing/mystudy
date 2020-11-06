package exercise1105;

import java.util.Scanner;

public class wk2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	baseball
		 	
		 	1~10	
		 	
		 	랜덤숫자 3개, 다 다른 숫자로
		 	
		 	입력 숫자 3개, 다 다른 숫자여야 함
		 	기회 10번
		 	
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Baseball 게임!");
		System.out.println("세 가지 다른 숫자를 입력해 주세요(기회 10번)");
		System.out.println();
		int r1, r2, r3;
		int p1, p2, p3;
		int a, b, c;
		int d, e, f;
		int g, h, i;
		String re;
		
		int n;
		boolean t;
		
		
	while(true) {
		
		a=b=c=d=e=f=g=h=i =0;
		t= true;
		n=0;
		
	
		while(true) {
		r1 = (int)(Math.random()*10) +1;
		r2 = (int)(Math.random()*10) +1;
			if(r1==r2) {
				continue;
			}
		r3 = (int)(Math.random()*10) +1;
			if(r3==r2) {
				continue;
			}else if(r3==r1) {
				continue;
			}else {
				break;
			}
		}   // System.out.println(r1+", "+r2+", "+r3); // -> 랜덤으로 정해진 수
		
	while(n<10) {
		
	
		while(true) {
			System.out.println("남은 기회 " + (10-n) + "회");
			System.out.print("(1~10)1번째 숫자 입력 = ");
			p1 = sc.nextInt();
			if(0 < p1 && p1 < 11) {
				p1 = p1;
			}else {
				System.out.println("1~10의 숫자를 입력하세요");
				System.out.println();
				continue;
			}
			System.out.print("(1~10)2번째 숫자 입력 = ");
			p2 = sc.nextInt();
				if(0 < p2 && p2 < 11) {
					//p2 = p2;
				}else {
					System.out.println("1~10의 숫자를 입력하세요");
					System.out.println();
					continue;
				}
				if(p1==p2) {
					System.out.println("각각 다른 숫자를 입력하세요");
					continue;
				}
			System.out.print("(1~10)3번째 숫자 입력 = ");
			p3 = sc.nextInt();
				if(0 < p3 && p3 < 11) {
				//	p3 = p3;
				}else {
					System.out.println("1~10의 숫자를 입력하세요");
					System.out.println();
					continue;
				}
				if(p3==p1) {
					System.out.println("각각 다른 숫자를 입력하세요");
					continue;
				}else if(p3==p2) {
					System.out.println("각각 다른 숫자를 입력하세요");
					continue;
				}else {
					break;
				}
				
			}
	
				if(r1==p1) {
					a = 1;
				}else if(r1==p2) {
					d=1;			
				}else if(r1==p3) {
					d=1;
				}else {
					g=1;
				}
				
				if(r2==p2) {
					b = 1;
				}else if(r2==p1) {
					e=1;			
				}else if(r2==p3) {
					e=1;
				}else {
					h=1;
				}
				
				if(r3==p3) {
					c = 1;
					
				}else if(r3==p1) {
					f=1;
					
				}else if(r3==p2) {
					f=1;
					
				}else {
					i=1;
					
				}
				System.out.println("* " + (a+b+c)+"스트라이크 "+(d+e+f)+"볼 "+(g+h+i)+"아웃입니다");
				if(a+b+c==3) {
					System.out.println("정답입니다");
					break;
				}else {
					System.out.println("다시 도전해보세요");
					
				}
				System.out.println();
				n++;			
			if(n==10) {
				break;
				}
			}
	System.out.println("다시 도전하시겠습니까? (y,n)");
			
		re = sc.next();
		if(re.equals("n")) {
			System.out.println("안녕히 가세요");
			break;
		}else {
			System.out.println("파이팅입니다");
			System.out.println();
		}
		
	}
		
	}

}
