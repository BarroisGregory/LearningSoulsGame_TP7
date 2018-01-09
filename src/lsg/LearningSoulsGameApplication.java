package lsg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lsg.graphics.CSSFactory;
import lsg.graphics.panes.CreationPane;
import lsg.graphics.panes.TitlePane;
import lsg.graphics.widgets.texts.GameLabel;

public class LearningSoulsGameApplication extends Application {
    private Scene scene;
    private AnchorPane root;
    private TitlePane gameTitle;
    private CreationPane creationPane;
    private String heroName;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Learning Souls Game");
        root = new AnchorPane();
        scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        stage.setResizable(false);
        buildUI();
        stage.show();
        startGame();
    }

    private void buildUI() {

        scene.getStylesheets().addAll(CSSFactory.getStyleSheet("LSG.css"));
        gameTitle = new TitlePane(scene, "Learning Souls Game");
        root.getChildren().addAll(gameTitle);
        root.setLeftAnchor(gameTitle,0.0);
        root.setRightAnchor(gameTitle,0.0);
        root.setTopAnchor(gameTitle,10.0);
        creationPane = new CreationPane();
        root.setLeftAnchor(creationPane,0.0);
        root.setRightAnchor(creationPane,0.0);
        root.setTopAnchor(creationPane,0.0);
        root.setBottomAnchor(creationPane,0.0);
        root.getChildren().addAll(creationPane);
        creationPane.setOpacity(0);

    }

    public void startGame(){
        gameTitle.zoomIn(event -> {
            creationPane.fadeIn(null);
        });
    }
}
