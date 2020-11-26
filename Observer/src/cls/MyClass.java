package cls;

import java.util.Observable;

public class MyClass extends Observable{
	
	private String id;
	private String password;
	
	private String preArg = null;
	
	public MyClass() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void notifyObservers(Object arg) {
		String str = (String)arg;
		
		if(str.equals(preArg)) return; // 변화가 없을 때, null이 감지됐을 때 ---> 감시자에게 넘기는 정보 없음
		
		preArg = str; // 변화가 있을 때, 값이 들어왔을 때 ---> 감시자에게 정보 전송
		
		this.setChanged();  // reset
				
		super.notifyObservers(arg);
		
		clearChanged();
		
	}
	
	

}
