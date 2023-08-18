create database if not exists examportal;

use examportal;

create table QuestionPool(
questionId int primary key auto_increment,
question varchar(1000) not null unique,
optionA varchar(200) not null,
optionB varchar(200) not null,
optionC varchar(200) not null,
optionD varchar(200) not null,
answer varchar(5) not null,
competency varchar(10) not null,
marks int default 1,
subject varchar(10)
);

truncate table questionpool;

drop table questionpool;


insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('Which is a reserved word in the Java programming language?', 'method', 'native', 'subclasses', 'array', 'B', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('Which is a valid keyword in java?', 'interface', 'string', 'Float', 'unsigned', 'A', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('Which one of these lists contains only Java programming language keywords?', 'class, if, void, long, Int, continue', 'goto, instanceof, native, finally, default, throws', 'try, virtual, throw, final, volatile, transient', 'byte, break, assert, switch, include', 'B', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('Which will legally declare, construct, and initialize an array?', 'int [] myList = {"1", "2", "3"};', 'int [] myList = (5, 8, 2);', 'int myList [] [] = {4,9,7,0};', 'int myList [] = {4, 3, 7};', 'D', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('Which is the valid declarations within an interface definition?', 'public double methoda();', 'public final double methoda();', 'static void methoda(double d1);', 'protected void methoda(double d1);', 'A', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('Which one of the following will declare an array and initialize it with five numbers?', 'Array a = new Array(5);', 'int [] a = {23,22,21,20,19};', 'int a [] = new int[5];', 'int [5] array;', 'B', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('Which one is a valid declaration of a boolean?', 'boolean b1 = 0;', "boolean b2 = 'false';", 'boolean b3 = false;', 'boolean b4 = Boolean.false();', 'C', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('Which is a valid declarations of a String?', 'String s1 = null;', "String s2 = 'null';", "String s3 = (String) 'abc';", "String s4 = (String) '\ufeed';", 'A', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('What is the numerical range of a char?', '-128 to 127', '-(215) to (215) - 1', '0 to 32767', '0 to 65535', 'D', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('You want subclasses in any package to have access to members of a superclass. Which is the most restrictive access that accomplishes this objective?', 'public', 'private', 'protected', 'transient', 'C', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('public class Test { } What is the prototype of the default constructor?', 'Test( )', 'Test(void)', 'public Test( )', 'public Test(void)', 'C', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('What is the most restrictive access modifier that will allow members of one class to have access to members of another class in the same package?', 'public', 'abstract', 'protected', 'default access', 'D', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('Which cause a compiler error?', 'int[ ] scores = {3, 5, 7};', 'int [ ][ ] scores = {2,7,6}, {9,3,45};', 'String cats[ ] = {"Fluffy", "Spot", "Zeus"};', 'boolean results[ ] = new boolean [] {true, false, true};', 'B', 'low', 1, 'Java');

insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject)
 values ('You want a class to have access to members of another class in the same package. Which is the most restrictive access that accomplishes this objective?', 'public', 'private', 'protected', 'default access', 'D', 'low', 1, 'Java');
 
 
 insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question1 of competency Medium and ans B?', 'option A', 'option B', 'option C', 'option D', 'B', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question2 of competency Medium and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question3 of competency Medium and ans D?', 'option A', 'option B', 'option C', 'option D', 'D', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question4 of competency Medium and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question5 of competency Medium and ans A?', 'option A', 'option B', 'option C', 'option D', 'A', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question6 of competency Medium and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question7 of competency Medium and ans B?', 'option A', 'option B', 'option C', 'option D', 'B', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question8 of competency Medium and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question9 of competency Medium and ans D?', 'option A', 'option B', 'option C', 'option D', 'D', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question10 of competency Medium and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question11 of competency Medium and ans B?', 'option A', 'option B', 'option C', 'option D', 'B', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question12 of competency Medium and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question13 of competency Medium and ans A?', 'option A', 'option B', 'option C', 'option D', 'A', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question14 of competency Medium and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Medium', 2, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question15 of competency Medium and ans D?', 'option A', 'option B', 'option C', 'option D', 'D', 'Medium', 2, 'Java');
 
 
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question1 of competency Hard and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question2 of competency Hard and ans A?', 'option A', 'option B', 'option C', 'option D', 'A', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question3 of competency Hard and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question4 of competency Hard and ans B?', 'option A', 'option B', 'option C', 'option D', 'B', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question5 of competency Hard and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question6 of competency Hard and ans A?', 'option A', 'option B', 'option C', 'option D', 'A', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question7 of competency Hard and ans B?', 'option A', 'option B', 'option C', 'option D', 'B', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question8 of competency Hard and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question9 of competency Hard and ans B?', 'option A', 'option B', 'option C', 'option D', 'B', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question10 of competency Hard and ans A?', 'option A', 'option B', 'option C', 'option D', 'A', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question11 of competency Hard and ans B?', 'option A', 'option B', 'option C', 'option D', 'B', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question12 of competency Hard and ans D?', 'option A', 'option B', 'option C', 'option D', 'D', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question13 of competency Hard and ans B?', 'option A', 'option B', 'option C', 'option D', 'B', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question14 of competency Hard and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Hard', 3, 'Java');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is Java question15 of competency Hard and ans D?', 'option A', 'option B', 'option C', 'option D', 'D', 'Hard', 3, 'Java');


insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is C++ question1 of competency Hard and ans B?', 'option A', 'option B', 'option C', 'option D', 'B', 'Hard', 3, 'C++');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is C++ question2 of competency Low and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Low', 1, 'C++');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is C++ question3 of competency Hard and ans B?', 'option A', 'option B', 'option C', 'option D', 'B', 'Hard', 3, 'C++');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is C++ question4 of competency Medium and ans A?', 'option A', 'option B', 'option C', 'option D', 'A', 'Medium', 2, 'C++');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is C++ question5 of competency Hard and ans D?', 'option A', 'option B', 'option C', 'option D', 'D', 'Hard', 3, 'C++');


insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is SQL question1 of competency Hard and ans B?', 'option A', 'option B', 'option C', 'option D', 'B', 'Hard', 3, 'SQL');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is SQL question2 of competency Medium and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Medium', 2, 'SQL');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is SQL question3 of competency Hard and ans B?', 'option A', 'option B', 'option C', 'option D', 'B', 'Hard', 3, 'SQL');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is SQL question4 of competency Low and ans D?', 'option A', 'option B', 'option C', 'option D', 'D', 'Low', 1, 'SQL');
insert into QuestionPool(question, optionA, optionB, optionC, optionD, answer, competency, marks, subject) 
 values ('This is SQL question5 of competency Hard and ans C?', 'option A', 'option B', 'option C', 'option D', 'C', 'Hard', 3, 'SQL');