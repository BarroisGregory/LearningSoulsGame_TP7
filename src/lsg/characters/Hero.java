package lsg.characters;

import lsg.armor.*;
import lsg.buffs.BuffItem;
import lsg.buffs.rings.*;
import lsg.exceptions.NoBagException;

import java.util.Locale;

public class Hero extends Character {

    private static int MAX_ARMOR_PIECES = 3;
    private static int MAX_RINGS = 2;
    private ArmorItem[] armor;
    private Ring[] rings;

    public Hero() {
        this("Gregooninator");
    }

    public Hero(String name) {
        super(name, 100, 100, 50, 50);
        armor = new ArmorItem[MAX_ARMOR_PIECES];
        rings = new Ring[MAX_RINGS];
    }

    public void setArmorItem(ArmorItem armor, int slot) {
        if (slot > 0 && slot <= MAX_ARMOR_PIECES)
            this.armor[slot - 1] = armor;
    }

    public float getTotalArmor() {
        float armorValue = 0;
        for (ArmorItem armor : this.armor) {
            if (armor != null) {
                armorValue += armor.getArmorValue();
            }
        }
        return armorValue;
    }

    public String armorToString() {
        int increment = 1;
        String result = "ARMOR ";

        for (ArmorItem armor : this.armor) {
            if (armor != null) {
                result += String.format(" %2d:%-30s", increment, armor.toString());
            } else {
                result += String.format(" %2d:%-30s", increment, "empty");
            }
            increment++;
        }
        return result += String.format(Locale.ROOT, "TOTAL:%.1f", getTotalArmor());
    }

    public void printArmor(){
        System.out.println(armorToString());
    }

    public ArmorItem[] getArmorItems() {

        int tabArmorSize = MAX_ARMOR_PIECES;
        for (ArmorItem armor : this.armor) {
            if (armor == null) {
                tabArmorSize--;
            }
        }

        int i = 0;
        ArmorItem[] tabArmor = new ArmorItem[tabArmorSize];
        for (ArmorItem armor : this.armor) {
            if (armor != null) {
                tabArmor[i] = armor;
                i++;
            }
        }

        return tabArmor;
    }

    @Override
    protected float computeProtection() {
        return getTotalArmor();
    }

    public void setRing(Ring ring, int slot) {
        if (slot > 0 && slot <= MAX_RINGS)
            rings[slot - 1] = ring;
        ring.setHero(this);
    }

    public void printRings(){
        int increment = 1;
        String result = "RINGS";

        for (BuffItem ring : this.rings) {
            if (ring != null) {
                result += String.format(" %2d:%-30s", increment, ring.toString());
            } else {
                result += String.format(" %2d:%-30s", increment, "empty");
            }
            increment++;
        }
        System.out.println(result);
    }

    public Ring[] getRings(){
        int tabRingSize = MAX_RINGS;
        for (Ring ring : this.rings) {
            if (ring == null) {
                tabRingSize--;
            }
        }

        int i = 0;
        Ring[] tabRing = new Ring[tabRingSize];
        for (Ring ring : this.rings) {
            if (ring != null) {
                tabRing[i] = ring;
                i++;
            }
        }

        return tabRing;
    }

    @Override
    protected float computeBuff() {
        float totalBuff = 0;
        for (Ring ring : this.rings) {
            if(ring != null)
                totalBuff += ring.computeBuffValue();
        }
        return totalBuff;
    }

    public void equip(ArmorItem item, int slot) throws NoBagException{
        if(pullOut(item) != null) {
            this.setArmorItem(item, slot);
            System.out.println(" and equips it !");
        }
    }

    public void equip(Ring ring, int slot) throws NoBagException{
        if(pullOut(ring) != null){
            this.setRing(ring, slot);
            System.out.println(" and equips it !");
        }
    }

    public static void main(String[] args){
        Hero hero = new Hero();
        hero.setArmorItem(new BlackWitchVeil(), 1);
        hero.setArmorItem(new RingedKnightArmor(), 3);
        System.out.print(hero.armorToString());
    }
}