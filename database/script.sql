
CREATE DATABASE gimnasiodb;
CREATE USER 'gimnasio'@'localhost' IDENTIFIED BY 'clave123';
GRANT ALL PRIVILEGES ON gimnasiodb.* TO 'gimnasio'@'localhost';
FLUSH PRIVILEGES;
USE gimnasiodb;


INSERT INTO socio (nombre, plan, mensualidad, activo) VALUES
('Carlos Mena',     'mensual',    30.0, true),
('Andrea Salazar',  'trimestral', 25.0, true),
('Luis Paredes',    'mensual',    30.0, true),
('Daniela Cruz',    'anual',      20.0, true),
('Jorge Villacís',  'mensual',    30.0, false);

INSERT INTO clase_grupal (nombre, instructor, horario, cupos) VALUES
('Spinning', 'María Ruiz',    'Lunes 18:00',     15),
('Yoga',     'Paola Andrade', 'Martes 07:00',    10),
('Zumba',    'Kevin Torres',  'Miércoles 19:00',  8),
('Crossfit', 'Diego Núñez',   'Jueves 06:00',     5),
('Boxeo',    'Santiago León', 'Viernes 18:30',    0);

INSERT INTO maquina (nombre, marca, anio_compra, en_mantenimiento) VALUES
('Prensa de piernas', 'Technogym',  2019, false),
('Caminadora',        'Life Fitness', 2021, false),
('Press de pecho',    'Matrix',     2016, false),
('Bicicleta fija',    'Precor',     2022, false),
('Remo',              'Concept2',   2015, true);
