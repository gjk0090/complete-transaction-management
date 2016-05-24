-- Spring JDBC has a DataSource initializer feature. Spring Boot enables it by default and loads SQL from the standard locations schema.sql and data.sql (in the root of the classpath). 
-- http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#howto-initialize-a-database-using-spring-jdbc

insert into users (username, password, enabled) values ('gjk', 'gjk', true);
insert into authorities (username, authority) values ('gjk', 'ROLE_USER');

insert into users (username, password, enabled) values ('admin', 'admin', true);
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
