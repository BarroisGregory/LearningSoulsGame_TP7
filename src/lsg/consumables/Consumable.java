package lsg.consumables;

import lsg.exceptions.ConsumeEmptyException;

public class Consumable implements lsg.bags.Collectible{

    private String name;
    private int capacity;
    private String stat;

    public Consumable(String name, int capacity, String stat){
        this.name = name;
        this.capacity = capacity;
        this.stat = stat;
    }

    public int getWeight(){
        return 1;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStat() {
        return stat;
    }

    private void setStat(String stat) {
        this.stat = stat;
    }

    public int use() throws ConsumeEmptyException{
        if(capacity <= 0){
            throw new ConsumeEmptyException(this);
        }
        int tmpCapacity = getCapacity();
        this.setCapacity(0);
        return tmpCapacity;
    }

    @Override
    public String toString(){
        return getName() + " [" + getCapacity() + " " + getStat() + " point(s)]";
    }
}
