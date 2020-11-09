import java.util.Scanner;

public class Studentmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	성적관리 프로그램
		 	
		 	1. 인원 수
		 	2. 입력	(이름, 국어, 수학, 영어)
 			3. 각 학생의 총점수
 			4. 1위 선정
 			5. 과목 별 1등
 			6. 과목 별 뒤에서 1등
 			7. 학생 별 평균
 			8. 이름 입력 -> 성적 출력
		 	
		 */

		Scanner sc = new Scanner(System.in);
		
		int nstu;
		String lan, mat, eng;
		String name;
		
		System.out.print("학생 수?: ");
		nstu = sc.nextInt();
		
		String arr[][] = new String[nstu][4];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print("이름: ");
				name = sc.next();
				
				arr[i][j] = name;
				
			System.out.println("arr[" + i + "]" + "[" + j + "]: " + arr[i][j]);
		
				
			}
				}
		/*for (int i = 0; i < arr.length; i++) { // 0 1 2
			for (int j = 0; j < arr[0].length; j++) { // 0 1 2 3
				arr[arr[0].length * i + j] = arr[i];
			}
		}
		*/
	}

}
