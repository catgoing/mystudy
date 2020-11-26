package main;

import java.util.Scanner;

import dao.memberdao;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		memberdao dao = new memberdao();
		
		dao.insert();
		dao.allprint();
		dao.insert();
		dao.allprint();
		
		/*
		Scanner sc = new Scanner(System.in);
		// 메뉴 (view)
		
		while(true) {
			
			System.out.println("1.선수정보 등록");
			System.out.println("2.선수정보삭제");
			System.out.println("3.선수정보 검색");
			System.out.println("4.선수정보 수정");
			System.out.println("5.선수정보 모두 출력");
			System.out.println("6.데이터 저장");
			System.out.println("7.종료");
			System.out.print("어느 작업을 하시겠습니까? = ");
			int num = sc.nextInt();
			
			switch( num ) {
				case 1:
					stDao.insert();
					break;
				case 2:
					stDao.delete();
					break;
				case 3:
					stDao.select();
					break;
				case 4:
					stDao.update();
					break;
				case 5:
					stDao.allprint();
					break;
				case 6:
					stDao.sorting();
					break;
			}
			*/
	}

}
