INSERT INTO category (id, category_name) VALUES (1, 'Tablas');
INSERT INTO category (id, category_name) VALUES (2, 'Ejes');
INSERT INTO category (id, category_name) VALUES (3, 'Ruedas');
INSERT INTO category (id, category_name) VALUES (4, 'Rodamientos');
INSERT INTO category (id, category_name) VALUES (5, 'Tornillos');
INSERT INTO category (id, category_name) VALUES (6, 'Lijas');
INSERT INTO category (id, category_name) VALUES (7, 'SkateBoards Completos');
INSERT INTO category (id, category_name) VALUES (8, 'Cruisers');
INSERT INTO category (id, category_name) VALUES (9, 'Longboards');


INSERT INTO product (id, price, name, description, image, stock, visible, category_id)
VALUES (1, 59.99, 'Tabla básica', 'Tabla de skate de iniciación', 'tabla1.jpg', 10, true, 1);

INSERT INTO product (id, price, name, description, image, stock, visible, category_id)
VALUES (2, 89.99, 'Ejes Pro', 'Ejes profesionales de aluminio', 'ejes1.jpg', 5, true, 2);

INSERT INTO product (id, price, name, description, image, stock, visible, category_id)
VALUES (3, 29.99, 'Ruedas suaves', 'Ruedas para mayor agarre', 'ruedas1.jpg', 20, true, 3);

INSERT INTO product (id, price, name, description, image, stock, visible, category_id)
VALUES (4, 24.99, 'Rodamientos ABEC-9', 'Rodamientos de alta precisión', 'rodamientos1.jpg', 15, true, 4);

INSERT INTO product (id, price, name, description, image, stock, visible, category_id)
VALUES (5, 4.99, 'Juego de tornillos', 'Tornillos resistentes para montaje', 'tornillos1.jpg', 50, true, 5);

INSERT INTO product (id, price, name, description, image, stock, visible, category_id)
VALUES (6, 7.99, 'Lija negra', 'Lija clásica para tabla', 'lija1.jpg', 30, true, 6);

INSERT INTO product (id, price, name, description, image, stock, visible, category_id)
VALUES (7, 139.99, 'Skate completo principiantes', 'Incluye todos los componentes', 'completo1.jpg', 8, true, 7);

INSERT INTO product (id, price, name, description, image, stock, visible, category_id)
VALUES (8, 149.99, 'Cruiser madera natural', 'Ideal para paseos urbanos', 'cruiser1.jpg', 6, true, 8);

INSERT INTO product (id, price, name, description, image, stock, visible, category_id)
VALUES (9, 179.99, 'Longboard downhill', 'Estable para altas velocidades', 'longboard1.jpg', 4, true, 9);