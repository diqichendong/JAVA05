
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
    Id NUMERIC(3) NOT NULL PRIMARY KEY,
    Nombre VARCHAR(20) NOT NULL,
    Usuario VARCHAR(20) NOT NULL,
    Password VARCHAR(20) NOT NULL,
    Imagen VARCHAR(40),
    Sueldo_a_pagar NUMERIC(6, 2)
);

CREATE TABLE EMPLEADOS(
    Id NUMERIC(3) NOT NULL PRIMARY KEY,
    Id_jefe NUMERIC(3) NOT NULL,
    Nombre VARCHAR(20) NOT NULL,
    Sueldo NUMERIC(6, 2),
    Fecha_incorp DATE
);

ALTER TABLE empleados
ADD CONSTRAINT fk_empleados_jefe
    FOREIGN KEY (Id_jefe)
    REFERENCES JEFES(Id)
    ON DELETE CASCADE;

INSERT INTO JEFES VALUES (1, 'Di Qi', 'diqi', 'diqi', 'default.jpg', 0);
INSERT INTO JEFES VALUES (2, 'Andrés', 'andres', 'andres', 'default.jpg', 0);

INSERT INTO EMPLEADOS VALUES (1, 1, 'Antonio', 3000, '1/10/2018');
INSERT INTO EMPLEADOS VALUES (2, 1, 'Beatriz', 2000, '2/20/2018');
INSERT INTO EMPLEADOS VALUES (3, 1, 'Carlos', 4000, '3/22/2018');
INSERT INTO EMPLEADOS VALUES (4, 2, 'Diego', 5000, '4/12/2018');
INSERT INTO EMPLEADOS VALUES (5, 2, 'Elena', 1500, '5/17/2018');
INSERT INTO EMPLEADOS VALUES (6, 2, 'Fernando', 2200, '6/26/2018');