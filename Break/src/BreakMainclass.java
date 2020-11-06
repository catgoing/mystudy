
public class BreakMainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	break: 탈출,	loop와 함께 사용
		 				switch
		 				
			switch(){
				case 1:
					처리
					break;
			}
			
			for(int i=0; i<10; i++){
				if(i==5){
					break;
					}
				}
		 	
		 		 	
		 */
		
		/*
		int n=0;
		
		for (int i = 0; i < 100; i++) {
			System.out.println("i: " + i);
			if(i==12) {
				n=i;
				break;
			}
			
		}
		System.out.println("n: " + n);
		
		char charArr[] = {'A', 'B', 'C', 'D'};
		
		for (int i = 0; i < charArr.length; i++) {
			System.out.println(i + ": " + charArr[i]);
			if(charArr[i]=='C') {
				System.out.println("C를 찾았습니다");
				break;
			}
		}
		
		for (int i = 0; i < 6; i++) {
			System.out.println("i: " + i);
			for (int j = 0; j < 3; j++) {
				System.out.println(" j: " + j);	
				if(i==3 && j==2) {
					break;
				}
				
			}
			
		}
		
		*/
		
	// 탈출법 1
		
	 boolean b=false; 
	 	for (int i = 0; i < 6; i++) {
			System.out.println("i: " + i);
			for (int j = 0; j < 3; j++) {
				System.out.println(" j: " + j);	
				if(i==3 && j==2) {
					b=true;
					}
				if(b==true) {
					break;
				}
			}
			if(b==true) {
				break;
			}
		
	 	}
	 	
	 	
	 	// 탈출법 2, Java에서만 되는 방법
	 	
	 	loopout: for (int i = 0; i < 6; i++) {
			System.out.println("i: " + i);
			for (int j = 0; j < 3; j++) {
				System.out.println(" j: " + j);	
				if(i==1 && j==2) {
					break loopout;
					}
				}
			}
			
		
	 	


	}
}
