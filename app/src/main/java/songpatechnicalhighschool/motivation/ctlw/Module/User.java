package songpatechnicalhighschool.motivation.ctlw.Module;

public class User {

    private String email;
    private String username;
    private String gender;
    private String age;
    private String birth;
    private String imageURL;

    public User() {
    }

    public User(String email, String username, String gender, String age, String birth, String imageURL) {
        this.email = email;
        this.username = username;
        this.gender = gender;
        this.age = age;
        this.birth = birth;
        this.imageURL = imageURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
