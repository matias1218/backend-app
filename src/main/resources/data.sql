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
('Max', 'Chacón', 'Pacheco', 'maxchacon@usach.cl', true);

INSERT INTO topics
(name)
VALUES
('Ingeniería de Software'),
('Inteligencia Artificial'),
('Interacción Humano-Computadora'),
('Bioinformática');

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
(4,3);


INSERT INTO theses
(description, title, professor_guide_id, topic_id)
VALUES
('Descripcion...', 'El titulo', 1, 1);


INSERT INTO students
(email, year_income, lastname_1, lastname_2, name, program_id, thesis_id)
VALUES
('pico', 2015, 'arredondo', 'contreras', 'javier', 1, 1);