package java_hw_5.MediaFiles;

public class Video extends Media {

    private String resolution;

    public Video(String title, String resolution) {
        super(title);
        this.resolution = resolution;
    }

    public String getResolution() {
        return this.resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public void play() {
        System.out.println("Video is playing " +
                this.getTitle() + " with the resolution " +
                this.resolution);
    }
}


