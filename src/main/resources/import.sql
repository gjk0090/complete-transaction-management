-- JPA has features for DDL generation (should be based on class annotation)
-- import.sql will be executed by JPA (Hibernate?) automatically
-- http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#howto-initialize-a-database-using-jpa

INSERT INTO book(isbn, title, author,description) VALUES ('1111111', 'The Spirit Thief (The Legend of Eli Monpress #1)', 'Rachel Aaron', 'des1');
INSERT INTO book(isbn, title, author,description) VALUES ('2222222', 'The Spirit Rebellion (The Legend of Eli Monpress, #2)', 'Rachel Aaron', 'des2');
INSERT INTO book(isbn, title, author,description) VALUES ('3333333', 'The Spirit Eater (The Legend of Eli Monpress, #3)', 'Rachel Aaron', 'des3');
INSERT INTO book(isbn, title, author,description) VALUES ('4444444', 'The Spirit War (The Legend of Eli Monpress, #4)', 'Rachel Aaron', 'des4');
INSERT INTO book(isbn, title, author,description) VALUES ('5555555', 'Spirit''s End (The Legend of Eli Monpress #5)', 'Rachel Aaron', 'des5');

INSERT INTO userinfo(username, fname, lname, email) VALUES ('gjk', 'jk', 'gao', 'gaojk0090@gmail.com');
INSERT INTO userinfo(username, fname, lname, email) VALUES ('admin', 'ad', 'min', 'gaojk0090@gmail.com');