
public class RandommainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	랜덤: 난수, 무작위		 	
		 	
		 */
		
		int randNum;
		randNum = (int)(Math.random() * 10);  // 0~9  * 뒤의 숫자에 의해 범위가 결정, 랜덤 숫자의 개수에 의해 숫자 결정 5개면 5, 99개면 99
		System.out.println(randNum);
		
		// 10~19
		randNum = (int)(Math.random() * 10) + 10;  
		System.out.println(randNum);

		// 10, 20, 30.., 50
		randNum = (int)((Math.random() * 5) + 1) * 10;  
		System.out.println(randNum);
		
		// -1 0 1
		randNum = (int)(Math.random() * 3) - 1;  
		System.out.println(randNum);
		// 이것에 x, y좌표를 넣으면서 무작위로 움직이게 하는 게 가능
		
		// 11 23 14 56 78
		int rArrNum[] = {11, 23, 14, 56, 78};
		
		randNum = (int)(Math.random() * 5);  
		System.out.println(rArrNum[randNum]);
		
	}

}
