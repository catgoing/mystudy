
public class ExceptionClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	exception: 예외
		 	
		 	char c = 65; -> 'A'
		 	array	index number[3] -> number[0~2]	number[3]
		 	class	Scanner 못 찾는 경우
		 	file이 없는 경우
		 	
		 	형식: 
		 	try{
		 	예외1이 나올 수 있는 코드
		 	예외2가 나올 수 있는 코드
		 	} catch(예외1 class e){
		 		메시지 출력
		 		}
	 		catch(예외2 class e){
	 			메시지 출력
	 		} finally{//finally는 생략 가능
	 			무조건 실행
	 			뒤처리 	파일 -> undo
	 		}
	 		
	 		void func() throws 예외1 class{
	 		
	 		}
		 
		 */
		
		
		

		/*
		int array[] = {1,2,3};
		System.out.println("프로그램 시작");
		try {
		for (int i = 0; i < 4; i++) {
			System.out.println(array[i]);
		}
		System.out.println("프로그램 실행 중"); // 이 부분은 건너 뜀
		}catch (ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace();
			//System.out.println("배열에서 예외발생");
			System.out.println("-----"+e.getMessage());
			return;
			
		}catch(NumberFormatException e) {
			
		}finally {	// 이건 무조건 실행
			System.out.println("finally");
		}
		
		System.out.println("프로그램 끝");
		*/
		
//		func();
		func1();
	}
	

	static void func() {
		int array[] = {1,2,3};
		
		try {
			for (int i = 0; i < 4; i++) {
				System.out.println(array[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
	static void func1() throws ArrayIndexOutOfBoundsException{
		int array[] = {1,2,3};
		
		for (int i = 0; i < 3; i++) {
			System.out.println(array[i]);
		}
	}
}
