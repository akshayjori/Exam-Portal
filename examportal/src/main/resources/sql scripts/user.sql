
create database if not exists examportal;

use examportal;

create table user(
userid int primary key auto_increment,
firstname varchar(10) not null,
lastname varchar(10) not null,
dateOfBirth date not null,
gender varchar(10) not null,
contactNo varchar(10) not null,
email varchar(50) not null,
username varchar(50) not null unique,
password varchar(50) not null,
adminAccess boolean default false);

select * from user;

insert into user(firstname, lastname, dateofbirth, gender, contactNo, email, username, password, adminAccess) 
values("Akshay", "Jori", "1999-07-23", "Male", 8668698599, "aj@gmail.com", "akshayjori", "1234", true);

drop table user;