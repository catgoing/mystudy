package write;

public abstract class Writer  {
	
	public abstract void write();
		
	public void erase() {
		System.out.println("기록을 지웁니다");
	}

}
