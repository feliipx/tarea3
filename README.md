# Tarea 3

- Felipe Fuentes Villegas
- 201973102-5
- Fecha: 27 Junio 2024

# Problema

Este programa implementa un sistema de gestión de salas, donde se pueden generar reservas de estas con fechas establecidas por el usuario.
Se tienen distintos requerimientos, a continuación se listan los que se nos piden:

#### Gestión de Salas

- Agregar Salas: Permitir la creación de 1 a n salas.
- Atributos de las Salas: Cada sala debe tener un código, nombre, ubicación y estado de reserva (reservada o disponible).
- CRUD de Salas: Crear, leer, actualizar y eliminar salas.

#### Gestión de Usuarios

- Agregar Usuarios: Permitir la creación de usuarios.
- Atributos de los Usuarios: Cada usuario debe tener un identificador, nombre, departamento y descripción.
- CRUD de Usuarios: Crear, leer, actualizar y eliminar usuarios.
- Otros: Un usuario solamente puede reservar una sala en un mismo espacio de tiempo.
  
#### Gestión de Reservas

- Crear Reservas: Permitir la reserva de salas por parte de los usuarios en una fecha determinada.
- Atributos de las Reservas: Una reserva debe vincular una sala y un usuario en una fecha específica.
- CRUD de Reservas: Crear, leer, actualizar y eliminar reservas

#### Menú Principal

- Gestión de Usuarios: Acceso a las operaciones CRUD para usuarios.
- Gestión de Salas: Acceso a las operaciones CRUD para salas.
- Gestión de Resrevas: Acceso a las operaciones CRUD para reservas.

#### Otros
Considerando la lectura de todo el enunciado, surgieron otros requerimientos:

- Las ID deben ser únicas.
- El valor máximo de salas puede variar durante la ejecución del programa.
  


# Programa

El programa completo se desarrolló en Java, utilizando IntelliJ para aprovechar las ventajas que nos otorga para realizar el testing y el manejo del proyecto. El testing se realizó con JUnit 5.


### Estructura del proyecto

src/ejemplo/Main.java: Contiene la clase principal que maneja la lógica del programa.
src/ejemplo/Room.java: Define la clase Room.
src/ejemplo/User.java: Define la clase User.
src/ejemplo/Reservation.java: Define la clase Reservation.
src/ejemplo/RoomManager.java: Gestiona las operaciones CRUD para las salas.
src/ejemplo/UserManager.java: Gestiona las operaciones CRUD para los usuarios.
src/ejemplo/ReservationManager.java: Gestiona las operaciones CRUD para las reservas.


### Instrucciones para ejecución

1. Clonar el repositorio: https://github.com/feliipx/tarea3
2. En IntelliJ, crear proyecto con la carpeta del repo
3. Configurar el proyecto agregando JUnit 5 para el testing
4. Ejecutar los archivos de test con el botón que provee IntelliJ para probar uno a uno los archivos



# Testing JUnit 5

Es claro que tenemos 3 cosas grandes que probar, estos son el CRUD de Salas, Usuarios y Reservas.

#### Salas

- Probar la creación de una sala nueva dentro del límite permitido.
- Probar la lectura de salas.
- Probar la actualización de una sala existente.
- Probar la eliminación de una sala.
- Probar la creación de una sala vacía.
- Obtener sala por su ID.


![](https://github.com/feliipx/tarea3/blob/main/room.png)


#### Usuarios

- Probar la creación de un usuario nuevo.
- Probar la lectura de usuarios.
- Probar la actualización de un usuario existente.
- Probar la eliminación de un usuario.
- Probar la creación de usuario vacío.
- Obtener usuario por su ID.
- Probar la creación de usuario duplicado.

![](https://github.com/feliipx/tarea3/blob/main/user.png)

#### Reservas

- Probar la creación de una reserva nueva.
- Probar la lectura de reservas.
- Probar la actualización de una reserva existente.
- Probar la eliminación de una reserva.

![](https://github.com/feliipx/tarea3/blob/main/reservation.png)






