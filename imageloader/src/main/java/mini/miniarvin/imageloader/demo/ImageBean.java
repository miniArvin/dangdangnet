package mini.miniarvin.imageloader.demo;

/**
 * Created by Administrator on 2016/5/16.
 */
public class ImageBean {

    String name;
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageBean() {
    }

    public ImageBean(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
