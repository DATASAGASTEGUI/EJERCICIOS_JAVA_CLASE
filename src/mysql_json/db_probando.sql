DROP DATABASE IF EXISTS DB_PROBANDO;

CREATE DATABASE DB_PROBANDO;

USE DB_PROBANDO;

CREATE TABLE Persona (
    id        INT PRIMARY KEY AUTO_INCREMENT,
    datojson  JSON
);

INSERT INTO Persona(datojson) VALUES ('{\"nombre\": \"Miguel\", \"edad\": 23, \"estatura\": 1.72, \"casado\": true}');
INSERT INTO Persona(datojson) VALUES ('{\"nombre\": \"Carlos\", \"edad\": 22, \"estatura\": 1.75, \"casado\": false}');
INSERT INTO Persona(datojson) VALUES ('{\"nombre\": \"María\", \"edad\": 25, \"estatura\": 1.65, \"casado\": false}');

-- CONSULTA

-- CUAL ES LA ESTATURA DE MARIA
SELECT datojson->'$.estatura'
FROM Persona
WHERE datojson->'$.nombre' = 'María';