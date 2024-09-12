package top.jonakls.testpage.entity;

import java.util.Date;

public class BookingEntity {

    private final String name;
    private Date date;
    private String workspace;
    private int hours;

    public BookingEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWorkspace() {
        return this.workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public int getHours() {
        return this.hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
