package ccls;

import pcls.parentclass;

public class childclass extends parentclass {
	
	private int cnum;
	
	public childclass() {
		System.out.println("childclass childclass()");
	}
	
	public childclass(int cnum, int pnum) {
//		this();	// 기본생성자 참조
//		super();	// 부모클래스 참조
		super(pnum);
		
		this.cnum = cnum;
		System.out.println("childclass childclass()" + this.cnum);
	}

}
