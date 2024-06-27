package ejemplo;

import java.util.ArrayList;
import java.util.List;

public class ReservationManager {
    private List<Reservation> reservations;

    public ReservationManager() {
        reservations = new ArrayList<>();
    }

    public boolean addReservation(Reservation reservation) {
        return reservations.add(reservation);
    }


    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Reservation> getReservationsByUser(User user) {
        List<Reservation> userReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getUser().equals(user)) {
                userReservations.add(reservation);
            }
        }
        return userReservations;
    }

    public List<Reservation> getReservationsByRoom(Room room) {
        List<Reservation> roomReservations = new ArrayList<>();
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().equals(room)) {
                roomReservations.add(reservation);
            }
        }
        return roomReservations;
    }

    public boolean updateReservation(Reservation reservation) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getRoom().equals(reservation.getRoom()) &&
                    reservations.get(i).getUser().equals(reservation.getUser()) &&
                    reservations.get(i).getDate().equals(reservation.getDate())) {

                reservations.set(i, reservation);
                return true; // Se encontró y actualizó la reserva
            }
        }

        return false; // No se encontró la reserva
    }


    public boolean deleteReservation(Reservation reservation) {
        boolean removed = reservations.removeIf(r ->
                r.getRoom().equals(reservation.getRoom()) &&
                        r.getUser().equals(reservation.getUser()) &&
                        r.getDate().equals(reservation.getDate()));

        if (removed) {
            reservation.getRoom().setReserved(false);
            return true;
        } else {
            return false;
        }
    }
}
