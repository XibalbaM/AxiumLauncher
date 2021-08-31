package fr.xibalba.launcher.games;

import fr.xibalba.launcher.main.Const;
import fr.xibalba.launcher.lang.Lang;
import fr.xibalba.utils.Function;
import fr.xibalba.utils.song.Song;

import static fr.xibalba.launcher.games.GamesRegistry.register;

public class Games {

    private String fileName = "games";
    private Function<Game> defaultOnShow = game -> game.getSound().play();
    private Function<Game> defaultOnHide = game -> game.getSound().stopPlay();

    public void init() {

        Game worldLegends = register(new Game("World Legends", Lang.getText(fileName, "worldLegends.description"), null, new Song(Const.CLASS_LOADER.getResource("fr/xibalba/launcher/ui/panels/assets/main.wav").getFile()), defaultOnShow, defaultOnHide));
    }
}
