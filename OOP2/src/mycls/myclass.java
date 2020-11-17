package mycls;

public class myclass {
	
	private int number;		// private는 클래스 내부(여기서는 myclass)에서만 접근 가능
	public String name;		// 어디서든 접근 가능
	protected char c;
	
	// variable의 대부분은 private로 작성
	/*
	public void setnumber(int newnumber) { // setter, 외부에서 접근할 때
		number = newnumber;
	}
	
	public int getnumber() { // getter, 외부에서 접근할 때
		return number;
	}
	*/
	
	
	// getter와 setter은 메뉴 > source > Generate getter and setter에서 체크하여 만들 수 있음

	public int getnumber() {
		return number;
	}

	public void setnumber(int number) {
		this.number = number;
		/*
			this: 자기참조 -> 자기 자신의 주소(Heap)
			0번째 매개변수로 자기자신을 가리키는 주소
			this.변수 : 멤버변수를 가리킴
			= number에서 number는 매개변수를 가리킴
		 */
	}
	public myclass getthis() {
		return this;
	}
	
	public void method() {
		
		int number;  // 이걸 쓰면			쓰지 않으면
		
		number = 12; // 여기에서 받음		멤버변수를 받음(이름이 같으니까)
		this.number = 14; // 이거는 무조건 멤버변수
		this.setnumber(23);
	}
	
	public void sums() {
		
	}
	

}
