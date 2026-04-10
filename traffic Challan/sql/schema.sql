CREATE DATABASE traffic_db;

USE traffic_db;

CREATE TABLE challans (
    challan_id INT PRIMARY KEY AUTO_INCREMENT,
    vehicle_no VARCHAR(20),
    violation VARCHAR(100),
    fine_amount DECIMAL(8,2),
    issued_on DATETIME DEFAULT NOW(),
    paid BOOLEAN DEFAULT FALSE
);