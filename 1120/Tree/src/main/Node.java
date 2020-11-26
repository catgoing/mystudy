package main;

public class Node {
	
	private Node left;
	private Node right;
	private Object data;
	
	public Node(Object data) {
		left = null;
		right = null;
		this.data = data;
		
	}
	
	public void makeLeftSubTree(Node sub) {	// 왼쪽 자식 노드와 연결하는 메소드
		this.left = sub;
	}
	
	public void makeRightSubTree(Node sub) {
		this.right = sub;
	}

	public Object getData() {
		return data;
	}
	
	public Node getLeftSubTree() {
		return this.left;
	}
	
	public Node getRightSubTree() {
		return this.right;
	}
	
	
	
	
	

}
