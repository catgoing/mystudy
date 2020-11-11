import java.util.Arrays;
import java.util.Scanner;

public class BaseballFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int rnum[] = null;
		boolean clear;
		
		
		// init
		clear = false;
			// random
		rnum = random();
		System.out.println(Arrays.toString(rnum));
		
		// loop
			// user input
			// finding
			// message
		clear = loop(rnum);
		
		
		// release
			//result
		resultp(clear);
		
		
	}
	
	static int[] random() {
		boolean swit[] = new boolean[10];
		int w = 0, r;
		int rnum[] = new int[3];
		
		while(w < 3) {
			r = (int)(Math.random() * 10);
			if(swit[r] == false) {
				swit[r] = true;
				rnum[w] = r+1;
				w++;
			}
		}
		
		return rnum;
		
	}
	
	static boolean loop(int rnum[]) {
		int strike, ball;
		int unum[] = new int[3];
		boolean clear = false;
		int w=0;
		
		// loop
		while(w <10) {
			
		
		// user input
		userinput(unum);
		
		// find
		strike = strikec(unum, rnum);
		ball = ballc(unum, rnum);
		
		if(strike==3) {
			clear = true;
			break;
		}
		
		// message
		System.out.println(strike + "strike, " + ball + "ball입니다");
		
		w++;
		}
		return clear;
	}
	
	static void userinput(int unum[]) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			for (int i = 0; i < unum.length; i++) {
				System.out.print((i+1) + " 번째 수: ");
				unum[i] = sc.nextInt();
			}
			
			if(unum[0] != unum[1] && unum[2] != unum[1] && unum[0] != unum[2]) {
				break;
			}
			System.out.println("서로 다른 숫자를 입력하세요");
		}
	}
	
	static int strikec(int unum[], int rnum[]) {
		int strike = 0;
		for (int i = 0; i < rnum.length; i++) {
			if(unum[i] == rnum[i]) {
				strike++;
			}
		}
		return strike;
	}
	static int ballc(int unum[], int rnum[]) {
		int ball = 0;
		for (int i = 0; i < rnum.length; i++) {
			for (int j = 0; j < rnum.length; j++) {
				if(unum[i] == rnum[j] && i != j) {
					ball++;
				}
			}
		}
		
		return ball;
	}
	
	static void resultp(boolean clear) {
		if(clear==true) {
			System.out.println("game clear");
		}else {
			System.out.println("game over");
		}
	}
	
}
