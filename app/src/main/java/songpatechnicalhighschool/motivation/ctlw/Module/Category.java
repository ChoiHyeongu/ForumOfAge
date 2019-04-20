package songpatechnicalhighschool.motivation.ctlw.Module;

public class Category {

    String topic;
    int youngMin, youngMax;
    int oldMin, oldMax;

    public Category(String topic, int youngMin, int youngMax, int oldMin, int oldMax) {
        this.topic = topic;
        this.youngMin = youngMin;
        this.youngMax = youngMax;
        this.oldMin = oldMin;
        this.oldMax = oldMax;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getYoungMin() {
        return youngMin;
    }

    public void setYoungMin(int youngMin) {
        this.youngMin = youngMin;
    }

    public int getYoungMax() {
        return youngMax;
    }

    public void setYoungMax(int youngMax) {
        this.youngMax = youngMax;
    }

    public int getOldMin() {
        return oldMin;
    }

    public void setOldMin(int oldMin) {
        this.oldMin = oldMin;
    }

    public int getOldMax() {
        return oldMax;
    }

    public void setOldMax(int oldMax) {
        this.oldMax = oldMax;
    }
}
