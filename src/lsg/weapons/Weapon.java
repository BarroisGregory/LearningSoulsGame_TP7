package lsg.weapons;

import lsg.consumables.repair.RepairKit;
import lsg.exceptions.ConsumeEmptyException;
import lsg.exceptions.ConsumeNullException;

public class Weapon implements lsg.bags.Collectible{

    private String name;
    private int minDamage;
    private int maxDamage;
    private int stamCost;
    private int durability;
    public static final String DURABILITY_STAT_STRING = "durability";

    public Weapon(){
        this("Default Weapon", 1, 1 ,1, 1);
    }

    public Weapon(String name, int minDamage, int maxDamage, int stamCost, int durability){
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.stamCost = stamCost;
        this.durability = durability;
    }

    public int getWeight(){
        return 2;
    }

    public String getName() {
        return name;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getStamCost() {
        return stamCost;
    }

    public int getDurability() {
        return durability;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    public void use(){
        setDurability(durability - 1);
    }

    public boolean isBroken(){
        return durability <= 0;
    }

    public void repairWith(RepairKit kit) throws ConsumeNullException, ConsumeEmptyException{
        if(kit == null){
            throw new ConsumeNullException();
        }
        this.durability += kit.use();
    }

    @Override
    public String toString(){
        return String.format("%s (min:%d max:%d stam:%d dur:%d)",
                name, minDamage, maxDamage, stamCost, durability);
    }
}
