package lk.madhack.unigo.model;

public class Event {

    private Integer event_id;
    private String name;
    private String date;

    public Event() {
    }

    public Event(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
