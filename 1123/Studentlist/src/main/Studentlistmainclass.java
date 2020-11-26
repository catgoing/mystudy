package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.Studentdao;
import student.Student;

public class Studentlistmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		Studentdao std = new Studentdao();
		
		while(true) {
			System.out.println("1. 학생정보 추가");
			System.out.println("2. 학생정보 삭제");
			System.out.println("3. 학생정보 검색");
			System.out.println("4. 학생정보 수정");
			System.out.println("5. 학생정보 모두 출력 수정");
			System.out.println("6. 영어 점수의 순위");
			System.out.println("7. quit");
			System.out.print("어느 작업?: ");
			int num = sc.nextInt();
			
			switch(num) {
				case 1:
					std.insert();
					break;
				case 2:
					std.delete();
					break;
				case 3:
					std.select();
					break;
				case 4:
					std.update();
					break;			
				case 5:
					std.allprint();
					break;
				case 6:
					std.sorting();
					break;
			}
			
		
		}
			

	}

}
