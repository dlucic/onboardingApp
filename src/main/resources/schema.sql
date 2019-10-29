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
DROP TABLE IF EXISTS formdata;
DROP SEQUENCE IF EXISTS form_seq;
DROP SEQUENCE IF EXISTS process_seq;
DROP SEQUENCE IF EXISTS field_seq;

create sequence form_seq increment by 1;
create sequence process_seq increment by 1;
create sequence field_seq increment by 1;


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
    foreign key (field_id) references field(id) on delete cascade
);


CREATE TABLE process (
    id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(50),
    user_id integer,
    foreign key (user_id) references user(id) on delete cascade
);

CREATE TABLE process_form (
    primary key (process, form),
    process INTEGER,
    form INTEGER,
    foreign key (process) references process(id) on delete cascade,
    foreign key (form) references form(id) on delete cascade,
);

CREATE TABLE form_field (
    primary key (form, field),
    form INTEGER,
    field INTEGER,
    foreign key (field) references field(id) on delete cascade,
    foreign key (form) references form(id) on delete cascade,
);


CREATE TABLE formdata (
    id INTEGER IDENTITY PRIMARY KEY,
    form_id integer,
    number_value integer,
    long_text VARCHAR(500),
    short_text VARCHAR(50),
    single_choice VARCHAR(50),
    multiple_choice VARCHAR(50),
    yes_no VARCHAR(20),
    date_value DATE,
    foreign key (form_id) references form(id)
);
