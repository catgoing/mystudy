package child1;

import parent.parent;

public class child1 extends parent {
	
	public void method() {
		/*super.method();  override 되기 전 부모클래스 메소드 사용하겠다는 함수 */
		System.out.println("child1 override");
	}
	
	public void child1method() {
		System.out.println("child1 child1method");
	}

}
