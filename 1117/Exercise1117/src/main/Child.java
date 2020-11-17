package main;

class Child extends Parent {
	int x = 3000;
	Child() {
	this(1000);
	}
	Child(int x) {
	this.x = x;
	}
	int getX() {
	return x;
	}
}
