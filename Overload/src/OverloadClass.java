
public class OverloadClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	overload:	함수(메소드)명은 같고  매개변수의 자료형이나 개수가 다른 것으로 분류하는 것
		 				이름만 같은 것
			예시)
			imageDraw(int x, int y, int a)
			imagaDraw(int x, int y)
			
			
		 */
		
		funcname();
		funcname(1);
		funcname('c');
		funcname('a', 33);
		funcname(2, 'a');
		

	}
	
	static void funcname() {
		System.out.println("funcname() 호출");
	}
	
	static void funcname(int i) {
		System.out.println("funcname(int i) 호출");
	}
	
	static void funcname(char c) {
		System.out.println("funcname(char c) 호출");
	}
	
	static void funcname(char c, int i) {
		System.out.println("funcname(char c, int i) 호출" + c + i);
	}
	
	static void funcname(int i, char c) {
		System.out.println("funcname(int i, char c) 호출" + c + i);
	}
	
	/*
	static void funcname(char c1) { // 가인수만 다른 건 에러남
		
	}
	
	static int funcname(){	// 리턴값만 바꾸는 것도 에러남
		return 1;	
	}
	
	*/
}
