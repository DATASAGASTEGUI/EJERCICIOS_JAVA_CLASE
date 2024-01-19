--------------------------------------------------------------------------------
C:\ProgramData\MySQL\MySQL Server 8.3\
C:\Program Files\MySQL\MySQL Workbench 8.0 CE\
--------------------------------------------------------------------------------
Usuario: root
Clave  : 12345678
--------------------------------------------------------------------------------
SHOW DATABASES;
USE SAKILA;
SHOW TABLES;
SELECT * FROM ACTOR;
--------------------------------------------------------------------------------
SERVIDOR: MySQL
CLIENTE : LINEAS DE COMANDOS (MODO TEXTO)
          WORKBENCH          (MODO GRAFICO)
--------------------------------------------------------------------------------		  
- CREAR UNA BASE DE DATOS
CREATE SCHEMA test2;
- BORRAR UNA BASE DE DATOS
DROP DATABASE TEST2;
--------------------------------------------------------------------------------
- EJEMPLO

1. CREAR UNA BASE DE DATOS QUE LLAMAREMOS "UNIVERSIDAD"
2. CREAR UNA TABLA ALUMNO CON LOS SIGUIENTES CAMPOS: id_alumno,nombre,apellido,
                                                     fecha_nacimiento,estatura,
													 es_casado
3. INSERTAR 2 REGISTROS

CREATE TABLE `universidad`.`alumno` (
  `id_alumno` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apaterno` VARCHAR(45) NOT NULL,
  `amaterno` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `estatura` DOUBLE NOT NULL,
  `es_casado` TINYINT NOT NULL,
  PRIMARY KEY (`id_alumno`));
  
INSERT INTO `universidad`.`alumno` (`nombre`, `apaterno`, `amaterno`, `fecha_nacimiento`, `estatura`, `es_casado`) VALUES ('Luis', 'Ruiz', 'Roncal', '2000-01-01', '1.72', '0');
INSERT INTO `universidad`.`alumno` (`nombre`, `apaterno`, `amaterno`, `fecha_nacimiento`, `estatura`, `es_casado`) VALUES ('Carmen', 'Cuba', 'Ledezma', '1998-10-05', '1.65', '1');

DELETE FROM `universidad`.`alumno` WHERE (`id_alumno` = '3');
--------------------------------------------------------------------------------
MAVEN REPOSITORY
https://mvnrepository.com/

--------------------------------------------------------------------------------
jdbc:mysql://localhost:3306/universidad?zeroDateTimeBehavior=CONVERT_TO_NULL
jdbc:mysql://localhost:3306/universidad?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema
jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]
--------------------------------------------------------------------------------
JDBC = CONEXION BASE DATOS JAVA

--------------------------------------------------------------------------------
MYSQL (ORACLE)

MARIADB (CONTINUACION DEL PROYECTO MYSQL LIBRE)

--------------------------------------------------------------------------------
CRUD: CREATE    CREAR UNA TABLA, INSERTAR UN REGISTRO
      READ      SELECCIONAR REGISTROS
      UPDATE    MODIFICAR
      DELETE    ELIMINAR
--------------------------------------------------------------------------------
SQL                          CRUD (OPERACIONES BASICAS SOBRE UNA BASE DE DATOS)

SELECT      executeQuery     READ
INSERT      executeUpdate    CREATE
DELETE      executeUpdate    DELETE
UPDATE      executeUpdate    UPDATE

SHOW ---> SINTAXIS DEL SELECT
--------------------------------------------------------------------------------
- REINCIAR EL CONTADOR DE AUTO-INCREMENTA

ALTER TABLE ALUMNO AUTO_INCREMENT = 1;
--------------------------------------------------------------------------------
SELECT * FROM ALUMNO;

DELETE FROM ALUMNO WHERE id_alumno = 8;

ALTER TABLE ALUMNO AUTO_INCREMENT = 1;
SHOW TABLE STATUS LIKE 'ALUMNO';

INSERT INTO `universidad`.`alumno` (`nombre`, `apaterno`, `amaterno`, `fecha_nacimiento`, `estatura`, `es_casado`) VALUES ('Luis', 'Ruiz', 'Roncal', '2000-01-01', '1.72', '0');
INSERT INTO `universidad`.`alumno` (`nombre`, `apaterno`, `amaterno`, `fecha_nacimiento`, `estatura`, `es_casado`) VALUES ('Carmen', 'Cuba', 'Ledezma', '1998-10-05', '1.65', '1');

UPDATE ALUMNO SET apaterno = "Rodriguez", es_casado = 0 WHERE id_alumno = 3;
UPDATE ALUMNO SET apaterno = ?, es_casado = ? WHERE id_alumno = ?;


--------------------------------------------------------------------------------
- CERRAR PUERTO

NETSTAT -ANO | FIND "3306"
TASKKILL /F /PID 16012

"C:\Program Files\MySQL\MySQL Server 8.0\bin\mysqld.exe" --defaults-file="C:\ProgramData\MySQL\MySQL Server 8.0\my.ini" MySQL80
--------------------------------------------------------------------------------
CREATE TABLE Trabajador (
idTrabajador       VARCHAR(6)  NOT NULL PRIMARY KEY,
nombre             VARCHAR(20) NOT NULL,
apaterno           VARCHAR(30) NOT NULL,
tipo_trabajador    INT         NOT NULL,
parametros_sueldo  VARCHAR(15) NOT NULL
)
--------------------------------------------------------------------------------
CREATE TABLE Trabajador (
idTrabajador        VARCHAR(6)  NOT NULL PRIMARY KEY,
nombre             VARCHAR(20) NOT NULL,
apaterno           VARCHAR(30) NOT NULL,
tipo_trabajador    INT         NOT NULL,
parametros_sueldo  VARCHAR(15) NOT NULL
);

DROP TABLE TRABAJADOR;

SELECT * FROM TRABAJADOR;
-- MOSTRAR TODOS LOS TRABAJADORES DE TIPO 1
SELECT * FROM TRABAJADOR WHERE tipo_trabajador = 1;
-- MOSTRAR CUANTOS TRABAJADORES SON DE TIPO 1
SELECT COUNT(*) FROM TRABAJADOR WHERE tipo_trabajador = 1;
-- MOSTRAR QUE TIPOS DE TRABAJADOR EXISTE 
-- (TODOS LOS VALORES DISTINTOS DEL CAMPO TIPO_TRABAJADOR)
SELECT DISTINCT tipo_trabajador FROM Trabajador;
-- MOSTRAR TODOS LOS NOMBRES DISTINTOS
SELECT DISTINCT nombre FROM Trabajador;
SELECT COUNT(DISTINCT nombre) AS "CANTIDAD NOMBRES DISTINTOS" FROM Trabajador;
--------------------------------------------------------------------------------







