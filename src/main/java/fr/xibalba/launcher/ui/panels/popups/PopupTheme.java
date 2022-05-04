package fr.xibalba.launcher.ui.panels.popups;

import fr.xibalba.launcher.ui.panel.PopupPanel;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class PopupTheme extends PopupPanel {

    public PopupTheme() {

        super(720, 500);

        try {
            centerPanel.getChildren().add(new FXMLLoader(getClass().getResource("/panels/themeSelectionPanel.fxml")).load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("PopupTheme");
    }

    @Override
    public String getName() {

        return "themeSelectionPanel";
    }
}
