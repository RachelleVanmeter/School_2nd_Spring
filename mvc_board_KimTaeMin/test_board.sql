CREATE TABLE test_board(
	bno int primary key auto_increment,
	title varchar(200) not null,
	content text not null,
	writer varchar(50) not null,
	regdate timestamp not null default now(),
	viewcnt int default 0
);

INSERT INTO test_board(title, content, writer)
SELECT title, content, writer FROM test_board;