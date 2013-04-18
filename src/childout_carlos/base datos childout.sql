DROP DATABASE IF EXISTS childout;
CREATE DATABASE childout;
USE childout;
CREATE TABLE alumno (
    id_alumno  int unsigned auto_increment,
    nombre VARCHAR(40) NOT NULL,
	grupo VARCHAR(10) NOT NULL,
    constraint pk_alumno primary key (id_alumno)
);

CREATE TABLE relacion (
    id_relacion  int unsigned auto_increment,
    id_autorizado  int unsigned,
	id_alumno  int unsigned,
    constraint pk_relacion primary key (id_relacion)
);

CREATE TABLE autorizado (
    id_autorizado  int unsigned auto_increment,
    nombre VARCHAR(30) NOT NULL,
    apellidos VARCHAR(60) NOT NULL,	
    dni char(9) not null unique,
    email varchar(30) unique,
    telefono char(9) not null,
	foto blob null,
	firma blob null,
	parentesco varchar(20),
	huella blob null,
        denegado boolean,
    constraint pk_autorizado primary key (id_autorizado)
);

CREATE TABLE salida (
    id_salida  int unsigned auto_increment,
	fecha date,
	hora time,
    id_alumno  int unsigned,
    id_autorizado  int unsigned,
	motivo varchar(100),
	observacion text,
	firma blob,
	foto blob,
    constraint pk_salida primary key (id_salida)
);

INSERT INTO alumno VALUES
(1,'Alberto','1ESO-A'),
(2,'Diego','1PRI-B'),
(3,'José','3PRIM-A');

INSERT INTO autorizado VALUES
(1,'Francisco','Lopez','11111111a','francisco@corre.es',956000000,'','','Padre',''),
(2,'Santiago','García','11111112b','santiago@corre.es',956000000,'','','Abuelo',''),
(3,'Julian', 'Suarez','11111113c','julian@corre.es',956000000,'','','Vecino','');

INSERT INTO relacion VALUES
(1,1,1),
(2,2,2),
(3,3,3);

INSERT INTO salida VALUES
(1,'2012-12-05','01:00:00',1,1,'Tiene fiebre.','','',''),
(2,'2013-1-10','12:00:00',2,2,'Cambio de ropa.','','',''),
(3,'2013-3-25','10:00:00',3,3,'Dentista.','','','');