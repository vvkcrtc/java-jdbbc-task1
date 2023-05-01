INSERT INTO netology.Customers (name, surname, age, phone_number)
VALUES
    ('fedor', '111', 22, '+9123456789'),
    ('alexey', '222', 29, '+9123456791'),
    ('sergey', '333', 34, '+9123456792'),
    ('nikolay', '444', 25, '+9123456793'),
    ('mikhail', '555', 28, '+9123456794'),
    ('pavel', '666', 32, '+9123456795'),
    ('alexandr', '777', 38, '+9123456796');

INSERT INTO netology.Orders (date, customer_id, product_name, amount)
VALUES
    ('2023-01-12', (SELECT id FROM netology.Customers WHERE name='alexey'),'Smartphone Samsung', 22000),
    ('2023-02-02', (SELECT id FROM netology.Customers WHERE name='sergey'),'Game Keyboard', 2000),
    ('2023-02-05', (SELECT id FROM netology.Customers WHERE name='nikolay'),'Monitor LG', 15000),
    ('2023-02-07', (SELECT id FROM netology.Customers WHERE name='mikhail'),'Smart clock', 18000);