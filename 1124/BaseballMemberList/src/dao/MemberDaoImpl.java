package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import file.DataProc;

// Data Access Object == back end
public class MemberDaoImpl implements MemberDao{
	Scanner sc = new Scanner(System.in);
	
	private List<Human> list = null;	
	private int memberNumber;	// 1 2 3 4 5 ~	1000, 2000
	
	private DataProc dataProc;
	
	public MemberDaoImpl() {
		list = new ArrayList<Human>();
		
		dataProc = new DataProc("baseballTeam");
		dataProc.createFile();	
		
		dataLoad();		
		 
		 
		if(list.isEmpty()) {
			memberNumber = 1000 + 1;
		}else {
			// list의 마지막 선수의 번호
			memberNumber = list.get( list.size() - 1 ).getNumber();
			if(memberNumber >= 2000) {
				memberNumber = memberNumber - 1000;
			}
			
			memberNumber = memberNumber + 1;
		}
		 
	}

	@Override
	public void insert() {
		System.out.print("투수(1)/타자(2) = ");
		int position = sc.nextInt();
		
		// human
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("신장 = ");
		double height = sc.nextDouble();
		
		if(position == 1) {
			System.out.print("승 = ");
			int win = sc.nextInt();
			
			System.out.print("패 = ");
			int lose = sc.nextInt();
			
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			list.add(new Pitcher(memberNumber, name, age, height, win, lose, defence));			
			
		}else if(position == 2){
			Batter b = new Batter();
			
			b.setNumber(memberNumber + 1000);
			b.setName(name);
			b.setAge(age);
			b.setHeight(height);
			
			System.out.print("타수 = ");
			int batcount = sc.nextInt();
			b.setBatcount(batcount);
			
			System.out.print("안타 수 = ");
			b.setHit( sc.nextInt() );
			
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			b.setHitAvg(hitAvg);

			list.add(b);			
		}
		
		memberNumber++;
		
	}

	@Override
	public void delete() {		
		System.out.print("삭제하고 싶은 선수의 이름 = ");
		String name = sc.next();
		
		int index = search(name);
		
		if(index == -1) {
			System.out.println("선수 명단에 없습니다");
			return;
		}
		
		list.remove(index);
		System.out.println("선수 명단에서 삭제하였습니다");
	}

	@Override
	public void select() {		
		System.out.print("검색하고 싶은 선수 명 = ");
		String name = sc.next();
		
		List<Integer> indexList = searchAll(name);
		
		if(indexList.size() == 0) {
			System.out.println("선수 명단에 없습니다");
			return;
		}
		
		for (int i = 0; i < indexList.size(); i++) {
			Human h = list.get( indexList.get(i) );
			System.out.println(h.toString());
		}		
	}

	@Override
	public void update() {		
		System.out.print("수정하고 싶은 선수의 이름 = ");
		String name = sc.next();
		
		int index = search(name);
		
		if(index == -1) {
			System.out.println("선수 명단에 없습니다");
			return;
		}
		
		Human h = list.get(index);
		if(h instanceof Pitcher) {
			System.out.print("승 = ");
			int win = sc.nextInt();
			
			System.out.print("패 = ");
			int lose = sc.nextInt();
			
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			((Pitcher)h).setWin(win);
			((Pitcher)h).setLose(lose);
			((Pitcher)h).setDefence(defence);
		}
		else if(h instanceof Batter) {
			System.out.print("타수 = ");
			int batcount = sc.nextInt();
			
			System.out.print("안타 수 = ");
			int hit = sc.nextInt();
			
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			
			Batter bat = (Batter)h;
			bat.setBatcount(batcount);
			bat.setHit(hit);
			bat.setHitAvg(hitAvg);			
		}
	}	
	
	@Override
	public void allprint() {
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i);
			if(h.getNumber() < 2000) {
				System.out.print("투수:");
			}else {
				System.out.print("타자:");
			}
			System.out.println(h.toString());
		}		
	}

	private int search(String name) {
		int index = -1;		
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i);
			if(name.equals(h.getName())) {
				index = i;
				break;
			}
		}		
		return index; 
	}
	
	private List<Integer> searchAll(String name) {		
		List<Integer> indexList = new ArrayList<Integer>();		
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i);
			if(name.equals(h.getName())) {
				indexList.add( i );
			}			
		}		
		return indexList;
	}
	

	@Override
	public void dataSave() {		
		// 1001-홍길동-24-180.0-20-1-0.01
		
		String arrStr[] = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i);
			arrStr[i] = h.toString();
		}
		
		dataProc.saveData(arrStr);		
	}

	@Override
	public void dataLoad() {		
		String arrStr[] = dataProc.loadData();
		
		for (int i = 0; i < arrStr.length; i++) {
			/*
				1001-홍길동-24-180.0-10-2-0.2
				2002-일지매-21-179.0-12-4-0.3
				1003-성춘향-16-167.0-21-2-0.12
			*/
			
			String data[] = arrStr[i].split("-");
			int pos = Integer.parseInt(data[0]);
						
			if(pos < 2000) {
				list.add( new Pitcher(
						Integer.parseInt(data[0]), 	// 번호
										data[1], 	// 이름
						Integer.parseInt(data[2]), 	// 나이
						Double.parseDouble(data[3]), // 신장
						Integer.parseInt(data[4]), 	// 승
						Integer.parseInt(data[5]), 	// 패
						Double.parseDouble(data[6]) ) );	// 방어율
			}
			else {
				list.add( new Batter(
						Integer.parseInt(data[0]), 	// 번호
										data[1], 	// 이름
						Integer.parseInt(data[2]), 	// 나이
						Double.parseDouble(data[3]), // 신장
						Integer.parseInt(data[4]), 	// 타수
						Integer.parseInt(data[5]), 	// 안타 수
						Double.parseDouble(data[6]) ) );	// 타율				
			}			
		}		
	}
}











