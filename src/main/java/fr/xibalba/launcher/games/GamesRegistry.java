package fr.xibalba.launcher.games;

import java.util.ArrayList;
import java.util.List;

public class GamesRegistry {

    private static List<Game> gameList = new ArrayList<>();

    public static Game register(Game game) {
        gameList.add(game);
        return game;
    }

    public static List<Game> getGameList() {
        return gameList;
    }
}
