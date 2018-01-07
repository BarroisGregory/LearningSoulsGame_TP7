package lsg.characters;

import lsg.weapons.Claw;

public class Lycanthrope extends Monster {

    public Lycanthrope(){
        super("Lycanthrope");
        setSkinThickness(30);
        this.setWeapon(new Claw());
    }
}
