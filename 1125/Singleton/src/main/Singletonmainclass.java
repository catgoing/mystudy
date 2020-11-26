package main;

import he.HeClass;
import my.MyClass;
import single.SingletonClass;
import you.YouClass;

public class Singletonmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	싱글턴 정리!!
		 	
		 	싱글턴의 목적은 클래스 간의 private 변수끼리 소통하게 하는 것.
		 	
		 	클래스A private 변수 > 싱글턴 public 변수 > 클래스B private 변수  ==> 메인클래스 출력
		 	
		 	싱글턴 클래스 생성 >  > 클래스A private 변수  초기화 > 클래스A에 싱글턴 호출 > 
		 	
		 	싱글턴 public 변수 > 클래스B private 변수  ==> 메인클래스 출력
		 	
		 	
		 	
		 	싱글턴 public 변수는 하나의 값만 받아들일 수 있으므로
		 	값의 개수에 맞추어 생성해주어야 함.
		 	
		 	
		 	
		 	
		 */
		
		/*
		MyClass mycls = new MyClass();
		YouClass youcls = new YouClass();
		
		int n = mycls.getNumber();
		youcls.setCount(n);
		
		System.out.println(youcls.toString());
		*/
		
//		SingletonClass scls1 = new SingletonClass();	// private이라 생성 안 됨
		
		/*
		SingletonClass si = SingletonClass.getInstance();
		System.out.println(si);
		
		si = SingletonClass.getInstance();
		System.out.println(si);
		*/
		
		MyClass mycls = new MyClass();
		YouClass youcls = new YouClass();
		
		System.out.println(youcls.toString());
		
		HeClass hecl = new HeClass();
		
		System.out.println(hecl.toString());
		

	}

}
