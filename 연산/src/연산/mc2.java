package 연산;

import java.util.Scanner;

public class mc2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scaner = new Scanner(System.in);
		
		
		/*
		int num1, num2;
		System.out.print("가격 = ");
		num1 = scaner.nextInt();
		System.out.print("가진 돈 = ");
		num2 = scaner.nextInt();
		System.out.println(num2 - num1);
		
		
		int num4, num5, num6, num7, num8, num9;
		int result1, result2, result3, result4, result5, result6, result7, result8, result9, result10, result11, result12;
		
		result1 = num2 - num1;
		System.out.println("거스름돈");
		

		num4 = 5000;
		num5 = 1000;
		num6 = 500;
		num7 = 100;
		num8 = 50;
		num9 = 10;
		
		result2 = result1 / num4;
		System.out.println("5천원권 " + result2 + "장");
		result3 = result1 % num4;
		result4 = result3 / num5;
		System.out.println("천원권 " + result4 + "장");
		result5 = result3 % num5;
		result6 = result5 / num6;
		System.out.println("오백원 " + result6 + "개");
		result7 = result5 % num6;
		result8 = result7 / num7;
		System.out.println("백원 " + result8 + "개");
		result9 = result7 % num7;
		result10 = result9 / num8;
		System.out.println("오십원 " + result10 + "개");
		result11 = result9 % num8;
		result12 = result11 / num9;
		System.out.println("십원 " + result12 + "개");
		*/
		
		
		// ===========
		// 변수의 선언
		int money; // 소지금
		int price; // 가격
		
		System.out.println("가격: ");
		price = scaner.nextInt();
				
		System.out.println("소지금: ");
		money = scaner.nextInt();
		
		int change; // 거스름돈
		
		// money = 10000;
		// price = 3230;
		
		// 거스름돈
		change = money - price;
		
		// 화폐단위
		// 5000원
		int m5000 = change / 5000;
		
		// 1000원
		int m1000 = (change % 5000) / 1000;
		
		// 500원
		int m500 = (change % 1000) / 500;
		
		// 100원
		int m100 = (change % 500) / 100;
		
		// 50원
		int m50 = (change % 100) / 50;
		
		// 10원
		int m10 = (change % 50) / 10;
		
		// 결과출력
		System.out.println("거스름돈 : " + change);
		System.out.println("5000원 : " + m5000);
		System.out.println("1000원 : " + m1000);
		System.out.println("500원 : " + m500);
		System.out.println("100원 : " + m100);
		System.out.println("50원 : " + m50);
		System.out.println("10원 : " + m10);
		
		
			
		
		
		
	

	}

}
