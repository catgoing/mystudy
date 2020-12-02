package main;

public class MainclassThreadex {

	public static void main(String[] args) {
		
		System.out.println("안녕하세요");
		Thread thread1 = new ThreadEx("안");
		Thread thread2 = new ThreadEx("녕");
		thread1.start();		// start를 하면 run함수를 불러냄
		thread2.start();
		
		// 멀티 쓰레드는 각각 포문을 설정해도 다 같이 돌아감
		
		
		System.out.println("out");
				

	}

}
