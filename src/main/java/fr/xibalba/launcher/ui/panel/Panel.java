package fr.xibalba.launcher.ui.panel;

import fr.xibalba.launcher.core.AxiumLauncher;
import javafx.animation.FadeTransition;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.util.Duration;

public class Panel implements IPanel {

    protected GridPane layout = new GridPane();

    @Override
    public void init() {

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
    public void onRefresh() {

        System.out.println("Refreshing " + getName());
    }

    @Override
    public String getName() {
        return "panel";
    }
}