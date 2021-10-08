package fr.xibalba.utils.javaFX;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class YoutubeVideoView extends GridPane {

    private String contentUrl;
    private int width, height;

    public YoutubeVideoView(int width, int height, String contentUrl) {

        this.contentUrl = contentUrl;
        this.width = width;
        this.height = height;

        GridPane.setVgrow(this, Priority.ALWAYS);
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setValignment(this, VPos.TOP);
        GridPane.setHalignment(this, HPos.RIGHT);
        this.setMinSize(width, height);
        this.setMaxSize(width, height);
        this.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        /*WebView webView = new WebView();
        webView.setStyle("overflow-x: hidden; overflow-y: hidden");
        webView.setMinSize(width, height);
        webView.setMaxSize(width, height);
        webView.getEngine().load("https://www.youtube.com/embed/3LtnTRU1yJg");

        this.getChildren().add(webView);*/
    }
}