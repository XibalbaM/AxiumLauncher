package fr.xibalba.launcher.lang;

import fr.xibalba.launcher.main.AxiumLauncher;
import fr.xibalba.launcher.main.Const;
import fr.xibalba.launcher.ui.panel.Panel;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Lang {

    public static String getText(Panel panel, String field, Locale locale) {

        try {
            ResourceBundle bundle = ResourceBundle.getBundle("lang/" + panel.getName(), locale, Const.CLASS_LOADER);
            return bundle.getString(field);
        } catch (MissingResourceException e) {
            if (locale != AxiumLauncher.getAppLocale())
                return getText(panel, field);
            else
                return field;
        }
    }

    public static String getText(Panel panel, String field) {
        return getText(panel, field, AxiumLauncher.getAppLocale());
    }

    public static String getText(String fileName, String field, Locale locale) {

        try {
            ResourceBundle bundle = ResourceBundle.getBundle("lang/" + fileName, locale, Const.CLASS_LOADER);
            return bundle.getString(field);
        } catch (MissingResourceException e) {
            if (locale != AxiumLauncher.getAppLocale())
                return getText(fileName, field);
            else
                return field;
        }
    }

    public static String getText(String fileName, String field) {
        return getText(fileName, field, AxiumLauncher.getAppLocale());
    }
}