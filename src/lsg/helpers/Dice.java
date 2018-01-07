package lsg.helpers;
import java.util.Random;

public class Dice {

    private int faces;
    private Random random;

    public Dice(int faces){
        this.faces = faces;
        random = new Random(5340);
    }

    public int roll(){
        return random.nextInt(faces);
    }
}
