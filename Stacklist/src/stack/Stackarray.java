package stack;

import java.util.ArrayList;
import java.util.List;

public class Stackarray {
	
	private int maxsize;
	
	private List<Object> list = new ArrayList<Object>();
	
	public Stackarray() {
		maxsize = 10;
	}
	
	public boolean isEmpty() {
		return (list.size() == 0);
	}

	public boolean isFull() {
		return(list.size()>=10);
	}
	
	public void push(Object obj) {
		if(isFull()) {
			return;
		}
		list.add(obj);
		
	}
	
	// pop
	public Object pop() {
		Object obj = peek();
		list.remove(obj);
		return obj;
	}
	
	// pick
	public Object peek() {
		if(isEmpty()) {
			return null;
		}
		return list.get(list.size() - 1);
	}
	
	
}
