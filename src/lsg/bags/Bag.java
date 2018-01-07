package lsg.bags;

import lsg.LearningSoulsGame;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.armor.RingedKnightArmor;
import lsg.buffs.rings.DragonSlayerRing;
import lsg.consumables.food.Hamburger;
import lsg.exceptions.BagFullException;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;

import java.util.HashSet;
import java.util.Iterator;

public class Bag {

    private int capacity;
    private int weight;
    private HashSet<Collectible> items;

    public Bag(int capacity){
        this.capacity = capacity;
        items = new HashSet<Collectible>();
    }

    public int getCapacity() {
        return capacity;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getWeight() {
        return weight;
    }

    protected void setWeight(int weight) {
        this.weight = weight;
    }

    public void push(Collectible item) throws BagFullException{
        if(capacity < this.weight + item.getWeight()){
            throw new BagFullException(this);
        }
        if(this.weight + item.getWeight() <= capacity) {
            items.add(item);
            weight += item.getWeight();
        }
    }

    public Collectible pop(Collectible item){
        Iterator<Collectible> it = items.iterator();
        while(it.hasNext()) {
            Collectible c = it.next();
            if (c == item) {
                it.remove();
                weight -= c.getWeight();
                return c;
            }
        }
        return null;
    }

    public boolean contains(Collectible item){
        return items.contains(item);
    }

    public Collectible[] getItems(){
        return items.toArray(new Collectible[items.size()]);
    }

    public static void transfer(Bag from, Bag into){
        if(from == null || into == null){
            return;
        }

        if(from == into){
            return;
        }

        for(Collectible item: from.getItems()){
            try{
                into.push(item);
                if(into.contains(item)){
                    from.pop(item);
                }
            }catch (BagFullException e){
                System.out.println("Bag is full !");
            }

        }
    }

    @Override
    public String toString(){
        String result = String.format("%s [ %d items | %d/%d kg ]",
                getClass().getSimpleName(),
                items.size(),
                weight,
                capacity
        );
        if(items.size() == 0){
            result += "\n" + LearningSoulsGame.BULLET_POINT + "(empty)";
        }
        else{
            for (Collectible item: items) {
                result += "\n"+ LearningSoulsGame.BULLET_POINT + item.toString() + "[" + item.getWeight() + " kg]";
            }
        }
        return result;
    }
}
