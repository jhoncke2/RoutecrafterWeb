-- Creación y selección de la base de datos para Route Crafter
CREATE DATABASE IF NOT EXISTS routecraftermoduledb;
USE routecraftermoduledb;

-- Tabla de Rutas utilizada por el módulo web y JDBC
CREATE TABLE IF NOT EXISTS routes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    city_id INT NOT NULL
);

-- (Opcional) Datos de prueba para verificar de inmediato en el navegador
INSERT INTO routes (name, description, city_id) VALUES 
('Ruta Norte - Centro', 'Recorrido logístico principal de distribución urbana', 1),
('Ruta Sur - Veredal', 'Conexión con zonas rurales y puntos de entrega', 1);