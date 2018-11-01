CREATE TABLE IF NOT EXISTS author (
    id INT AUTO_INCREMENT,
    birth_date DATE,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    sex VARCHAR(255),
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS book (
    id INT AUTO_INCREMENT,
    isbn VARCHAR(255),
    genre VARCHAR(255),
    title VARCHAR(255),
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS reward (
    id INT AUTO_INCREMENT,
    title VARCHAR(255),
    year INT,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS author_books (
    author_id INT,
    books_id INT,
    PRIMARY KEY (author_id,books_id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS author_rewards (
    author_id INT,
    rewards_id INT
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS book_authors (
    books_id INT,
    authors_id INT
)  ENGINE=INNODB;