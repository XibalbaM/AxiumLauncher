package fr.xibalba.launcher.main;

import javafx.application.Application;
import libs.arilibfx.utils.AriLogger;

import javax.swing.*;
import java.util.Arrays;

/**
 * Start of the programme
 * @author Xibalba
 */
public class Main {

    public static AriLogger logger = new AriLogger(Const.TITLE);

    public static void main(String[] args) {

        if (args.length > 0 && Arrays.stream(args).anyMatch("--boot"::equalsIgnoreCase)) {

            try {
                Class.forName("javafx.application.Application");
                Application.launch(FxApplication.class, args);
            } catch (ClassNotFoundException e) {
                logger.error("JavaFx not found :cry:");
                JOptionPane.showMessageDialog(null, "Une erreur avec java à été détectée.\n" + e.getMessage() + " Not found", "Erreur Java", JOptionPane.ERROR_MESSAGE);
            }

        } else {

            System.out.println("Booting");

            Boot.boot();
        }
    }
}