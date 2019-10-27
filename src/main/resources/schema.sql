DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS forms;
DROP TABLE IF EXISTS form;
DROP TABLE IF EXISTS processes;
DROP TABLE IF EXISTS field;
DROP TABLE IF EXISTS process;
DROP TABLE IF EXISTS process_form;
DROP TABLE IF EXISTS form_field;
DROP TABLE IF EXISTS field_value;
DROP SEQUENCE IF EXISTS form_seq;
DROP SEQUENCE IF EXISTS process_seq;
DROP SEQUENCE IF EXISTS field_seq;

create sequence form_seq increment by 1;
create sequence process_seq increment by 1;
create sequence field_seq increment by 1;

CREATE TABLE user (
    id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(100),
    );

CREATE TABLE form(
    id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE field (
    id INTEGER IDENTITY PRIMARY KEY,
    label VARCHAR(50),
    type VARCHAR(50)
);

CREATE TABLE field_value (
    id INTEGER IDENTITY PRIMARY KEY,
    value VARCHAR(50),
    field_id integer,
    foreign key (field_id) references field(id)
);


CREATE TABLE process (
    id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(50),
    user_id integer,
    foreign key (user_id) references user(id)
);

CREATE TABLE process_form (
    process INTEGER,
    form INTEGER,
    PRIMARY KEY (process, form)
);

CREATE TABLE form_field (
    form INTEGER,
    field INTEGER,
    PRIMARY KEY (form, field)
);