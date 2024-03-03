CREATE DATABASE IF NOT EXISTS db_laundry_shop;

USE db_laundry_shop;

CREATE TABLE tbl_addOns (
    a_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    a_name VARCHAR(25) NOT NULL,
    a_price INT NOT NULL
);

INSERT INTO tbl_addOns (a_name, a_price)
VALUES
    ("Pack 1", 100),
    ("Pack 2", 180),
    ("Pack 3", 250),
    ("Pack 4", 300);

CREATE TABLE tbl_services (
    s_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    s_name VARCHAR(25) NOT NULL,
    s_price INT NOT NULL
);

INSERT INTO tbl_services (s_name, s_price)
VALUES
    ("Fresh Essentials", 350),
    ("Gentle Care", 450),
    ("Sparkle & Shine", 600),
    ("Luxury Bliss", 950),
    ("Royal Elegance", 1500);

CREATE TABLE tbl_users (
    u_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    u_username VARCHAR(25) UNIQUE NOT NULL,
    u_password VARCHAR(100) NOT NULL,
    u_role ENUM('customer', 'admin') NOT NULL
);

CREATE TABLE tbl_customers (
    c_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    u_id INT NOT NULL,
    c_name VARCHAR(100) NOT NULL,
    c_contact VARCHAR(11) NOT NULL,
    c_address VARCHAR(250) NOT NULL,
    FOREIGN KEY (u_id) REFERENCES tbl_users(u_id)
);

CREATE TABLE tbl_transactions (
    t_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    c_id INT NOT NULL,
    s_id INT NOT NULL,
    a_id INT,
    t_kilo INT,
    t_total INT,
    t_note VARCHAR(350),
    t_deliveryMethod ENUM('delivery', 'pickup') DEFAULT 'pickup',
    t_dropOffDate DATE NOT NULL,
    t_submittedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    t_completedDate DATE,
    t_transacStatus ENUM('pending', 'approved', 'request cancel', 'cancelled') DEFAULT 'pending',
    t_paymentStatus ENUM('pending', 'paid') DEFAULT 'pending',
    FOREIGN KEY (c_id) REFERENCES tbl_customers(c_id),
    FOREIGN KEY (s_id) REFERENCES tbl_services(s_id),
    FOREIGN KEY (a_id) REFERENCES tbl_addOns(a_id)
);
