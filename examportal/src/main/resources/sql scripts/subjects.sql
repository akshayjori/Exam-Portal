create database if not exists examportal;

use examportal;

create table subjects(
subjectId int primary key auto_increment,
subjectName varchar(20) not null);

insert into subjects
values(1, 'Java');
insert into subjects
values(2, 'C++');
insert into subjects
values(3, 'SQL');