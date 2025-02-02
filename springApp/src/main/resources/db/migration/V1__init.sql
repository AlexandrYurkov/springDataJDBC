CREATE TABLE users (
    id bigserial primary key,
    name varchar(255),
    age varchar(255)
);

INSERT INTO users (name, age) VALUES ('USER_1', '10-01-2000'),
                                     ('USER_2', '11-02-2001'),
                                     ('USER_3', '12-06-2024');