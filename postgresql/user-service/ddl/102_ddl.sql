\c user_service

CREATE SCHEMA security
    AUTHORIZATION user_app_user;

--https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/jdbc.html

create table security.users(
    username varchar(50) not null primary key,
    password varchar(500) not null,
    enabled boolean not null
);

ALTER TABLE IF EXISTS security.users
    OWNER to user_app_user;


create table security.authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references security.users(username)
);

create unique index ix_auth_username on security.authorities (username,authority);

ALTER TABLE IF EXISTS security.authorities
    OWNER to user_app_user;