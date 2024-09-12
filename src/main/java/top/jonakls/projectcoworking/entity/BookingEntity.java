package top.jonakls.projectcoworking.entity;

import top.jonakls.projectcoworking.entity.workspace.BookingWorkspace;

import java.util.Date;

public class BookingEntity {

    private final String id;
    private final String name;
    private Date date;
    private BookingWorkspace workspace;
    private int hours;

    public BookingEntity(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
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
        return this.workspace.getName();
    }

    public void setWorkspace(int workspace) {
        this.workspace = BookingWorkspace.fromId(workspace);
    }

    public int getHours() {
        return this.hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
