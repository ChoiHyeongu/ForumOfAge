package songpatechnicalhighschool.motivation.ctlw.Module;

public class Post {
    String title;
    String date;
    String preview;
    String content;
    String key;
    String youngMin, youngMax;
    String oldMin, oldMax;
    String topic;
    String user1, user2;
    String user1Vote, user2Vote;

    public Post() {
    }

    public Post(String title, String date, String preview, String content, String key, String youngMin, String youngMax, String oldMin, String oldMax, String topic, String user1, String user2, String user1Vote, String user2Vote) {
        this.title = title;
        this.date = date;
        this.preview = preview;
        this.content = content;
        this.key = key;
        this.youngMin = youngMin;
        this.youngMax = youngMax;
        this.oldMin = oldMin;
        this.oldMax = oldMax;
        this.topic = topic;
        this.user1 = user1;
        this.user2 = user2;
        this.user1Vote = user1Vote;
        this.user2Vote = user2Vote;
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

    public String getYoungMin() {
        return youngMin;
    }

    public void setYoungMin(String youngMin) {
        this.youngMin = youngMin;
    }

    public String getYoungMax() {
        return youngMax;
    }

    public void setYoungMax(String youngMax) {
        this.youngMax = youngMax;
    }

    public String getOldMin() {
        return oldMin;
    }

    public void setOldMin(String oldMin) {
        this.oldMin = oldMin;
    }

    public String getOldMax() {
        return oldMax;
    }

    public void setOldMax(String oldMax) {
        this.oldMax = oldMax;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user) {
        this.user2 = user;
    }

    public String getUser1Vote() {
        return user1Vote;
    }

    public void setUser1Vote(String user1Vote) {
        this.user1Vote = user1Vote;
    }

    public String getUser2Vote() {
        return user2Vote;
    }

    public void setUser2Vote(String user2Vote) {
        this.user2Vote = user2Vote;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
