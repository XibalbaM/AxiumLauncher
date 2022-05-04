package fr.xibalba.launcher.games;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.image.Image;

public class Game {

    private String name;
    private String description;
    private BooleanProperty isDownloaded;
    private String downloadUrl;
    private String defaultPath;
    private Image icon;
    private String url;
    private String[] keyword;

    public Game(String name, String description, boolean isDownloaded, String downloadUrl, String defaultPath, Image icon, String url, String... keyword) {

        this.name = name;
        this.description = description;
        this.isDownloaded = new SimpleBooleanProperty(isDownloaded);
        this.downloadUrl = downloadUrl;
        this.defaultPath = defaultPath;
        this.icon = icon;
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

    public String getDownloadUrl() {

        return downloadUrl;
    }

    public String getDefaultPath() {

        return defaultPath;
    }

    public String getUrl() {

        return url;
    }

    public String[] getKeyword() {

        return keyword;
    }
}