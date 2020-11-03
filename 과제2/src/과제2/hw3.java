package 과제2;

import java.util.Scanner;

public class hw3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int num1, num2;
		System.out.print("num1 = ");
		num1 = scan.nextInt();
		
		System.out.print("num2 = ");
		num2 = scan.nextInt();
		
		int temp; 		// buffer(저장 공간)
		
		temp = num1;
		num1 = num2;
		num2 = temp;
		
		System.out.println("num1 = " + num1 + " num2 = " + num2);
		
				

	}

}
