package ejemplo;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ejemplo.Room;
import ejemplo.RoomManager;


public class RoomManagerTest {
    private RoomManager roomManager;

    @BeforeEach
    public void setUp() {
        roomManager = new RoomManager();
        // Agregar algunas salas para pruebas
        Room room1 = new Room("101", "Sala 101", "Edificio A");
        Room room2 = new Room("102", "Sala 102", "Edificio B");
        roomManager.addRoom(room1);
        roomManager.addRoom(room2);
    }

    @Test
    public void testAddRoom() {
        Room room = new Room("103", "Sala 103", "Edificio C");
        assertTrue(roomManager.addRoom(room));
    }

    @Test
    public void testGetRoomByCode() {
        Room room = roomManager.getRoomByCode("101");
        assertNotNull(room);
        assertEquals("Sala 101", room.getName());
    }

    @Test
    public void testUpdateRoom() {
        Room room = roomManager.getRoomByCode("101");
        assertNotNull(room);
        room.setName("Nueva Sala 101");
        roomManager.updateRoom(room);
        Room updatedRoom = roomManager.getRoomByCode("101");
        assertEquals("Nueva Sala 101", updatedRoom.getName());
    }

    @Test
    public void testDeleteRoom() {
        Room room = roomManager.getRoomByCode("102");
        assertNotNull(room);
        roomManager.deleteRoom("102");
        Room deletedRoom = roomManager.getRoomByCode("102");
        assertNull(deletedRoom);
    }

    @Test
    public void testGetRooms() {
        List<Room> rooms = roomManager.getRooms();
        assertEquals(2, rooms.size());
    }

}