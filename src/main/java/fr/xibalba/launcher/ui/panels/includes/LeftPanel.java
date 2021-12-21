package fr.xibalba.launcher.ui.panels.includes;

import fr.xibalba.launcher.games.GamesRegistry;
import fr.xibalba.launcher.ui.panel.Panel;
import fr.xibalba.utils.javaFX.GameButton;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class LeftPanel extends Panel {

    private final List<GameButton> gameButtons = new ArrayList<>();

    @Override
    public void init() {
        super.init();
        //Creator components for each server
        final VBox vBox = new VBox();
        GridPane.setVgrow(vBox, Priority.ALWAYS);
        GridPane.setHgrow(vBox, Priority.ALWAYS);
        vBox.setSpacing(5.0D);
        GamesRegistry.getInstance().getGameList().forEach((s, game) -> {
            GameButton button = new GameButton(game);
            if (s == GamesRegistry.getInstance().worldLegends.getName()) {

                gameButtons.add(0, button);
                vBox.getChildren().add(0, button);
            } else {

                gameButtons.add(button);
                vBox.getChildren().add(button);
            }
        });
        vBox.setTranslateY(10);

        Separator separator = new Separator();
        GridPane.setVgrow(separator, Priority.ALWAYS);
        GridPane.setHgrow(separator, Priority.ALWAYS);
        GridPane.setHalignment(separator, HPos.RIGHT);
        separator.setOrientation(Orientation.VERTICAL);
        separator.setTranslateY(1);
        separator.setTranslateX(4);
        separator.setMinWidth(2);
        separator.setMaxWidth(2);
        separator.setOpacity(0.30);
        this.layout.getChildren().add(vBox);
        this.layout.getChildren().add(separator);
    }

    public List<GameButton> getGameButtons() {

        return gameButtons;
    }
}