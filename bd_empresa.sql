DROP DATABASE IF EXISTS EMPRESA;

-- 1. CREAR LA BASE DE DATOS

CREATE DATABASE EMPRESA;

-- 2. SELECCIONARA LA BASE DE DATOS A USAR

USE EMPRESA;

-- 3. CREAR LA TABLA

CREATE TABLE empleados (
    id             INT PRIMARY KEY,
    nombre         VARCHAR(50),
    apellido       VARCHAR(50),
    salario        DECIMAL(10, 2),
    fecha_contrato DATE,
    edad           INT
);

-- 4. INSERTAR REGISTROS

INSERT INTO empleados VALUES
(1, 'Juan', 'Pérez', 50000.50, '2022-01-15', 28),
(2, 'María', 'González', 60000.75, '2021-03-10', 35),
(3, 'Carlos', 'Ramírez', 75000.00, '2022-05-20', 42),
(4, 'Laura', 'Díaz', 48000.25, '2021-08-05', 23),
(5, 'Pedro', 'Fernández', 55000.80, '2022-02-28', 29);

INSERT INTO empleados(id,nombre,apellido,salario,fecha_contrato,edad)
VALUES (6, 'Arturo', 'Roncal', 50000.50, '2022-02-28', 35);

CREATE TABLE ventas (
    venta_id INT PRIMARY KEY,
    empleado_id INT,
    ciudad VARCHAR(50),
    producto_id INT,
    cantidad INT
);

INSERT INTO ventas VALUES
(1, 1, 'Ciudad A', 101, 5),
(2, 1, 'Ciudad B', 102, 8),
(3, 2, 'Ciudad A', 101, 3),
(4, 2, 'Ciudad B', 103, 6),
(5, 3, 'Ciudad A', 102, 4),
(6, 3, 'Ciudad B', 103, 7),
(7, 1, 'Ciudad A', 101, 6),
(8, 2, 'Ciudad B', 102, 5),
(9, 3, 'Ciudad A', 103, 9);

-- 5. MOSTRAR TODOS LOS REGISTROS

SELECT * FROM empleados;

