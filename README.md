# Asignación de comisiones correctoras de memoria DIINF
 
## Paquetes del proyecto

 - [ ] `controller`: contiene los controladores de la API que exponen endpoints de consumo a clientes.
 - [ ] `dao`: (Data Access Object) contiene las interfaces de comunicación con base de datos
 - [ ] `dto`: (Data Transfer Object) contiene los objetos de transferencia de datos, los cuáles son los que comunican con los clientes.
 - [ ] `mapper`: contiene los objetos transformación entre `model` y `dto`.
 - [ ] `model`: contiene las entidades de datos del proyecto.
 - [ ] `service`: contiene los objetos que coordinan la lógica de datos entre `dao` y `controller`
 - [ ] `util`: contiene los objetos de utilidad miscelánea para el sistema.

![estructura](https://i.ibb.co/6wjz0Bk/Diagrama-Estructura.png)

## Dependencias utilizadas
 - [Lombok:](https://projectlombok.org/) Biblioteca de anotaciones de Java que ayuda a reducir el código y el código repetido.
 - [Rest Repositories:](https://spring.io/projects/spring-data-rest) Para exponer los repositorios de `Spring Data` sobre `REST` a través de `Spring Data REST`.
 - [HATEOAS:](https://spring.io/projects/spring-hateoas) es un pequeño módulo perteneciente al «ecosistema Spring» que nos ayudará a crear `APIs REST` que respeten el principio `HATEOAS`.
 - [JPA](https://spring.io/projects/spring-data-jpa): Persiste los datos en `SQL` almacenados con `Java Persistence API` usando `Spring Data` e `Hibernate`.
 - [PostgreSQL](https://jdbc.postgresql.org/): Driver JDBC de PostgreSQL.

## Ejecución de software


