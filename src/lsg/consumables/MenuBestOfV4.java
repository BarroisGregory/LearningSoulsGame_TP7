package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;
import lsg.consumables.repair.RepairKit;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.logging.ConsoleHandler;

public class MenuBestOfV4 extends LinkedHashSet<Consumable>{

    public MenuBestOfV4(){
        this.add(new Hamburger());
        this.add(new Wine());
        this.add(new Americain());
        this.add(new Coffee());
        this.add(new Whisky());
        this.add(new RepairKit());
    }

    @Override
    public String toString(){
        String result = getClass().getSimpleName() + " :\n";
        int i = 0;
        Iterator<Consumable> iterator = this.iterator();
        while(iterator.hasNext()){
            result += (i+1) + " : " + iterator.next().toString() + "\n";
            i++;
        }
        return result;
    }

    public static void main(String[] args){
        MenuBestOfV4 m1 = new MenuBestOfV4();
        System.out.print(m1.toString());
    }

}

