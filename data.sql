
--JEFES
--int Id PRIMARY KEY
--String Usuario
--String Contraseña
--String Imagen
--double Sueldos empleados a pagar (Voluntario)

--EMPLEADOS
--int Id
--int Id_jefe
--String Nombre
--double Sueldo
--date/Greg Fecha incorporación

DROP TABLE JEFES CASCADE CONSTRAINT;
DROP TABLE EMPLEADOS CASCADE CONSTRAINT;

CREATE TABLE JEFES(
    Id NUMER(3) NOT NULL PRIMARY KEY
    Nombre VARCHAR2(20) NOT NULL,
    Usuario VARCHAR2(20) NOT NULL,
    Password VARCHAR2(20) NOT NULL,
    Imagen VARCHAR2(40),
    Sueldo_a_pagar NUMBER(6, 2)
);

CREATE TABLE EMPLEADOS(
    Id NUMBER(3) NOT NULL PRIMARY KEY,
    Id_jefe NUMBER(3) NOT NULL,
    Nombre VARCHAR2(20) NOT NULL,
    Sueldo NUMBER(6, 2),
    Fecha_incorp DATE
);

ALTER TABLE empleados
ADD CONSTRAINT fk_empleados_jefe
    FOREIGN KEY (Id_jefe)
    REFERENCES JEFES(Id)
    ON DELETE CASCADE;

INSERT INTO JEFES VALUES (1, 'Di Qi', 'diqi', 'diqi', 'default.png', 0);
INSERT INTO JEFES VALUES (2, 'Andrés', 'andres', 'andres', 'default.png', 0);

INSERT INTO EMPLEADOS VALUES (1, 1, 'Antonio', 3000, '20/1/2018');
INSERT INTO EMPLEADOS VALUES (2, 1, 'Beatriz', 2000, '23/2/2018');
INSERT INTO EMPLEADOS VALUES (3, 1, 'Carlos', 4000, '24/3/2018');
INSERT INTO EMPLEADOS VALUES (4, 2, 'Diego', 5000, '10/4/2018');
INSERT INTO EMPLEADOS VALUES (5, 2, 'Elena', 1500, '15/5/2018');
INSERT INTO EMPLEADOS VALUES (6, 2, 'Fernando', 2200, '12/6/2018');