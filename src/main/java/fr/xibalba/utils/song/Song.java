package fr.xibalba.utils.song;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Song {

    private File file;

    private Thread playing = new Thread(new Runnable() {
        public void run() {
            Clip clip = null;
            try {
                clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            while (!playing.isInterrupted())
                if (playing.isInterrupted())
                    clip.stop();
        }
    });

    public void play() {

        playing.start();
    }

    public void stopPlay() {
        playing.interrupt();
    }

    public Song(String file) {
        this.file = new File(file);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
