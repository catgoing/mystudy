package main;

import cls.myclass;

public class mainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	constructor:	생성자
		 					메소드
		 					return값 없음
		 					overload(같은 이름의 함수로 매개변수로 구분) 가능
		 					클래스명과 같은 이름임
		 					자동호출됨
		 					클래스 생성 시에 호출
		 					생략이 가능
		 					
			Destructor: 	소멸자
			(자바에서는 없어짐)	반드시 한 개만
		 	
		 */
		
		
		
		int array[] = {1,2,3};
		/*
		student stu = new student();
		stu.setName("홍길동");
		stu.setNumber(123);
		*/
		
//		student stu = {"홍길동", 123};	-> 틀린 문법
		
		/*
		myclass cls = new myclass();  // new myclass 이게 constructor
//		cls.setNumber(1001);
//		cls.setName("홍길동");
		
		myclass cls1 = new myclass(12);
		*/
		
//		myclass cls2 = {1,"rks"}; 문법 오류
		myclass cls2 = new myclass(1,"rks");
		
//		cls.myclass();  이건 안 됨(기본 생성자 호출은 불가, 왜냐면 생성 때만 자동 호출)
		
		// final
		
		final int num=12;  // final을 입력하면 변수가 상수로 됨
//		num=24; 	그래서 num을 바꿀 수가 없게 됨
		int n;
		n = num;			// num=12이기 때문에 n = 12
		
		

	}

}
