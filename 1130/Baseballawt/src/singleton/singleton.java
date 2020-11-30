package singleton;

public class singleton {
	
	private static singleton si = null;
			
	private singleton() {
	
	}
	
	public static singleton getInstance() {
		if(si == null) {
			si = new singleton();
		}
		return si;
	}

}
