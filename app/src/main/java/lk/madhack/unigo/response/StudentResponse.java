package lk.madhack.unigo.response;

import lk.madhack.unigo.model.Student;

public class StudentResponse {

    private String message;
    private String code;
    private Student student;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
