package pcls;

public class parentclass {
	
	private int privnum;
	public int pubnum;
	protected int protectnum; // 자식클래스에서만 접근 가능
	
	public int getPrivnum() {
		return privnum;
	}

	public void setPrivnum(int privnum) {
		this.privnum = privnum;
	}

	
	
	public parentclass() {
		System.out.println("parentclass parentclass()");
	}
	
	public void parantMethod() {
		System.out.println("parentclass parentMethod()");
	}
	
	protected void protectedmethod() {
		System.out.println("parentclass protectedmethod()");
	}

}
