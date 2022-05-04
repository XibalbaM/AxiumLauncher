package fr.xibalba.launcher.theme;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public abstract class Theme {

    /**
     * the theme.json file
     */
    protected File themeJson;
    protected JsonObject theme;
    protected JsonObject styles;

    /**
     * the constructor
     * @param themeJson the theme.json file
     */
    public Theme(File themeJson) throws FileNotFoundException {

        this.themeJson = themeJson;
        try {
            this.theme = JsonParser.parseReader(new JsonReader(new FileReader(this.themeJson))).getAsJsonObject();
        } catch (Exception e) {}
        this.styles = this.theme.get("styles").getAsJsonObject();
    }

    public JsonObject getTheme() {

        return theme;
    }

    public JsonObject getStyles() {

        return styles;
    }

    public abstract String getStyle(String key);
}
