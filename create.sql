CREATE DATABASE my_doctors;
\c my_doctors;

CREATE TABLE doctors (
id serial PRIMARY KEY,
firstName VARCHAR,
lastName VARCHAR,
image VARCHAR,
specialization VARCHAR,
hospital VARCHAR,
experience VARCHAR,
phone int,
rating DOUBLE PRECISION,
about VARCHAR
);

CREATE DATABASE my_doctors_test WITH TEMPLATE my_doctors;