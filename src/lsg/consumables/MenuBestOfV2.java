package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.ConsoleHandler;

public class MenuBestOfV2{

    private HashSet<Consumable> menu;

    public MenuBestOfV2(){
        menu = new HashSet<>();
        menu.add(new Hamburger());
        menu.add(new Wine());
        menu.add(new Americain());
        menu.add(new Coffee());
        menu.add(new Whisky());
    }

    @Override
    public String toString(){
        String result = getClass().getSimpleName() + " :\n";
        int i = 0;
        Iterator<Consumable> iterator = menu.iterator();
        while(iterator.hasNext()){
            result += (i+1) + " : " + iterator.next().toString() + "\n";
            i++;
        }
        return result;
    }

    public static void main(String[] args){
        MenuBestOfV2 m1 = new MenuBestOfV2();
        System.out.print(m1.toString());
    }

}

