package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.Batter;
import dto.Human;
import dto.Pitcher;

public class Memberdao {
	
	Scanner sc = new Scanner(System.in);
//	private Human player[];
	private List<Human> PL = new ArrayList<Human>();
	int memnum = 1;
	
	public Memberdao() {
		PL.add(new Pitcher(101, "1", 1, 1, 1, 1, 1));
		PL.add(new Pitcher(102, "2", 2, 2, 2, 2, 2));
		PL.add(new Pitcher(203, "3", 3, 3, 3, 3, 3));
		PL.add(new Pitcher(204, "4", 4, 4, 4, 4, 4));
		
	}
	
	public Memberdao(int count) {
//		player = new Human[count];
		
	}
	
	public void insert() {
		int n;
		while(true) {
			boolean b = false;
			System.out.print("투수(1)/타자(2)? ");
			String pos = sc.next();

			for (int i = 0; i < pos.length(); i++) {
				n = (int)pos.charAt(i);
				if(n<47 || n>57) {
					b = false;
					break;
				} else b = true;
			} 
			if(b==false) {
				System.out.println("숫자를 입력하세요");
				continue;
			}else {
				n = Integer.parseInt(pos);
				if(n != 1 && n != 2) {
					System.out.println("투수(1)/타자(2)를 입력해 주세요");
					continue;
				} else break;
			}
			
		}
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("나이: ");
		int age = sc.nextInt();
		
		System.out.print("키: ");
		int height = sc.nextInt();
		
		if(n == 1) {
			
			int numb = 100 + memnum;
			
			System.out.print("승수: ");
			int wins = sc.nextInt();
			
			System.out.print("패배수: ");
			int loses = sc.nextInt();
			
			System.out.print("방어율: ");
			double def = sc.nextDouble();
			
			Pitcher pit = new Pitcher(numb, name, age, height, wins, loses, def);
			PL.add(pit);
			
			memnum++;
			
			
//			PL.add(index, null);
//			PL.add(new Pitcher(numb, name, age, height, wins, loses, def ));
			
		} else {
			int numb = 200 + memnum;
			
			System.out.print("타수: ");
			int hit = sc.nextInt();
			
			System.out.print("안타수: ");
			int anta = sc.nextInt();
			
			System.out.print("타율: ");
			double hitrate = sc.nextDouble();
			
			Batter bat = new Batter(numb, name, age, height, hit, anta, hitrate);
			PL.add(bat);
			
			memnum++;
		}
	
	}
	
	public void delete() {
		System.out.print("지울 대상의 이름? ");
		
		String name = sc.next();
		Human h = null;
		boolean b = true;
		int n = 0;
		for (int i = 0; i < PL.size(); i++) {
			h = PL.get(i);
			if(name.equals(PL.get(i).getName())) {
				b=false;
				n = i;
				break;
				
				
			} 
		}if (b == true) {
			PL.remove(n);
			System.out.println("데이터가 삭제되었습니다");
		}if(b == false) {
			System.out.println("데이터가 없습니다");
		}
			
				
		}
		
	public void select() {
		System.out.print("검색할 대상의 이름? ");
		String name = sc.next();
		Human h = null;
		int n = 0;
		boolean b = false;
		for (int i = 0; i < PL.size(); i++) {
			h = PL.get(i);
			if(name.equals(PL.get(i).getName())) {
				b = true;
				break;
			}

		}if(b == true) {
			System.out.println(h.toString());
		}
		else System.out.println("데이터가 없습니다");
	}
		
	public void update() {
		System.out.print("수정할 대상의 이름? ");
		String name = sc.next();
		
		
	}

	public void Allprint() {
		for (int i = 0; i < PL.size(); i++) {
			System.out.println(PL.get(i));
		}
	}
	
	
	/*
	public void search() {
		String name = sc.next();
		Human h = null;
		int n = 0;
		boolean b = false;
		for (int i = 0; i < PL.size(); i++) {
			h = PL.get(i);
			if(name.equals(PL.get(i).getName())) {
				b = true;
				n = i;
				break;
			}
		}
	}
	*/

}
