package fr.xibalba.launcher.theme;

import fr.xibalba.launcher.config.ConfigManager;
import fr.xibalba.launcher.core.AxiumLauncher;
import fr.xibalba.launcher.core.Const;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ThemeManager {

    private static File themesFolder;
    private static List<Theme> themes;

    /**
     * Detects the themes in the themes folder and save themes in an Array.
     * @return An array of themes.
     */
    public static void initThemes() {

        try {

            // init default theme
            themes = new ArrayList<>();
            themes.add(new DefaultTheme());

            //get themes folder
            getFolderPath();

            for (File file : themesFolder.listFiles(File::isDirectory)) {

                File file1 = new File(file.getAbsolutePath() + "/theme.json");

                if (file1.exists()) {

                    Theme theme = new CustomTheme(file1);
                    themes.add(theme);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Themes found : " + themes.size());
    }

    private static File getFolderPath() throws URISyntaxException, IOException {

        if (themesFolder == null) {

            themesFolder = new File(Const.JAR_LOCATION + "/themes");
        }

        return themesFolder;
    }

    public static Theme getTheme(int index) {

        return themes.get(index);
    }

    public static Theme getCurrentTheme() {

        if (ConfigManager.CONFIG.currentTheme >= themes.size())
            ConfigManager.CONFIG.currentTheme = 0;

        return themes.get(ConfigManager.CONFIG.currentTheme);
    }

    public static List<Theme> getThemes() {

        return themes;
    }

    public static void setCurrentTheme(int index) {

        ConfigManager.CONFIG.currentTheme = index;

        AxiumLauncher.getPanelManager().updateTopBar();
        AxiumLauncher.getPanelManager().update();
    }
}
