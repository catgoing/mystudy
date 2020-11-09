
public class Array2mainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	1차원 배열
		 	Array : 같은 자료형 변수들의 묶음
		 			index number로 관리된다
		 			int arr[] = new int[배열의 총 수];
		 			
		 			int arr[] = new int[3]; // 동적할당
		 						
		 			int arr[] = {1, 2, 3};  // 정적할당
		 			
 			String member[] = {"홍길동", "24", "서울시"};
 			int age = Integer.parseInt(member[1]);
 			
 			2차원 배열
 			다수의 1차원 배열을 관리할 수 있는 배열
 			
 			int array2[][] = new int[3][4];
 			= int []array2[] = new int[3][4];
 			= int [][]array2 = new int[3][4];
 			= int **array2 = new int[3][4];
 			
 			int array2[3][4] = {
 			{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
 			}; 
 			
 			
 			cArr[][]
 			= cArr**
 			cArr[1][1]
 			= *(*(cArr + 1) + 1)
		 
		 
		 */
		
		
		int array[][] = new int[3][];
		int row1[] = {1, 2, 3};
		int row2[] = {2, 3, 4, 5};
		
		
		array[0] = row1;
		array[1] = row2;
		array[2] = row1;
		
		// 자릿수를 통일하고 싶을 때 row2
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		
		// 다른 자릿수를 전부 나타내고 싶을 때 row2
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		
		char cArr[][] = {
				{'A', 'B' , 'C'},
				{'D', 'E' , 'F'}
		};
		
		for (int i = 0; i < cArr.length; i++) {
			for (int j = 0; j < cArr[i].length; j++) {
				System.out.print(cArr[i][j]+" ");
			}
			System.out.println();
		}
		
		/*
		int array2[][] = new int[3][2];
		array2[0][0] = 11;
		array2[0][1] = 12;
		array2[1][0] = 21;
		array2[1][1] = 22;
		array2[2][0] = 31;
		array2[2][1] = 32;
		
		// alias -> pointer
		int array1[] = {111, 222, 333};
		int alias[] = array1;
		
		for (int i = 0; i < alias.length; i++) {
			System.out.println(alias[i]);
		}
		
		alias[1] = 200;
		System.out.println(array1[1]);
		
		// foreach
		for (int n: array1) {
			System.out.println("n: " + n);
		}
		
		// 2차원 선언
		int array3[][] = new int[3][];
		int row3[] = {2,5,7,12};
		int row4[] = {1,5,8,2};
		int row5[] = {9,0,3,112};
		

		
		// 값을 대입
		array3[0] = row3;
		array3[1] = row4;
		array3[2] = row5;
		
		// 출력
		for (int i = 0; i < array3.length; i++) {
			for (int j = 0; j < array3[i].length; j++) {
				System.out.print(array3[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		*/
		
		// 2차원 배열 -> 1차원 배열 2*3 = 6
		
		int array4[][] = new int[2][];
		int row11[] = {1,2,3};
		int row22[] = {2,2,2};
		
		int array5[] = new int[6];
		

		// 값을 대입
		array4[0] = row11;
		array4[1] = row22;
		
		
		// 출력
		
		for (int i = 0; i < array4.length; i++) {
			for (int j = 0; j < array4[i].length; j++) {
				array5[0] = array5[0] + array4[i][j];
			}
		} System.out.println("array5[0]: " + array5[0]);
		
		System.out.println();

		
		 		// 2차원 배열 -> 1차원 배열 2*3 = 6
		/*  
		 
		int array2[][] = {
				{1,2,3,4},
				{2,3,4,5},
				{3,4,5,6},
		};
		
		int array1[] = new int[array2.length * array2[0].length];
		
//		 	array2[0][0]	array2[0].length == 4  * 0 + 0
//		 	array2[0][1]	array2[0].length == 4  * 0 + 1
//		 	array2[0][2]	array2[0].length == 4  * 0 + 2
//		 	array2[0][3]	array2[0].length == 4  * 0 + 3
		 	

		
		
		for (int i = 0; i < array2.length; i++) { // 0 1 2
			for (int j = 0; j < array2[0].length; j++) { // 0 1 2 3
				array1[array2[0].length * i + j] = array2[i][j];
			}
			
		}
		
		for (int i = 0; i < array1.length; i++) {
			System.out.println("array1[" + i + "]: " + array1[i]);
		}
		
		
		*/
		
		
		
	}

}
