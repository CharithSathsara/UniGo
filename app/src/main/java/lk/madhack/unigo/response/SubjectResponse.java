package lk.madhack.unigo.response;

import lk.madhack.unigo.model.Subject;

public class SubjectResponse {

    private String message;
    private String code;
    private Iterable<Subject> subjects;

    public SubjectResponse() {
    }

    public SubjectResponse(String message, String code, Iterable<Subject> subjects) {
        this.message = message;
        this.code = code;
        this.subjects = subjects;
    }

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

    public Iterable<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Iterable<Subject> subjects) {
        this.subjects = subjects;
    }
}
