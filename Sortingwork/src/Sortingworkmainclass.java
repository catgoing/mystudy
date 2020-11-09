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
		
		

	}

}
