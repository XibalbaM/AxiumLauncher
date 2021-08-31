package fr.xibalba.launcher.games;

import fr.xibalba.utils.Function;
import fr.xibalba.utils.javaFX.Showable;
import fr.xibalba.utils.song.Song;

import java.util.List;

public class Game {

    private String name;
    private String description;
    private List<Showable> display;
    private Song sound;
    private Function<Game> onShow;
    private Function<Game> onHide;

    public Game(String name, String description, List<Showable> display, Song sound, Function<Game> onShow, Function<Game> onHide) {

        this.name = name;
        this.description = description;
        this.display = display;
        this.sound = sound;
        this.onShow = onShow;
        this.onHide = onHide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Showable> getDisplay() {
        return display;
    }

    public void setDisplay(List<Showable> display) {
        this.display = display;
    }

    public Song getSound() {
        return sound;
    }

    public void setSound(Song sound) {
        this.sound = sound;
    }

    public Function<Game> getOnShow() {
        return onShow;
    }

    public void setOnShow(Function<Game> onShow) {
        this.onShow = onShow;
    }

    public Function<Game> getOnHide() {
        return onHide;
    }

    public void setOnHide(Function<Game> onHide) {
        this.onHide = onHide;
    }
}