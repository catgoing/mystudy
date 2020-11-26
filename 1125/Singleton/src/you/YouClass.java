package you;

import single.SingletonClass;

public class YouClass {
	
	private int count;
	private int ynumber;
	
	public YouClass() {
		ynumber = 11231;
		SingletonClass si = SingletonClass.getInstance();
		
		si.kk = ynumber;
		
		count = si.number;
	}

//	public void setCount(int count) {
//		this.count = count;
//	}

	@Override
	public String toString() {
		return "YouClass [count=" + count + "]";
	}

}
