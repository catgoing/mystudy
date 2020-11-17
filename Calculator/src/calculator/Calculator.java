package calculator;

import java.util.Scanner;

public class Calculator {

	// num1, num2, operator
	int num1,num2; // menber 변수
	String oper;
	int result;
	
	public void input() {	// member 메소드
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자: ");
		num1 = sc.nextInt();
		
		System.out.print("연산자: ");
		oper = sc.next();
		
		System.out.print("두 번째 숫자: ");
		num2 = sc.nextInt();
		
	}
	
	public void process() {
		
		switch(oper) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;		
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		}
		
	}
	
	public void result() {
		System.out.println(num1 + " " + oper + " "  + num2 + " = " + result);
	}

}
