1. FUNCIONES SQL: COUNT, MIN, MAX, AVG, SUM

- MOSTRAR EL SALARIO PROMEDIO DE LOS EMPLEADOS

SELECT AVG(salario) FROM empleados;
SELECT AVG(salario) AS PROMEDIO_SUELDO FROM empleados;

+-----------------+
| PROMEDIO_SUELDO |
+-----------------+
|    57600.460000 |
+-----------------+

- MOSTRAR EL SUELDO MINIMO Y SUELDO MAXIMO DE LOS EMPLEADOS

SELECT MIN(salario) AS SALARIO_MIN, MAX(salario) AS SALARIO_MAXIMO FROM empleados;

+-------------+----------------+
| SALARIO_MIN | SALARIO_MAXIMO |
+-------------+----------------+
|    48000.25 |       75000.00 |
+-------------+----------------+

- MODIFICAR LA EDAD DEL ALUMNO CON ID 5, CAMBIAR SU EDAD A 28

UPDATE empleados
SET edad = 28
WHERE id = 5;
 
CONSULTAR EL CAMBIO
SELECT edad FROM empleados WHERE id = 5;

- MOSTRAR LOS GRUPOS DE EDADES EXISTEN

SELECT edad
FROM empleados
GROUP BY edad;

+------+
| edad |
+------+
|   28 |
|   35 |
|   42 |
|   23 |
+------+

- CUANTOS EMPLEADOS FORMAN CADA GRUPO DE EDAD

SELECT edad, COUNT(*)
FROM empleados
GROUP BY edad;

+------+----------+
| edad | COUNT(*) |
+------+----------+
|   28 |        2 |
|   35 |        1 |
|   42 |        1 |
|   23 |        1 |
+------+----------+

- INSERTAR UN REGISTRO EN LA TABLA EMPLEADOS CON LOS SIGUIENTES DATOS

(6, 'Arturo', 'Roncal', 50000.00, '2022-02-28', 35)

INSERT INTO empleados(id,nombre,apellido,salario,fecha_contrato,edad)
VALUES (6, 'Arturo', 'Roncal', 50000.00, '2022-02-28', 35);

- MOSTRAR CUANTOS EMPLEADOS EXISTEN POR CADA GRUPO DEL SALARIO

SELECT salario, COUNT(*)
FROM empleados
GROUP BY salario;

- MOSTRAR EL TOTAL A PAGAR POR CADA GRUPO DE SALARIO

SELECT salario, SUM(salario)
FROM empleados
GROUP BY salario;

- MOSTRAR QUE GRUPO DE EDAD TIENE MAS DE UN EMPLEADO.

SELECT edad, COUNT(*) 
FROM empleados
GROUP BY edad
HAVING COUNT(*) >= 2;

SELECT edad, COUNT(*) AS cantidad
FROM empleados
GROUP BY edad
HAVING cantidad >= 2;

- AGRUPAMIENTO CON MAS DE UN CAMPO

(1)

SELECT
    empleado_id,
    ciudad,
    producto_id,
    SUM(cantidad) AS total_vendido
FROM
    ventas
GROUP BY
    empleado_id, ciudad, producto_id
ORDER BY
    empleado_id, ciudad, producto_id;
	
(2)

SELECT empleado_id, ciudad, producto_id, SUM(cantidad)
FROM ventas
GROUP BY empleado_id, ciudad, producto_id
ORDER BY empleado_id, ciudad, producto_id;

- CANTIDAD DE UNIDADES VENDIDAS DE CADA GRUPO DE PRODUCTO

SELECT producto_id, SUM(cantidad)
FROM ventas
GROUP BY producto_id
HAVING SUM(cantidad) > 20; -- EL PRODUCTO QUE SUPERA LAS 20 UNIDADES VENDIDAS
	