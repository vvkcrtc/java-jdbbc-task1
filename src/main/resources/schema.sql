create schema if not exists netology;

CREATE TABLE IF NOT EXISTS netology.Customers
(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(120),
    surname VARCHAR(120),
    age INTEGER,
    phone_number VARCHAR(40)
);
CREATE TABLE IF NOT EXISTS netology.Orders
(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    date VARCHAR(20) NOT NULL,
    customer_id INTEGER NOT NULL,
    product_name TEXT,
    amount INTEGER
);
