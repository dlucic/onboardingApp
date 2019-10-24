DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS forms;
DROP TABLE IF EXISTS form;
DROP TABLE IF EXISTS processes;
DROP TABLE IF EXISTS process;
DROP TABLE IF EXISTS process_form;
DROP TABLE IF EXISTS form_field;
DROP SEQUENCE IF EXISTS form_seq;
DROP SEQUENCE IF EXISTS process_seq;

CREATE TABLE user (
    id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(100),
    );

create sequence form_seq increment by 1;
create sequence process_seq increment by 1;

CREATE TABLE form(
    id INTEGER IDENTITY PRIMARY KEY,
    longText BOOLEAN,
    shortText BOOLEAN,
    date BOOLEAN,
    singleChoice BOOLEAN,
    multipleChoice BOOLEAN,
    number BOOLEAN,
    yesNo BOOLEAN,
    name VARCHAR(50)
);

CREATE TABLE process (
    id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(50),
    user_id INTEGER
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