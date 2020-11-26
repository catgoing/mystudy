package main;

import factory.CharFactory;
import types.Atype;

public class Characterfactorymainclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CharFactory char1 = new CharFactory();
		char1.create(new Atype());
		
		char1.mWeapon.drawWeapon();
		char1.mBomb.drawBomb();

	}

}
