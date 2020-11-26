package factory;

import bomb.Bomb;
import types.Abstractitem;
import weapon.Weapon;

public class CharFactory {
	
	public Weapon mWeapon;
	public Bomb mBomb;
	
	public void create(Abstractitem ai) {
		mWeapon = ai.createWeapon();
		mBomb = ai.createBomb();
		
		
	}

}
