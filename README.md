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
- 



# Programa

El programa completo se desarrolló en Java, utilizando IntelliJ para aprovechar las ventajas que nos otorga para realizar el testing y el manejo del proyecto. El testing se realizó con JUnit 5.







