package fr.xibalba.launcher.config;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private String config = "config.properties";
    private Properties props;
    public ConfigManager() {

        props = new Properties();
        InputStream fis = null;
        try {
            fis = getClass().getClassLoader().getResourceAsStream(config);
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            props.store(new FileOutputStream(getClass().getClassLoader().getResource(config).getFile()), "Config file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }

    public String getProperty(Config config) {
        return props.getProperty(config.name().toLowerCase());
    }

    public void setProperty(String key, String value) {
        props.setProperty(key, value);
    }

    public void setProperty(Config config, String value) {
        props.setProperty(config.name().toLowerCase(), value);
    }

    public Properties getProperties() {
        return props;
    }
}
