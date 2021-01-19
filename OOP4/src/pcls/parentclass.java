package pcls;

public class parentclass /*extends Object*/{
	
	private int pnum;
	
	public parentclass(int pnum) {
		super();
		this.pnum = pnum;
		System.out.println(pnum);
	}

	public parentclass() {
		System.out.println("parentclass parentclass()");
	}

}
