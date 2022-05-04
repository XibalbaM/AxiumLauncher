package fr.xibalba.launcher.ui.components;

import fr.xibalba.launcher.lang.Lang;
import fr.xibalba.launcher.theme.Theme;
import fr.xibalba.launcher.theme.ThemeManager;
import fr.xibalba.launcher.ui.controllers.ThemeSelectionContoller;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.awt.*;
import java.net.URI;

public class ThemeView extends AnchorPane {

    public ThemeView(Theme theme, ThemeSelectionContoller controller) {

        int width = 490;
        if (theme.equals(ThemeManager.getCurrentTheme())) {

            this.getStyleClass().add("theme-view-selected");
        } else {

            this.getStyleClass().add("theme-view");
        }
        this.setPrefSize(width, 200);

        if (theme.getTheme().has("icon") && theme.getTheme().get("icon").getAsString().length() > 0) {

            ImageView imageView = new ImageView(theme.getTheme().get("icon").getAsString());
            imageView.setFitWidth(90);
            imageView.setFitHeight(90);
            imageView.setTranslateX(5);
            imageView.setTranslateY(5);
            imageView.setOnMouseClicked(event -> {

                Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                    try {
                        desktop.browse(new URI(theme.getTheme().get("link").getAsString()));
                    } catch (Exception e) {}
                }
            });

            Label name = new Label(theme.getTheme().get("name").getAsString());
            name.setTranslateX(100);
            name.setTranslateY(5);
            name.setFont(Font.font("Arial", FontWeight.BOLD, 30));

            Label author = new Label(Lang.getText("global", "by") + " " + theme.getTheme().get("author").getAsString());
            author.setFont(Font.font("Arial", FontPosture.ITALIC, 10));
            author.setTranslateX(width - 10 - author.getWidth());
            author.setTranslateY(90);

            Label version = new Label(theme.getTheme().get("version").getAsString());
            version.setFont(Font.font(10));
            version.setTranslateX(100);
            version.setTranslateY(90);

            Label description = new Label(theme.getTheme().get("description").getAsString());
            description.setFont(Font.font(20));
            description.setTranslateX(100);
            description.setTranslateY(40);
            description.setMaxWidth(width - 110);
            description.setWrapText(true);

            this.getChildren().addAll(imageView, name, author, version, description);
        } else {

            Label name = new Label(theme.getTheme().get("name").getAsString());
            name.setTranslateX(5);
            name.setTranslateY(5);
            name.setFont(Font.font("Arial", FontWeight.BOLD, 30));
            name.setOnMouseClicked(event -> {

                Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                    try {
                        desktop.browse(new URI(theme.getTheme().get("link").getAsString()));
                    } catch (Exception e) {}
                }
            });

            Label author = new Label(Lang.getText("global", "by") + " "  + theme.getTheme().get("author").getAsString());
            author.setFont(Font.font("Arial", FontPosture.ITALIC, 10));
            author.setTranslateX(width - 10 - author.getWidth());
            author.setTranslateY(90);

            Label version = new Label(theme.getTheme().get("version").getAsString());
            version.setFont(Font.font(10));
            version.setTranslateX(5);
            version.setTranslateY(90);

            Label description = new Label(theme.getTheme().get("description").getAsString());
            System.out.println(width);
            description.setFont(Font.font(20));
            description.setTranslateX(5);
            description.setTranslateY(40);
            description.setMaxWidth(width - 10);
            description.setMaxHeight(175);
            description.setWrapText(true);

            this.getChildren().addAll(name, author, version, description);
        }

        this.setOnMouseClicked(event -> {

            ThemeManager.setCurrentTheme(ThemeManager.getThemes().indexOf(theme));
            System.out.println(ThemeManager.getCurrentTheme().getTheme().get("name").getAsString());
            controller.update();
        });
    }
}
