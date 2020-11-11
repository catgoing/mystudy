
public class Fucntion2mainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 가변인수 // 일반인수와 함께 쓸 수 있으나 그럴 경우 가변인수는 항상 마지막에 입력
		 
		 	static void 함수이름(인수, 인수, 가변인수){
		 	처리
		 	}
		 	
		 	function : 함수
		 				들어가는 값 : 인수, 인자, parameter, 매개변수(가인수)
	 					나오는 값 : return 값
	 					
			나오는 값의 자료형		함수명	(들어가는 값(다수 입력 가능)){
				처리
				
				return 나오는 값
			
			}
		 */
		
		allocParam(12, 13, 33, 44);
		
		allocParam(1,2,3,4,5,6,7,8,9);
		
		allocFunc("기범", 2,5,6,8,10);
		

	}
	
	static void allocParam(int...num) { // printf( "%d", , ,)
		int sum = 0;
		
		for (int i = 0; i < num.length; i++) {
			sum = sum+ num[i];
			
		}
		System.out.println("sum: " + sum);
	}
	
	static void allocFunc(String str, int...num) { // 가변인수는 항상 마지막에 나와야 함
		System.out.println("str: " + str);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}

}
