package fr.xibalba.launcher.main;

import fr.xibalba.launcher.config.Config;
import fr.xibalba.launcher.config.ConfigManager;
import fr.xibalba.launcher.database.DatabaseManager;
import fr.xibalba.launcher.ui.PanelManager;
import fr.xibalba.launcher.ui.panels.PanelLang;
import javafx.stage.Stage;
import libs.arilibfx.utils.AriLogger;

import java.util.Locale;

public class AxiumLauncher {

    private static PanelManager panelManager;
    private final static ConfigManager configManager = new ConfigManager();
    private static DatabaseManager databaseManager;
    static AriLogger logger = new AriLogger("Axium Launcher");

    public void init(Stage stage) {

        databaseManager = new DatabaseManager();
        databaseManager.init();

        panelManager = new PanelManager(this, stage);
        panelManager.init();
        panelManager.showPanel(new PanelLang());
    }

    public static void stopApp() {
        configManager.save();
        System.exit(0);
    }

    public static Locale getAppLocale() {

        Locale result;
        if (configManager.getProperty(Config.LANGUAGE) == null) {
            return Locale.getDefault();
        }

        switch (configManager.getProperty(Config.LANGUAGE)) {

            case "fr" : result = Locale.FRENCH; break;
            case "en" : result = Locale.ENGLISH; break;
            default : result = Locale.getDefault(); break;
        }
        return result;
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }

    public static PanelManager getPanelManager() {
        return panelManager;
    }

    public static DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public static AriLogger getLogger() {
        return logger;
    }
}
