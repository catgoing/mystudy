import cls.childclass;
import pcls.parentclass;

public class OOP3mainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	은닉성: 접근지정자를 통해 외부의 접근을 차단, 허용
		 			private(변수), public(메소드)
		 			
		 	상속성: 부모클래스(super)에서 기능을 상속하는 것
		 			추가 기입을 할 수 있다(override)
		 			
		 	
		 	다형성: 상속후에 여러 형태의 자식클래스를 제작하는 것
		 	
		 */
		
		childclass cc = new childclass(); // 순서는 부모클래스 -> 자식클래스
//		cc.parantMethod();
		cc.childmethod();
		cc.pubnum = 222;
//		cc.protectedmethod(); // 외부에서는 접근 불가
		
//		parentclass pc = new parentclass();  // parentclass에서 childclass는 호출 안 됨

		
		

	}

}
