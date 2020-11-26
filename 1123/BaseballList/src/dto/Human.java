package dto;

public class Human {
	
	private int numb;
	private String name;
	private int age;
	private int height;
	
	public Human() {
		
	}

	public Human(int numb, String name, int age, int height) {
		super();
		this.numb = numb;
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public int getNumb() {
		return numb;
	}

	public void setNumb(int numb) {
		this.numb = numb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "numb=" + numb + ", name=" + name + ", age=" + age + ", height=" + height + ", ";
	}
	
	

}
