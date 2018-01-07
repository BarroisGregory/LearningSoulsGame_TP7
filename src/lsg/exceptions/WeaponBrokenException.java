package lsg.exceptions;

import lsg.weapons.Weapon;
public class WeaponBrokenException extends Exception{

    private Weapon weapon;

    public WeaponBrokenException(Weapon weapon){
        super();
        this.weapon = weapon;
    }

    @Override
    public String toString(){
        return "weapon is broken !";
    }

    public Weapon getWeapon(){
        return weapon;
    }
}
