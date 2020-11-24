package main;

public class StackClass {
	
	private int top;
	private int maxSize;
	
	private Object stackArray[]; // 자료를 담는 공간
	
	public StackClass(int maxSize) {
		this.maxSize = maxSize;
		top = -1;
		
		stackArray = new Object[maxSize];
		
	}
	
	public boolean isEmpty() { // 공간이 비어 있는지 여부 확인하는 메소드
		return (top == -1);
	}
	
	public boolean isFull() {  // 공간이 가득 차 있는지 여부
		return (top == maxSize - 1);
	}
	
	public void push(Object obj) {  // 공간에 값 추가
		if(isFull()) {
			System.out.println("가득 찼습니다");
			return;
		}
		top++;
		stackArray[top] = obj;
	}
	
	public Object pop() {
		Object obj = peek();
		
		if(top <= -1) {
			System.out.println("값이 없습니다");
			return null;
		}
		top--;
		return obj;
		
	}
	
	public Object peek() {
		if(isEmpty()) {
			System.out.println("값이 없습니다");
			return null;
		}
		return stackArray[top];
	}
}
