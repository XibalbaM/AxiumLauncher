package fr.xibalba.launcher.core;

import fr.xibalba.launcher.config.ConfigManager;
import fr.xibalba.launcher.games.Game;
import fr.xibalba.launcher.ui.PanelManager;
import fr.xibalba.launcher.ui.panels.PanelLang;
import fr.xibalba.launcher.ui.panels.includes.GamePanel;
import javafx.stage.Stage;
import libs.arilibfx.utils.AriLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;

public class AxiumLauncher {

    private static PanelManager panelManager;
    public static AriLogger logger = new AriLogger("Axium Launcher");

    public static void init(Stage stage) {

        ConfigManager.load();

        panelManager = new PanelManager(stage);
        panelManager.init();
        panelManager.showPanel(new PanelLang());
        //panelManager.showPanel(panelManager.getHomePanel());
    }

    public static void launchGame(GamePanel gamePanel) throws Exception { //TODO use libs.arilibfx.updater.Updater

        Game game = gamePanel.getGame();

        //String s = new URL(game.getDownloadUrl()).getFile().substring(new URL(game.getDownloadUrl()).getFile().lastIndexOf('/'), new URL(game.getDownloadUrl()).getFile().length() - 5);
        File file = new File(ConfigManager.CONFIG.gameConfigs.get(game.getName()).path);

        /*if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        if (!file.exists())
            file.createNewFile();*/

        new Thread(() -> {
            gamePanel.onDownloadJobStarted();
            try {
                FileUtils.copyURLToFile(new URL(game.getUrl()), file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            gamePanel.onDownloadJobFinished();
        }).start();
    }

    public static void stopApp() {
        ConfigManager.save();
        System.exit(0);
    }

    public static PanelManager getPanelManager() {
        return panelManager;
    }

    public static AriLogger getLogger() {
        return logger;
    }

    public static Locale currentLocal() {

        return ConfigManager.CONFIG.language;
    }
}