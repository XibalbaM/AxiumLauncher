package fr.xibalba.launcher.theme;

import java.io.File;
import java.io.FileNotFoundException;

public class DefaultTheme extends Theme {

    private static File resource = new File(DefaultTheme.class.getResource("/defaultTheme/theme.json").getFile());

    /**
     * the constructor
     */
    public DefaultTheme() throws FileNotFoundException {

        super(resource);
    }

    @Override
    public String getStyle(String key) {

        return "file:" + (resource.getParentFile().getAbsolutePath() + "\\" + this.styles.get(key).getAsString()).replace("\\", "/");
    }
}
