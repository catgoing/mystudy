package main;

public class Queuemainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QueueClass queue = new QueueClass(5); // first in first out
		
		String str = "one";
		queue.push(str);
		
		String front = (String)queue.pick(); // cast 왜...
		System.out.println("front = " + front);
		
		str = "two";
		queue.push(str);
		front = (String)queue.pick(); // cast 왜...
		System.out.println("front = " + front);
		
		str = "3";
		queue.push(str);
		front = (String)queue.pick(); // cast 왜...
		System.out.println("front = " + front);
		
		queue.pop();	// 첫 번째 데이터 제거
		front = (String)queue.pick(); // cast 왜...
		System.out.println("front = " + front);
		queue.pop();	// 두 번째 데이터 제거
		front = (String)queue.pick(); // cast 왜...
		System.out.println("front = " + front);


	}

}
