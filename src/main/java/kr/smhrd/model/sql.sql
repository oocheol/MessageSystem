create table msg_member
(
	email varchar2(50),
	pw varchar2(50) not null,
	tel varchar2(50),
	address varchar2(200),
	
	constraint msg_email_pk primary key(email)
);

select * from msg_member;

create table msg_board
(
	num Number(30),
	writer varchar2(50),
	title varchar2(100),
	fileName varchar2(100),
	content varchar2(2000),
	day Date,
	
	constraint msg_num_pk primary key (num)
);

create sequence msg_num_seq
	start with 1
	increment by 1
	maxvalue 999999
	nocycle
	nocache

select * from msg_board;