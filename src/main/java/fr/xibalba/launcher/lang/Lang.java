package fr.xibalba.launcher.lang;

import fr.xibalba.launcher.config.ConfigManager;
import fr.xibalba.launcher.main.AxiumLauncher;
import fr.xibalba.launcher.ui.panel.Panel;
import fr.xibalba.utils.StringUtils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Lang {

    public static String getText(Panel panel, String field, Locale locale) {

        return getText(panel.getName(), field, locale);
    }

    public static String getText(Panel panel, String field) {

        return getText(panel, field, AxiumLauncher.currentLocal());
    }

    public static String getText(String fileName, String field) {
        return getText(fileName, field, AxiumLauncher.currentLocal());
    }

    public static String getText(String fileName, String field, Locale locale) {

        try {

            ResourceBundle bundle = ResourceBundle.getBundle("lang/" + fileName, locale);
            return bundle.getString(field);
        } catch (MissingResourceException e) {

            if (!locale.getDisplayLanguage().equals(Locale.ENGLISH.getDisplayLanguage()) && ConfigManager.CONFIG.autoTranslate) {

                String translated = StringUtils.translate(getText(fileName, field, Locale.ENGLISH), locale);

                if (!StringUtils.isEmpty(translated))
                    return translated;
            } else if (!locale.getDisplayLanguage().equals(Locale.ENGLISH.getDisplayLanguage())) {

                return getText(fileName, field, Locale.ENGLISH);
            }

            return field;
        }
    }
}