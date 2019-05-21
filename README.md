# Asignación de comisiones correctoras de memoria DIINF
 
## Paquetes del proyecto

 - [ ] `controller`: contiene los controladores de la API que exponen endpoints de consumo a clientes.
 - [ ] `dao`: (Data Access Object) contiene las interfaces de comunicación con base de datos
 - [ ] `dto`: (Data Transfer Object) contiene los objetos de transferencia de datos, los cuáles son los que comunican con los clientes.
 - [ ] `mapper`: contiene los objetos transformación entre `model` y `dto`.
 - [x] `model`: contiene las entidades de datos del proyecto.
 - [ ] `service`: contiene los objetos que coordinan la lógica de datos entre `dao` y `controller`
 - [ ] `util`: contiene los objetos de utilidad miscelánea para el sistema.

![estructura](https://i.ibb.co/6wjz0Bk/Diagrama-Estructura.png)

## Dependencias utilizadas
 - [Lombok:](https://projectlombok.org/) Biblioteca de anotaciones de Java que ayuda a reducir el código y el código repetido.
 - [Rest Repositories:](https://spring.io/projects/spring-data-rest) Para exponer los repositorios de `Spring Data` sobre `REST` a través de `Spring Data REST`.
 - [HATEOAS:](https://spring.io/projects/spring-hateoas) es un pequeño módulo perteneciente al «ecosistema Spring» que nos ayudará a crear `APIs REST` que respeten el principio `HATEOAS`.
 - [JPA](https://spring.io/projects/spring-data-jpa): Persiste los datos en `SQL` almacenados con `Java Persistence API` usando `Spring Data` e `Hibernate`.
 - [PostgreSQL](https://jdbc.postgresql.org/): Driver JDBC de PostgreSQL.

## Servicios

Consultar a `23.20.84.8:9090`

| path | tipo | descripción |
|--|--|--|
| `students/create` | POST | Crea un estudiante dentro de la base de datos. Devuelve al estudiante recién creado. Ver [1] para ver cómo funciona los argumentos del post. |
| `students/all`| GET| Devuelve una lista todos los estudiantes de la base de datos. |
| `students/{studentId}/assign/{professorId}`|GET| Asigna a la tesis del estudiante el profesor, dado sus ids. Devuelve booleano que indica si se pudo realizar la asignación.|
| `professors/all` | GET | Devuelve una lista todos los profesores de la base de datos |
| `professors/topic/{topicId}` | GET| Devuelve un listado de los profesores asociados a un tema en particular |
| `theses/all`| GET| Devuelve un listado de todas las tesis que etsán en la base de datos|
| `theses/guide/{professorId}`|GET|Devuelve todas las tesis en la que un profesor ha sido guía, dado su id.|
| `theses/commission/{professorId}`|GET|Devuelve todas las tesis en que un profesor ha sido parte de la comisión, dado su id|
| `topics/all`| GET | Se obtiene todos los temas|
| `topics/professor/{professorId}` | GET | Se obtienen los temas asociados a un profesor dado su id|







##### [1] Creación de un estudiante
    {
    	"name": "Nombre ejemplo",
    	"lastname1": "Apellido 1 ejemplo",
    	"lastname2": "Apellidos 2 ejemplo",
    	"income": 2015,
    	"email": "ejemploe@ejemplo.cl",
    	"codeProgram": 1363
    }
