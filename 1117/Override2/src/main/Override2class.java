package main;

import child1.child1;
import child2.child2;
import parent.parent;

public class Override2class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	instanceOf:	instance를 구별하기 위한 키워드
		 	
		 */
		
		parent parr[] = new parent[3];
		parr[0] = new child1();
		parr[1] = new child2();
		parr[2] = new child2();
		
		for (int i = 0; i < parr.length; i++) {
			parr[i].method();
			
			if(parr[i] instanceof child1) {
				((child1)parr[i]).child1method();
			}
			else if(parr[i] instanceof child2) {
				child2 ch = (child2)parr[i];
				ch.child2method();
			}
		}
		
//		child1 one = (child1)parr[0];
//		one.child1method();
		
		if(parr[0] instanceof child1) {
			System.out.println("parr[0]는 child1로 생성되었음");
		}

	}

}
