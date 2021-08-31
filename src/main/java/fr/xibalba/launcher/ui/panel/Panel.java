package fr.xibalba.launcher.ui.panel;

import fr.xibalba.launcher.main.AxiumLauncher;
import fr.xibalba.launcher.ui.PanelManager;
import javafx.animation.FadeTransition;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.util.Duration;

public class Panel implements IPanel{

    protected GridPane layout = new GridPane();
    protected PanelManager panelManager;

    @Override
    public void init(PanelManager panelManager) {

        this.panelManager = panelManager;
        GridPane.setHgrow(layout, Priority.ALWAYS);
        GridPane.setVgrow(layout, Priority.ALWAYS);
    }

    @Override
    public GridPane getLayout() {

        return this.layout;
    }

    @Override
    public void onShow() {

        AxiumLauncher.getLogger().log("Showing " + getName());
        FadeTransition transition = new FadeTransition(Duration.seconds(1), this.layout);
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.setAutoReverse(true);
        transition.play();
    }

    @Override
    public void onHide() {
        AxiumLauncher.getLogger().log("Hiding " + getName());
    }

    @Override
    public String getName() {
        return "panel";
    }
}