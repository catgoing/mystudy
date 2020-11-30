package dto;

public class Human {
	
	int num; 
	String name, age;
	String height;
	
	public Human() {
	
	}

	public Human(int num, String name, String age, String height) {
		super();
		this.num = num;
		this.age = age;
		this.name = name;
		this.height = height;
	}

	@Override
	public String toString() {
		return num + "-" + name + "-" + age + "-" + height + "-";
	}
	
	
}
