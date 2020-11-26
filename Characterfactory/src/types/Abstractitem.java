package types;

import bomb.Bomb;
import weapon.Weapon;

public interface Abstractitem {
	
	public Weapon createWeapon();
	public Bomb createBomb();

}
