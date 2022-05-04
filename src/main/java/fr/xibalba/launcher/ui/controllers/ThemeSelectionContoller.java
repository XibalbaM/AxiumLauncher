package fr.xibalba.launcher.ui.controllers;

import fr.xibalba.launcher.core.AxiumLauncher;
import fr.xibalba.launcher.lang.Lang;
import fr.xibalba.launcher.theme.Theme;
import fr.xibalba.launcher.theme.ThemeManager;
import fr.xibalba.launcher.ui.components.ThemeView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ThemeSelectionContoller implements Initializable {

    @javafx.fxml.FXML
    private Button closeButton;
    @javafx.fxml.FXML
    private Button editButton;
    @javafx.fxml.FXML
    private VBox themesVBox;
    @javafx.fxml.FXML
    private Button removeButton;
    @javafx.fxml.FXML
    private Button addButton;
    @javafx.fxml.FXML
    private ScrollPane scrollPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        closeButton.setText(Lang.getText("themeSelectionPanel", "close"));
        editButton.setText(Lang.getText("themeSelectionPanel", "edit"));
        removeButton.setText(Lang.getText("themeSelectionPanel", "remove"));
        addButton.setText(Lang.getText("themeSelectionPanel", "add"));

        closeButton.setOnAction(event -> {

            AxiumLauncher.getPanelManager().getPopupPanel("themeSelectionPanel").close();
            AxiumLauncher.getPanelManager().removePopupPanel("themeSelectionPanel");
        });

        for (Theme theme : ThemeManager.getThemes()) {

            themesVBox.getChildren().add(new ThemeView(theme, this));
        }
    }

    public void update() {

        themesVBox.getChildren().clear();

        for (Theme theme : ThemeManager.getThemes()) {

            themesVBox.getChildren().add(new ThemeView(theme, this));
        }
    }
}