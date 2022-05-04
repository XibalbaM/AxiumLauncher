package fr.xibalba.launcher.ui.components;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SearchBar extends AnchorPane {

    public SearchBar(int width, int height) {

        this.getStyleClass().add("search-bar");

        this.setPrefHeight(height);
        this.setPrefWidth(width);

        TextField searchField = new TextField();
        searchField.setPromptText("Search");
        searchField.setPrefHeight(height);
        searchField.setPrefWidth(width);
        searchField.getStyleClass().add("search-field");

        MaterialDesignIconView searchIcon = new MaterialDesignIconView(MaterialDesignIcon.MAGNIFY);
        searchIcon.setGlyphSize(height * 0.8);
        searchIcon.setStyleClass("search-icon");
        searchIcon.setTranslateY(height * 0.1);
        searchIcon.setTranslateX(width - (height * 0.1));

        this.getChildren().addAll(searchField, searchIcon);
    }

    public SearchBar() {

        this(40, 200);
    }
}
