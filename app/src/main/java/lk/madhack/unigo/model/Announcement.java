package lk.madhack.unigo.model;

public class Announcement {

    private Integer id;
    private String announcement;

    public Announcement() {
    }

    public Announcement(String announcement) {
        this.announcement = announcement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
}
