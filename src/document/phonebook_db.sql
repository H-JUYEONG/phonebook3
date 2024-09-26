use mysql;

create user 'phonebook'@'%' identified by 'phonebook';

create database phonebook_db
default character set utf8mb4
collate utf8mb4_general_ci
default encryption='n'
;

grant all privileges on phonebook_db.* to 'phonebook'@'%';
 
flush privileges;

select host, user from user;
DROP USER 'phonebook'@'%';