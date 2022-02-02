package fr.xibalba.launcher.core;

import javafx.application.Application;
import javafx.stage.Stage;

public class FxApplication extends Application {

    @Override
    public void start(Stage stage) {

        AxiumLauncher.init(stage);
    }
}
