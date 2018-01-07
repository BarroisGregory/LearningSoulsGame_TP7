package lsg.exceptions;

public class StaminaEmptyException extends Exception {

    public StaminaEmptyException(){
        super();
    }

    @Override
    public String toString(){
        return "no stamina !";
    }
}
