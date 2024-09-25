create schema if not exists whatchdogdb;

create table if not exists report (
    id varchar not null,
    content varchar not null,
    fotourl varchar not null,
    fechacreacion date not null,
);