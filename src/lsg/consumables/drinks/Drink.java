package lsg.consumables.drinks;

import lsg.characters.Character;
import lsg.consumables.Consumable;

public abstract class Drink extends Consumable{

    public Drink(String name, int capacity){
        super(name,capacity, Character.STAM_STAT_STRING);
    }
}
