package main;

import child.childclass;
import child1.child1class;
import parent.parentclass;

public class Overrideclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 	override: 상속받은 후 자식클래스에서 상속받은 함수를 고쳐 기입하는 것
		 	* 상속받은 함수와 prototype이 같아야 함

		 	ex)
		 	public void func(int n){
		 	}
		 	public double func(String st){
		 	}
		 	
		 */
		
//		childclass cc = new childclass();
//		cc.parentmethod();
		
		parentclass pp = new childclass();
		
		pp.parentmethod();
		
		/*
		childclass childarr[] = new childclass[5];
		child1class child1arr[] = new child1class[3];
		
		childarr[0] = new childclass();
		childarr[1] = new childclass();
		childarr[2] = new childclass();
		
		child1arr[0] = new child1class();
		child1arr[1] = new child1class();
		child1arr[2] = new child1class();
		
		
		parentclass parr[] = new parentclass[8];
		
		parr[0] = new childclass();
		parr[1] = new child1class();
		parr[2] = new childclass();
		*/
		
		

	}

}
