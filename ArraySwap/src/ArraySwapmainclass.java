
public class ArraySwapmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numberOne[] = {1,2,3,4,5};
		int numberTwo[] = {11,22,33,44,55};
		
		int oneNum[] = numberOne;
		int twoNum[] = numberTwo;
		
		
		// swap 정석
		/*
		int temp;
		
		for (int i = 0; i < numberOne.length; i++) {
			temp = numberOne[0];
			numberOne[i] = numberTwo[i];
			numberTwo[i] = temp;
			}
		
		for (int i = 0; i < numberTwo.length; i++) {
			System.out.println(numberOne[i]);
		}
		*/
		
		int temp[];
		temp = oneNum;
		oneNum = twoNum;
		twoNum = temp;
		
		for (int i = 0; i < numberTwo.length; i++) { //numberOne.length = numberTwo.length라서 바꿔도 상관없음
			System.out.println(numberOne[i]);
		}
		System.out.println();
		
		for (int i = 0; i < oneNum.length; i++) {
			System.out.println(oneNum[i]);
		}

	}

}
