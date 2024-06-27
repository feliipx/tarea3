package ejemplo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationManagerTest {
    private ReservationManager reservationManager;
    private RoomManager roomManager;
    private UserManager userManager;
    private SimpleDateFormat dateFormat;

    @BeforeEach
    public void setUp() {
        reservationManager = new ReservationManager();
        roomManager = new RoomManager();
        userManager = new UserManager();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Mock data setup
        Room room1 = new Room("101", "Sala 101", "Edificio A");
        roomManager.addRoom(room1);

        User user1 = new User("1", "Usuario 1", "Departamento 1", "Descripción 1");
        userManager.addUser(user1);
    }

    @Test
    public void testAddReservation() throws ParseException {
        Room room = roomManager.getRoomByCode("101");
        User user = userManager.getUserById("1");
        Date date = dateFormat.parse("01/01/2025");
        String detail = "Reserva de prueba";

        Reservation reservation = new Reservation(room, user, date, detail);
        assertTrue(reservationManager.addReservation(reservation));
    }

    @Test
    public void testGetReservations() throws ParseException {
        Room room = roomManager.getRoomByCode("101");
        User user = userManager.getUserById("1");
        Date date = dateFormat.parse("01/01/2025");
        String detail = "Reserva de prueba";

        Reservation reservation = new Reservation(room, user, date, detail);
        reservationManager.addReservation(reservation);

        List<Reservation> reservations = reservationManager.getReservations();
        assertEquals(1, reservations.size());
        assertEquals("101", reservations.get(0).getRoom().getCode());
        assertEquals("1", reservations.get(0).getUser().getId());
        assertEquals(dateFormat.parse("01/01/2025"), reservations.get(0).getDate());
        assertEquals("Reserva de prueba", reservations.get(0).getDetail());
    }

    @Test
    public void testUpdateReservation() throws ParseException {
        Room room = roomManager.getRoomByCode("101");
        User user = userManager.getUserById("1");
        Date date = dateFormat.parse("01/01/2025");
        String detail = "Reserva inicial";

        Reservation reservation = new Reservation(room, user, date, detail);
        reservationManager.addReservation(reservation);

        Date newDate = dateFormat.parse("02/01/2025");
        reservation.setDate(newDate);
        reservation.setDetail("Reserva actualizada");

        assertTrue(reservationManager.updateReservation(reservation));

        Reservation updatedReservation = reservationManager.getReservations().get(0);
        assertEquals(newDate, updatedReservation.getDate());
        assertEquals("Reserva actualizada", updatedReservation.getDetail());
    }

    @Test
    public void testDeleteReservation() throws ParseException {
        Room room = roomManager.getRoomByCode("101");
        User user = userManager.getUserById("1");
        Date date = dateFormat.parse("01/01/2025");
        String detail = "Reserva de prueba";

        Reservation reservation = new Reservation(room, user, date, detail);
        reservationManager.addReservation(reservation);

        assertTrue(reservationManager.deleteReservation(reservation));
        assertEquals(0, reservationManager.getReservations().size());
    }
}
