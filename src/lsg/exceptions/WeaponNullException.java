package lsg.exceptions;

public class WeaponNullException extends Exception{

    public WeaponNullException(){
        super();
    }

    @Override
    public String toString(){
        return "no weapon !";
    }
}
