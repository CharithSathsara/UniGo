package lk.madhack.unigo.model;

public class Subject {

    private Integer sub_id;
    private String name;
    private String description;
    private Course course;

    public Subject() {
    }

    public Subject(String name, String description, Course course) {
        this.name = name;
        this.description = description;
        this.course = course;
    }

    public Integer getSub_id() {
        return sub_id;
    }

    public void setSub_id(Integer sub_id) {
        this.sub_id = sub_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
