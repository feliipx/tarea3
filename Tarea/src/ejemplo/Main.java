package ejemplo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static RoomManager roomManager = new RoomManager();
    private static UserManager userManager = new UserManager();
    private static ReservationManager reservationManager = new ReservationManager();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static int maxRooms = 10; // Límite por defecto de salas

    public static void main(String[] args) {
        System.out.print("Ingrese el límite máximo de salas: ");
        maxRooms = Integer.parseInt(scanner.nextLine());

        boolean running = true;
        while (running) {
            System.out.println("\n1. Gestión de Salas");
            System.out.println("2. Gestión de Usuarios");
            System.out.println("3. Gestión de Reservas");
            System.out.println("4. Configurar límite de salas");
            System.out.println("5. Salir");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    manageRooms();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 3:
                    manageReservations();
                    break;
                case 4:
                    configureMaxRooms();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }

    private static void configureMaxRooms() {
        System.out.println("Configurar límite de salas:");
        System.out.print("Nuevo límite de salas (actual " + maxRooms + "): ");
        try {
            int newMaxRooms = Integer.parseInt(scanner.nextLine());
            if (newMaxRooms <= 0) {
                System.out.println("El límite de salas debe ser mayor que cero.");
            } else {
                maxRooms = newMaxRooms;
                System.out.println("Límite de salas actualizado a " + maxRooms + ".");
            }
        } catch (NumberFormatException e) {
            System.out.println("Valor ingresado no válido. Introduce un número entero positivo.");
        }
    }

    private static void manageRooms() {
        System.out.println("Gestión de Salas");
        System.out.println("1. Agregar Sala");
        System.out.println("2. Ver Salas");
        System.out.println("3. Actualizar Sala");
        System.out.println("4. Eliminar Sala");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                addRoom();
                break;
            case 2:
                viewRooms();
                break;
            case 3:
                updateRoom();
                break;
            case 4:
                deleteRoom();
                break;
            default:
                System.out.println("Opción inválida. Inténtalo de nuevo.");
        }
    }

    private static void manageUsers() {
        System.out.println("Gestión de Usuarios");
        System.out.println("1. Agregar Usuario");
        System.out.println("2. Ver Usuarios");
        System.out.println("3. Actualizar Usuario");
        System.out.println("4. Eliminar Usuario");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                viewUsers();
                break;
            case 3:
                updateUser();
                break;
            case 4:
                deleteUser();
                break;
            default:
                System.out.println("Opción inválida. Inténtalo de nuevo.");
        }
    }

    private static void manageReservations() {
        System.out.println("Gestión de Reservas");
        System.out.println("1. Crear Reserva");
        System.out.println("2. Ver Reservas");
        System.out.println("3. Actualizar Reserva");
        System.out.println("4. Eliminar Reserva");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                addReservation();
                break;
            case 2:
                viewReservations();
                break;
            case 3:
                updateReservation();
                break;
            case 4:
                deleteReservation();
                break;
            default:
                System.out.println("Opción inválida. Inténtalo de nuevo.");
        }
    }

    private static boolean addRoom() {
        if (roomManager.getRooms().size() >= maxRooms) {
            System.out.println("No se pueden agregar más salas, se ha alcanzado el límite máximo (" + maxRooms + ").");
            return false;
        }
        System.out.println("Agregar nueva sala:");
        System.out.print("Código: ");
        String code = scanner.nextLine();
        if (code.isEmpty()) {
            System.out.println("El código no puede estar vacío.");
            return false;
        }
        if (roomManager.getRoomByCode(code) != null) {
            System.out.println("Ya existe una sala con ese código.");
            return false;
        }
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Ubicación: ");
        String location = scanner.nextLine();
        Room room = new Room(code, name, location);
        roomManager.addRoom(room);
        System.out.println("Sala agregada con éxito.");
        return true;
    }

    private static void viewRooms() {
        System.out.println("Lista de salas:");
        List<Room> rooms = roomManager.getRooms();
        for (Room room : rooms) {
            System.out.println("Código: " + room.getCode() + ", Nombre: " + room.getName() + ", Ubicación: " + room.getLocation() + ", Reservada: " + room.isReserved());
        }
    }

    private static void updateRoom() {
        System.out.println("Actualizar sala:");
        System.out.print("Código de la sala a actualizar: ");
        String code = scanner.nextLine();
        Room room = roomManager.getRoomByCode(code);
        if (room == null) {
            System.out.println("Sala no encontrada.");
            return;
        }
        System.out.print("Nuevo nombre: ");
        String name = scanner.nextLine();
        System.out.print("Nueva ubicación: ");
        String location = scanner.nextLine();
        room.setName(name);
        room.setLocation(location);
        roomManager.updateRoom(room);
        System.out.println("Sala actualizada con éxito.");
    }

    private static void deleteRoom() {
        System.out.println("Eliminar sala:");
        System.out.print("Código de la sala a eliminar: ");
        String code = scanner.nextLine();
        roomManager.deleteRoom(code);
        System.out.println("Sala eliminada con éxito.");
    }

    private static void addUser() {
        System.out.println("Agregar nuevo usuario:");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        if (id.isEmpty()) {
            System.out.println("El ID no puede estar vacío.");
            return;
        }
        if (userManager.getUserById(id) != null) {
            System.out.println("Ya existe un usuario con ese ID.");
            return;
        }
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Departamento: ");
        String department = scanner.nextLine();
        System.out.print("Descripción: ");
        String description = scanner.nextLine();
        User user = new User(id, name, department, description);
        userManager.addUser(user);
        System.out.println("Usuario agregado con éxito.");
    }

    private static void viewUsers() {
        System.out.println("Lista de usuarios:");
        List<User> users = userManager.getUsers();
        for (User user : users) {
            System.out.println("ID: " + user.getId() + ", Nombre: " + user.getName() + ", Departamento: " + user.getDepartment() + ", Descripción: " + user.getDescription());
        }
    }

    private static void updateUser() {
        System.out.println("Actualizar usuario:");
        System.out.print("ID del usuario a actualizar: ");
        String id = scanner.nextLine();
        User user = userManager.getUserById(id);
        if (user == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        System.out.print("Nuevo nombre: ");
        String name = scanner.nextLine();
        System.out.print("Nuevo departamento: ");
        String department = scanner.nextLine();
        System.out.print("Nueva descripción: ");
        String description = scanner.nextLine();
        user.setName(name);
        user.setDepartment(department);
        user.setDescription(description);
        userManager.updateUser(user);
        System.out.println("Usuario actualizado con éxito.");
    }

    private static void deleteUser() {
        System.out.println("Eliminar usuario:");
        System.out.print("ID del usuario a eliminar: ");
        String id = scanner.nextLine();
        userManager.deleteUser(id);
        System.out.println("Usuario eliminado con éxito.");
    }

    private static void addReservationn() {
        System.out.println("Crear nueva reserva:");
        System.out.print("Código de la sala: ");
        String roomCode = scanner.nextLine();
        Room room = roomManager.getRoomByCode(roomCode);
        if (room == null || room.isReserved()) {
            System.out.println("Sala no encontrada o ya reservada.");
            return;
        }
        System.out.print("ID del usuario: ");
        String userId = scanner.nextLine();
        User user = userManager.getUserById(userId);
        if (user == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        System.out.print("Fecha (dd/MM/yyyy): ");
        String dateStr = scanner.nextLine();
        Date date;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido.");
            return;
        }
        System.out.print("Detalle de la reserva: ");
        String detail = scanner.nextLine();
        Reservation reservation = new Reservation(room, user, date, detail);
        reservationManager.addReservation(reservation);
        System.out.println("Reserva creada con éxito.");
    }
    private static void addReservation() {
        System.out.println("Crear nueva reserva:");
        System.out.print("Código de la sala: ");
        String roomCode = scanner.nextLine();
        Room room = roomManager.getRoomByCode(roomCode);
        if (room == null) {
            System.out.println("Sala no encontrada.");
            return;
        }
        System.out.print("ID del usuario: ");
        String userId = scanner.nextLine();
        User user = userManager.getUserById(userId);
        if (user == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        System.out.print("Fecha (dd/MM/yyyy): ");
        String dateStr = scanner.nextLine();
        Date date;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido.");
            return;
        }
        System.out.print("Detalle de la reserva: ");
        String detail = scanner.nextLine();
        Reservation reservation = new Reservation(room, user, date, detail);
        if (reservationManager.addReservation(reservation)) {
            System.out.println("Reserva creada con éxito.");
        } else {
            System.out.println("La sala ya está reservada para esta fecha.");
        }
    }

    private static void viewReservations() {
        System.out.println("Lista de reservas:");
        List<Reservation> reservations = reservationManager.getReservations();
        for (Reservation reservation : reservations) {
            System.out.println("Sala: " + reservation.getRoom().getCode() + ", Usuario: " + reservation.getUser().getId() + ", Fecha: " + dateFormat.format(reservation.getDate()) + ", Detalle: " + reservation.getDetail());
        }
    }

    private static void updateReservation() {
        System.out.println("Actualizar reserva:");
        System.out.print("Código de la sala: ");
        String roomCode = scanner.nextLine();
        Room room = roomManager.getRoomByCode(roomCode);
        if (room == null) {
            System.out.println("Sala no encontrada.");
            return;
        }
        System.out.print("ID del usuario: ");
        String userId = scanner.nextLine();
        User user = userManager.getUserById(userId);
        if (user == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        System.out.print("Fecha de la reserva (dd/MM/yyyy): ");
        String dateStr = scanner.nextLine();
        Date date;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido.");
            return;
        }
        Reservation existingReservation = null;
        for (Reservation reservation : reservationManager.getReservations()) {
            if (reservation.getRoom().equals(room) && reservation.getUser().equals(user) && reservation.getDate().equals(date)) {
                existingReservation = reservation;
                break;
            }
        }
        if (existingReservation == null) {
            System.out.println("Reserva no encontrada.");
            return;
        }
        System.out.print("Nuevo detalle de la reserva: ");
        String detail = scanner.nextLine();
        existingReservation.setDetail(detail);
        reservationManager.updateReservation(existingReservation);
        System.out.println("Reserva actualizada con éxito.");
    }

    private static void deleteReservation() {
        System.out.println("Eliminar reserva:");
        System.out.print("Código de la sala: ");
        String roomCode = scanner.nextLine();
        Room room = roomManager.getRoomByCode(roomCode);
        if (room == null) {
            System.out.println("Sala no encontrada.");
            return;
        }
        System.out.print("ID del usuario: ");
        String userId = scanner.nextLine();
        User user = userManager.getUserById(userId);
        if (user == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        System.out.print("Fecha de la reserva (dd/MM/yyyy): ");
        String dateStr = scanner.nextLine();
        Date date;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido.");
            return;
        }
        Reservation reservationToDelete = null;
        for (Reservation reservation : reservationManager.getReservations()) {
            if (reservation.getRoom().equals(room) && reservation.getUser().equals(user) && reservation.getDate().equals(date)) {
                reservationToDelete = reservation;
                break;
            }
        }
        if (reservationToDelete == null) {
            System.out.println("Reserva no encontrada.");
            return;
        }
        reservationManager.deleteReservation(reservationToDelete);
        System.out.println("Reserva eliminada con éxito.");
    }
}
