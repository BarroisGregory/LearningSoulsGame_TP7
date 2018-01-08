package lsg.graphics.widgets.texts;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class GameLabel extends Label {
    public GameLabel(){
        super();
        this.getStyleClass().addAll("game-font");
    }

    public GameLabel(String text){
        super(text);
        this.getStyleClass().addAll("game-font");
    }

    public GameLabel(String text, Node graphic){
        super(text,graphic);
        this.getStyleClass().addAll("game-font");
    }
}
