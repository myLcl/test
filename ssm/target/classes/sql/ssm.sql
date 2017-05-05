drop database if exists ssm;
create database ssm;
use ssm;

create table book (
  book_id int auto_increment,
  name varchar(100),
  number int,
  
  primary key(book_id)
) charset=utf8 ENGINE=InnoDB;


create table appointment(
  id int auto_increment,
  book_id varchar(100),
  student_id varchar(100),
  appoint_time time,
  
  primary key(id)
) charset=utf8 ENGINE=InnoDB;


insert into book(name,number)values('ÓïÎÄ',10);



