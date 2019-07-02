CREATE TABLE security_member(
	uid varchar(50) primary key,
	upw varchar(100) NOT NULL,
	uname VARCHAR(100) NOT NULL,
	regdate TIMESTAMP DEFAULT now(),
	updatedate TIMESTAMP default now()
);

CREATE TABLE security_member_auth(
	uid VARCHAR(50) NOT NULL,
	auth VARCHAR(50) NOT NULL,
	constraint fk_memberauth FOREIGN KEY(uid) REFERENCES security_member(uid)
);

INSERT INTO security_member_auth(uid, auth) VALUES('admin99', 'ROLE_MEMBERSHIP');

SELECT * FROM security_member;
SELECT * FROM security_member_auth;