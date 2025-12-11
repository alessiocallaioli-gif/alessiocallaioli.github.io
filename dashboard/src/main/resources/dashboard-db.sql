CREATE DATABASE dashboard_db;

USE dashboard_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);

INSERT INTO users(username, password) VALUES('admin', 'admin123');