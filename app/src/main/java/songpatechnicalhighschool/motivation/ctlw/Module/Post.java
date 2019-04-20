package songpatechnicalhighschool.motivation.ctlw.Module;

public class Post {
    String title;
    String date;
    String preview;
    String content;

    public Post(String title, String date, String preview, String content) {
        this.title = title;
        this.date = date;
        this.preview = preview;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
