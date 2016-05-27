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

INSERT INTO app(app_Id, parent_App_Id, app_Name, app_Display_Name) VALUES (1, 0, 'parentapp', 'parent app');
INSERT INTO app(app_Id, parent_App_Id, app_Name, app_Display_Name) VALUES (2, 1, 'childapp1', 'child app 1');
INSERT INTO app(app_Id, parent_App_Id, app_Name, app_Display_Name) VALUES (3, 1, 'childapp2', 'child app 2');

INSERT INTO param(param_Id, app_Id, param_Name, param_Display_Name, param_Sequence, param_Properties, param_Category, param_Type) VALUES (null, 2, 'param1', 'param 1', 1, '', '', 'text');
INSERT INTO param(param_Id, app_Id, param_Name, param_Display_Name, param_Sequence, param_Properties, param_Category, param_Type) VALUES (null, 2, 'param2', 'param 2', 2, '', '', 'text');
INSERT INTO param(param_Id, app_Id, param_Name, param_Display_Name, param_Sequence, param_Properties, param_Category, param_Type) VALUES (null, 2, 'param3', 'param 3', 3, '', '', 'text');
INSERT INTO param(param_Id, app_Id, param_Name, param_Display_Name, param_Sequence, param_Properties, param_Category, param_Type) VALUES (null, 3, 'param1', 'param 1', 1, '', '', 'text');
INSERT INTO param(param_Id, app_Id, param_Name, param_Display_Name, param_Sequence, param_Properties, param_Category, param_Type) VALUES (null, 3, 'param2', 'param 2', 2, '', '', 'text');
INSERT INTO param(param_Id, app_Id, param_Name, param_Display_Name, param_Sequence, param_Properties, param_Category, param_Type) VALUES (null, 3, 'param3', 'param 3', 3, '', '', 'text');