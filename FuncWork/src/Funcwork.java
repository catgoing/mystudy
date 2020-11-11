import java.util.Arrays;

public class Funcwork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 2차원 배열 -> 1차원 배열
		
		
		int array2[][] = {
				{1,2,3,4},
				{7,8,9,0}
		};
		
		int array1[]= null;
		
		
		
		array1 = changeArr(array2);
		System.out.println(Arrays.toString(array1));
		
		
		

	}
	
	static int[] changeArr(int arr[][]) {
		if(arr==null || arr.length ==0) return null;
		int array[] = new int[arr.length * arr[0].length];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				array[arr[0].length * i + j] = arr[i][j];
			}
			
		}
			return array;	
	}
	
	/*
	static void changeArray(int arr[][]){
		int arr1[] = new int[arr.length * arr[0].length];;
	
		
		for (int i = 0; i < arr.length; i++) { // 0 1 2
			for (int j = 0; j < arr[0].length; j++) { // 0 1 2 3
				arr1[arr[0].length * i + j] = arr[i][j];
			}
			
		}
		
		for (int i = 0; i < arr1.length; i++) {
			//System.out.println("arr1[" + i + "]: " + arr1[i]);
			
		}
		System.out.println(Arrays.toString(arr1));
	}
	*/
	
}
