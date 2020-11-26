package factory;

import animal.Animal;
import animal.Cat;
import animal.Cow;
import animal.Dog;

public class AnimalFactory {
	
	
	// method는 static으로 얼마든지 써도 됨
	// 다만 변수는 static으로 너무 많이 잡으면 무거워질 수 있음..
	
	public static Animal create(String animalname) {
		
		if(animalname.equals("고양이")) {
			return new Cat();
		} else if(animalname.equals("강아지")) {
			return new Dog();
		} else if(animalname.equals("소")) {
			return new Cow();
		} 
		
		System.out.println("생성할 클래스가 없습니다");
		
		return null;
	}

}
