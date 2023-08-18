use examportal;

create table ExamDetails(
examcode varchar(10) not null primary key,
examName varchar(100) not null,
subject varchar(20) not null,
competency varchar(20) not null
);

select * from examdetails;

insert into examDetails
values('JVL1', 'Java Leval 1', 'Java', 'Low');
insert into examDetails
values('JVL2', 'Java Leval 2', 'Java', 'Medium');
insert into examDetails
values('JVL3', 'Java Leval 3', 'Java', 'Hard');

insert into examDetails
values('CPPL1', 'C++ Leval 1', 'C++', 'Low');
insert into examDetails
values('CPPL2', 'C++ Leval 2', 'C++', 'Medium');
insert into examDetails
values('CPPL3', 'C++ Leval 3', 'C++', 'Hard');

insert into examDetails
values('SQLL1', 'SQL Leval 1', 'Java', 'Low');
insert into examDetails
values('SQLL3', 'SQL Leval 3', 'Java', 'Hard');