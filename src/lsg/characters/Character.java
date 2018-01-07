package lsg.characters;
import lsg.bags.Bag;
import lsg.bags.Collectible;
import lsg.bags.SmallBag;
import lsg.consumables.Consumable;
import lsg.consumables.drinks.Drink;
import lsg.consumables.food.Food;
import lsg.consumables.repair.RepairKit;
import lsg.exceptions.*;
import lsg.helpers.*;
import lsg.weapons.*;

import java.util.Locale;

public abstract class Character {

    private String name;
    private int life;
    private int maxLife;
    private int stamina;
    private int maxStamina;
    private Dice dice;
    private Weapon weapon;
    private Consumable consumable;
    private Bag bag;

    public static final String LIFE_STAT_STRING = "life";
    public static final String STAM_STAT_STRING = "stamina";
    public static final String PROTECTION_STAT_STRING = "protection";
    public static final String BUFF_STAT_STRING = "buff";

    public Character() {
        this("Character", 1, 1, 1, 1);
    }

    public Character(String name, int life, int maxLife, int stamina, int maxStamina){
        this.name = name;
        this.life = life;
        this.maxLife = maxLife;
        this.stamina = stamina;
        this.maxStamina = maxStamina;
        this.dice = new Dice(101);
        this.bag = new SmallBag();
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    protected void setLife(int life) {
        if(life > maxLife)
            this.life = maxLife;
        else
            this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    protected void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getStamina() {
        return stamina;
    }

    protected void setStamina(int stamina) {
        if(stamina > maxStamina)
            this.stamina = maxStamina;
        else
            this.stamina = stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    protected void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public Consumable getConsumable() {
        return consumable;
    }

    public void setConsumable(Consumable consumable){
        this.consumable = consumable;
    }


    public void pickUp(Collectible item) throws NoBagException, BagFullException{
        if(this.bag != null) {
            this.bag.push(item);
            if(this.bag.contains(item)){
                System.out.print(getName() + " picks up " + item );
            }
        }
        else{
            throw new NoBagException();
        }
    }

    public Collectible pullOut(Collectible item) throws NoBagException{
        if(this.bag != null){
            System.out.print(getName() + " pulls out " + item );
            return this.bag.pop(item);
        }
        else{
            throw new NoBagException();
        }
    }

    public void printWeapon(){
        if(this.weapon == null){
            System.out.println("WEAPON : empty");
        }
        else{
            System.out.println("WEAPON : " + weapon.toString() );
        }
    }

    public void printBag(){
        System.out.println("BAG : " + this.bag);
    }

    public int getBagCapacity() throws NoBagException{
        if(this.bag == null){
            throw new NoBagException();
        }
        return this.bag.getCapacity();
    }

    public int getBagWeight() throws NoBagException{
        if(this.bag == null){
            throw new NoBagException();
        }
        return this.bag.getWeight();
    }

    public Collectible[] getBagItems() throws NoBagException{
        if(this.bag == null){
            throw new NoBagException();
        }
        return this.bag.getItems();
    }

    public Bag setBag(Bag bag){

          if(this.bag == null){
              this.bag = bag;
              return null;
          }

          if(bag == null){
              Bag tmp = this.bag;
              this.bag = bag;
              return tmp;
          }

          else {
              Bag tmp;
              Bag.transfer(this.bag, bag);
              tmp = this.bag;
              this.bag = bag;
              System.out.println(getName() + " changes " + tmp.getClass().getSimpleName() + " for " + bag.getClass().getSimpleName());
              return tmp;
          }
    }

    public void equip(Weapon weapon) throws NoBagException{
        if(pullOut(weapon) != null){
            setWeapon(weapon);
            System.out.println(" and equips it !");
        }
    }

    public void equip(Consumable consumable) throws NoBagException{
        if(pullOut(consumable) != null){
            setConsumable(consumable);
            System.out.println(" and equips it !");
        }
    }

    public void consume() throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException{
        use(consumable);
    }

    private void drink(Drink something) throws ConsumeNullException, ConsumeEmptyException{
        if(something == null){
            throw new ConsumeNullException();
        }
        System.out.println(this.name + " drinks " + something.toString());
        this.setStamina(getStamina() + something.use());
    }

    private void eat(Food something) throws ConsumeNullException, ConsumeEmptyException{
        if(something == null){
            throw new ConsumeNullException();
        }
        System.out.println(this.name + " eats " + something.toString());
        this.setLife(getLife() + something.use());
    }

    public void use(Consumable consumable) throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException{
        if(consumable == null){
            throw new ConsumeNullException();
        }

        if(consumable instanceof Drink){
            drink((Drink) consumable);
        }
        else if(consumable instanceof Food){
            eat((Food) consumable);
        }
        else if(consumable instanceof RepairKit){
            try{
                repairWeaponWith((RepairKit) consumable);
            }
            catch(WeaponNullException e){
                throw new ConsumeRepairNullWeaponException(consumable);
            }
        }
    }

    protected abstract float computeProtection();

    protected abstract float computeBuff();

    public int getHitWith(int value){

        int hitValue = value;
        if(computeProtection() > 100){
            return 0;
        }

        hitValue = Math.round(hitValue*(1-(computeProtection()/100)));
        hitValue = (getLife() < hitValue) ? getLife() : hitValue;

        setLife(getLife() - hitValue);
        return hitValue;
    }

    public int attack() throws WeaponNullException, WeaponBrokenException, StaminaEmptyException{
           return attackWith(getWeapon());
    }

    private int attackWith(Weapon weapon) throws WeaponNullException, WeaponBrokenException, StaminaEmptyException{

        if(weapon == null){
            throw new WeaponNullException();
        }

        if(stamina <= 0){
            throw new StaminaEmptyException();
        }

        int finalDamage = 0;
        int accuracy = dice.roll();
        int additionalDamage = (int)((weapon.getMaxDamage() - weapon.getMinDamage()) * (accuracy/100.f));

        weapon.use();
        if(weapon.isBroken()) {
            throw new WeaponBrokenException(weapon);
        }
        else if(this.getStamina() < weapon.getStamCost()){
            float malusDamage = this.getStamina() / weapon.getStamCost();
            this.setStamina(0);
            finalDamage = Math.round( (weapon.getMinDamage() + additionalDamage) * malusDamage);
        }

        else{
            this.setStamina(this.getStamina() - weapon.getStamCost());
            finalDamage = Math.round(weapon.getMinDamage() + additionalDamage);
        }

        finalDamage += Math.round(finalDamage * computeBuff()/100.f);

        return finalDamage;
    }

    public void printStats(){
        System.out.println(toString());
    }

    public boolean isAlive(){
       return getLife() > 0;
    }

    private void repairWeaponWith(RepairKit kit) throws WeaponNullException, ConsumeNullException, ConsumeEmptyException{
        if(weapon == null){
            throw new WeaponNullException();
        }
        else{
            System.out.println(this.name + " repairs " + weapon.toString() + " with " + kit.toString());
            this.weapon.repairWith(kit);
        }
    }

    private Consumable fastUseFirst(Class<? extends Consumable> consumableClass) throws ConsumeNullException, ConsumeEmptyException, ConsumeRepairNullWeaponException, NoBagException{
        for (Collectible item : bag.getItems()) {
            if (consumableClass.isInstance(item)) {
                use((Consumable) item);
                if (((Consumable) item).getCapacity() == 0) {
                    pullOut(item);
                }
                return (Consumable)item;
            }
        }
        // Si aucun item n'est trouvé pour effectuer l'action, on lance une exception.
        throw new ConsumeNullException();
    }

    public Drink fastDrink() throws ConsumeNullException, ConsumeEmptyException, NoBagException{
        try{
            System.out.println(getName() + " drinks FAST :" );
            return (Drink)fastUseFirst(Drink.class);
        }catch(ConsumeRepairNullWeaponException e){
            return null;
        }
    }

    public Food fastEat() throws ConsumeNullException, ConsumeEmptyException, NoBagException{
        try{
            System.out.println(getName() + " eats FAST :" );
            return (Food)fastUseFirst(Food.class);
        }catch (ConsumeRepairNullWeaponException e){
            return null;
        }
    }

    public RepairKit fastRepair() throws ConsumeNullException, ConsumeEmptyException, NoBagException, ConsumeRepairNullWeaponException{
            System.out.println(getName() + " repairs FAST :" );
            return (RepairKit) fastUseFirst(RepairKit.class);
    }

    public void printConsumable(){
        if(consumable != null) {
            System.out.println("CONSUMABLE : " + this.consumable.toString());
        }
        else{
            System.out.println("CONSUMABLE : empty");
        }
    }

    @Override
    public String toString(){
        return String.format("%-20s %-20s %s:%-10s %s:%-10s %s:%-10s %s:%-10s%s",
                "[ " + getClass().getSimpleName() + " ]",
                getName(),
                LIFE_STAT_STRING.toUpperCase(),
                String.format("%5d",getLife()),
                STAM_STAT_STRING.toUpperCase(),
                String.format("%5d",getStamina()),
                PROTECTION_STAT_STRING.toUpperCase(),
                String.format(Locale.ROOT,"%6.2f",computeProtection()),
                BUFF_STAT_STRING.toUpperCase(),
                String.format(Locale.ROOT,"%6.2f",computeBuff()),
                isAlive() ? "(ALIVE)" : "(DEAD)"
                );
    }


}