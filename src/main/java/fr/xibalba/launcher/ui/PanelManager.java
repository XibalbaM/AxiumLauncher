package fr.xibalba.launcher.ui;

import fr.xibalba.launcher.ui.panel.Panel;
import libs.arilibfx.AriLibFX;
import libs.arilibfx.ui.utils.ResizeHelper;
import fr.xibalba.launcher.main.AxiumLauncher;
import fr.xibalba.launcher.main.Const;
import fr.xibalba.launcher.ui.panel.IPanel;
import fr.xibalba.launcher.ui.panels.includes.TopPanel;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PanelManager {

    private final AxiumLauncher axiumLauncher;
    private final Stage stage;
    private GridPane layout;
    private TopPanel topPanel = new TopPanel();
    private GridPane centerPanel = new GridPane();
    private IPanel currentPanel;

    public PanelManager(AxiumLauncher axiumLauncher, Stage stage) {

        this.axiumLauncher = axiumLauncher;
        this.stage = stage;
    }

    public void init() {

        this.currentPanel = new Panel();
        this.stage.getIcons().add(new Image("https://www.dropbox.com/s/p33vgwl8ewdx0v4/Axium%20Games%20Logo.png?dl=1"));
        this.stage.setTitle(Const.TITLE);
        this.stage.setMinWidth(1280);
        this.stage.setWidth(1280);
        this.stage.setMinHeight(720);
        this.stage.setHeight(720);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.centerOnScreen();
        this.stage.show();

        this.layout = new GridPane();
        this.layout.getStylesheets().add(getClass().getClassLoader().getResource("style/Main.css").toString());
        this.layout.setStyle(AriLibFX.setResponsiveBackground("https://www.dropbox.com/s/p33vgwl8ewdx0v4/Axium%20Games%20Logo.png?dl=1"));
        this.stage.setScene(new Scene(this.layout));

        RowConstraints topPanelConstraints = new RowConstraints();
        topPanelConstraints.setValignment(VPos.TOP);
        topPanelConstraints.setMinHeight(25);
        topPanelConstraints.setMaxHeight(25);
        this.layout.getRowConstraints().addAll(topPanelConstraints, new RowConstraints());
        this.layout.add(this.topPanel.getLayout(), 0, 0);
        this.topPanel.init(this);

        this.layout.add(this.centerPanel, 0, 1);
        GridPane.setVgrow(this.centerPanel, Priority.ALWAYS);
        GridPane.setHgrow(this.centerPanel, Priority.ALWAYS);
        ResizeHelper.addResizeListener(this.stage);
    }

    public void showPanel(IPanel panel) {

        this.currentPanel.onHide();
        this.centerPanel.getChildren().clear();
        this.centerPanel.getChildren().add(panel.getLayout());
        this.currentPanel = panel;
        panel.init(this);
        panel.onShow();
    }

    public void updatePanel() {

        IPanel panel = null;
        try {
            panel = this.currentPanel.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        this.centerPanel.getChildren().clear();
        this.centerPanel.getChildren().add(panel.getLayout());
        this.currentPanel = panel;
        panel.init(this);
        panel.onShow();
    }

    public void updateTopBar() {
        this.layout.getChildren().remove(topPanel);
        this.topPanel = new TopPanel();
        this.topPanel.init(this);
        this.layout.add(topPanel.getLayout(), 0, 0);
    }

    public Stage getStage() {
        return stage;
    }

    public AxiumLauncher getAxiumLauncher() {
        return axiumLauncher;
    }

    public TopPanel getTopPanel() {
        return topPanel;
    }

    public IPanel getCurrentPanel() {
        return currentPanel;
    }
}
