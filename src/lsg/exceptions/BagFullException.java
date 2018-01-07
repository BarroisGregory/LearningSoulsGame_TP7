package lsg.exceptions;

import lsg.bags.Bag;

public class BagFullException extends Exception{

    private Bag bag;

    public BagFullException(Bag bag){
        super();
        this.bag = bag;
    }

    @Override
    public String toString(){
        return bag.getClass().getSimpleName() + " is full !";
    }

    public Bag getBag() {
        return bag;
    }
}
