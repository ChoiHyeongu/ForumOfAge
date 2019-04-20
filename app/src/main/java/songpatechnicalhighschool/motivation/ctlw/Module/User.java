package songpatechnicalhighschool.motivation.ctlw.Module;

public class User {

    private String email;
    private String name;
    private String gender;
    private int age;
    private int birth;

    public User(String email, String name, String gender, int age, int birth) {
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }
}
