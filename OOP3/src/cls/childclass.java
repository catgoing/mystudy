package cls;

import pcls.parentclass;

public class childclass extends parentclass {
	
	public childclass() {
		System.out.println("childclass childclass()");
	}
	
	public void childmethod() {
//		privnum = 10;  // private는 상속 x
		setPrivnum(123); // setter와 getter로 사용은 가능
		int n = getPrivnum();
		pubnum = 555;
		protectnum = 111;  // 메인함수에서는 접근 불가
		
		protectedmethod();
		
		System.out.println("childclass childmethod() = " + n);
	}

}
