package main;

import java.util.Scanner;

import Student.Student;

public class ex1 {

	public static void main(String[] args) {
		
		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
//		System.out.println("이름:"+s.name);
////		System.out.println(s.kor);
//		System.out.println("총점:"+s.getTotal(s.kor, s.eng, s.math));
//		System.out.println("평균:"+s.getAverage( ) );
//		System.out.println(s.getTotal(s.kor, s.eng, s.math));
		s.getTotal(s.kor, s.eng, s.math);
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println();
		
		
	}

}
