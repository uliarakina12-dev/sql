CREATE TABLE IF NOT EXISTS CUSTOMERS (
                                         id INTEGER PRIMARY KEY AUTOINCREMENT,
                                         name TEXT NOT NULL,
                                         surname TEXT NOT NULL,
                                         age INTEGER,
                                         phone_number TEXT
);

CREATE TABLE IF NOT EXISTS ORDERS (
                                      id INTEGER PRIMARY KEY AUTOINCREMENT,
                                      date TEXT NOT NULL,
                                      customer_id INTEGER NOT NULL,
                                      product_name TEXT NOT NULL,
                                      amount INTEGER,
                                      FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id)
    );