package fr.xibalba.launcher.core;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Boot {

    public static void boot() {

        try {

            File booterFile = new File(Const.JAR_LOCATION.getAbsolutePath() + "/boot.jar");
            File versionFile = new File(Const.JAR_LOCATION.getAbsolutePath() + "/bootVersion.axdata");
            String versionLink = "https://www.dropbox.com/s/iqudirmfnd4nsll/bootVersion.axdata?dl=1";
            String booterLink = "https://www.dropbox.com/s/ritkodldwajubn1/Boot.jar?dl=1";

            if (!(booterFile.exists())) {
                booterFile.createNewFile();

                try {

                    FileUtils.copyURLToFile(
                            new URL(booterLink),
                            booterFile);

                } catch (IOException e) {

                    if (!(booterFile.exists() && booterFile.isFile())) {

                        JOptionPane.showMessageDialog(null, "Couldn't download the bootstrap.\n" + e.getMessage() + " Not found", "Erreur Java", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            if (!versionFile.exists()) {
                versionFile.createNewFile();
            }

            String oldVersion = read(new FileInputStream(versionFile));
            String newVersion = read(new URL(versionLink).openStream());

            if (!oldVersion.equals(newVersion)) {

                FileUtils.copyURLToFile(
                        new URL(versionLink),
                        versionFile);
                FileUtils.copyURLToFile(
                        new URL(booterLink),
                        booterFile);
            }

            Process process = Runtime.getRuntime().exec("java -jar \"" + booterFile.getAbsolutePath() + "\"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String read(InputStream stream) {

        Scanner scanner = new Scanner(stream);
        String result = "";
        if (scanner.hasNextLine()) {
            result = scanner.nextLine();
        }

        scanner.close();

        return result;
    }
}
