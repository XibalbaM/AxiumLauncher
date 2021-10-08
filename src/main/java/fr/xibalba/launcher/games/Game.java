package fr.xibalba.launcher.games;

import fr.xibalba.utils.Function;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.image.Image;

public class Game {

    private String name;
    private String description;
    private BooleanProperty isDownloaded;
    private Image icon;
    private Function<Game> onShow;
    private Function<Game> onHide;
    private String url;
    private String[] keyword;

    public Game(String name, String description, boolean isDownloaded, Image icon, Function<Game> onShow, Function<Game> onHide, String url, String... keyword) {

        this.name = name;
        this.description = description;
        this.isDownloaded = new SimpleBooleanProperty(isDownloaded);
        this.icon = icon;
        this.onShow = onShow;
        this.onHide = onHide;
        this.url = url;
        this.keyword = keyword;
    }

    public String getName() {

        return name;
    }

    public String getDescription() {

        return description;
    }

    public BooleanProperty isDownloadedProperty() {

        return isDownloaded;
    }

    public Image getIcon() {

        return icon;
    }

    public Function<Game> getOnShow() {

        return onShow;
    }

    public Function<Game> getOnHide() {

        return onHide;
    }

    public String getUrl() {

        return url;
    }

    public String[] getKeyword() {

        return keyword;
    }
}