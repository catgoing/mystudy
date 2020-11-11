import java.util.Arrays;
import java.util.Scanner;

public class SortingFuncclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count;
		int number[] = null;
		boolean updown[] = new boolean[1];
		
		// 입력
			// 숫자의 개수
		
			// 동적할당
			// 숫자 입력
				// 숫자인지 체크
			// 오름? 내림?
		
		number = sortinput(updown);
		
		System.out.println(Arrays.toString(number));
		System.out.println("updown = " + updown[0]);
		
		
		// 정렬처리
			// 오름? 내림?
			// 교환
		sorting(number, updown[0]);
		
		// 결과출력
		print(number, updown[0]);
		
	}
	/*
	static int sorting(String arr[]) {
		Scanner sc = new Scanner(System.in);
		
		
		String inp;
		boolean ok = true;
		while(true) {
			inp = sc.next();
			for (int i = 0; i < inp.length(); i++) {
				char c = inp.charAt(i);
				int a = (int)c;
				if(a<47 || a>57) {
					System.out.println("숫자를 입력하세요");
					ok = false;
					break;
				}
			}
			if(ok == true) {
				break;
			}
			
		}
		int n = Integer.parseInt(inp);
		
		
		String arr1[] = new String[n];
		
		
		
		
	}
	*/
	static int[] sortinput(boolean updown[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 개?: ");
		int count = sc.nextInt();
		
		int number[] = new int[count];
		
		
		
			for (int i = 0; i < number.length; i++) {
				while(true) {
				System.out.print((i+1) + "번째 수: ");
				String snum = sc.next();
				boolean b = isnumber(snum);
				if(b==true) {
					number[i] = Integer.parseInt(snum);
				}
				break;
				}
		System.out.println("숫자를 입력하세요");
		}
		
		String ud = "";
		
		while(true) {
			System.out.print("오름(1)/내림(2): ");
			ud = sc.next() ;
			if(ud.equals("1") || ud.equals("2")) {
				break;
			}System.out.println("다시 입력하세요");		
		}
		
		if(ud.equals("1")) updown[0] = true;
		else				updown[0] = false;
		
		return number;
	}
	
	static boolean isnumber(String str) {
		boolean b = true;
		for (int j = 0; j < str.length(); j++) {
			char c = str.charAt(j);
			int asc = (int)c;
			if(asc<48 || asc>57) {
				b=false;
				break;
			}
		}
				return b;
	}
	
	static void sorting(int number[], boolean updown) {
		
		for (int i = 0; i < number.length-1; i++) {
			for (int j = i+1; j < number.length; j++) {
				if(updown==true) {
					if(number[i] > number[j]) {
						swap(number, i, j);
					}
				}
				else {
					if(number[i] < number[j]) {
						swap(number, i, j);
					}
				}
			}
		}
	}
	
	static void swap(int number[], int i, int j) {
		int temp = number[i];
		number[i] = number[j];
		number[j] = temp;
				
	}
	
	static void print(int number[], boolean updown) {
		if(updown) System.out.println("오름");
		else System.out.println("내림");
		
		for (int i = 0; i < number.length; i++) {
			System.out.println("number" + (i+1) + ": " + number[i]);
		}
	}
}
