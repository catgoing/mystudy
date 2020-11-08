import java.util.Scanner;

public class baseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int ran[]; 
		int sel[];
		
		int rn;  // 설정할 랜덤수&입력할 수의 개수
		boolean rns = true; // 랜덤 숫자 입력을 위한
		
		rn=0;
		while(rns=true) {
			System.out.print("설정할 랜덤 수의 개수(1~10): ");
			rn = sc.nextInt();
			if(rn<1 || rn>10) {
				System.out.println("(1부터 10까지의 숫자를 입력)");
			}else {
				break;
				}
		} 
		ran = new int[rn];
		sel = new int[rn];
		boolean swit[] = new boolean[10];
		for (int i = 0; i < swit.length; i++) {
			swit[i] = false;
			//System.out.println("swit[" + i + "] = " + swit[i]);
		}
		
		/*
		for (int i = 0; i < rn; i++) {
			ran[i] = (int)((Math.random()*10)+1);
			System.out.println("ran[" + i + "] = " + ran[i]);	
		}
		*/
		
		int r1, w;
		w = 0;
		
		while(w < ran.length) {
			r1 = (int)(Math.random()*10);
			if(swit[r1] == false) {
				swit[r1] = true;
				ran[w] = r1 + 1;
				w++;
			}
		}
		
		for (int i = 0; i < ran.length; i++) {
			//System.out.println("ran[" + i + "] = " + ran[i]);
		}

		for (int i = 0; i < sel.length; i++) {
			while(i<sel.length) {
			System.out.print("입력(1~10): ");
			sel[i] = sc.nextInt();
			
			if(sel[i]<1 || sel[i]>10) {
				System.out.println("(1부터 10까지의 숫자를 입력)");
			}else {
				//System.out.println("sel[" + i + "] : " + sel[i]);
				break;
				}
			}
			
			// 입력 숫자 안 겹치게, 입력한 숫자를 출력, 판정, 결과 출력
		}
			
		
		
	}

}
