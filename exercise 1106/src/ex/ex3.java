package ex;

import java.util.Scanner;

public class ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 입력된 소문자를 모두 대문자로
		/*
		Scanner sc = new Scanner(System.in);
		
		String str;
		System.out.print("입력: ");
		str = sc.next();
		
		String upstr = str.toUpperCase();
		System.out.println(upstr);
		*/
		
		String str = "absDEF";
		String result = "";
		
		for (int i = 0; i < str.length(); i++) {
			int asc = (int)str.charAt(i);
			if(asc>=65 && asc<=90) {
				result = result + (char)asc;
			}else {
				asc = asc - 32;
				result = result + (char)asc;
			}
		}
		
		System.out.println("원본: " + str);
		System.out.println("결과: " + result);
		

	}

}
