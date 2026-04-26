package java_hw_5.MediaFiles;

public class Main {

    public static void main(String[] args) {
        Music music = new Music("I`m still standing", "Elton John");
        Video video = new Video("Harry Potter", "1920x1080");

        music.play();
        video.play();
    }
}
