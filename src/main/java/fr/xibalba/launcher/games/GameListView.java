package fr.xibalba.launcher.games;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;

public class GameListView extends Pane {

    private String name;
    private String description;
    private Image icon;

    public GameListView(String name, String description, Image icon) {

        this.name = name;
        this.description = description;
        this.icon = icon;

        this.setPrefSize(300, 50);

        Rectangle rectangle;

        if (icon != null) {

            rectangle = new Rectangle(300, 50);
            rectangle.setStroke(Color.WHITE);
            rectangle.setStrokeType(StrokeType.INSIDE);
            rectangle.setStrokeWidth(1);
            this.getChildren().add(rectangle);

            ImageView view = new ImageView(icon);
            view.setFitWidth(48);
            view.setFitHeight(48);
            view.setTranslateX(1);
            view.setTranslateY(1);
            this.getChildren().add(view);

            Label title = new Label(name);
            title.setFont(Font.font(20));
            title.setTranslateX(55);
            title.setTextFill(Color.grayRgb(230));
            this.getChildren().add(title);

            Label desc = new Label(description);
            desc.setFont(Font.font(15));
            desc.setTranslateX(80);
            desc.setTranslateY(25);
            desc.setTextFill(Color.grayRgb(125));
            this.getChildren().add(desc);
        } else {

            rectangle = new Rectangle(300, 50);
            rectangle.setStroke(Color.WHITE);
            rectangle.setStrokeType(StrokeType.INSIDE);
            rectangle.setStrokeWidth(1);
            this.getChildren().add(rectangle);

            Label title = new Label(name);
            title.setFont(Font.font(20));
            title.setTextFill(Color.grayRgb(230));
            title.setTranslateX(5);
            this.getChildren().add(title);

            Label desc = new Label(description);
            desc.setFont(Font.font(15));
            desc.setTranslateX(25);
            desc.setTranslateY(25);
            desc.setTextFill(Color.grayRgb(125));
            this.getChildren().add(desc);
        }

        this.setOnMouseEntered(event -> rectangle.setFill(Color.grayRgb(25)));
        this.setOnMouseExited(event -> rectangle.setFill(Color.BLACK));
    }
}