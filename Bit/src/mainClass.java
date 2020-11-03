
public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	bit: 0, 1
		 	
		 	& 	and
		 	| 	or
		 	^	xor
		 	<<	left shift
		 	>>	right shift
		 	~	반전
		 	
		 	
		 */
		
		int result;
		
		// and		1011 1100 -> 16진수 -> BC
		//			8421 8421
		//			1100 1001 -> 16진수 -> C9
		//			1000 1000 -> 16진수 -> 88
		result = 0xBC & 0xC9;
		System.out.println(result);
		System.out.printf("%x \n", result);
		
		/*
		 	0x5D | 0xE3
		 	0101 1100
		 or 1110 0011
		 	1111 1111
		 	F	 F
		 			 	
		 */
		
		result = 0x5D | 0xE3;
		System.out.println(result);
		System.out.printf("%x \n", result);
		
		/*
		 	xor
		 	0x37 ^ 0xAB
		 	
		 */
		result = 0x37 ^ 0xAB;
		System.out.println(result);
		System.out.printf("%x \n", result);
		
		// ~ 반전  0을 1로, 1을 0으로
		byte by = ~0x55;   // 0101 0101 -> 1010 1010 -> 0xAA
		System.out.printf("%x \n", by);
		
		/*
		 	left shift  왼쪽으로 한 칸씩 이동 후 끝자리 0 채움 1010 1100 -> 10101 1000
		 	right shift 오른쪽으로 한 칸씩 이동 1000 > 100
		 			 	
		 */
		byte by1;
		by1 = 0x1 << 1;
		System.out.println(by1);
		
		by1 <<= 3;
		System.out.println(by1);
		
		by1 >>= 1;
		System.out.println(by1);
		

	}

}
