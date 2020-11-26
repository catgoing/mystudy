package observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverBB implements Observer{

	@Override
	public void update(Observable o, Object arg) {	//MyClass 의 notify 함수에서 값이 넘어옴
		
		String str = (String)arg;
		
		System.out.println("감시자 BB " + str);
		
	}

}
