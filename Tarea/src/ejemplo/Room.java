package ejemplo;

public class Room {
    private String code;
    private String name;
    private String location;
    private boolean reserved;

    public Room(String code, String name, String location) {
        this.code = code;
        this.name = name;
        this.location = location;
        this.reserved = false;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
