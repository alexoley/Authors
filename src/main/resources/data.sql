DELETE FROM author_book;
DELETE FROM reward;
DELETE FROM author;
DELETE FROM book;

ALTER TABLE author_book AUTO_INCREMENT = 0;
ALTER TABLE reward AUTO_INCREMENT = 0;
ALTER TABLE author AUTO_INCREMENT = 0;
ALTER TABLE book AUTO_INCREMENT = 0;

INSERT INTO author (first_name,last_name,sex,birth_date) VALUES ('Buckminster','Fuller','MALE','1895-07-12');
INSERT INTO author (first_name,last_name,sex,birth_date) VALUES ('Frederic','Skinner','MALE','1904-03-20');
INSERT INTO author (first_name,last_name,sex,birth_date) VALUES ('Robert','Wilson','MALE','1932-01-18');
INSERT INTO author (first_name,last_name,sex,birth_date) VALUES ('Kurt','Vonnegut','MALE','1922-11-11');
INSERT INTO author (first_name,last_name,sex,birth_date) VALUES ('Agatha','Christie','FEMALE','1890-09-15');

INSERT INTO book (title,ISBN,genre) VALUES ('Operating Manual For Spaceship Earth','0-8093-2461-X','Philosophy');
INSERT INTO book (title,ISBN,genre) VALUES ('Critical Path','0-312-17488-8','Philosophy');
INSERT INTO book (title,ISBN,genre) VALUES ('Skinner for the Classroom','0-87822-261-8','Psychology');
INSERT INTO book (title,ISBN,genre) VALUES ('About Behaviorism','0-394-71618-3','Psychology');
INSERT INTO book (title,ISBN,genre) VALUES ('Utopia 14','978-0385333788','Novel');

INSERT INTO author_book (author_id,book_id) VALUES ('1','1');
INSERT INTO author_book (author_id,book_id) VALUES ('1','2');
INSERT INTO author_book (author_id,book_id) VALUES ('2','3');
INSERT INTO author_book (author_id,book_id) VALUES ('2','4');
INSERT INTO author_book (author_id,book_id) VALUES ('4','5');

INSERT INTO reward (year,title,author_id) VALUES ('1971','Gold Medal Award, American Psychological Foundation','2');
INSERT INTO reward (year,title,author_id) VALUES ('1972','Humanist of the Year','2');
INSERT INTO reward (year,title,author_id) VALUES ('2000','Entony award','5');
