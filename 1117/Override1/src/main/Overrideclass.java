package main;

import child1.child1;
import child2.child2;
import parent.parent;

public class Overrideclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		child1 one = new child1();
		child2 two = new child2();
		*/
		
		
		parent p1 = new child1();
		parent p2 = new child2();
		
		((child1)p1).func();
		
		/*
		child1 c1 = (child1)p1;
		c1.func();
		
		child1 c2 = new child1();
		c2.func();
		
		parent p = c2;
		*/
		
	
//		Object ob1 = new child1();
//		Object ob2 = new child2();
//		
//		child1 one = (child1)ob1;
//		one.func();
		
		
		
		
		/*
		parent parr[] = new parent[10];
		parr[0] = new child1();
		parr[1] = new child2();
		parr[2] = new child2();
		parr[3] = new child2();
		parr[4] = new child1();
		parr[5] = new child1();
		parr[6] = new child2();
		parr[7] = new child1();
		parr[8] = new child1();
		parr[9] = new child2();
		
		for (parent p : parr) {
			p.method();
		}
		*/
		
		

	}

}
