package main;

import java.util.Arrays;

import student.Student;

public class Studentmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student stu = new Student();
		stu.setNumber(1);
		stu.setName("홍길동");
		stu.setLan(95);
		stu.setMat(100);
		stu.setEng(85);
		
		String name = stu.getName();
		System.out.println("name: " + name);
		
		String student[][]= {
				{"홍길동", "95", "90", "80"}
		};
		
		Student students[] = new Student[3];
//		Student students1, students2, students3;
		
		students[0] = new Student();
		students[1] = new Student();
		students[2] = new Student();
		
		students[0].setName("홍기똥");
		students[0].setNumber(1);
		students[0].setEng(90);
		students[0].setMat(50);
		students[0].setEng(100);
			

	}

}
