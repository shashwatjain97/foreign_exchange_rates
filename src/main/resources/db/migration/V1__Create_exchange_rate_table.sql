CREATE TABLE exchange_rate (
    date DATE PRIMARY KEY,
    source VARCHAR(3),
    target VARCHAR(3),
    rate DOUBLE PRECISION
);