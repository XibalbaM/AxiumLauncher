package fr.xibalba.launcher.core;

import java.io.File;
import java.net.URISyntaxException;

public class Const {

    public static final String TITLE = "Axium Games Launcher";
    public static File JAR_LOCATION;
    public static final ClassLoader CLASS_LOADER = new Const().getClass().getClassLoader();

    static {
        try {
            JAR_LOCATION = new File(Const.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
