package lsg.armor;

public class ArmorItem implements lsg.bags.Collectible{

    private String name;
    private float armorValue;

    public ArmorItem(){
        this("Default",1.0f);
    }

    public ArmorItem(String name, float armorValue){
        this.name = name;
        this.armorValue = armorValue;
    }

    public int getWeight(){
        return 4;
    }

    public String getName(){
        return name;
    }

    public float getArmorValue(){
        return armorValue;
    }

    @Override
    public String toString(){
        return name + "(" + armorValue + ")";
    }
}
