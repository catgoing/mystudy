package cls;

import inter.WriteMode;

public class Ballpen implements WriteMode {

	public void write() {
		System.out.println("볼펜으로 입력합니다");
		
		erase();
	}
	
	public void erase() {
		System.out.println("화이트로 지웁니다");
	}

}
