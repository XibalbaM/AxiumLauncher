package fr.xibalba.launcher.ui.panels;

import fr.xibalba.launcher.config.Config;
import fr.xibalba.launcher.main.AxiumLauncher;
import fr.xibalba.launcher.ui.panel.Panel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class PanelLang extends Panel {

    private final GridPane pane = new GridPane();
    private String language = "en";

    @Override
    public void init() {

        super.init();

        initPane();
        initMain();

        this.layout.getChildren().add(pane);
    }

    private void initPane() {

        pane.setMinWidth(400);
        pane.setMaxWidth(400);
        pane.setMinHeight(580);
        pane.setMaxHeight(580);

        GridPane.setVgrow(pane, Priority.ALWAYS);
        GridPane.setHgrow(pane, Priority.ALWAYS);
        GridPane.setValignment(pane, VPos.CENTER);
        GridPane.setHalignment(pane, HPos.CENTER);
        pane.setStyle("-fx-background-color: #181818;");
    }

    private void initMain() {

        Label text = new Label("Select Language:");
        GridPane.setVgrow(text, Priority.ALWAYS);
        GridPane.setHgrow(text, Priority.ALWAYS);
        GridPane.setValignment(text, VPos.CENTER);
        GridPane.setHalignment(text, HPos.CENTER);
        pane.getChildren().add(text);

        ObservableList<String> items = FXCollections.observableArrayList(
                "DEFAULT", "ENGLISH", "FRANCAIS");
        ComboBox<String> box = new ComboBox<>(items);
        GridPane.setVgrow(box, Priority.ALWAYS);
        GridPane.setHgrow(box, Priority.ALWAYS);
        GridPane.setValignment(box, VPos.CENTER);
        GridPane.setHalignment(box, HPos.CENTER);
        box.getSelectionModel().selectFirst();
        box.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                switch (newValue) {
                    case "FRANCAIS" : language = "fr"; break;
                    default : language = "en"; break;
                }
            }
        });

        Button button = new Button("Done");
        GridPane.setVgrow(button, Priority.ALWAYS);
        GridPane.setHgrow(button, Priority.ALWAYS);
        GridPane.setValignment(button, VPos.BOTTOM);
        GridPane.setHalignment(button, HPos.CENTER);
        button.setTranslateY(-100);
        button.setOnMouseClicked(event -> {
            AxiumLauncher.getConfigManager().setProperty(Config.LANGUAGE, language);
            AxiumLauncher.getPanelManager().showPanel(AxiumLauncher.getPanelManager().getPanelLogin());
            AxiumLauncher.getPanelManager().updateTopBar();
        });

        pane.getChildren().addAll(box, button);
    }

    @Override
    public String getName() {
        return "panellang";
    }
}