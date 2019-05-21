INSERT INTO users
(name, lastname, email, password)
VALUES
('Luis', 'Perez', 'luisperez@usach.cl', '1234'),
('José', 'Padilla', 'josepadilla@usach.cl', '4321');

INSERT INTO professors
(name, lastname_1, lastname_2, email, academic)
VALUES
('Alcides', 'Quispe', 'Sanca', 'alcidesquispe@usach.cl', true),
('Hector', 'Antillanca', 'Espina', 'hectorantillanca@usach.cl', true),
('Max', 'Chacón', 'Pacheco', 'maxchacon@usach.cl', true),
('Luciano', 'Hidalgo', 'Khe', 'lucianohidalgo@usach.cl', false),
('Alejandro', 'Cisterna', 'Khe', 'alejandrocisterna@usach.cl', false),
('Cristobal', 'Acosta', 'Jurado', 'cristobalacosta@usach.cl', false);


INSERT INTO topics
(name)
VALUES
('Ingeniería de Software'),
('Biomédica'),
('Astroinformática'),
('Educación'),
('Machine Learning'),
('Deep Learning'),
('Educación'),
('DevOps'),
('Drones'),
('DevOps'),
('Optimización'),
('Interacción Humano-Computadora'),
('Bioinformática'),
('Seguridad');

INSERT INTO programs
(code, name)
VALUES
(1353, 'Ingeniería en Ejecución en Computación e Informática'),
(1363, 'Ingeniería Civil en Informática');

INSERT INTO professor_topics
(topic_id, professor_id)
VALUES
(1,1),
(1,2),
(2,3),
(4,4),
(13,4),
(5,4),
(14,5),
(7,6);


INSERT INTO theses
(description, title, professor_guide_id, topic_id)
VALUES
('Descripcion...', 'El titulo', 1, 1),
('Descripcion...', 'El titulo', 2, 2);


INSERT INTO students
(email, year_income, lastname_1, lastname_2, name, program_id, thesis_id)
VALUES
('javier.arredondo.c@usach.cl', 2015, 'arredondo', 'contreras', 'javier', 1, 1),
('almuno.1@usach.cl', 2016, 'apellido', 'apellido', 'jnombre', 1, 2 ),
('almuno.2@usach.cl', 2016, 'apellido', 'apellido', 'jnombre', 2, null ),
('almuno.3@usach.cl', 2014, 'apellido', 'apellido', 'jnombre', 2, null );