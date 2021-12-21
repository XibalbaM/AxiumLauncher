package fr.xibalba.utils.javaFX;

import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.beans.property.StringProperty;
import javafx.css.Styleable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ShowablePasswordField extends StackPane {

    public PasswordField passwordField;
    public TextField textField;

    public ShowablePasswordField() {

        passwordField = new PasswordField();
        passwordField.setPrefHeight(50);
        textField = new TextField();
        passwordField.textProperty().bindBidirectional(textField.textProperty());
        textField.setPrefHeight(50);
        MaterialDesignIconView eye = new MaterialDesignIconView(MaterialDesignIcon.EYE);
        eye.setSize("22.0px");
        eye.setFill(Color.WHITE);
        eye.setOpacity(0.70f);
        eye.setOnMouseEntered(e -> eye.setOpacity(1.0f));
        eye.setOnMouseExited(e -> eye.setOpacity(0.70f));
        StackPane.setMargin(eye, new Insets(0, 10, 0, 0));
        StackPane.setAlignment(eye, Pos.CENTER_RIGHT);
        var context = new Object() {

            boolean on = true;
        };

        eye.setOnMouseClicked((event) -> {

            if (context.on) {

                textField.toFront();
                eye.setIcon(MaterialDesignIcon.EYE_OFF);
            } else {

                passwordField.toFront();
                eye.setIcon(MaterialDesignIcon.EYE);
            }
            context.on = !context.on;
            eye.toFront();
        });

        this.getChildren().addAll(textField, passwordField, eye);
    }
}
