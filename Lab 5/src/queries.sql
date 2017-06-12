create table representative(repno int(10) primary key, repname varchar(20), state varchar(20), comission int, rate float(6,2));

create table customer(custno int primary key, custname varchar(20), state varchar(20), credit_limit int, repno int references representative(repno));
