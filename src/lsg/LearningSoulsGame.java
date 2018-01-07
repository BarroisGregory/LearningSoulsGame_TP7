package lsg;
import lsg.armor.ArmorItem;
import lsg.armor.BlackWitchVeil;
import lsg.armor.DragonSlayerLeggings;
import lsg.armor.RingedKnightArmor;
import lsg.bags.MediumBag;
import lsg.bags.SmallBag;
import lsg.buffs.rings.DragonSlayerRing;
import lsg.buffs.rings.RingOfDeath;
import lsg.characters.*;
import lsg.characters.Character;
import lsg.consumables.MenuBestOfV4;
import lsg.consumables.drinks.Coffee;
import lsg.consumables.drinks.Drink;
import lsg.consumables.drinks.Whisky;
import lsg.consumables.food.Hamburger;
import lsg.consumables.repair.RepairKit;
import lsg.exceptions.*;
import lsg.weapons.Claw;
import lsg.weapons.ShotGun;
import lsg.weapons.Sword;
import lsg.weapons.Weapon;
import lsg.consumables.Consumable;
import sun.reflect.annotation.EnumConstantNotPresentExceptionProxy;
import sun.reflect.annotation.ExceptionProxy;

import java.util.Scanner;

public class LearningSoulsGame {

     private Scanner scanner = new Scanner(System.in);
     private Hero hero;
     private  Monster monster;
     public static final String BULLET_POINT = "\u2219 ";

     private void refresh(){
        hero.printStats();
        hero.printArmor();
        hero.printRings();
        hero.printConsumable();
        hero.printWeapon();
        hero.printBag();

        System.out.println();

        monster.printStats();
        monster.printWeapon();
    }

     private void fight1v1(){
        Character attaquant = hero;
        Character defenseur = monster;
        Character temp;
        int action = 0;
        int hitValue, damage;

        refresh();
        while(hero.isAlive() && monster.isAlive()){
            System.out.println();

            if (attaquant instanceof Hero){
                action = 0;
                while(action != 1 && action != 2) {
                    System.out.println("Hit enter key for next move : (1) attack | (2) consume >");
                    action = scanner.nextInt();
                }
            }

            else{
                action = 1;
            }

            switch (action){
                case 1:
                    try {
                        hitValue = attaquant.attack();
                    }catch(WeaponNullException e){
                        hitValue = 0;
                        System.out.println("WARNING: no weapon has been equiped !!!");
                    }catch(WeaponBrokenException e){
                        hitValue = 0;
                        System.out.println("WARNING: " + e);
                    }catch(StaminaEmptyException e){
                        hitValue = 0;
                        System.out.println("ACTION HAS NO EFFECT: no more stamina !!!");
                    }

                    damage = defenseur.getHitWith(hitValue);

                    try {
                        System.out.println(attaquant.getName() + " attacks " + defenseur.getName() + " with " + attaquant.getWeapon().getName() + " (ATTACK:" + hitValue + " | DMG : " + damage + ")");
                    }catch(NullPointerException e){
                        System.out.println(attaquant.getName() + " attacks " + defenseur.getName() + " with " + attaquant.getWeapon() + " (ATTACK:" + hitValue + " | DMG : " + damage + ")");
                    }
                    break;
                case 2:
                    try{
                        attaquant.consume();
                    }catch(ConsumeNullException e){
                        System.out.println("IMPOSSIBLE ACTION : no consumable has been equiped");
                    }catch(ConsumeEmptyException e){
                        System.out.println("ACTION HAS NO EFFECT : " + e.getConsumable().getName() + " is empty !");
                    }catch(ConsumeRepairNullWeaponException e){
                        System.out.println("IMPOSSIBLE ACTION : no weapon has been equiped !");
                    }

                    break;
                default:
                    ;
            }

            temp = attaquant;
            attaquant = defenseur;
            defenseur = temp;
            refresh();
        }

        System.out.println("--- " + (hero.isAlive() ? hero.getName() : monster.getName()) + " WINS !!! ---");
    }

    private void init(){
        hero = new Hero();
        hero.setWeapon(new Sword());
        hero.setConsumable(new Hamburger());
        monster = new Monster();
        monster.setWeapon(new Claw());
    }

    private void play_v1(){
        init();
        fight1v1();
    }

    private void play_v2(){
        init();
        hero.setArmorItem(new DragonSlayerLeggings(), 1);
        fight1v1();
    }

    private void play_v3(){
        init();
        hero.setArmorItem(new DragonSlayerLeggings(), 1);
        DragonSlayerRing ring1 = new DragonSlayerRing();
        hero.setRing(ring1,1);
        RingOfDeath ring2 = new RingOfDeath();
        hero.setRing(ring2,2);
        fight1v1();
    }

    public void createExhaustedHero(){
        hero = new Hero();
        hero.getHitWith(99);
        hero.setWeapon(new Weapon("Grosse arme", 0, 0, 1000, 100));
        try{
            hero.attack();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void title(){
        System.out.println("##########################");
        System.out.println("# THE LEANING SOULS GAME #");
        System.out.println("##########################");
    }

    public void testExceptions(){

        // Test WEAPON NULL
        try{
            hero.setWeapon(null);
            hero.attack();
        }catch(Exception e){
            System.out.println(e);
        }

        // Test WEAPON BROKEN
        try{
            hero.setWeapon(new Weapon("Broken Sword", 0, 0, 10, 0));
            hero.attack();
        }catch(Exception e){
            System.out.println(e);
        }

        // Test REPAIR WEAPON NULL
        try{
            hero.setWeapon(null);
            hero.pickUp(new RepairKit());
            hero.fastRepair();
        }catch(Exception e){
            System.out.println(e);
        }
        // Test NO STAMINA
        try{
            hero.setWeapon(new Weapon("Exhaustator", 0, 0, 1000, 10));
            for(;;){
                hero.attack();
            }
        }catch (Exception e){
            System.out.println(e);
        }

        // Test CONSUME NULL
        try{
           hero.setConsumable(null);
            hero.consume();
        }catch(Exception e){
            System.out.println(e);
        }


        // Test CONSUMABLE EMPTY
        try{
            hero.setConsumable(new Coffee());
            for(;;){
                hero.consume();
            }
        }catch(Exception e){
            System.out.println(e);
        }

        // Test BAG NULL
        try{
            hero.setBag(null);
            hero.pickUp(new RepairKit());
        }catch (Exception e){
            System.out.println(e);
        }

        // Test pas d'item dispo dans le sac pour faire l'action
        try{
            hero.setBag(new MediumBag());
            hero.pickUp(new RepairKit());
            for(;;){
                hero.fastRepair();
            }
        }catch (Exception e){
            System.out.println("\n" + e);
        }

        // Test BAG FULL
        try{
            hero.setBag(new SmallBag());
            for(;;){
                hero.pickUp(new RepairKit());
            }
        }catch (Exception e){
            System.out.println("\n" + e);
        }


        fight1v1();
    }

    public static void main(String[] args){
        LearningSoulsGame game = new LearningSoulsGame();
        game.init();
        game.testExceptions();
    }
}