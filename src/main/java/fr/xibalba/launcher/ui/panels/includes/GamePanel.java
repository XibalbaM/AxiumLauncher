package fr.xibalba.launcher.ui.panels.includes;

import com.sun.javafx.tk.Toolkit;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.xibalba.launcher.games.Game;
import fr.xibalba.launcher.theme.ThemeManager;
import fr.xibalba.launcher.ui.panel.Panel;
import fr.xibalba.utils.javaFX.YoutubeVideoView;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import libs.arilibfx.ui.component.AProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GamePanel extends Panel {

    private final Game game;
    private AProgressBar dlBar;

    public GamePanel(Game game) {

        Objects.requireNonNull(game);
        this.game = game;
    }

    @Override
    public void init() {
        super.init();
        //this.layout.setStyle("-fx-background-color: #" + game.getColor() + ";");
        AxiumLauncher.getPanelManager().getLayout().setStyle("-fx-background-image: url('"+this.game.getUrl()+"');"
                +"-fx-backgound-repeat: skretch;"+"-fx-backgound-position: center center;"
                +"-fx-background-size: cover;");

        ScrollPane scrollPane = new ScrollPane();
        GridPane.setHgrow(scrollPane, Priority.ALWAYS);
        GridPane.setVgrow(scrollPane, Priority.ALWAYS);
        scrollPane.getStylesheets().add(ThemeManager.getCurrentTheme().getStyle("scrollbar"));

        VBox vBox = new VBox();
        GridPane.setHgrow(vBox, Priority.ALWAYS);
        GridPane.setVgrow(vBox, Priority.ALWAYS);
        vBox.setMinHeight(200);
        vBox.setMinWidth(900);
        vBox.setMaxWidth(900);
        vBox.setAlignment(Pos.CENTER);
        vBox.setTranslateX(30);
        vBox.setTranslateY(1);
        //vBox.setStyle("-fx-background-color: #ff58b3");

        GridPane topPane = new GridPane();
        GridPane.setVgrow(topPane, Priority.ALWAYS);
        GridPane.setHgrow(topPane, Priority.ALWAYS);
        GridPane.setValignment(topPane, VPos.TOP);
        topPane.setMaxWidth(880);
        topPane.setMinWidth(880);
        topPane.setMaxHeight(340);
        topPane.setMinHeight(340);
        this.showTopPanel(topPane);
        //topPane.setStyle("-fx-background-color: #4dfff0");

        GridPane aboutPane = new GridPane();
        GridPane.setVgrow(aboutPane, Priority.ALWAYS);
        GridPane.setHgrow(aboutPane, Priority.ALWAYS);
        GridPane.setValignment(aboutPane, VPos.BOTTOM);
        aboutPane.setMaxWidth(880);
        aboutPane.setMinWidth(880);
        aboutPane.setMaxHeight(600);
        aboutPane.setMinHeight(600);
        aboutPane.setTranslateY(100);
        //aboutPane.setStyle("-fx-background-color: #006fff");

        GridPane newsPane = new GridPane();
        GridPane.setVgrow(newsPane, Priority.ALWAYS);
        GridPane.setHgrow(newsPane, Priority.ALWAYS);
        GridPane.setValignment(newsPane, VPos.BOTTOM);
        newsPane.setMaxWidth(880);
        newsPane.setMinWidth(880);
        newsPane.setMaxHeight(300);
        newsPane.setMinHeight(300);
        newsPane.setTranslateY(50);
        //newsPane.setStyle("-fx-background-color: #fffa00");

        GridPane  footerPane = new GridPane();
        GridPane.setVgrow(footerPane, Priority.ALWAYS);
        GridPane.setHgrow(footerPane, Priority.ALWAYS);
        GridPane.setValignment(footerPane, VPos.BOTTOM);
        footerPane.setMaxWidth(880);
        footerPane.setMinWidth(880);
        footerPane.setMaxHeight(280);
        footerPane.setMinHeight(280);
        footerPane.setTranslateY(100);
        //footerPane.setStyle("-fx-background-color: #00ff11");

        this.layout.getChildren().add(scrollPane);
        scrollPane.setContent(vBox);
        vBox.getChildren().add(0,topPane);
        vBox.getChildren().add(1,aboutPane);
        vBox.getChildren().add(2,newsPane);
        vBox.getChildren().add(3,footerPane);
        this.addDlBar(this.layout);
    }

    private void addDlBar(GridPane pane) {

        this.drawDlDesign(pane);

        Button installButton = new Button("Install");
        GridPane.setVgrow(installButton, Priority.ALWAYS);
        GridPane.setHgrow(installButton, Priority.ALWAYS);
        GridPane.setValignment(installButton, VPos.BOTTOM);
        GridPane.setHalignment(installButton, HPos.LEFT);
        installButton.setFont(Font.font(14));
        installButton.setTextFill(Color.WHITE);
        installButton.setBackground(new Background(new BackgroundFill(Color.web("#115FAA"), new CornerRadii(5), Insets.EMPTY)));
        installButton.setOnMouseEntered(event -> installButton.setBackground(new Background(new BackgroundFill(Color.web("#2C77AA"), new CornerRadii(5), Insets.EMPTY))));
        installButton.setOnMouseExited(event -> installButton.setBackground(new Background(new BackgroundFill(Color.web("#115FAA"), new CornerRadii(5), Insets.EMPTY))));
        installButton.setCursor(Cursor.HAND);
        installButton.translateXProperty().bind(AxiumLauncher.getPanelManager().getStage().widthProperty().subtract(300).divide(2).subtract(installButton.widthProperty().divide(2)));
        installButton.setTranslateY(-90);
        installButton.setPrefSize(140, 40);
        installButton.setOnMouseClicked(event -> {
            try {
                AxiumLauncher.launchGame(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Button settingsButton = new Button();
        GridPane.setVgrow(settingsButton, Priority.ALWAYS);
        GridPane.setHgrow(settingsButton, Priority.ALWAYS);
        GridPane.setValignment(settingsButton, VPos.BOTTOM);
        GridPane.setHalignment(settingsButton, HPos.LEFT);
        MaterialDesignIconView settingsIcon = new MaterialDesignIconView(MaterialDesignIcon.SETTINGS);
        settingsIcon.setSize("20px");
        //settingsIcon.setFill(Color.rgb(17, 95, 170));
        settingsIcon.setFill(Color.web("#4C4F56"));
        settingsButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(5), Insets.EMPTY)));
        settingsButton.setBorder(new Border(new BorderStroke(Color.web("#4C4F56"), BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        settingsButton.translateXProperty().bind(AxiumLauncher.getPanelManager().getStage().widthProperty().subtract(300).divide(2).subtract(settingsButton.widthProperty().divide(2)).add(installButton.widthProperty()));
        settingsButton.setTranslateY(-95);
        settingsButton.setMinSize(30, 30);
        settingsButton.setMaxSize(30, 30);
        settingsButton.setGraphic(settingsIcon);
        settingsButton.setCursor(Cursor.HAND);
        settingsButton.setOnMouseEntered(event -> settingsButton.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.05), new CornerRadii(5), Insets.EMPTY))));
        settingsButton.setOnMouseExited(event -> settingsButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(5), Insets.EMPTY))));
        settingsButton.setOnMouseClicked(event -> game.isDownloadedProperty().setValue(!game.isDownloadedProperty().getValue()));

        dlBar = new AProgressBar(800, 35);
        GridPane.setVgrow(dlBar, Priority.ALWAYS);
        GridPane.setHgrow(dlBar, Priority.ALWAYS);
        GridPane.setValignment(dlBar, VPos.BOTTOM);
        GridPane.setHalignment(dlBar, HPos.LEFT);
        Stop[] backStops = new Stop[] {new Stop(0, Color.grayRgb(50)), new Stop(1, Color.grayRgb(100))};
        RadialGradient backLG = new RadialGradient(400, 400, 400, 17, 400, true, CycleMethod.NO_CYCLE, backStops);
        dlBar.setBackgroundColor(backLG);
        Stop[] frontStops = new Stop[] {new Stop(0, Color.rgb(7, 85, 136)), new Stop(1, Color.rgb(3, 163, 219))};
        LinearGradient frontLG = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, frontStops);
        dlBar.setForegroundColor(frontLG);
        dlBar.setTranslateY(-20);
        dlBar.translateXProperty().bind(AxiumLauncher.getPanelManager().getStage().widthProperty().subtract(300).divide(2).subtract(dlBar.widthProperty().divide(2)));

        pane.getChildren().addAll(installButton, settingsButton, dlBar);
    }

    private void drawDlDesign(GridPane pane) {

        Rectangle rectangle1 = new Rectangle();
        GridPane.setVgrow(rectangle1, Priority.ALWAYS);
        GridPane.setHgrow(rectangle1, Priority.ALWAYS);
        GridPane.setValignment(rectangle1, VPos.BOTTOM);
        GridPane.setHalignment(rectangle1, HPos.LEFT);
        rectangle1.setFill(Color.web("#2A2E33"));
        rectangle1.widthProperty().bind(AxiumLauncher.getPanelManager().getStage().widthProperty().subtract(300));
        rectangle1.setHeight(75);

        Polygon polygon = new Polygon();
        GridPane.setVgrow(polygon, Priority.ALWAYS);
        GridPane.setHgrow(polygon, Priority.ALWAYS);
        GridPane.setValignment(polygon, VPos.BOTTOM);
        GridPane.setHalignment(polygon, HPos.LEFT);
        polygon.getPoints().clear();
        polygon.getPoints().addAll(0D, 720D, 0D, 645D, 219D, 645D, 294D, 570D, 686D, 570D, 761D, 645D, 980D, 645D, 980D, 720D);

        AxiumLauncher.getPanelManager().getStage().widthProperty().addListener((observable, oldValue, newValue) -> {

            polygon.getPoints().clear();
            polygon.getPoints().addAll(0D, 730D, 0D, 645D, (newValue.doubleValue() - 300) / 4.4748, 645D, (newValue.doubleValue() - 300) / 3.3333, 570D, (newValue.doubleValue() - 300) / 1.4285, 570D, (newValue.doubleValue() - 300) / 1.2877, 645D, newValue.doubleValue() - 300, 645D, newValue.doubleValue() - 300, 730D);
        });
        polygon.setFill(Color.web("#2A2E33"));
        polygon.setStroke(Color.web("#383C41"));
        polygon.setStrokeType(StrokeType.CENTERED);
        polygon.setStrokeWidth(3);

        pane.getChildren().add(polygon);
    }

    private void showTopPanel(GridPane panel) {

        Label gameTitle = new Label(this.game.getName());
        GridPane.setVgrow(gameTitle, Priority.ALWAYS);
        GridPane.setHgrow(gameTitle, Priority.ALWAYS);
        GridPane.setValignment(gameTitle, VPos.TOP);
        gameTitle.setStyle("-fx-font-size: 26px; -fx-text-fill: #DDD; -fx-font-weight: bold");
        gameTitle.setTranslateY(20);

        List<String> passKeywords = new ArrayList<>();
        for (String keyword : this.game.getKeyword()) {

            Label key = new Label(keyword);
            GridPane.setVgrow(key, Priority.ALWAYS);
            GridPane.setHgrow(key, Priority.ALWAYS);
            GridPane.setValignment(key, VPos.TOP);
            key.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 14px; -fx-opacity: 90%");
            key.setTranslateY(70);

            float translate = 5;
            for (String passKeyword : passKeywords) {
                translate += computeStringWidth(passKeyword, key.getFont()) + 15;
            }
            key.setTranslateX(translate);
            passKeywords.add(keyword);

            Rectangle background = new Rectangle(computeStringWidth(keyword, key.getFont()) + 10, Toolkit.getToolkit().getFontLoader().getFontMetrics(key.getFont()).getLineHeight() + 10);
            GridPane.setVgrow(background, Priority.ALWAYS);
            GridPane.setHgrow(background, Priority.ALWAYS);
            GridPane.setValignment(background, VPos.TOP);
            background.setOpacity(0.7);
            background.setTranslateX(translate - 2);
            background.setArcWidth(10);
            background.setArcHeight(10);
            background.setTranslateY(65);
            background.setFill(Color.RED);

            panel.getChildren().add(background);
            panel.getChildren().add(key);
        }

        Label desc = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus laoreet ante ac blandit elementum. Nullam pharetra mattis odio, et blandit mi vehicula nec. Nunc erat orci, imperdiet eget laoreet sit amet, blandit nec lorem. Etiam auctor efficitur risus id pretium. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed lorem quam, pulvinar eget semper sit amet, vestibulum vel quam.");
        GridPane.setVgrow(desc, Priority.ALWAYS);
        GridPane.setHgrow(desc, Priority.ALWAYS);
        GridPane.setValignment(desc, VPos.TOP);
        desc.setMaxWidth(480);
        desc.setWrapText(true);
        desc.setStyle("-fx-text-fill: #bcc6e7; -fx-font-size: 14px; -fx-opacity: 70%");
        desc.setTranslateY(130);

        YoutubeVideoView videoView = new YoutubeVideoView(320, 430, "");

        panel.getChildren().addAll(gameTitle, desc, videoView);
    }

    public void onDownloadJobStarted() {

        game.isDownloadedProperty().setValue(false);
        dlBar.setProgress(0, 1);
    }

    public void onDownloadJobFinished() {

        game.isDownloadedProperty().setValue(true);
        dlBar.setProgress(1, 1);
    }

    public static float computeStringWidth(String txt, Font font) {

        float result = 0;

        for (char c : txt.toCharArray()) {
            result += Toolkit.getToolkit().getFontLoader().getCharWidth(c, font);
        }

        return result;
    }

    public Game getGame() {

        return game;
    }
}