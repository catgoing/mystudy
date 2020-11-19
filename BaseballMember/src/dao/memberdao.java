package dao;

import java.util.Scanner;

import dto.batter;
import dto.human;
import dto.pitcher;

public class memberdao {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 	번호, 이름, 나이, 키
	 	
	 */
	
	private human human[] = null;
	private int memcount;
	
	
	public memberdao() {  // 2. 입력 안 하면 100개로 생성
		human = new human[100];
	}
	
	public memberdao(int count) {  // 1. 카운트를 입력하면 입력한 만큼 배열 생성
		human = new human[count];
	}
	
	public void insert() {	// create
		System.out.print("투수(1) or 타자(2)?: ");
		int pos = sc.nextInt();
		
		System.out.print("number = ");
		int number = sc.nextInt();
		
		System.out.print("name = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("키 = ");
		int height = sc.nextInt();
		
		human h = null;
		if(pos==1) {
			System.out.print("승수: ");
			int win = sc.nextInt();
			System.out.print("패배수: ");
			int lose = sc.nextInt();
			System.out.print("방어율: ");
			double defense = sc.nextDouble();
			
			// 입력받은 자료 바로 입력 방법 1.
			human[memcount] = new pitcher(number, name, age, height, win, lose, defense);
			
			// 입력받은 자료 바로 입력 방법 2.
//			h =  new pitcher(number, name, age, height, win, lose, defense);
			
			
		} else if(pos==2) {
			System.out.print("타수: ");
			int batcount = sc.nextInt();
			System.out.print("안타수: ");
			int hit = sc.nextInt();
			System.out.print("타율: ");
			double hitrate = sc.nextDouble();
			
			human[memcount] = new batter(number, name, age, height, batcount, hit, hitrate);
			h =  new pitcher(number, name, age, height, batcount, hit, hitrate);
			
		}
		
		// 입력받은 자료 바로 입력 방법 2.
//		human[memcount] = h;
		memcount++;
		
	}
	
	public void allprint() {
		for (int i = 0; i < human.length; i++) {
			if (human[i] != null) {
				System.out.println(human[i].toString());
			}
		}
	}
	
	
	
	
	
	/*	
		
//		human pit = new pitcherclass();
//		human bat = new batterclass();
		
		dto.human humanarr[] = new dto.human[20];
		membernum=0;
		
//		humanarr[0] = new pitcherclass(1, "가나1", 100, 90);
//		humanarr[1] = new pitcherclass(2, "가나2", 90, 85);
//		humanarr[2] = new pitcherclass(3, "가나3", 100, 100);
//		humanarr[3] = new pitcherclass(4, "가나4", 100, 90);
//		humanarr[4] = new pitcherclass(5, "가나5", 90, 85);
//		humanarr[5] = new pitcherclass(6, "가나6", 100, 100);
//		humanarr[6] = new pitcherclass(7, "가나7", 100, 90);
//		humanarr[7] = new pitcherclass(8, "가나8", 90, 85);
//		humanarr[8] = new pitcherclass(9, "가나9", 100, 100);
//		humanarr[9] = new pitcherclass(10, "가나10", 100, 100);
//		humanarr[10] = new batterclass(11, "다라1", 100, 100);
//		humanarr[11] = new batterclass(12, "다라2", 100, 100);
//		humanarr[12] = new batterclass(13, "다라3", 100, 100);
//		humanarr[13] = new batterclass(14, "다라4", 100, 100);
//		humanarr[14] = new batterclass(15, "다라5", 100, 100);
//		humanarr[15] = new batterclass(16, "다라6", 100, 100);
//		humanarr[16] = new batterclass(17, "다라7", 100, 100);
//		humanarr[17] = new batterclass(18, "다라8", 100, 100);
//		humanarr[18] = new batterclass(19, "다라9", 100, 100);
//		humanarr[19] = new batterclass(20, "다라10", 100, 100);
	}
	
	public void insert() {	// create
		System.out.print("number = ");
		int number = sc.nextInt();
		
		System.out.print("name = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("키 = ");
		int height = sc.nextInt();
				
//		humanarr[membernum] = new human(number, name, age, height);
		
//		membernum++;
  
	 */
	

}
