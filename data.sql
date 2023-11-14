
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
    Sueldo_a_pagar NUMBER(6.2)
);

CREATE TABLE EMPLEADOS(
    Id NUMBER(3) NOT NULL PRIMARY KEY,
    Id_jefe NUMBER(3) NOT NULL,
    Nombre VARCHAR2(20) NOT NULL,
    Sueldo NUMBER(6.2),
    Fecha_incorp DATE
);

ALTER TABLE empleados
ADD CONSTRAINT fk_empleados_jefe
    FOREIGN KEY (Id_jefe)
    REFERENCES JEFES(Id)
    ON DELETE CASCADE;