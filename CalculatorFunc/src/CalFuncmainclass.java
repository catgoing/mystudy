import java.util.Scanner;

public class CalFuncmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		int num1, num2, result = 0;
//		String snum1, snum2;
		String op;
		
		num1 = inputNumber("첫");
		/*
		while(true) {
			System.out.print("첫 번째 숫자: ");
			snum1 = sc.next();
			boolean ok = true;
			for (int i = 0; i < snum1.length(); i++) {
				char c = snum1.charAt(i);
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
		*/
		
		op = inputOper();
		
		
		/*
		while(true) {
			System.out.print("+,-,*,/ ?: ");
			op = sc.next();
			
			
			if(op.equals("+") || op.equals("-") || 
					op.equals("*") || op.equals("/")) {
				break;}
			else {
				System.out.println("다시 입력하세요");
			}
			
			
			if(!op.equals("+") && !op.equals("-") && 
					!op.equals("*") && !op.equals("/")){
				System.out.println("다시 입력하세요");
					continue;
					}
			else {
				break;
			}
		}
		*/
		
		num2 = inputNumber("두");
		
		/*
		while(true) {
			System.out.print("두 번째 숫자: ");
			snum2 = sc.next();
			boolean ok = true;
			for (int i = 0; i < snum2.length(); i++) {
				char c = snum2.charAt(i);
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
		
		
		num1 = Integer.parseInt(snum1);
		num2 = Integer.parseInt(snum2);
		*/
		
		result = numberProc(num1, num2, op);
		
		
		/*
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
		*/
		
		System.out.println(num1 +" " + op + " "+ num2 + " = " + result);
		
	
	}
	
	static int inputNumber(String str) {
		Scanner sc = new Scanner(System.in);
		String snum;
		int rnum;
		
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
		rnum = Integer.parseInt(snum);
		return rnum;
	}

	static String inputOper() {
		Scanner sc = new Scanner(System.in);
		String op = "";
		
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
		return op;
	}
	
	static int numberProc(int n1, int n2, String op) {
		int result = 0;
		
		switch(op) {
		case "+": 
			result = n1 + n2;
			break;
		case "-": 
			result = n1 - n2;
			break;
		case "*": 
			result = n1 * n2;
			break;
		case "/": 
			if(n2 !=0) {
			result = n1 / n2;}
			break;
		}
		return result;
	}
	
//	static double nResult(int n1, int n2, double r) {
//		
//	}
	
}
