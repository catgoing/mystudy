
public class SwitchMainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	switch : 조건문으로 값이 명확해야 함
		 	가독성
		 	
		 	switch(변수){
		 		case 값1:		≒	if	
		 			처리
		 			break;
		 		case 값2:		≒	else if
		 			처리
		 			break;
		 		default:		≒	else
		 			처리
		 			break;
		 	}
		 		 
		 	*>, <, =, ! 등은 switch에서 사용 불가
		 	*변수에 소수점 값은 사용 불가
		 	
		 */
		
		int num = 7;
		switch(num) {
			case 1:			// if(num==1)
				System.out.println("num은 1이다");
				break;
			case 2:			// else if(num==2)
				System.out.println("num은 2이다");
				break;
			case 3:
				System.out.println("num은 3이다");
				break;
			default:
				System.out.println("num은 ?이다");
			
		}
		
		char c = '가';			// swi 이후 컨트롤+스페이스
		switch (c) {
			case '가':
				System.out.println("c는 가이다");
				break;
	
			default:
				break;
		}
		
		/* 소수점은 변수값으로 사용 불가
		double d = 3.141592;
		switch (d) {
		case 3.141592:
			
			break;

		default:
			break;
		}
		*/
		
		String str = "hello";
		switch (str) {
		case "hello":
			System.out.println("str은 hello이다");
			break;

		default:
			break;
		}

		/* 부등호 사용 불가
		switch (num) {
		case num>1:
			System.out.println("num은 1보다 크다");
			break;

		default:
			break;
		}
		*/
		
		
	}

}
