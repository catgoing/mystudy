
public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		x1, y1 x2,y2
		루트 [ (y2-y1)제곱 + (x2 - x1)제곱]
		
		*/
/*
 
		array[0] { 5,7};
		array[1] {10, 15};
		
		array[0][0] - array[1][0]
		array[0][1] - array[1][1]
				
	*/	
		
		int x1, y1, x2, y2;
		double result;
		x1 = 0;
		y1 = 0;
		x2 = 1;
		x2 = 1;
		
		result = getDistance(x1,y1,x2,x2);
		System.out.println("두 점의 거리: " + result);

	}	
	static double getDistance(int x1, int y1, int x2, int y2) {
		/*
		 	루트: math.sqrt
		 	제곱: math.pow
		 */
		/*
		double value;
		
		value = Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2);
		value = Math.sqrt(value);
		
		return value;
		*/
		
		return Math.sqrt(Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2));
	}
		
}
	
	

