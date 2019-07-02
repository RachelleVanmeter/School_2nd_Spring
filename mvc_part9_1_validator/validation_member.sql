CREATE TABLE validation_member(
	u_no int primary key auto_increment,
	u_id varchar(50) not null unique,
	u_pw varchar(50) not null,
	u_phone varchar(20) not null,
	u_birth varchar(20) not null,
	u_name varchar(20) not null,
	u_addr varchar(20),
	u_addr_detail varchar(20),
	u_addr_post varchar(20),
	u_point int default 0,
	u_info char(1) default 'y',
	u_date timestamp not null default now(),
	u_visit_date timestamp not null default now(),
	u_withraw char(1) default 'n'
);