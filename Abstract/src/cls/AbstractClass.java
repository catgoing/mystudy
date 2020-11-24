package cls;

public abstract class AbstractClass {  // class 앞에  abstract 추가
										// 추상메소드 + 일반메소드
	
	private int number;
	
	public void method() {	// 일반메소드
		System.out.println("AbstractClass method()");
	}
	
	public abstract void abstractmethod();  // 추상메소드, 리턴값 앞에 abstract 추가

}
