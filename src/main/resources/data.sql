DROP TABLE IF EXISTS person;

create table person (person_id bigint generated by default as identity, age integer not null, first_name varchar(255), last_name varchar(255), primary key (person_id));

insert into person (person_id, age, first_name, last_name) values (1,23,'edik','mutagarov');