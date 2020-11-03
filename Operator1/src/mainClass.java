
public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	operator
		 	+, -, *, /, %
		 	/ : 몫 , % : 나머지
		 	
		 		 
		 */
		
		int num1, num2;
		int result;		// 결과
		
		num1 = 25;
		num2 = 7;
		
		result = num1 % num2;
		System.out.println("num1 % num2 = " + result);
			
		// 주의점
		// /, %을 사용할 때 분모에 0이 오면 안 됨
		
		num2 = 0;
		
		/*
		result = num1 / num2;
		System.out.println("num1 / num2 = " + result);
		
		result = num1 % num2;
		System.out.println("num1 % num2 = " + result);
		*/
		
		// 연산 중 빈도 1위
		int n = 0;
		n = n + 1;  // 자기자신을(n)을 갱신 = n += 1;
		System.out.println("n = " + n);
		
		/*
		n += 1;
		System.out.println("n = " + n);
		 */
		
		// increment(증가), decrement(감소)
		
		n = 0;
		
		n++;	// n = n + 1
		System.out.println("n = " + n);
		++n;
		System.out.println("n = " + n);
		++n;
		System.out.println("n = " + n);
		
		n--;
		System.out.println("n = " + n);
		--n;
		System.out.println("n = " + n);
		
	int num;
	num = 1;
	
	int tag;
	// num++;
	// tag = num++;
	// tag = ++num;
	// tag = (num++); // 이것은 tag = num++와 결과가 같음
	
	// System.out.println("tag = " + tag);
	System.out.println("num = " + num);

	}

}
