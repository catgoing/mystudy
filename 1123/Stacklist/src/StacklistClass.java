import stack.Stackarray;

public class StacklistClass {

	public static void main(String[] args) {

		Stackarray sa = new Stackarray();
		String str1 = "AAAA";
		sa.push(str1);
		
		String peekStr = (String)sa.peek();
		
		System.out.println("top object = " + peekStr);
		
		str1 = "BBBB";
		sa.push(str1);
		peekStr = (String)sa.peek();
		
		System.out.println("top object = " + peekStr);
		
		String delStr = (String)sa.pop();
		
		peekStr = (String)sa.peek();
		System.out.println("top object = " + peekStr);
		
	}

}
