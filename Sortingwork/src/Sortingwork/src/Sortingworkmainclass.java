import java.util.Arrays;
import java.util.Scanner;

public class Sortingworkmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// user 몇 개 정렬할 것인지
		
		// 배열 확보
		
		// 숫자들 입력
		
		// 올림? 내림?
		
		// 정렬
		
		// 출력
		
		int inp;
		String sor;
		
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력: ");
		inp = sc.nextInt();
		
		int arr[] = new int[inp];
		
		
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print((i+1) + "번째 숫자 입력: ");
			arr[i] = sc.nextInt();
			
		}
		
		boolean b = true;
		int temp;
		
		while(b=true) {
			System.out.print("오름차순? 내림차순?:(u/d) ");
			sor = sc.next();
			if(sor.equals("u")) {
				for (int i = 0; i < arr.length-1; i++) {
					for (int j = i+1; j < arr.length; j++) {
						if(arr[i]<arr[j]) {
							temp = arr[i];
							arr[i] = arr[j];
							arr[j] = temp;
						
						}break;
					} break;
				}	break;
			}else if(sor.equals("d")){
				for (int i = 0; i < arr.length-1; i++) {
					for (int j = i+1; j < arr.length; j++) {
						if(arr[i]>arr[j]) {
							temp = arr[i];
							arr[i] = arr[j];
							arr[j] = temp;
						
						}break;
					}break;
				}break;
				
			}
			
			  else {
			 
				System.out.println("다시 입력해주세요");
				continue;
			}
			
			
			
		}b = false;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		/*강사님 풀이
		int number[] = null;
		boolean updown = false;
		
		// 몇 개 정렬?
		int count;
		System.out.print("입력: ");
		count = sc.nextInt();
		
		// 배열확보
		number = new int[count];
		String strNum[] = new String[count];
		
		// 숫자 입력
		int w;
		w=0;
		while(w< number.length) {
			
			System.out.print((w+1) + "번째 수: ");
			strNum[w] = sc.next();
			
			//check 문자인지 숫자인지
			boolean b = false;
			for (int i = 0; i < strNum[w].length(); i++) {
				int asc = (int)strNum[w].charAt(i);
				if(asc<48 || 57<asc) {
					b = true;
					break;
				}
			}
			if(b==true) {
				System.out.println("다시 입력하세요");
				continue;
			}
			
			w++;
		}
	
		System.out.print("오름? 내림?(1/2): ");
		int ud = sc.nextInt();
		if(ud==1) updown = true;
		else updown = false;
		
		// String -> Integer
		for (int i = 0; i < strNum.length; i++) {
			number[i] = Integer.parseInt(strNum[i]);
		}
		
		// 정렬
		for (int i = 0; i < number.length -1; i++) {
			for (int j = i+1; j < number.length; j++) {
				if(updown==true) {
					if(number[i]>number[j]) {//오름
					int temp = number[i];
					number[i] = number[j];
					number[j] = temp;
					}
				}else { 
					if(number[i]<number[j]) { // 내림
					int temp = number[i];
					number[i] = number[j];
					number[j] = temp;
					}
				}
				
			}
			
		}
		for (int n : number) {
			System.out.print(n + " ");
			
		}
		
	}

}
 
		 */

	}

}
