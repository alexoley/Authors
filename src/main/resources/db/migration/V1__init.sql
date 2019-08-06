CREATE TABLE IF NOT EXISTS author (
  id INT AUTO_INCREMENT NOT NULL,
  birth_date DATE,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  sex VARCHAR(255),
  PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS book (
  id INT AUTO_INCREMENT NOT NULL,
  isbn VARCHAR(255),
  genre VARCHAR(255),
  title VARCHAR(255),
  PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS reward (
  id INT AUTO_INCREMENT NOT NULL,
  title VARCHAR(255),
  year INT,
  author_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (author_id) REFERENCES author (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS author_book (
  author_id INT NOT NULL,
  book_id INT NOT NULL,
  PRIMARY KEY (author_id,book_id),
  FOREIGN KEY (book_id) REFERENCES book (id),
  FOREIGN KEY (author_id) REFERENCES author (id)
)  ENGINE=INNODB;