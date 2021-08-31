package fr.xibalba.launcher.ui.panels;

import fr.xibalba.launcher.main.AxiumLauncher;
import fr.xibalba.launcher.ui.PanelManager;
import fr.xibalba.launcher.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class PanelHome extends Panel {

    private final GridPane mainPanel = new GridPane();
    private final GridPane gameListPanel = new GridPane();
    private final GridPane gameListContent = new GridPane();
    private final GridPane gameViewPanel = new GridPane();
    private final GridPane gameDescPanel = new GridPane();
    private final GridPane gameDLBarPanel = new GridPane();

    @Override
    public void init(PanelManager panelManager) {

        super.init(panelManager);

        initMain();
        initList();
        initView();

        this.layout.getChildren().add(mainPanel);
    }

    private void initMain() {

        mainPanel.setMinHeight(AxiumLauncher.getPanelManager().getStage().getHeight());
        mainPanel.setMaxHeight(AxiumLauncher.getPanelManager().getStage().getHeight());
        mainPanel.setMinWidth(AxiumLauncher.getPanelManager().getStage().getWidth());
        mainPanel.setMaxWidth(AxiumLauncher.getPanelManager().getStage().getWidth());
        mainPanel.getStylesheets().clear();

        mainPanel.setBackground(new Background(new BackgroundFill(Color.web("#181818"), CornerRadii.EMPTY, Insets.EMPTY)));
        GridPane.setVgrow(mainPanel, Priority.ALWAYS);
        GridPane.setHgrow(mainPanel, Priority.ALWAYS);

        ColumnConstraints leftConstraints = new ColumnConstraints();
        leftConstraints.setHalignment(HPos.LEFT);
        leftConstraints.setMinWidth(300);
        leftConstraints.setMaxWidth(300);
        mainPanel.getColumnConstraints().addAll(leftConstraints, new ColumnConstraints());
        mainPanel.add(gameListPanel, 0, 0);
        mainPanel.add(gameViewPanel, 1, 0);
    }

    private void initList() {

        GridPane.setVgrow(gameListPanel, Priority.ALWAYS);
        GridPane.setHgrow(gameListPanel, Priority.ALWAYS);

        Separator listSeparator = new Separator();
        GridPane.setVgrow(listSeparator, Priority.ALWAYS);
        GridPane.setHgrow(listSeparator, Priority.ALWAYS);
        GridPane.setHalignment(listSeparator, HPos.RIGHT);
        listSeparator.setOrientation(Orientation.VERTICAL);
        listSeparator.setTranslateY(1);
        listSeparator.setTranslateX(4);
        listSeparator.setMinWidth(2);
        listSeparator.setMaxWidth(2);
        listSeparator.setOpacity(0.30d);
        gameListPanel.getChildren().add(listSeparator);

        GridPane.setVgrow(gameListContent, Priority.ALWAYS);
        GridPane.setHgrow(gameListContent, Priority.ALWAYS);
        GridPane.setHalignment(gameListContent, HPos.LEFT);
        GridPane.setValignment(gameListContent, VPos.TOP);
        gameListContent.setTranslateY(30);
        gameListContent.setMinWidth(40);
        gameListContent.setMaxWidth(40);
        gameListContent.setMinHeight(300);
        gameListContent.setMaxHeight(300);
        gameListPanel.getChildren().add(gameListContent);

        initListContent();
    }

    private void initListContent() {

    }

    private void initView() {

        initDesc();
        initDLBar();
        gameViewPanel.getChildren().addAll(gameDescPanel, gameDLBarPanel);
    }

    private void initDesc() {

    }

    private void initDLBar() {

    }

    @Override
    public String getName() {
        return "panelhome";
    }
}
