package lsg.exceptions;

import lsg.consumables.Consumable;

public class ConsumeNullException extends ConsumeException{

    public ConsumeNullException(){
        super("Consumable is null !",null);
    }
}
