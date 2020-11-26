package he;

import single.SingletonClass;

public class HeClass {
	private int num;
	
	public HeClass() {
	
		SingletonClass si = SingletonClass.getInstance();
		
		num = si.kk;
		
	}
	
	public void method() {
		
	}

	@Override
	public String toString() {
		return "HeClass [num=" + num + "]";
	}

	
}
