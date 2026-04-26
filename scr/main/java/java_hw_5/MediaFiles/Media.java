package java_hw_5.MediaFiles;

public class Media {
        private String title;

        public Media(String title) {
            this.title = title;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void play() {
            System.out.println("Media is playing: " + this.title);
        }
    }

