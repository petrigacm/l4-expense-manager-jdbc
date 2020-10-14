CREATE SCHEMA expense AUTHORIZATION sa;

create table expense (id bigint not null, amount double, description varchar(255), primary key (id));