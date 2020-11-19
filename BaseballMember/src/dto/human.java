package dto;  

// dto: data transfer object
// vo: value object (dto=vo)

public class human {
	private int number;
	private String name;
	private int age;
	private double height;
	
	/*
 	번호, 이름, 나이, 키
 	
	 */	
	
	public human() { // 안 써도 만들어두는 게 좋음
		
	}
	
	public human(int number, String name, int age, int height) {
		super();
		this.number = number;
		this.name = name;
		this.age = age;
		this.height = height;
		
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "human [number=" + number + ", name=" + name + ", age=" + age + ", height=" + height + "]";
	}

}
