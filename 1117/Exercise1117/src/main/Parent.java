package main;

public class Parent {
	
	int x=100;
	Parent() {
	this(200);
//	System.out.println(x);
	}
	Parent(int x) {
	this.x = x;
	}
	int getX() {
	return x;
	}
}
