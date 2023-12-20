CREATE TABLE Homework (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255),
                          description TEXT
);

CREATE TABLE Lesson (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(255),
                        updatedAt TIMESTAMP,
                        homework_id INT,
                        FOREIGN KEY (homework_id) REFERENCES Homework(id)
);

CREATE TABLE Schedule (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255),
                          updatedAt TIMESTAMP,
);


CREATE TABLE schedule_lessons (
                                  schedule_id INT,
                                  lesson_id INT,
                                  PRIMARY KEY (schedule_id, lesson_id),
                                  FOREIGN KEY (schedule_id) REFERENCES Schedule(id),
                                  FOREIGN KEY (lesson_id) REFERENCES Lesson(id)
);

INSERT INTO Homework (name, description) VALUES
                                             ('Homework 1', 'Description for Homework 1'),
                                             ('Homework 2', 'Description for Homework 2');

INSERT INTO Lesson (name, updatedAt, homework_id) VALUES
                                                      ('Lesson 1', CURRENT_TIMESTAMP, 1),
                                                      ('Lesson 2', CURRENT_TIMESTAMP, 2);

INSERT INTO Schedule (name, updatedAt) VALUES
                                           ('Schedule 1', CURRENT_TIMESTAMP),
                                           ('Schedule 2', CURRENT_TIMESTAMP);

INSERT INTO schedule_lessons (schedule_id, lesson_id) VALUES
                                                          (1, 1),
                                                          (1, 2),
                                                          (2, 1);