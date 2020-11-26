package single;

public class SingletonClass {
	
	private static SingletonClass si = null;
	public int number;
	public int kk;
	
	private SingletonClass() {
	
	}
	
	public static SingletonClass getInstance() {
		if(si == null) {
			si = new SingletonClass();
		}
		return si;
	}

}
