package main;

import cls.AbstractClass;
import cls.NormalClass;

public class Abstractmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 	abstract:	추상
		 				완전체는 아닌 선언만 되어 있는 메소드 포함하고 있는 클래스
		 				추상메소드 + 일반메소드 + 변수 = 추상클래스

		 				단독 생성은 불가능. 상속 후 추상메소드를 작성한 후 생성 가능
		 				instance로서의 생성은 가능

		 				추상메소드가 하나라도 있으면 추상클래스

		 	abstract class{
		 		void method(){

		 		}
		 		abstract func();
		 	}

		 */

		// AbstractClass acls = new AbstractClass(); // 이렇게 단독으로는 생성 불가

		NormalClass nc = new NormalClass();
		nc.method();
		nc.abstractmethod();

		AbstractClass ac = new NormalClass();  // 부모클래스의 인스턴스로 자식클래스 생성 가능 -> 똑같이 적용됨
		ac.method();
		ac.abstractmethod();

		AbstractClass acc = new AbstractClass() {

			@Override
			public void abstractmethod() {
				System.out.println("AbstractClass AbstractClass()");

			}
		};

		acc.abstractmethod();
		acc.method();

	}

}
