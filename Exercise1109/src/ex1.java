
public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// TODO 1번 과제
		/*
		int[] arr = {10,20,30,40,50};
		int sum=0;
		
		for(int value: arr) {
			sum = sum + value;
		}

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		*/
		
		//System.out.println("sum: " + sum);

		// TODO 2번 과제
		/*
		int arr[][]= {
				{5,5,5,5,5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}
		};

		int total = 0;
		float average = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total = total + arr[i][j];
			}
		}
		
		average = (float)total / (arr.length * arr[0].length);
		*/
		
		/*
		int arr1[] = new int[arr.length * arr[0].length];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr1[arr[i].length * i + j] = arr[i][j];
			}
		}
		
		for (int i = 0; i < arr1.length; i++) {
			//System.out.println("arr1[" + i + "]: " + arr1[i]);
		}
		
		for (int i = 0; i < arr1.length; i++) {
			total = total + arr1[i];
		}
		
		average = total / (float)arr1.length ;
		*/
		
//		System.out.println("total: " + total);
//		System.out.println("average: " + average);
		
		
		//TODO 3번 과제
				// abcdefghijklmnopqrstuvwxyz
		char[] abcCode =
			{ '`','~','!','@','#','$','%','^','&','*',
			'(',')','-','_','+','=','|','[',']','{',
			'}',';',':',',','.','/'};
		
				// 0 1 2 3 4 5 6 7 8 9
			char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
			
			// 암호화
			String originalcode = "hello201109";
			
			String resultcode = "";
			
			for (int i = 0; i < originalcode.length(); i++) {
				
			
				char c = originalcode.charAt(i);
				int asc = (int)c;
				
				//알파벳
				if(asc>=97 && asc<=122) { // 97~122, 97을 0으로 만들어 0~25으로
					asc = asc-97;
					resultcode = resultcode + abcCode[asc];
				}
				//숫자
				if(asc>=48 && asc<=57) { // 48~47, 48을 0으로 만들어 0~9로
					asc = asc-48;
					resultcode = resultcode + numCode[asc];
				}
			}		
			System.out.println(originalcode);
			System.out.println(resultcode);
					
			
			// 복호화
			String basecode = "";
			
			for (int i = 0; i < resultcode.length(); i++) {
				
				char c = resultcode.charAt(i);
				int asc1 = (int)c;
				if(asc1>=97 && asc1<122) {
					int index = 0;
					for (int j = 0; j < numCode.length; j++) {
						if(c==numCode[j]) {
							index = j;
							break;
						}
					}
					index = index+48;
					basecode = basecode + (char)index;
					
				}else {
					int index = 0;
					for (int j = 0; j < abcCode.length; j++) {
						if(c==abcCode[j]) {
							index = j;
							break;
						}
					}
					index = index + 97;
					basecode = basecode + (char)index;
					
				}
				
			}
			
			System.out.println(basecode);
			
			
			
			
			
			/*
			String src = "abc123";
			String result = "";
			// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
			for(int i=0; i < src.length();i++) {
			char ch = src.charAt(i);
			
			
			
			}
			System.out.println("src:"+src);
			System.out.println("result:"+result);
		*/
			
			
			
			
	}

}
