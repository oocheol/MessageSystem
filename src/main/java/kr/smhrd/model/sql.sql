create table msg_member
(
	email varchar2(50),
	pw varchar2(50) not null,
	tel varchar2(50),
	address varchar2(200),
	
	constraint msg_email_pk primary key(email)
);

select * from msg_member;