package main;

import mycls.myclass;

public class OOP2Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
			oop = object oriented programming
			
			절차지향			객체지향(=분산처리)
			초기화(변수)
			처리1				처리1, 처리2, 처리3
			처리2
			처리3
			
			결과
		
							class
							변수, 함수
							
							1. 은닉성(=캡슐화)
							: 외부의 접근 차단으로 변수 관리
							class의 내부에서 접근 제어(접근지정자를 통해)
							
							접근지정자
							: private 	-> 주로 멤버변수에 사용
							  public 	-> 처리, 멤버 메소드
							  protected	-> 상속
							  
						  	2. 상속성
						  	3. 다형성
							  

		 */
		
		
		myclass cls = new myclass();
		cls.name = "홍길동";
//		cls.number = 12;
//		cls.c = 'x';
		cls.setnumber(12);
		int n = cls.getnumber();
		
		
		System.out.println("cls heap 주소: " + cls);
		System.out.println(cls.getthis());
		
		myclass mcls = new myclass();
		System.out.println("mcls heap 주소: " + mcls);
		System.out.println(mcls.getthis());

		
		

	}

}
