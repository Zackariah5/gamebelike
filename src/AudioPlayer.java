//Zachary Copans 2023
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioPlayer {

    public File musicPath; //Not compatible with .mp3 files, .wav is highly recommended, but also works with .snd and .aiff files.
    public static Clip clip;
    public long position;
    public static boolean isPlaying;
    public static boolean hasStarted;

    public AudioPlayer(String filepath) {
        musicPath = new File(filepath);
        try {
            File musicPath = new File(filepath);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
            } else {
                System.out.println("Can't find file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        isPlaying = false;
        hasStarted = false;
    }

    //Plays the song, either looping if boolean parameter "loop" is true, or just once if "loop" is false.
    public static void play(boolean loop) {
        if (loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
        else clip.start();
        isPlaying = true;
        hasStarted = true;
    }

    //Pauses the song, saving the current position for resuming later.
    public void pause() {
        if (!hasStarted) {
            System.out.println("Error: Audio hasn't been played.");
        } else if (!isPlaying) {
            System.out.println("Error: Audio is not currently playing.");
        } else {
            position = clip.getMicrosecondPosition();
            clip.stop();
            isPlaying = false;
        }
    }

    //Resumes the song at the position last paused at.
    public void resume() {
        if (!hasStarted) {
            System.out.println("Error: Audio hasn't been played.");
        } else if (isPlaying) {
            System.out.println("Error: Audio is already being played.");
        } else {
            clip.setMicrosecondPosition(position);
            clip.start();
            isPlaying = true;
        }
    }

}