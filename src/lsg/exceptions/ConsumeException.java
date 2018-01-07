package lsg.exceptions;

import lsg.consumables.Consumable;

public abstract class ConsumeException extends Exception{

    private String message;
    private Consumable consumable;

    public ConsumeException(String message, Consumable consumable){
        super();
        this.message = message;
        this.consumable = consumable;
    }

    public Consumable getConsumable() {
        return consumable;
    }

    @Override
    public String toString(){
        return this.message;
    }
}

