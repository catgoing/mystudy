package main;

import java.util.Scanner;

import dao.MemberDao;
import dao.MemberDaoImpl;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MemberDao dao = new MemberDaoImpl();
		
		while(true) {
			System.out.println("1.선수 추가");
			System.out.println("2.선수 삭제");
			System.out.println("3.선수 검색");
			System.out.println("4.선수 수정");
			System.out.println("5.선수 모두 출력");
			System.out.println("6.데이터 저장");
			System.out.println("7.종료");
			
			System.out.print(">> ");
			int work = sc.nextInt();
			
			switch(work) {
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allprint();
					break;
				case 6:
					dao.dataSave();
					break;
				case 7:
					System.exit(0);					
					break;			
			}
		}

	}

}








