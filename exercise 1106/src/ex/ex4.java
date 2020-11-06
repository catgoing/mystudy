package ex;

import java.util.Scanner;

public class ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		int num;
		int num1;
				
		System.out.println("피보나치 수열 추출기");
		System.out.print("n번째 피보나치 수열의 값: ");
		num = sc.nextInt();
		
		int array[] = new int[999999];
		array[0] = 1;
		array[1] = 1;
		
		if(num==1) {
			System.out.println(array[0]);
		}else if(num==2) {
			System.out.println(array[1]);
		}else {
			for (int i = 2; i < array.length; i++) {
				array[i] = array[(i-1)] + array[(i-2)]; 
				//System.out.println("array[" + i + "]: " + array[i]);
			}System.out.println(array[(num-1)]);
		
		/*
		System.out.print("입력: ");
		num1 = sc.nextInt();
		*/
		
	}

	}
}

