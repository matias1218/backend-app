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

INSERT INTO professor_topics
(topic_id, professor_id)
VALUES
(1,1),
(1,2),
(4,3);

