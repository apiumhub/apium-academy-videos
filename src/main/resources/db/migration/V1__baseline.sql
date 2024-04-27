CREATE TABLE courses
(
    name VARCHAR(255) NULL,
    id   BINARY(16)   NULL
);

ALTER TABLE courses
    ADD PRIMARY KEY (id);

CREATE TABLE students
(
    name VARCHAR(255) NULL,
    id   BINARY(16)   NULL
);

ALTER TABLE students
    ADD PRIMARY KEY (id);