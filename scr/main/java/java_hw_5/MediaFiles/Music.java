package java_hw_5.MediaFiles;

public class Music extends Media {
    private String artist;

    public Music(String title, String artist) {
        super(title);
        this.artist = artist;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Music is playing " +
                this.getArtist() + ": " + this.getTitle());
    }
}

