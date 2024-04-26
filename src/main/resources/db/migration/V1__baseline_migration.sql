CREATE TABLE courses
(
    name VARCHAR(255) NULL,
    id   BINARY(16)   NULL
);

ALTER TABLE courses
    ADD PRIMARY KEY (id);