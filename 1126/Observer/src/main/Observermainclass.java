package main;

import cls.MyClass;
import observer.ObserverAA;
import observer.ObserverBB;

public class Observermainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	observer:	감시, 정찰
		 				감시자 패턴
		 				특정 class를 감시
		 	
		 */
		
		MyClass cls = new MyClass();
		
		cls.addObserver(new ObserverAA());
		cls.addObserver(new ObserverBB());
		
		cls.setId("abcd");
		cls.setPassword("1q2w3e4r");
		
		cls.notifyObservers("id = " + cls.getId() + ", pass = " + cls.getPassword());
		
		
	}

}
