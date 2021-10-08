package fr.xibalba.launcher.games;

import fr.xibalba.launcher.lang.Lang;
import javafx.scene.image.Image;

import static fr.xibalba.launcher.games.GamesRegistry.register;

public class Games {

    private static String fileName = "games";

    public static Game worldLegends = register(new Game("World Legends", Lang.getText(fileName, "worldLegends.description"), false, new Image("https://www.dropbox.com/s/k8kba15p514uopq/W.png?dl=1"), param -> {}, param -> {}, "https://www.dropbox.com/s/k8kba15p514uopq/W.png?dl=1", "Salut", "hey", "axium"));
    public static Game test = register(new Game("Test", Lang.getText(fileName, "worldLegends.description"), true, null, param -> {}, param -> {}, "", "Salut", "hey", "axium"));
}
