INSERT OR IGNORE INTO CUSTOMERS (name, surname, age, phone_number)
VALUES ('Alexey', 'Petrov', 28, '+79991234567'),
       ('alexey', 'Ivanov', 35, '+79997654321');

INSERT OR IGNORE INTO ORDERS (date, customer_id, product_name, amount)
VALUES ('2026-02-20', 1, 'MacBook Pro', 1),
       ('2026-02-19', 2, 'iPhone 16', 2);