package main;

public class Treemainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node node1 = new Node(111); // wrapper 클래스라서 new Integer(1)을 그냥 1로...?
		
		Node node2 = new Node(222);
		Node node3 = new Node(333);
		
		node1.makeLeftSubTree(node2);
		node1.getLeftSubTree().makeRightSubTree(node3);		// 왜 서브트리 옆에 .make...?
		
		System.out.println(node1.getLeftSubTree().getRightSubTree());
		
	}

}
