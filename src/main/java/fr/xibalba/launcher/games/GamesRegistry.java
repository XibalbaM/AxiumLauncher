package fr.xibalba.launcher.games;

import fr.xibalba.launcher.main.Const;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GamesRegistry {

    private static GamesRegistry instance;

    private String fileName = "games";

    public Game worldLegends;
    public Game test;

    private Map<String, Game> gameList;

    public GamesRegistry() {

        this.gameList = new HashMap<>();

        this.worldLegends = register(new Game("World Legends", "worldLegends.description", false, "https://www.dropbox.com/s/ndm66bhpk2cvlu9/AxCraft%20Logo.png?dl=1",
                Const.JAR_LOCATION.getAbsolutePath() + "/game.png", new Image("https://www.dropbox.com/s/k8kba15p514uopq/W.png?dl=1"), "https://www.dropbox.com/s/k8kba15p514uopq/W.png?dl=1", "Salut", "hey", "axium"));

        this.test = register(new Game("Test", "worldLegends.description", true, "https://www.dropbox.com/s/k8kba15p514uopq/W.png?dl=1", Const.JAR_LOCATION.getAbsolutePath() + "/test.png", null, "https://www.dropbox.com/s/k8kba15p514uopq/W.png?dl=1", "Salut", "hey", "axium"));
    }

    public Game register(Game game) {

        Objects.requireNonNull(game);
        this.gameList.put(game.getName(), game);
        return game;
    }

    public Map<String, Game> getGameList() {
        return gameList;
    }

    public static GamesRegistry getInstance() {

        if (instance == null) {
            instance = new GamesRegistry();
        }

        return instance;
    }
}