package cls;

public class myclass {

	
	private int number;
	private String name;
	
	public myclass() { // = constructor
		System.out.println("myclass myclass()");
		// 보통 바꾸지 않을 변수를 기입
	}
	
	public myclass(int number) {
		this(); // 기본 생성자(myclass()) 호출
		this.number = number;
		System.out.println("myclass myclass(int number)");
	}
	
	public myclass(int number, String name) {
//		this();  // 기본 생성자(myclass()) 호출
		this(number); // // 생성자(myclass(int number)) 호출
		
		this.number = number;
		this.name = name;
		System.out.println("myclass(int number, String name)");
				
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
