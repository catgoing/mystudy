import java.util.Arrays;
import java.util.Scanner;

public class Studentteacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		String student[][] = null; 	/* {
				{"가나다", "90", "100", "85"} // row
		};
		*/
		int sum;
		double avg;
		int max, min;
			
			// 초기화
		sum=0;
		
		// 1. 몇 명의 학생?
		System.out.print("몇 명?: ");
		int count = sc.nextInt();
		
		student = new String[count][4];
		
		
		
		// 2. 입력: 이름, 국어, 수학, 영어				CRUD
											// 	Create, Read, Update, Delete
		
		/*
		for (int i = 0; i < student.length; i++) {
			System.out.print("이름: ");
			student[i][0] = sc.next();
//			String name = sc.next();
//			student[i][0] = name;
			System.out.print("국어: ");
			student[i][1] = sc.next();
			System.out.print("수학: ");
			student[i][2] = sc.next();
			System.out.print("영어: ");
			student[i][3] = sc.next();
			
		}
		*/
		
		int w=0;
		while(w< student.length) {
			System.out.println((w+1) + "번째 학생");
			System.out.print("이름: ");
			String name = sc.next();
//			String name = sc.next();
//			student[i][0] = name;
			System.out.print("국어: ");
			String lang = sc.next();
			System.out.print("수학: ");
			String math = sc.next();
			System.out.print("영어: ");
			String eng = sc.next();
			
			if(name.trim().equals("")){ // trim은 스페이스바 제거
				System.out.print("이름을 입력해주세요");
				continue;
			}
			boolean nogood = false;
			for (int i = 0; i < lang.length(); i++) {
				int asc = lang.charAt(i);
				if(asc<48 || asc>57) {
					nogood = true;
					break;
				}
			}
			if(nogood == true) {
				System.out.println("국어점수에 오류가 있습니다");
				continue;
			}
			
			for (int i = 0; i < math.length(); i++) {
				int asc = math.charAt(i);
				if(asc<48 || asc>57) {
					nogood = true;
					break;
				}
			}
			if(nogood == true) {
				System.out.println("수학점수에 오류가 있습니다");
				continue;
			}
			
			for (int i = 0; i < eng.length(); i++) {
				int asc = eng.charAt(i);
				if(asc<48 || asc>57) {
					nogood = true;
					break;
				}
			}
			if(nogood == true) {
				System.out.println("영어점수에 오류가 있습니다");
				continue;
			}
			
			// nogood = false;
			
			student[w][0] = name;
			student[w][1] = lang;
			student[w][2] = math;
			student[w][3] = eng;
			
			
			w++;
		}
		for (int i = 0; i < student.length; i++) {
			System.out.println(Arrays.toString(student[i]));	
		}
		
		// 3. 각 학생의 총점
		//System.out.println(Integer.parseInt(student[i][1]) + ));
		int stsum[] = new int[student.length];
		for (int i = 0; i < student.length; i++) {
			int lang = Integer.parseInt(student[i][1]);
			int math = Integer.parseInt(student[i][2]);
			int eng = Integer.parseInt(student[i][3]);
			stsum[i] = lang + math + eng;
		}
		
		for (int i = 0; i < stsum.length; i++) {
			System.out.print(student[i][0] + "의 총점: ");
			System.out.println(stsum[i]);
		}
		
		// 4. 총점 1등
		max=0;
		
		for (int i = 0; i < stsum.length; i++) {
			if(max< stsum[i]) {
				max = stsum[i];
			}
		}
		System.out.println("총점 1등: " + max);
		
		
		// 5. 과목 별 1등
		int lang_num[] = new int[student.length];
		for (int i = 0; i < lang_num.length; i++) {
			lang_num[i] = Integer.parseInt(student[i][1]);
		}
		
		max = lang_num[0];
		for (int i = 0; i < lang_num.length; i++) {
			if (max<lang_num[i]) {
				max = lang_num[i];
			}
		}
		
		
		// 6. 과목 별 최하점
		int math_num[] = new int[student.length];
		for (int i = 0; i < math_num.length; i++) {
			math_num[i] = Integer.parseInt(student[i][2]);
		}
		
		min = math_num[0];
		for (int i = 0; i < math_num.length; i++) {
			if (min>math_num[i]) {
				min = math_num[i];
			}
		}
		
		System.out.println("수학의 최저점수: " + min);
		
		// 7. 총점의 평균
		for (int i = 0; i < stsum.length; i++) {
			sum = sum + stsum[i];
		}
		avg = (double)sum / student.length;
		System.out.println("총점의 평균: " + avg);
		
		// 8. 이름 입력하면 성적 출력
		System.out.print("이름: ");
		String name = sc.next();
		int findindex = -1;
		
		for (int i = 0; i < student.length; i++) {
			if(name.equals(student[i][0])) {
				findindex = i;
				break;
			}
		}
		if(findindex != -1) {
			//System.out.println(Arrays.toString(student[findindex]));
			System.out.println("이름: " + student[findindex][0]);
			System.out.println("국어: " + student[findindex][1]);
			System.out.println("수학: " + student[findindex][2]);
			System.out.println("영어: " + student[findindex][3]);
			
			
		}else {
			System.out.println("찾을 수 없습니다");
		}
		
		
		
		

	}

}
