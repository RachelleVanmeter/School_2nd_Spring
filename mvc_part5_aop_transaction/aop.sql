CREATE TABLE tbl_user(
	uno int primary key auto_increment,
	uid varchar(50) not null unique,
	upw varchar(50) not null,
	uname varchar(50) not null,
	upoint int not null default 0
);

CREATE TABLE tbl_message(
	mno int primary key auto_increment,
	target varchar(50) not null,
	sender varchar(50) not null,
	message text not null,
	opendate timestamp,
	senddate timestamp not null default now()
);

ALTER TABLE tbl_message add constraint fk_user_target
FOREIGN KEY(target) REFERENCES tbl_user(uid);

ALTER TABLE tbl_message add constraint fk_user_sender
FOREIGN KEY(sender) REFERENCES tbl_user(uid);

INSERT INTO tbl_user(uid, upw, uname)
VALUES('id001', 'id001', 'IRON MAN'),('id002', 'id002', 'THOR'),('id003', 'id003', 'Dr.strange');

--------------------------------------------------------------------------------------------------

INSERT INTO tbl_message(target, sender, message)
VALUES('id001', 'id002', '안녕하세요... 대출 아자가 채납되었....');

UPDATE tbl_user SET upoint = upoint + 10
WHERE uid = 'id002';

--------------------------------------------------------------------------------------------------

--------------------------------------------------------------------------------------------------

UPDATE tbl_message SET opendate = now()
WHERE target = 'id001';

UPDATE tbl_user SET upoint = upoint + 5
WHERE uid = 'id001';

--------------------------------------------------------------------------------------------------

SELECT * from tbl_user;

SELECT * from tbl_message;