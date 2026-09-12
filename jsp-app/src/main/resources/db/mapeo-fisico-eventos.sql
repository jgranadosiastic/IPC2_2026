
create schema eventsdb;
use eventsdb;
create table evento (
    codigo varchar(50) primary key,
    nombre varchar(250) not null,
    tipo ENUM('CONGRESO', 'CHARLA', 'TALLER', 'DEBATE') not null,
    limite int not null
);