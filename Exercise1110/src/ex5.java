
public class ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 배열 값의 2배가 출력되도록 하는 함수
		int num[] = {1, 2, 3, 4, 5};
		
		getDouble(num);
		for (int i : num) {
			System.out.println(i + " ");
		}
		
		System.out.println();
		
		// 몫과 나머지 구하는 함수
		int num1, num2;
		int result, tag[] = new int[1];
		num1 = 9;
		num2 = 2;
		
		result = getResult(num1, num2, tag);
		System.out.println("목: " + result);
		System.out.println("나머지: " + tag[0]);
		
	}

	static void getDouble(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] *2;
		}
	}
	
	static int getResult(int n1, int n2, int t[]) {
		int result = n1 / n2;
		t[0] = n1 % n2;
		
		return result;
	}
	
}
