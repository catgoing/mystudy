package calculator2;

import java.util.Scanner;

public class Calculator2 {
	
	int num1, num2, result;
	String op;
	
	public int inputNumber(String str) {
		Scanner sc = new Scanner(System.in);
		String snum;
				
		while(true) {
			System.out.print(str + " 번째 숫자: ");
			snum = sc.next();
			boolean ok = true;
			for (int i = 0; i < snum.length(); i++) {
				char c = snum.charAt(i);
				int asc = (int)c;
				if(asc<48 || asc>57) {
					System.out.println("숫자를 입력하세요");
					ok = false;
					break;
				}
			}
			if(ok == true) {
				break;
			}
		}
		return Integer.parseInt(snum);
		
	}

	
	public void inputOper() {
		Scanner sc = new Scanner(System.in);
				
		while(true) {
			System.out.print("+,-,*,/ ?: ");
			op = sc.next();
			
			
			if(!op.equals("+") && !op.equals("-") && 
					!op.equals("*") && !op.equals("/")){
				System.out.println("다시 입력하세요");
					continue;
					}
			else {
				break;
			}
		}

	}

	public void numberProc() {
				
		switch(op) {
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
			if(num2 !=0) {
			result = num1 / num2;}
			break;
		}
		
	}

	public void resultp() {
		
		num1 = inputNumber("첫");
		inputOper();
		num2 = inputNumber("두");
		numberProc();
		System.out.println(num1 +" " + op + " "+ num2 + " = " + result);
	}


}
