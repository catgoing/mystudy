package ex5;

class Exercise5 {
	
	public static void main(String[] args) {
		Robot[] arr = { new DanceRobot(), new SingRobot(),
		new DrawRobot()};
		System.out.println(arr[0]);
		for(int i=0; i< arr.length;i++)
		action(arr[i]);
		} // main

	
		
	}





class Robot {}




class DanceRobot extends Robot {
	void dance() {
	System.out.println("춤을 춥니다.");
	}
}

class SingRobot extends Robot {
	void sing() {
	System.out.println("노래를 합니다.");
	}
}

class DrawRobot extends Robot {
	void draw() {
	System.out.println("그림을 그립니다.");
	}
}
}
