package scanner;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 입력(console), 앱이나 웹으로 넘어가서는 잘 쓰지 않음
		Scanner scaner = new Scanner(System.in);
		
		/*
		// boolean(true/false)
		
		boolean b;
		
		
		System.out.print("b = ");
		b = scaner.nextBoolean();
		System.out.println("b:" + b);
		*/
		
		
		// int(정수)
		int i;
		System.out.print("i = ");
		i = scaner.nextInt();
		System.out.println("i:" + i);;
		
		
		/*
		// double(소수)
		double d;
		System.out.print("d = ");
		d = scaner.nextDouble();
		System.out.println("d:" + d);
		*/
		
		
		/*
		// String
		String str;
		System.out.print("str = ");
		str = scaner.next();
		System.out.println("str:" + str);
		*/

	}

}
