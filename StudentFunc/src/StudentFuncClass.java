import java.util.Arrays;
import java.util.Scanner;

public class StudentFuncClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	
	
	String student[][] = null; 	
	
	// 1. 몇 명의 학생?
	int count = studentcountinput();
	

	// 2. 입력: 이름, 국어, 수학, 영어				CRUD
	// 	Create, Read, Update, Delete
	student = studentinput(count);
	
	for (int i = 0; i < student.length; i++) {
		System.out.println(Arrays.toString(student[i]));
	}
	
	
	// 3. 각 학생의 총점
	studentallnum(student);
	
	
	// 4. 총점 1등
	studentallnum1st(student);
	
	
	// 5. 과목 별 1등
	studenttitle1st(student);
	
	// 6. 과목 별 최하점
	
	
	// 7. 총점의 평균
	sumavg(student);
	
	// 8. 이름 입력하면 성적 출력
	
	}
	
	static int studentcountinput() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇 명?: ");
		int count = sc.nextInt();
		
		return count;
		
	}
	
	/*
	 	함수명: studentinput
	 	매개변수: 없음
	 	리턴: int
	 	내용: 학생수를 입력받음
	 	
	 
	 */
	
	static String[][] studentinput(int count) {
		if(count>0) {
			
		}
		String student[][] = new String[count][4];
		Scanner sc = new Scanner(System.in);
		
		int w = 0;
		while(w< student.length) {
			System.out.println((w+1) + "번째 학생");
			System.out.print("이름: ");
			String name = sc.next();
			
			if(name.trim().equals("")){ // trim은 앞 뒤의 스페이스바 입력 제거
				System.out.print("이름을 입력해주세요");
				continue;
			}
			
					
			/*
			String title[] = {"국어", "수학", "영어"};
			String lan[] = new String[3];
			
			for (int i = 0; i < lan.length; i++) {
				System.out.print(title[i] + ": ");
				lan[i] = sc.next();
				
				if(isnumber(lan[i]) == false) {
					System.out.println(title[i] + "점수에 오류가 있습니다");
					continue;
				}	
			}
			*/
	
			System.out.print("국어: ");
			String lang = sc.next();
			if(isnumber(lang) == false) {
				System.out.println("국어점수에 오류가 있습니다");
				continue;
			}
			
			
			System.out.print("수학: ");
			String math = sc.next();
			if(isnumber(math) == false) {
				System.out.println("수학점수에 오류가 있습니다");
				continue;
			}
			
			System.out.print("영어: ");
			String eng = sc.next();
			if(isnumber(eng) == false) {
				System.out.println("영어점수에 오류가 있습니다");
				continue;
			}
			
			
			student[w][0] = name;
			student[w][1] = lang;
			student[w][2] = math;
			student[w][3] = eng;
			
			/*
			student[w][0] = name;
			student[w][1] = lan[0];
			student[w][2] = lan[1];
			student[w][3] = lan[2];
			*/
			
			w++;
		}
		
		return student;
	}
	

	
	
	static boolean isnumber(String str) {
		boolean b = true;
		for (int i = 0; i < str.length(); i++) {
			int asc = str.charAt(i);
			if(asc<48 || asc>57) {
				b = false;
				break;
			}
		}
		return b;
	}
	
	static void studentallnum(String student[][]) {
		if(student == null || student.length == 0) {
			System.out.println("데이터가 없습니다");
			return;
		}
		/*
		int stsum[] = new int[student.length];
		for (int i = 0; i < student.length; i++) {
			int lang = Integer.parseInt(student[i][1]);
			int math = Integer.parseInt(student[i][2]);
			int eng = Integer.parseInt(student[i][3]);
			stsum[i] = lang + math + eng;
		}
		*/
		int stsum[] = strarrtointarr(student);
		
		
		for (int i = 0; i < stsum.length; i++) {
			System.out.print(student[i][0] + "의 총점: ");
			System.out.println(stsum[i]);
		}
		
	}
	
	static void studentallnum1st(String student[][]) {
		
		int stsum[] = strarrtointarr(student);
		/*
		int stsum[] = new int[student.length];
		for (int i = 0; i < student.length; i++) {
			int lang = Integer.parseInt(student[i][1]);
			int math = Integer.parseInt(student[i][2]);
			int eng = Integer.parseInt(student[i][3]);
			stsum[i] = lang + math + eng;
		}
		*/
		int max;
		max= stsum[0];
		
		for (int i = 0; i < stsum.length; i++) {
			if(max< stsum[i]) {
				max = stsum[i];
			}
		}
		System.out.println("총점 1등: " + max);
	}
	
	static int[] strarrtointarr(String student[][]) {
		int stsum[] = new int[student.length];
		for (int i = 0; i < student.length; i++) {
			int lang = Integer.parseInt(student[i][1]);
			int math = Integer.parseInt(student[i][2]);
			int eng = Integer.parseInt(student[i][3]);
			stsum[i] = lang + math + eng;
		}
		return stsum;
	}
	
	static void studenttitle1st(String student[][]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("어떤 과목?(국어 1, 수학 2, 영어 3): ");
		int title = sc.nextInt();
		
		int titlenum[][] = new int[student.length][3];
		
		for (int i = 0; i < titlenum.length; i++) {
			for (int j = 0; j < titlenum[i].length; j++) {
				titlenum[i][j]= Integer.parseInt(student[i][j+1]);
			}
		}
		
		int number[] = new int[student.length];
		
		for (int i = 0; i < number.length; i++) {
			number[i] = titlenum[i][title -1];
		}
		
		int max = number[0];
		for (int i = 0; i < number.length; i++) {
			if(max<number[i]) {
				max = number[i];
				
			}
		}
		
		
		/* 데이터 확인용
		for (int i = 0; i < titlenum.length; i++) {
			System.out.println(Arrays.toString(titlenum[i]));
		}
		*/
		String titlename = "";
		if(title==1) titlename = "국어";
		else if(title==2) titlename = "수학";
		else if(title==3) titlename = "영어";
				
		System.out.println(titlename + "의 최고 점수: " + max);
		
	}
	
	static void sumavg(String student[][]) {
		int sum[] = strarrtointarr(student);
		int asum = 0;
		for (int i = 0; i < sum.length; i++) {
			asum = asum + sum[i];
		}
		
		double avg = asum / sum.length;
		System.out.println("총점의 평균: " + avg);
	}
}
