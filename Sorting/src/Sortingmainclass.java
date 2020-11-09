import java.util.Arrays;

public class Sortingmainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	java < oracle 우수
		 	
		 	Sorting: 정렬
		 	
		 	선택, 버블, 합병, 퀵

		 	
		 */
		
		int number[] = {1,11,2,22,3,33,4,55,7,0};
		int temp;
		
		for (int i = 0; i < number.length-1; i++) {
			for (int j = i+1; j < number.length; j++) {
				//오름차순
				if(number[i] > number[j]) {
					// swap
					temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < number.length; i++) {
			System.out.println(number[i]);
		}
		System.out.println(Arrays.toString(number));  // 배열 출력
	}

}
