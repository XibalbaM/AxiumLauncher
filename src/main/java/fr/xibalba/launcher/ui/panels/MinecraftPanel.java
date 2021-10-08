package fr.xibalba.launcher.ui.panels;

import fr.xibalba.launcher.ui.panel.Panel;
import fr.xibalba.utils.minecraft.MinecraftConnection;
import fr.xibalba.utils.minecraft.MinecraftConnector;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class MinecraftPanel extends Panel {

    private final GridPane mainPane = new GridPane();
    private final GridPane connectionMainPane = new GridPane();
    private final GridPane connectionConnectionPane = new GridPane();
    private final GridPane connectionBottomPane = new GridPane();
    private MinecraftConnection connection;
    private final MinecraftConnector connector = new MinecraftConnector();

    @Override
    public void init() {

        super.init();

        initMain();
        showConnectionPane();

        this.layout.getChildren().add(mainPane);
    }

    private void initMain() {

    }

    private void showConnectionPane() {

        connectionMainPane.setMinWidth(400);
        connectionMainPane.setMaxWidth(400);
        connectionMainPane.setMinHeight(580);
        connectionMainPane.setMaxHeight(580);

        GridPane.setVgrow(connectionMainPane, Priority.ALWAYS);
        GridPane.setHgrow(connectionMainPane, Priority.ALWAYS);
        GridPane.setValignment(connectionMainPane, VPos.CENTER);
        GridPane.setHalignment(connectionMainPane, HPos.CENTER);

        RowConstraints bottomConstraints = new RowConstraints();
        bottomConstraints.setValignment(VPos.BOTTOM);
        bottomConstraints.setMaxHeight(55);
        connectionMainPane.getRowConstraints().addAll(new RowConstraints(), bottomConstraints);
        connectionMainPane.add(connectionConnectionPane, 0, 0);
        connectionMainPane.add(connectionBottomPane, 0, 1);

        this.mainPane.getChildren().add(connectionMainPane);

        initConnectionConnection();
    }

    private void initConnectionConnection() {
        connectionConnectionPane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("assets/dirt.png")), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }

    private void showMainPane(MinecraftConnection connection) {

    }

    @Override
    public void onShow() {
        super.onShow();
    }

    @Override
    public void onHide() {
        super.onHide();
    }

    @Override
    public String getName() {
        return "panelminecraft";
    }
}
