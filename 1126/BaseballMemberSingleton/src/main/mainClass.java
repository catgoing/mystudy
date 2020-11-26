package main;

import java.util.Scanner;

import dao.MemberDao;
import dao.impl.AllprintCls;
import dao.impl.DeleteCls;
import dao.impl.InsertCls;
import dao.impl.SelectCls;
import dao.impl.UpdateCls;
import data.DataLoad;
import data.DataSave;

public class mainClass {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DataLoad load = new DataLoad("baseballTeam");
		load.proc();
		
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
			
			MemberDao dao = null;
			
			switch(work) {
				case 1:
					dao = new InsertCls();					
					break;
				case 2:
					dao = new DeleteCls();
					break;
				case 3:
					dao = new SelectCls();
					break;
				case 4:
					dao = new UpdateCls();
					break;
				case 5:
					dao = new AllprintCls();
					break;
				case 6:
					dao = new DataSave("baseballTeam");
					break;
				case 7:
					System.exit(0);					
					break;			
			}
			
			dao.proc();
		}
		
	}
}
