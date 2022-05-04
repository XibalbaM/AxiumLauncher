package fr.xibalba.launcher.ui;

import fr.xibalba.launcher.core.AxiumLauncher;
import fr.xibalba.launcher.core.Const;
import fr.xibalba.launcher.theme.ThemeManager;
import fr.xibalba.launcher.ui.panel.Panel;
import fr.xibalba.launcher.ui.panel.PopupPanel;
import fr.xibalba.launcher.ui.panels.HomePanel;
import fr.xibalba.launcher.ui.panels.PanelLogin;
import fr.xibalba.launcher.ui.panels.includes.TopPanel;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import libs.arilibfx.AriLibFX;
import libs.arilibfx.ui.utils.ResizeHelper;

import java.util.HashMap;
import java.util.Map;

public class PanelManager {

    private final Stage stage;
    private GridPane layout;
    private TopPanel topPanel = new TopPanel();
    private GridPane centerPanel = new GridPane();
    private Panel currentPanel;
    private Map<String, PopupPanel> popups = new HashMap<>();

    private final PanelLogin panelLogin = new PanelLogin();
    private final HomePanel homePanel = new HomePanel();

    public PanelManager(Stage stage) {

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
        this.stage.setOnCloseRequest(event -> AxiumLauncher.stopApp());
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.centerOnScreen();
        this.stage.show();

        this.layout = new GridPane();
        this.layout.getStylesheets().add(ThemeManager.getCurrentTheme().getStyle("main"));
        this.layout.setStyle(AriLibFX.setResponsiveBackground("https://www.dropbox.com/s/p33vgwl8ewdx0v4/Axium%20Games%20Logo.png?dl=1"));
        this.stage.setScene(new Scene(this.layout));

        RowConstraints topPanelConstraints = new RowConstraints();
        topPanelConstraints.setValignment(VPos.TOP);
        topPanelConstraints.setMinHeight(25);
        topPanelConstraints.setMaxHeight(25);
        this.layout.getRowConstraints().addAll(topPanelConstraints, new RowConstraints());
        this.layout.add(this.topPanel.getLayout(), 0, 0);
        this.topPanel.init();

        this.layout.add(this.centerPanel, 0, 1);
        GridPane.setVgrow(this.centerPanel, Priority.ALWAYS);
        GridPane.setHgrow(this.centerPanel, Priority.ALWAYS);
        ResizeHelper.addResizeListener(this.stage);
    }

    public void showPanel(Panel panel) {

        this.currentPanel.onHide();
        this.centerPanel.getChildren().clear();
        this.centerPanel.getChildren().addAll(panel.getLayout());
        this.currentPanel = panel;
        panel.init();
        panel.onShow();
    }

    public void update() {

        Panel panel = null;
        try {
            panel = this.currentPanel.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        this.centerPanel.getChildren().clear();
        this.centerPanel.getChildren().add(panel.getLayout());
        this.currentPanel = panel;
        panel.init();
        panel.onRefresh();
    }

    public void updateTopBar() {

        this.layout.getChildren().remove(topPanel);
        this.topPanel = new TopPanel();
        this.topPanel.init();
        this.layout.add(topPanel.getLayout(), 0, 0);
    }

    public Stage getStage() {
        return stage;
    }

    public TopPanel getTopPanel() {
        return topPanel;
    }

    public Panel getCurrentPanel() {
        return currentPanel;
    }

    public PanelLogin getPanelLogin() {

        return panelLogin;
    }

    public HomePanel getHomePanel() {

        return homePanel;
    }

    public GridPane getLayout() {

        return layout;
    }

    public PanelManager addPopupPanel(String name, PopupPanel panel) {

        this.popups.put(name, panel);

    	return this;
    }

    public PopupPanel getPopupPanel(String name) {

    	return this.popups.get(name);
    }

    public PanelManager removePopupPanel(String name) {

        this.popups.remove(name);

    	return this;
    }
}
