package main;

public class QueueClass {
	
	
	private int front;
	private int rear;
	
	private int maxSize;
	
	private Object queueArray[];
	
	public QueueClass(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new Object[maxSize];
		front = 0;
		rear = -1;
	}
	
	public boolean isEmpty() {
		return (front == rear + 1);
	}
	
	public boolean isFull() {
		return (rear == maxSize -1);
	}
	
	public void push(Object obj) {
		if(isFull()) {
			System.out.println("공간이 가득 찼습니다");
			return;
		}
		rear++;
		queueArray[rear] = obj;
	}
	
	public Object pop() {
		Object obj = pick();
		
		if(front > maxSize -1) {
			return null;
		}
		front++;
		return obj;
	}
	
	public Object pick() {
		if(isEmpty()) {
			System.out.println("데이터가 없습니다");
			return null;
		}
		return queueArray[front];
		
	}
	
}
