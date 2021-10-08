package fr.xibalba.launcher.ui.panels.includes;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.xibalba.launcher.config.Config;
import fr.xibalba.launcher.lang.Lang;
import fr.xibalba.launcher.main.AxiumLauncher;
import fr.xibalba.launcher.main.Const;
import fr.xibalba.launcher.ui.panel.Panel;
import fr.xibalba.launcher.ui.panels.popups.PopupSettings;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class TopPanel extends Panel {

    private GridPane topBar;
    private MenuBar menuBar = new MenuBar();


    @Override
    public void init() {

        super.init();
        this.topBar = this.layout;
        this.layout.getStylesheets().add(getClass().getClassLoader().getResource("style/top.css").toString());
        this.layout.setBackground(new Background(new BackgroundFill(Color.rgb(31,35,37), CornerRadii.EMPTY, Insets.EMPTY)));

        initTitle();
        initMenu();
        initButtons();
    }

    public void initTitle() {

        Label topBarTitle = new Label(Const.TITLE);
        this.layout.getChildren().add(topBarTitle);
        GridPane.setHgrow(topBarTitle, Priority.ALWAYS);
        GridPane.setVgrow(topBarTitle, Priority.ALWAYS);
        GridPane.setHalignment(topBarTitle, HPos.CENTER);
        topBarTitle.setFont(Font.font("Consolas", FontWeight.THIN, FontPosture.REGULAR, 22.0f));
        topBarTitle.setStyle("-fx-text-fill: #ababab");
    }

    private void initMenu() {

        GridPane.setHgrow(menuBar, Priority.ALWAYS);
        GridPane.setVgrow(menuBar, Priority.ALWAYS);
        GridPane.setHalignment(menuBar, HPos.LEFT);
        menuBar.setStyle("-fx-background-color: transparent");

        initAxiumMenu();
        initShowMenu();
        initFriendsMenu();
        initGamesMenu();
        initHelpMenu();

        layout.getChildren().add(menuBar);
    }

    private void initAxiumMenu() {
        Menu axium = new Menu("Axium");

        MenuItem params = new MenuItem(Lang.getText(this, "params"));
        //params.setOnAction(event -> AxiumLauncher.getPanelManager().showPopup(new PopupSettings()));
        params.setOnAction(event -> {
            System.out.println("hi");
            new PopupSettings();
        });

        axium.getItems().add(params);

        menuBar.getMenus().add(axium);
    }

    private void initShowMenu() {
        Menu view = new Menu(Lang.getText(this, "menu.view"));

        menuBar.getMenus().add(view);
    }

    private void initFriendsMenu() {
        Menu friends = new Menu(Lang.getText(this, "menu.friends"));

        menuBar.getMenus().add(friends);
    }

    private void initGamesMenu() {
        Menu games = new Menu(Lang.getText(this, "menu.games"));

        menuBar.getMenus().add(games);
    }

    private void initHelpMenu() {
        Menu help = new Menu(Lang.getText(this, "menu.help"));
        Menu language = new Menu("Language");//TODO TRAD all here

        ToggleGroup group = new ToggleGroup();
        MenuItem l_default = new MenuItem("DEFAULT");
        l_default.setOnAction(event -> {
            AxiumLauncher.getConfigManager().setProperty(Config.LANGUAGE, "en");
            AxiumLauncher.getPanelManager().updateTopBar();
            AxiumLauncher.getPanelManager().update();
        });
        MenuItem l_english = new MenuItem("ENGLISH");
        l_english.setOnAction(event -> {
            AxiumLauncher.getConfigManager().setProperty(Config.LANGUAGE, "en");
            AxiumLauncher.getPanelManager().updateTopBar();
            AxiumLauncher.getPanelManager().update();
        });
        MenuItem l_french = new MenuItem("FRANCAIS");
        l_french.setOnAction(event -> {
            AxiumLauncher.getConfigManager().setProperty(Config.LANGUAGE, "fr");
            AxiumLauncher.getPanelManager().updateTopBar();
            AxiumLauncher.getPanelManager().update();
        });
        language.getItems().addAll(l_default, l_english, l_french);


        help.getItems().add(language);

        menuBar.getMenus().add(help);
    }

    private void initButtons() {

        GridPane topBarButton = new GridPane();
        this.layout.getChildren().add(topBarButton);
        topBarButton.setMinWidth(100.0d);
        topBarButton.setMaxWidth(100.0d);
        GridPane.setHgrow(topBarButton, Priority.ALWAYS);
        GridPane.setVgrow(topBarButton, Priority.ALWAYS);
        GridPane.setHalignment(topBarButton, HPos.RIGHT);

        MaterialDesignIconView close = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_CLOSE);
        GridPane.setVgrow(close, Priority.ALWAYS);
        MaterialDesignIconView fullScreen = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MAXIMIZE);
        GridPane.setVgrow(fullScreen, Priority.ALWAYS);
        MaterialDesignIconView hide = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MINIMIZE);
        GridPane.setVgrow(hide, Priority.ALWAYS);

        close.setFill(Color.WHITE);
        close.setOpacity(0.70f);
        close.setSize("18.0px");
        close.setCursor(Cursor.HAND);
        close.setOnMouseEntered(e -> close.setOpacity(1.0f));
        close.setOnMouseExited(e -> close.setOpacity(0.70f));
        close.setOnMouseClicked(e -> {
            AxiumLauncher.stopApp();
        });
        close.setTranslateX(70.0d);

        fullScreen.setFill(Color.WHITE);
        fullScreen.setOpacity(0.70f);
        fullScreen.setSize("16.0px");
        fullScreen.setCursor(Cursor.HAND);
        fullScreen.setOnMouseEntered(e -> fullScreen.setOpacity(1.0f));
        fullScreen.setOnMouseExited(e -> fullScreen.setOpacity(0.70f));
        fullScreen.setOnMouseClicked(e -> AxiumLauncher.getPanelManager().getStage().setMaximized(!AxiumLauncher.getPanelManager().getStage().isMaximized()));

        fullScreen.setTranslateX(50.0d);

        hide.setFill(Color.WHITE);
        hide.setOpacity(0.70f);
        hide.setSize("16.0px");
        hide.setCursor(Cursor.HAND);
        hide.setOnMouseEntered(e -> hide.setOpacity(1.0f));
        hide.setOnMouseExited(e -> hide.setOpacity(0.70f));
        hide.setOnMouseClicked(e -> AxiumLauncher.getPanelManager().getStage().setIconified(true));
        hide.setTranslateX(26.0d);
        topBarButton.getChildren().addAll(close, fullScreen, hide);
    }

    @Override
    public String getName() {
        return "paneltop";
    }
}
