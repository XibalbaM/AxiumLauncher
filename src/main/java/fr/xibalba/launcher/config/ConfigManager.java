package fr.xibalba.launcher.config;

import fr.xibalba.launcher.core.Const;

import java.io.*;

public class ConfigManager {

    private static final File configFile = new File(Const.JAR_LOCATION.getAbsolutePath() + "/config.axdata");
    public static Config CONFIG;

    public static void load() {

        try {

            if (configFile == null || !configFile.exists()) {

                configFile.createNewFile();
            }
            if (configFile.length() == 0) {

                CONFIG = new Config().initVars();
                save();
            }

            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(configFile));

            Config config = (Config)stream.readObject();
            config.initVars();

            CONFIG = config;
        } catch (Exception e) {

            e.printStackTrace();
            CONFIG = new Config().initVars();
        }
    }

    public static void save() {

        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(configFile));
            stream.writeObject(CONFIG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}