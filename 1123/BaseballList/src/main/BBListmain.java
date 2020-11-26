package main;

import dao.Memberdao;

public class BBListmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Memberdao bbl = new Memberdao();
		
//		bbl.insert();
//		bbl.insert();
////		bbl.insert();
		bbl.Allprint();
		bbl.delete();
		bbl.Allprint();
//		bbl.insert();
		bbl.select();
//		bbl.Allprint();
		

	}

}
