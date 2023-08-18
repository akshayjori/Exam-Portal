use examportal;

create table userfeedback(
attemptId int UNIQUE,
feedback varchar(1000),
notified boolean default false
);