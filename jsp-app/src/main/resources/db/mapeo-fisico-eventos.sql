
create schema eventsdb;
use eventsdb;
create table evento (
    codigo varchar(50) primary key,
    nombre varchar(250) not null,
    tipo ENUM('CONGRESO', 'CHARLA', 'TALLER', 'DEBATE') not null,
    limite int not null,
    fecha_inicio DATE NOT NULL,
    precio DECIMAL(10, 2) NOT NULL DEFAULT 0.00
);