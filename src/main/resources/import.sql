
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) values ('miguel','$2a$10$2ZbESYHsnMm61kNys0nFqeyVvphRdgJQWHF18F6PUpFSweKfLNHU2',1,'Miguel Angel','Chinchay','miguel@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) values ('admin','$2a$10$dtB6css6tfT4BlDK52YTA.htfqdL68kDBO2rl6Y5akxJp28krm6r.',1,'Administrador', 'ApeAdmin','admin@gmail.com');
INSERT INTO roles (nombre) VALUES ('ROLE_USER'), ('ROLE_ADMIN');
INSERT INTO usuarios_roles (usuario_id, roles_id) VALUES (1,1), (2,2), (2,1);
INSERT INTO db_proy_senior.regiones(nombre) values ('Sudamérica'),('Centroamérica'),('Norteamérica'),('Europa'),('Asia'),('Africa'),('Oceanía'),('Antártida');