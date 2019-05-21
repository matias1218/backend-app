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


## Entidades:

- **users:** Usuarios que interactúan con el software.
    - _email:_ Correo eléctrónico asociado al usuario.
    - _lastname:_ Apellido del usuario. 
    - _name:_ Nombre del usuario.
    - _password:_ Contraseña del usuario para autenticarse en el sistema.
- **programs:** Programa de estudios que soporta el sistema.
    - _code:_ Código de carrera. Ejemplo: 1353
    - _name:_ Nombre de la carrera. Ejemplo: Ingeniería en Ejecución en Computación e Informática.
- **students:** Estudiantes a los cuales se realizará seguimiento de su memoria.
    - _email:_ Correo eléctronico del estudiante.
    - _year_income:_ Año de ingreso del estudiante a su programa de estudios.
    - _lastname_1:_ Apellido paterno del estudiante.
    - _lastname_2:_ Apellido maternp del estudiante.
    - _name:_ Nombre del estudiante.
- **topics:** Temas que pueden ser desarrollados en una memoria. Ejemplo: Biomédica.
    - _name:_ Nombre del tema.
- **professors:** Profesores, los cuales pueden ser profesor guía y/o parte de una comisión de revisión.
    - _academic:_ Booleano que indica si es académico (profesor planta).
    - _email:_ Correo eléctronico del profesor.
    - _lastname_1:_ Apellido paterno del profesor.
    - _lastname_2:_ Apellido maternp del profesor.
    - _name:_ Nombre del profesor.
- **theses:** Memoria desarrollada por un estudiante para su titulación.
    - _description:_ Descripción de la memoria.
    - _title:_ Título de la memoria.
    - _professor_c1_id:_ Id del profesor que forma parte de la comisión de revisión.
    - _professor_c2_id:_ Id del profesor que forma parte de la comisión de revisión.
    - _professor_guide_id:_ Id del profesor guía.
    - _topic_id:_ Id del tema asociado a la memoria.
    

![entidades](https://i.ibb.co/xGzjJsr/diagram.png)



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
| `theses/create`| POST |Crea una tesis en la base de datos. Devuelve la tesis y todos sus atributos. Ver [2] para ver como funcionan los argumentos.|
| `theses/topic/{topicId}`|GET| Devuelve todas las tesis de un cierto tema, dado su id|
| `topics/all`| GET | Se obtiene todos los temas|
| `topics/professor/{professorId}` | GET | Se obtienen los temas asociados a un profesor dado su id|
| `user/register` | POST | Registra a un usuario en la base de datos [3]|
| `user/login` | POST | Realiza inicio de sesión de un usuario [4]|



##### [1] Creación de un estudiante
    {
    	"name": "Nombre ejemplo",
    	"lastname1": "Apellido 1 ejemplo",
    	"lastname2": "Apellido 2 ejemplo",
    	"income": 2015,
    	"email": "ejemploe@ejemplo.cl",
    	"codeProgram": 1363
    }
    
##### [2] Creación de una tesis
    {
    	"title": "Título de la tesis",
    	"description": "Descrićión de la tesis",
    	"studentId": 2,                          // id del estudiante
    	"guideId": 1,                            // id del profesor guía
    	"topicId":1                              // id del tema del estudiante
    }

##### [3] Creación de un usuario
    {
    	"name": "Nombre usuario",
    	"lastname": "Apellido del usuario",
    	"email": "correo@correo.cl",
    	"password": "contraseña del usuario"
    }
    
##### [4] Inicio de sesión de un usuario
    http://path:9090/users/login?email={correo}&password={pass}
    // email: email asociado al usuario
    // password: contraseña del usuario.
