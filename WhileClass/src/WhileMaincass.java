
public class WhileMaincass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	while 순환문
		 	do while -> 이건 잘 사용하지 않음
		 	
		 	*형식
		 	 - while
		 		변수선언
		 		변수초기화
		 	
		 		while(조건식){
		 			처리
		 			연산식
		 		}
		 		
		 		for(초기화;조건식;연산식){
		 			처리
		 		}
		 		
		 	 - do while	
		 		변수선언
		 		변수초기화
		 		
		 		do{
		 			처리
		 			연산식
		 		}while(조건식);
		 		
		 */
		
		
		int w;
		w = 0;
		
		while(w<10) {
			// w++; 위에 놓으면 1부터
			System.out.println("w: " + w);
			w++;  // 아래에 놓으면 0부터
		}
		
		/*
		 	init
		 	
		 	loop - while을 자주 사용
		 	
		 	release
		 	
		 */
		
		int w1 = 0;
		
		do {
			System.out.println("w1 = " + w1);
			w1++;
		}while(w1<10);  // while과 do while의 차이: do while은 조건과 상관없이 무조건 1회는 실행
		
		// 2중 while문
		
		for (int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
			for (int j = 0; j < 5; j++) {
				System.out.println(" j = " + j);
			}
		}
		
		System.out.println();
		
		int w2, w3;
		w2 = w3 = 0;
		
		while(w2<10) {
			System.out.println("w2 = " + w2);
			w3=0;  //  2. 그래서 여기서 w3 초기화 실행
			while(w3<5) {
				System.out.println(" w3 = " + w3);
				w3++;  // 1. 여기서 w3 초기화 안 됨
			}
			w2++;
		}
		
		
		/* 구구단
		  	2중 while문을 사용해서 출력
		 
		 */
		
		int g, g2, g3;
		
		g = g2 = 1;
		g3 = 0;
		
		
		while(g<10) {
			g2=1;
			while(g2<10) {
			System.out.print(g + " x " + g2 + " = " + g*g2 + " , ");
			g2++;
			}
			System.out.println();g++;}

	}

}
