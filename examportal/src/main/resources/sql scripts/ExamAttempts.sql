
use examportal;

create table ExamAttempts(
attemptId int,
examCode varchar(10),
userId int,
questionId int,
answer varchar(1),
marks int,
response varchar(1),
responseStatus varchar(20),
isCorrect boolean,
attemptDate date,
score int,
foreign key(examcode) references ExamDetails(examCode) ON DELETE CASCADE,
foreign key(userId) references User(userId) ON DELETE CASCADE,
foreign key(questionId) references QuestionPool(questionId) ON DELETE CASCADE
);

select * from examAttempts;

insert into examAttempts(attemptId, examCode, userId, questionId, answer, response, responseStatus, isCorrect, attemptDate)
values( 1 , 'JVL1', 6, 49, 'A', 'A', 'answered', true, curdate() );

drop table examattempts;