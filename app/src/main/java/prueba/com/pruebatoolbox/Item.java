package prueba.com.pruebatoolbox;

public class Item {

    private String title;
    private String url;
    private String video;

    public Item() {
        title   = "";
        url     = "";
        video   = "";
    }

    public Item(String title, String url, String video) {
        this.title = title;
        this.url = url;
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
