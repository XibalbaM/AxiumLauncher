package fr.xibalba.launcher.ui.panels;

import fr.xibalba.launcher.core.AxiumLauncher;
import fr.xibalba.launcher.ui.panel.Panel;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.io.IOException;

public class LauncherPanel extends Panel {

    protected AnchorPane bar;
    protected GridPane panel;

    @Override
    public void init() {

        try {
            this.bar = FXMLLoader.load(getClass().getResource("/panels/connected/account.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bar.prefWidthProperty().bind(AxiumLauncher.getPanelManager().getStage().widthProperty());

        GridPane.setVgrow(bar, Priority.ALWAYS);
        GridPane.setHgrow(bar, Priority.ALWAYS);
        GridPane.setValignment(bar, VPos.TOP);
        GridPane.setHalignment(bar, HPos.CENTER);

        this.panel = new GridPane();

        GridPane.setVgrow(panel, Priority.ALWAYS);
        GridPane.setHgrow(panel, Priority.ALWAYS);
        GridPane.setValignment(panel, VPos.CENTER);
        GridPane.setHalignment(panel, HPos.CENTER);

        RowConstraints barConstraints = new RowConstraints(50, 50, 50);
        barConstraints.setValignment(VPos.TOP);
        this.layout.getRowConstraints().addAll(barConstraints, new RowConstraints());
        this.layout.add(bar, 0, 0);
        this.layout.add(panel, 0, 1);

        super.init();
    }

    @Override
    public String getName() {

        return "launcher-panel";
    }
}