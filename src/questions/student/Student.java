package questions.student;

public class Student {
    private int id;
    private String name;
    private int rollNo;
    private String course;

    public Student(int id, String name, int rollNo, String course) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}

