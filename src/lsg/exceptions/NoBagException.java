package lsg.exceptions;

public class NoBagException extends Exception{

    public NoBagException(){
        super();
    }

    @Override
    public String toString(){
        return "No Bag !";
    }
}
