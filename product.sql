use mydb;

create table product(
id int PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3) 
);

select * from product;
truncate product;

drop table employee;

create table employee(
id int PRIMARY KEY auto_increment,
name varchar(20)
);

insert into product values(1, "Samsung QLED TV", "Samsung 2022 world class QLED TV", 2599.99);
insert into product values(2, "LG QLED TV", "LG 2022 world class QLED TV", 2899.99);
insert into product values(3, "Apple Watch", "The next generation fitness watch", 1300);
insert into product values(4, "LG washer", "LG washer", 1189.78);
insert into product values(5, "Samsung washer", "Samsung washer", 1210.89);

commit;

create table customer(
id int PRIMARY KEY auto_increment,
name varchar(20),
email varchar(20)
);

use mydb;

create table student(
id int PRIMARY KEY AUTO_INCREMENT,
lname varchar(20),
fname varchar(20),
score int
);

select * from student;

select fname, lname from student where fname = "Krishnakumar";

create table payment(
id int PRIMARY KEY AUTO_INCREMENT,
pmode varchar(2),
amount decimal(8,3) ,
cardnumber varchar(20),
checknumber varchar(20)
);

select * from payment;

create table card(
id int PRIMARY KEY,
amount decimal(8,3),
cardnumber varchar(20)
);

create table bankcheck(
id int PRIMARY KEY,
amount decimal(8,3),
checknumber varchar(20)
);


use mydb;

drop table employee_component_mapping;

create table employee_component_mapping(
id int PRIMARY KEY Auto_increment,
name varchar(20),
streetaddress varchar(30),
city varchar(20),
state varchar(20),
zipcode varchar(20),
country varchar(20)
);

select * from employee_component_mapping;


use mydb;
drop table customer_one_to_many ;
drop table phone_number_many_to_one;

create table customer_one_to_many(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20)
);

create table phone_number_many_to_one(
id int PRIMARY KEY AUTO_INCREMENT,
customer_id int,
number varchar(20),
type varchar(20),
 FOREIGN KEY (customer_id) REFERENCES customer_one_to_many(id)
);

select * from customer_one_to_many;

select * from phone_number_many_to_one;


use mydb;

create table programmer_many_to_many(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20),
salary int
);

create table project_many_to_many(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20)
);

create table programmers_projects(
programmer_id int,
project_id int,
FOREIGN KEY (programmer_id)
REFERENCES programmer_many_to_many(id),
FOREIGN KEY (project_id)
REFERENCES project_many_to_many(id)
);



select * from programmer_many_to_many;
select * from project_many_to_many;
select * from programmers_projects;


truncate programmers_projects;
delete from project_many_to_many;
delete from programmer_many_to_many;


