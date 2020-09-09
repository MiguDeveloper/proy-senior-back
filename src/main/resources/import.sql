
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) values ('miguel','$2a$10$2ZbESYHsnMm61kNys0nFqeyVvphRdgJQWHF18F6PUpFSweKfLNHU2',1,'Miguel Angel','Chinchay','miguel@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) values ('admin','$2a$10$dtB6css6tfT4BlDK52YTA.htfqdL68kDBO2rl6Y5akxJp28krm6r.',1,'Administrador', 'ApeAdmin','admin@gmail.com');
INSERT INTO roles (nombre) VALUES ('ROLE_USER'), ('ROLE_ADMIN');
INSERT INTO usuarios_roles (usuario_id, roles_id) VALUES (1,1), (2,2), (2,1);
INSERT INTO db_proy_senior.regiones(nombre) values ('Sudamérica'),('Centroamérica'),('Norteamérica'),('Europa'),('Asia'),('Africa'),('Oceanía'),('Antártida');

INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(1, 'Andres', 'Guzmán', 'profesor@bolsadeideas.com', NOW());

INSERT INTO productos(nombre, precio, create_at) VALUES ('Panasonic Pantalla LED', 2156.23, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Sony camara digital', 156.23, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Apple Ipod Shuffle', 56.23, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Sony Notebook Z110', 223.23, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Hewlett Packard multifuncional', 876.23, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Bianchi bicicleta Aro 26', 517.23, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES ('Mica comoda 5 cajones', 983.23, NOW());

INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES ('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (1, 1, 1);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (2, 1, 4);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (1, 1, 5);
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (1, 1, 7);

INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES ('Factura bicicleta', 'Alguna nota importante', 1, NOW());
INSERT INTO facturas_items(cantidad, factura_id, producto_id) VALUES (3, 2, 6);