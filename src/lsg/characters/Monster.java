package lsg.characters;

import lsg.buffs.talismans.Talisman;

public class Monster extends Character{

    private static int INSTANCES_COUNT = 0;
    private Talisman talisman;
    private float skinThickness = 20;

    public Monster() {
        this("Monster_" + INSTANCES_COUNT);
    }

    public Monster(String name){
        super(name,10,10,10,10);
        INSTANCES_COUNT ++;
    }

    @Override
    protected float computeProtection() {
        return skinThickness;
    }

    public float getSkinThickness(){
        return skinThickness;
    }

    protected void setSkinThickness(float skinThickness){
        this.skinThickness = skinThickness;
    }

    public void setTalisman(Talisman talisman){
        this.talisman = talisman;
    }

    public Talisman getTalisman() {
        return talisman;
    }

    @Override
    protected float computeBuff() {
        if(talisman != null)
            return talisman.computeBuffValue();
        else
            return 0;
    }
}
