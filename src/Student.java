import java.io.Serializable;

public class Student implements Serializable {
    private int roll;
    private String name;
    private float marks;
    private String hobbies;

    public static final long serialVersionUID = 100L;

    public Student(int roll, String name, float marks, String hobbies) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}
