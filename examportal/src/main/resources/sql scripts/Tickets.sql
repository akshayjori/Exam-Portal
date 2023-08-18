use examportal;

create table Tickets(
ticketId int auto_increment primary key,
userId int not null,
ticketDate datetime default now(),
typeofissue varchar(50) not null, 
description varchar(1000) not null,
status varchar(50) default "NOT RESOLVED",
adminResponce varchar(2000) default "NO RESPONSE",
foreign key(userId) references User(userId) ON DELETE CASCADE
);

select * from Tickets;

drop table tickets;