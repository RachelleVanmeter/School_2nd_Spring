DROP TABLE validation_member;
DROP TABLE validation_member_auth;
CREATE TABLE validation_member(
	u_no int primary key auto_increment,
	u_id varchar(50) not null unique,
	u_pw varchar(200) not null,
	u_phone varchar(20) not null,
	u_birth varchar(20) not null,
	u_name varchar(20) not null,
	u_addr varchar(100),
	u_addr_detail varchar(200),
	u_addr_post varchar(20),
	u_point int default 0,
	u_info char(1) default 'y',
	u_date timestamp not null default now(),
	u_visit_date timestamp not null default now(),
	u_withraw char(1) default 'n'
);

CREATE TABLE validation_member_auth(
	u_id varchar(50) not null,
	u_auth varchar(50) not null,
	constraint fk_member_auth foreign key (u_id) REFERENCES validation_member(u_id)
);

SELECT * FROM validation_member;
SELECT * FROM validation_member_auth;

INSERT INTO validation_member_auth(u_id, u_auth)
VALUES('ktm06069@naver.com', 'ROLE_MASTER')
