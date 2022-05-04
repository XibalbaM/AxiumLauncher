package fr.xibalba.launcher.ui.components;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.xibalba.launcher.games.Game;
import fr.xibalba.launcher.core.AxiumLauncher;
import fr.xibalba.launcher.core.Main;
import fr.xibalba.launcher.ui.panels.includes.GamePanel;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import libs.arilibfx.ui.component.AProgressBar;

public class GameButton extends GridPane {

    private final Game game;
    private AProgressBar aProgressBar;

    public GameButton(final Game game) {
        this.game = game;
        init();
    }

    public void init(){
        GridPane.setVgrow(this, Priority.ALWAYS);
        GridPane.setHgrow(this, Priority.ALWAYS);

        //this.setStyle("-fx-background-color: #" + this.game.getColor() + ";");
        // this.setStyle("-fx-background-color: rgba(22,22,22,0.3);");
        this.setPrefHeight(40);
        this.setMaxHeight(40);
        this.setPrefWidth(300);
        this.setMaxWidth(300);

        this.setOnMouseClicked(e->{
            AxiumLauncher.getPanelManager().getHomePanel().showGamePanel(new GamePanel(this.game));
        });

        Separator blueLeftSeparator = new Separator();
        GridPane.setVgrow(blueLeftSeparator, Priority.ALWAYS);
        GridPane.setHgrow(blueLeftSeparator, Priority.ALWAYS);
        blueLeftSeparator.setOrientation(Orientation.VERTICAL);
        blueLeftSeparator.setMinWidth(4);
        blueLeftSeparator.setMaxWidth(4);
        blueLeftSeparator.setMinHeight(36);
        blueLeftSeparator.setMaxHeight(36);
        blueLeftSeparator.setStyle("-fx-background-color: rgb(5,179,242); -fx-border-width: 4 4 4 0; -fx-border-color: rgb(5,179,242);");

        ImageView imageView = new ImageView(game.getIcon());
        GridPane.setVgrow(imageView, Priority.ALWAYS);
        GridPane.setHgrow(imageView, Priority.ALWAYS);
        GridPane.setValignment(imageView, VPos.CENTER);
        imageView.setTranslateX(20);
        imageView.setFitWidth(28);
        imageView.setFitHeight(28);

        Label gameLabel = new Label(this.game.getName());
        GridPane.setVgrow(gameLabel, Priority.ALWAYS);
        GridPane.setHgrow(gameLabel, Priority.ALWAYS);
        GridPane.setValignment(gameLabel, VPos.CENTER);
        gameLabel.setTranslateX(60);
        gameLabel.setStyle("-fx-text-fill: #fff");
        gameLabel.setFont(Font.loadFont(Main.class.getResource("/font/Poppins-Medium.ttf").toExternalForm(), 14));

        aProgressBar = new AProgressBar(170,3);
        GridPane.setVgrow(aProgressBar, Priority.ALWAYS);
        GridPane.setHgrow(aProgressBar, Priority.ALWAYS);
        GridPane.setValignment(aProgressBar, VPos.BOTTOM);

        aProgressBar.setBackgroundColor(Color.rgb(222,222,222,0.3d));
        aProgressBar.setForegroundColor(Color.rgb(255,255,255));
        aProgressBar.setTranslateX(60.0D);
        aProgressBar.setProgress(40.0f, 127.0f);
        aProgressBar.setVisible(false);

        MaterialDesignIconView iconView = new MaterialDesignIconView(MaterialDesignIcon.CHECK);
        iconView.setFill(Color.rgb(200,200,200));
        iconView.setSize("20px");
        iconView.setTranslateX(225);
        iconView.visibleProperty().bind(game.isDownloadedProperty());

        this.getChildren().addAll(blueLeftSeparator, imageView, gameLabel, aProgressBar, iconView);
    }

    public AProgressBar getAProgressBar() {

        return aProgressBar;
    }
}