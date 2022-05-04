package fr.xibalba.launcher.ui.panel;

import fr.xibalba.launcher.core.AxiumLauncher;
import fr.xibalba.launcher.ui.panels.includes.popup.TopPopupPanel;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public abstract class PopupPanel extends Stage {

    protected GridPane layout = new GridPane();
    protected GridPane centerPanel = new GridPane();
    protected TopPopupPanel topPanel;

    public PopupPanel(int width, int height) {

        super();
        this.initModality(Modality.APPLICATION_MODAL);
        this.initOwner(AxiumLauncher.getPanelManager().getStage());
        this.initStyle(StageStyle.UNDECORATED);

        RowConstraints topPanelConstraints = new RowConstraints();
        topPanelConstraints.setValignment(VPos.TOP);
        topPanelConstraints.setMinHeight(25);
        topPanelConstraints.setMaxHeight(25);
        this.layout.getRowConstraints().addAll(topPanelConstraints, new RowConstraints());
        this.topPanel = new TopPopupPanel();
        this.layout.add(this.topPanel.getLayout(), 0, 0);
        this.topPanel.init(this);

        this.layout.add(this.centerPanel, 0, 1);
        GridPane.setVgrow(this.centerPanel, Priority.ALWAYS);
        GridPane.setHgrow(this.centerPanel, Priority.ALWAYS);

        Scene dialogScene = new Scene(this.layout, width, height);
        this.setScene(dialogScene);
        this.setResizable(false);
        this.show();
        AxiumLauncher.getPanelManager().addPopupPanel(this.getName(), this);
        this.layout.getStyleClass().add("primary-background");
    }

    public abstract String getName();
}
