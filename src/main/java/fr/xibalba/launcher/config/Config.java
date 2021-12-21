package fr.xibalba.launcher.config;

import fr.xibalba.launcher.games.GamesRegistry;

import java.io.Serial;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Config implements IConfig {

    @Serial
    private static final long serialVersionUID = -4768480379293033518L;

    public Locale language;
    public boolean rememberPassword;
    public String email, mdp;
    public Map<String, GameConfig> gameConfigs;
    public boolean autoTranslate;

    @Override
    public Config initVars() {

        try {
            for (Field declaredField : getClass().getDeclaredFields()) {

                if (declaredField.get(this) == null) {

                    declaredField.set(this, switchType(declaredField.getType(), declaredField));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return this;
    }

    public static Object switchType(Class c, Field field) {

        return switch (c.getName()) {
            case "java.util.Boolean" -> false;
            case "java.util.Locale" -> Locale.getDefault();
            case "java.lang.Integer" -> 0;
            case "java.lang.String" -> "";
            default -> switchName(field);
        };
    }

    public static Object switchName(Field field) {

        return switch (field.getName()) {
            case "gameConfigs" -> initGameConfigs();
            default -> null;
        };
    }

    private static Map<String, GameConfig> initGameConfigs() {

        Map<String, GameConfig> result = new HashMap<>();

        GamesRegistry.getInstance().getGameList().forEach((s, game) -> result.put(s, new GameConfig(game)));
        System.out.println(result.toString());

        return result;
    }
}