package cls;

public class NormalClass extends AbstractClass{  // abstract class를 상속받은 클래스는 필수로 override를 해줘야 함
//												1. source에서 override/implement Methods...를 누름
//												2. NormalClass에 커서를 대고 위의 것을 선택        -> 둘 중 아무거나 하나만 하면 됨

	@Override
	public void abstractmethod() {
		System.out.println("Normal Class abstractmethod()");		
	}

}
