package ex;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	입력된 문자열이 모두 숫자인지 확인
		 	
		 	String "12345" 모두 숫자입니다
		 			"123a34" 숫자가 아닙니다
		
		 */
		
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		
		System.out.print("입력: ");
		str = sc.next();
		
		// 문자열의 길이 > 한 문자씩 끌어내기 위해
		int len = str.length();
		
		boolean b = false;
		for (int i = 0; i < len; i++) {
			char c= str.charAt(i);
			int asccode = (int)c;
			//System.out.println(asccode);
			
			if(asccode<48 || asccode>57) {//숫자인 경우
				b = true;
				break;
			}
		}
		if(b == true) {
			System.out.println("숫자가 아닌 게 있습니다");
		}else {
			System.out.println("모두 숫자입니다");
		}
		
		
		
		/*
		boolean b;
		int num;
		b = true;
		
		if(b == true) {
			num = Integer.parseInt(str);
			System.out.println("모두 숫자입니다");	
		}else {
			System.out.println("숫자가 아닌 게 있습니다");
		}
		*/


	}

}
