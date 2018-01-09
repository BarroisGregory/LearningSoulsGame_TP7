package lsg.graphics.panes;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import lsg.graphics.widgets.texts.GameLabel;

public class CreationPane extends VBox{
    private TextField nameField;
    private GameLabel playerName;
    private static final Duration ANIMATION_DURATION = Duration.millis(1500);

    public CreationPane(){
        playerName = new GameLabel("Player Name");
        this.getChildren().add(playerName);
        nameField = new TextField();
        this.getChildren().add(nameField);
        this.setAlignment(Pos.CENTER);
        nameField.setMaxWidth(200);
    }

    public TextField getNameField() {
        return nameField;
    }

    public void fadeIn(EventHandler<ActionEvent> finishedHandler){
        FadeTransition ft = new FadeTransition();
        ft.setNode(this);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setDuration(ANIMATION_DURATION);
        ft.setCycleCount(1);
        ft.setOnFinished(finishedHandler);
        ft.play();
    }
}
