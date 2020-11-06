package ex;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//입력된 숫자가 정수인지 소수인지 구별
		
		
		Scanner sc = new Scanner(System.in);
		
		int n;
		String str;
		
		System.out.print("입력: ");
		str = sc.next();
		
		//System.out.println(str);
		
		int len = str.length();
		int result = 0;
		boolean b = false;
		for (int i = 0; i < len; i++) {
			char c= str.charAt(i);
			//문자열인 경우
			if((i==0 && c=='.') || (i==str.length()-1) && c=='.') {
				result = 1;
				break;
			}
			
			// '.' 존재 여부
			if(c =='.') {
				result =2;
				break;
			}
			
		switch(result) {
			case 0:
				System.out.println("정수입니다");
				break;
			case 1:
				System.out.println("문자가 포함돼 있습니다");
				break;
			case 2:
				System.out.println("소수입니다");
				break;
		}
			
		
			/*
			 int asccode = (int)c;
			 
			//System.out.println(asccode);
			
			if(asccode==46) {
				b = true;
				break;
			}

		}
		if(b == true) {
			System.out.println("소수입니다");
		}else {
			System.out.println("정수입니다");
		}
		*/
	}
	}
}
