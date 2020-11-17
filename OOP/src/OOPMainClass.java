
public class OOPMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	Object Oriented Programming
		 	객체 		지향		
		 	
		 	절차지향의 순서
		 	
		 	선언(변수, 배열) - 50000만 줄이 넘어가면 한계가 드러남 	-> 따라서 분산(함수이용)
		 											-> 변수의 한계
		 											-> 크기의 한계
		 	1. 초기화
		 	2. 랜덤
		 	3. 입력
		 	4. 판단, 처리
		 	5. 결과
		 	
		 	// 학생 성적 관리
		 	int student[?][4] = { ...
		 	}
		 	
		 	student
		 		name
		 		lan
		 		mat
		 		eng
		 		
 			클래스 정의
	 		class 클래스명{
	 			선언: 변수들
	 			
	 			함수(메소드)
	 			
	 		}
		메모리: stack		 Heap
	 		클래스명 변수 = new 클래스명();
	 			->instance: 주체
	 			= object: 객체	
		 
		 */
		
		myclass cls = new myclass();
		System.out.println(cls); // 4byte, 8bit
		
		cls.c = 'A';
		cls.n = 123;
		cls.str = "hello";
		
		myclass aaa = new myclass();
		aaa.c = 'v';
		aaa.n = 234;
		aaa.str = "world";
		
		// TV -> 2대
		String name[] = new String[2];
		int channel[] = new int[2];
		boolean power[] = new boolean[2];
		
		name[0] = "samsung";
		name[1] = "lg";

		channel[0] = 11;
		channel[1] = 24;
		
		power[0] = true;
		power[1] = false;
		
		System.out.println(name[0] + " " + channel[0] + " " + power[0]);
		System.out.println(name[1] + " " + channel[1] + " " + power[1]);
		
		TV tv1, tv2;
		tv1 = new TV();
		tv2 = new TV();
		
		tv1.name = "lg";
		tv1.channel = 11;
		tv1.power = true;
		tv1.print();
		
		tv2.name = "samsung";
		tv2.channel = 24;
		tv2.power = true;
		tv2.print();
		
		
		
		for (int i = 0; i < power.length; i++) {
			
		}
		

	}

}


class myclass{
	char c;
	int n;
	String str;
	
}

class TV{
	String name;	// member 변수
	int channel;
	boolean power;
	
	void print() {
		System.out.println("메이커" + name + " " + channel + " " + power);
	}
	
}

// baseball



// sorting



