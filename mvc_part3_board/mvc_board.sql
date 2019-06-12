CREATE TABLE tbl_board(
	bno int PRIMARY KEY auto_increment,
	title VARCHAR(200) NOT NULL,
	content text NULL,
	writer VARCHAR(50) NOT NULL,
	regdate TIMESTAMP NOT NULL DEFAULT now(),
	viewcnt INT DEFAULT 0
);

INSERT INTO tbl_board(title, content, writer)
SELECT title, content, writer FROM tbl_board;

SELECT COUNT(*) FROM tbl_board;

SELECT * FROM tbl_board ORDER BY bno DESC LIMIT 0, 10;