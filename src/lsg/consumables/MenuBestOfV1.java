package lsg.consumables;

import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.drinks.Wine;
import lsg.consumables.food.Americain;
import lsg.consumables.food.Hamburger;

import java.util.logging.ConsoleHandler;

public class MenuBestOfV1{

    private Consumable[] menu;

    public MenuBestOfV1(){
        menu = new Consumable[] {
                new Hamburger(),
                new Wine(),
                new Americain(),
                new Coffee(),
                new Whisky()
        };
    }

    @Override
    public String toString(){
        String result = getClass().getSimpleName() + " :\n";
        for(int i = 0; i < menu.length; i++){
            result += (i+1) + " : " + menu[i].toString() + "\n";
        }
        return result;
    }

    public static void main(String[] args){
        MenuBestOfV1 m1 = new MenuBestOfV1();
        System.out.print(m1.toString());
    }
}

