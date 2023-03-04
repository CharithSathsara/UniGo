package lk.madhack.unigo.model;

public class Student {

    private Integer stdid;
    private String name;
    private String email;
    private String indexNo;
    private String password;

    public Student() {
    }

    public Student(String name, String email, String indexNo, String password) {
        this.name = name;
        this.email = email;
        this.indexNo = indexNo;
        this.password = password;
    }

    public Integer getStdid() {
        return stdid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public String getPassword() {
        return password;
    }
}
