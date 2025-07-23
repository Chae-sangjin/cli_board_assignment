DROP DATABASE IF EXISTS proj1;
CREATE DATABASE proj1;
USE proj1;

CREATE TABLE article (
                         id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         title char(100) NOT NULL UNIQUE,
                         content text,
                         memberid int UNSIGNED NOT NULL,
                         regDate DATETIME NOT null
);









SELECT * FROM article;

DESC article;


CREATE TABLE MEMBER (
                        id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        userid char(100) NOT NULL UNIQUE,
                        password char(100) NOT NULL,
                        regDate DATETIME NOT NULL

);


DESC MEMBER;

SELECT * FROM MEMBER;



SELECT
    A.id,
    A.title,
    A.content,
    A.regDate AS article_regDate,
    M.userid,
    M.password,
    M.regDate AS member_regDate

FROM article A
         JOIN MEMBER M
              ON A.memberid = M.id;

