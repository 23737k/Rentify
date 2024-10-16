## Run this sql script after the database initialization to load sample properties

```sql
START TRANSACTION;

-- Here I perform an INSERT of a sample user to add it as the owner of the properties
INSERT INTO users (email, password, status, created_at, is_verify, role_id)
VALUES ('johndoe@example.com', '$2a$10$somethingHashedPassword', 'ACTIVE', NOW(), 1, 1);

SET @userId = LAST_INSERT_ID();

INSERT INTO user_profiles (name, last_name, user_id)
VALUES ('John', 'Doe', @userId);

-- Here I perform an INSERT of 17 different rooms
INSERT INTO `room` (`name`)
VALUES
    ('Dormitorio'),
    ('Baño'),
    ('Cocina'),
    ('Comedor'),
    ('Sala de estar'),
    ('Estudio'),
    ('Lavadero'),
    ('Vestidor'),
    ('Oficina'),
    ('Balcón'),
    ('Terraza'),
    ('Garaje'),
    ('Sótano'),
    ('Ático'),
    ('Jardín'),
    ('Cuarto de servicio'),
    ('Patio');

INSERT INTO `features` (name)
VALUES
    ('apto profesional'),
    ('acceso para personas con discapacidad'),
    ('uso comercial'),
    ('permite mascotas');


INSERT INTO `amenities` (name)
VALUES
    ('aire acondicionado'),
    ('gimnasio'),
    ('hidromasaje'),
    ('solarium'),
    ('pileta'),
    ('sala de juegos'),
    ('parrilla'),
    ('sum'),
    ('cocina equipada'),
    ('ascensor'),
    ('quincho'),
    ('laundry'),
    ('internet'),
    ('wi-fi'),
    ('horno'),
    ('microondas'),
    ('calefaccion'),
    ('sauna');



SET @propertyId = NULL;


-- Here I perform an INSERT of 42 different properties
INSERT INTO properties (owner_id, antiquity, built_area, country, description, maintenance_fees, price, property_type, province, number_of_rooms, status, street_name, street_number, title, total_area, years_of_antiquity)
VALUES (@userId, 'BRAND_NEW', 120.50, 'Argentina', 'Moderno departamento de 2 ambientes', 1500.50, 100000.00, 'APARTMENT', 'Buenos Aires', 2, 'AVAILABLE', 'Av. Libertador', '500', 'Departamento moderno en excelente ubicación', 130.00, 0);

SET @propertyId = LAST_INSERT_ID();

INSERT INTO property_room (property_id, room_id, quantity)
VALUES
    (@propertyId, (SELECT id FROM room WHERE name = 'Dormitorio'), 1),
    (@propertyId, (SELECT id FROM room WHERE name = 'Baño'), 1);

INSERT INTO properties (owner_id, antiquity, built_area, country, description, maintenance_fees, price, property_type, province, number_of_rooms, status, street_name, street_number, title, total_area, years_of_antiquity)
VALUES (@userId, 'UNDER_CONSTRUCTION', 200.00, 'Argentina', 'Casa en construcción con amplio jardín', 0.00, 250000.00, 'HOUSE', 'Córdoba', 3, 'MAINTENANCE', 'Calle Falsa', '123', 'Casa con potencial en desarrollo', 350.00, 1);

SET @propertyId = LAST_INSERT_ID();

INSERT INTO property_room (property_id, room_id, quantity)
VALUES
    (@propertyId, (SELECT id FROM room WHERE name = 'Dormitorio'), 2),
    (@propertyId, (SELECT id FROM room WHERE name = 'Baño'), 1),
    (@propertyId, (SELECT id FROM room WHERE name = 'Jardín'), 1);


INSERT INTO properties (owner_id, antiquity, built_area, country, description, maintenance_fees, price, property_type, province, number_of_rooms, status, street_name, street_number, title, total_area, years_of_antiquity)
VALUES (@userId, 'YEARS_OF_ANTIQUITY', 450.00, 'Argentina', 'Quinta de lujo en zona exclusiva', 5000.00, 1500000.00, 'VACATION_HOME', 'Mendoza', 5, 'AVAILABLE', 'Los Álamos', '25', 'Quinta vacacional de lujo con piscina', 800.00, 20);

SET @propertyId = LAST_INSERT_ID();

INSERT INTO property_room (property_id, room_id, quantity)
VALUES
    (@propertyId, (SELECT id FROM room WHERE name = 'Dormitorio'), 4),
    (@propertyId, (SELECT id FROM room WHERE name = 'Baño'), 3),
    (@propertyId, (SELECT id FROM room WHERE name = 'Cocina'), 1),
    (@propertyId, (SELECT id FROM room WHERE name = 'Sala de estar'), 1),
    (@propertyId, (SELECT id FROM room WHERE name = 'Jardín'), 1);



INSERT INTO properties (owner_id, antiquity, built_area, country, description, maintenance_fees, price, property_type, province, number_of_rooms, status, street_name, street_number, title, total_area, years_of_antiquity)
VALUES (@userId, 'BRAND_NEW', 80.75, 'Chile', 'Moderna oficina en pleno centro', 300.00, 75000.00, 'COMMERCIAL_OFFICE', 'Santiago', 1, 'AVAILABLE', 'Calle Ahumada', '900', 'Oficina moderna lista para ser utilizada', 85.00, 0);

SET @propertyId = LAST_INSERT_ID();

INSERT INTO property_room (property_id, room_id, quantity)
VALUES
    (@propertyId, (SELECT id FROM room WHERE name = 'Oficina'), 1);

INSERT INTO properties (owner_id, antiquity, built_area, country, description, maintenance_fees, price, property_type, province, number_of_rooms, status, street_name, street_number, title, total_area, years_of_antiquity)
VALUES (@userId, 'YEARS_OF_ANTIQUITY', 300.00, 'Argentina', 'Edificio antiguo de 3 pisos con patio', 10000.00, 600000.00, 'BUILDING', 'Rosario', 10, 'RENTED', 'San Martín', '45', 'Edificio histórico con 10 habitaciones', 600.00, 50);

SET @propertyId = LAST_INSERT_ID();

INSERT INTO property_room (property_id, room_id, quantity)
VALUES
    (@propertyId, (SELECT id FROM room WHERE name = 'Dormitorio'), 6),
    (@propertyId, (SELECT id FROM room WHERE name = 'Baño'), 2),
    (@propertyId, (SELECT id FROM room WHERE name = 'Cocina'), 1),
    (@propertyId, (SELECT id FROM room WHERE name = 'Patio'), 1);

INSERT INTO properties (owner_id, antiquity, built_area, country, description, maintenance_fees, price, property_type, province, number_of_rooms, status, street_name, street_number, title, total_area, years_of_antiquity)
VALUES (@userId, 'UNDER_CONSTRUCTION', 500.00, 'Argentina', 'Galpón amplio en construcción', 0.00, 350000.00, 'WAREHOUSE', 'La Plata', 1, 'MAINTENANCE', 'Calle 10', '444', 'Galpón ideal para logística', 700.00, 1);

SET @propertyId = LAST_INSERT_ID();

INSERT INTO property_room (property_id, room_id, quantity)
VALUES
    (@propertyId, (SELECT id FROM room WHERE name = 'Garaje'), 1);


INSERT INTO properties (owner_id, antiquity, built_area, country, description, maintenance_fees, price, property_type, province, number_of_rooms, status, street_name, street_number, title, total_area, years_of_antiquity)
VALUES (@userId, 'YEARS_OF_ANTIQUITY', 120.00, 'Brasil', 'Casa con vista al mar', 200.00, 200000.00, 'HOUSE', 'Río de Janeiro', 3, 'AVAILABLE', 'Praia Grande', '85', 'Casa frente al mar con terraza', 150.00, 10);

SET @propertyId = LAST_INSERT_ID();

INSERT INTO property_room (property_id, room_id, quantity)
VALUES
    (@propertyId, (SELECT id FROM room WHERE name = 'Dormitorio'), 2),
    (@propertyId, (SELECT id FROM room WHERE name = 'Baño'), 1),
    (@propertyId, (SELECT id FROM room WHERE name = 'Terraza'), 1);

INSERT INTO properties (owner_id, antiquity, built_area, country, description, maintenance_fees, price, property_type, province, number_of_rooms, status, street_name, street_number, title, total_area, years_of_antiquity)
VALUES (@userId, 'BRAND_NEW', 75.00, 'Uruguay', 'Apartamento nuevo en Pocitos', 1000.00, 125000.00, 'APARTMENT', 'Montevideo', 2, 'AVAILABLE', 'Rambla', '1250', 'Apartamento con vista al río', 80.00, 0);

SET @propertyId = LAST_INSERT_ID();

INSERT INTO property_room (property_id, room_id, quantity)
VALUES
    (@propertyId, (SELECT id FROM room WHERE name = 'Dormitorio'), 1),
    (@propertyId, (SELECT id FROM room WHERE name = 'Cocina'), 1);

INSERT INTO properties (owner_id, antiquity, built_area, country, description, maintenance_fees, price, property_type, province, number_of_rooms, status, street_name, street_number, title, total_area, years_of_antiquity)
VALUES (@userId, 'YEARS_OF_ANTIQUITY', 60.00, 'Argentina', 'Oficina en barrio financiero', 500.00, 50000.00, 'COMMERCIAL_OFFICE', 'CABA', 1, 'AVAILABLE', 'Reconquista', '150', 'Oficina en excelente ubicación céntrica', 65.00, 15);

SET @propertyId = LAST_INSERT_ID();

INSERT INTO property_room (property_id, room_id, quantity)
VALUES
    (@propertyId, (SELECT id FROM room WHERE name = 'Oficina'), 1);


INSERT INTO properties (owner_id, antiquity, built_area, country, description, maintenance_fees, price, property_type, province, number_of_rooms, status, street_name, street_number, title, total_area, years_of_antiquity)
VALUES (@userId, 'UNDER_CONSTRUCTION', 100.00, 'Argentina', 'PH en construcción en zona residencial', 0.00, 180000.00, 'PH', 'Mar del Plata', 4, 'MAINTENANCE', 'Independencia', '3500', 'PH amplio y luminoso en desarrollo', 120.00, 1);

SET @propertyId = LAST_INSERT_ID();

INSERT INTO property_room (property_id, room_id, quantity)
VALUES
    (@propertyId, (SELECT id FROM room WHERE name = 'Dormitorio'), 2),
    (@propertyId, (SELECT id FROM room WHERE name = 'Baño'), 1),
    (@propertyId, (SELECT id FROM room WHERE name = 'Cocina'), 1);

INSERT INTO properties (owner_id, antiquity, built_area, country, description, maintenance_fees, price, property_type, province, number_of_rooms, status, street_name, street_number, title, total_area, years_of_antiquity)
VALUES (@userId, 'YEARS_OF_ANTIQUITY', 400.00, 'Argentina', 'Terreno con galpón en área industrial', 0.00, 700000.00, 'LAND', 'Tucumán', 0, 'UNAVAILABLE', 'Ruta 9', 'km 20', 'Terreno ideal para industria', 500.00, 30);

SET @propertyId = LAST_INSERT_ID();

-- No se inserta en property_room ya que el valor de number_of_rooms es 0

INSERT INTO properties (owner_id, antiquity, built_area, country, description, maintenance_fees, price, property_type, province, number_of_rooms, status, street_name, street_number, title, total_area, years_of_antiquity)
VALUES (@userId, 'BRAND_NEW', 200.00, 'Chile', 'Local comercial a estrenar', 2000.00, 90000.00, 'COMMERCIAL_PREMISES', 'Valparaíso', 1, 'AVAILABLE', 'Calle Comercio', '100', 'Local nuevo con gran afluencia de público', 210.00, 0);

SET @propertyId = LAST_INSERT_ID();

INSERT INTO property_room (property_id, room_id, quantity)
VALUES
    (@propertyId, (SELECT id FROM room WHERE name = 'Comedor'), 1);



COMMIT;
```
