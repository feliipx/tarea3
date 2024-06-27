package ejemplo;

import java.util.Date;

public class Reservation {
    private Room room;
    private User user;
    private Date date;
    private String detail;

    public Reservation(Room room, User user, Date date, String detail) {
        this.room = room;
        this.user = user;
        this.date = date;
        this.detail = detail;
        room.setReserved(true);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
