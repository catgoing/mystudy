
public class Funcwork2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 암호화, 복호화
		String originalcode = "abc012";
				
		
		
		String resultcode = encoding(originalcode);
		
		System.out.println("resultcode: " + resultcode);
		
		String basecode = deciph(resultcode);
		System.out.println("resultcode: " + basecode);
		
		
		

	}
	static String encoding(String originalcode) {
		String resultcode = "";
		
		char[] abcCode =
			{ '`','~','!','@','#','$','%','^','&','*',
			'(',')','-','_','+','=','|','[',']','{',
			'}',';',':',',','.','/'};

				// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
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
		
		return resultcode;
		
	}
	
	static String deciph(String resultcode) {
		
		char[] abcCode =
			{ '`','~','!','@','#','$','%','^','&','*',
			'(',')','-','_','+','=','|','[',']','{',
			'}',';',':',',','.','/'};

				// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
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
		return basecode;
	}
}
