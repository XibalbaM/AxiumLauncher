package fr.xibalba.launcher.theme;

import java.io.File;
import java.io.FileNotFoundException;

public class CustomTheme extends Theme {

    /**
     * the constructor
     *
     * @param themeJson the theme.json file
     */
    public CustomTheme(File themeJson) throws FileNotFoundException {

        super(themeJson);
    }

    @Override
    public String getStyle(String key) {

        if (styles.has(key)) {
            return "file:" + (themeJson.getParentFile().getAbsolutePath() + "\\" + this.styles.get(key).getAsString()).replace("\\", "/");
        } else {
            return ThemeManager.getTheme(0).getStyle(key);
        }
    }
}
