package ejemplo;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private List<Room> rooms;

    public RoomManager() {
        rooms = new ArrayList<>();
    }

    public boolean addRoom(Room room) {
        if (getRoomByCode(room.getCode()) != null) {
            System.out.println("Error: El usuario con ID '" + room.getCode() + "' ya está registrado.");
            return false;
        }

        rooms.add(room);
        return true;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getRoomByCode(String code) {
        for (Room room : rooms) {
            if (room.getCode().equals(code)) {
                return room;
            }
        }
        return null;
    }

    public void updateRoom(Room room) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getCode().equals(room.getCode())) {
                rooms.set(i, room);
                break;
            }
        }
    }

    public void deleteRoom(String code) {
        rooms.removeIf(room -> room.getCode().equals(code));
    }
}
