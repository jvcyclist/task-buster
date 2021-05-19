DROP TABLE IF EXISTS project;
CREATE TABLE project (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL
);

INSERT INTO project (title, description ) VALUES
    ('Project from DB1', 'Desc1'),
    ('Project from DB2', 'Desc2'),
    ('Project from DB3', 'Desc3');

DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS sprint;
CREATE TABLE sprint (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    end_date TIMESTAMP NOT NULL,
    start_date TIMESTAMP NOT NULL,
    story_points INT NOT NULL
);


INSERT INTO sprint (end_date, start_date, story_points ) VALUES
    ('2021-04-05 20:26:02','2021-04-05 20:26:02',4),
    ('2021-04-05 20:26:02','2021-04-05 20:26:02',4),
    ('2021-04-05 20:26:02','2021-04-05 20:26:02',4),
    ('2021-04-05 20:26:02','2021-04-05 20:26:02',4);


CREATE TABLE task (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250),
    description VARCHAR(250),
    sprint_id INT,
    story_points INT,
    progress ENUM('BACKLOG', 'TODO', 'IN_PROGRESS', 'QA', 'DONE'),
    FOREIGN KEY (sprint_id) REFERENCES sprint(id)
);

INSERT INTO task (name, description, sprint_id, story_points, progress) VALUES
    ('TASK1','TASK1 TEST',1,3,'BACKLOG'),
    ('TASK2','TASK2 TEST',1,3,'BACKLOG'),
    ('TASK3','TASK3 TEST',1,3,'BACKLOG'),

    ('TASK1','TASK1 TEST',2,4,'TODO'),
    ('TASK1','TASK1 TEST',2,4,'TODO'),

    ('TASK1','TASK1 TEST',3,4,'IN_PROGRESS'),
    ('TASK1','TASK1 TEST',3,4,'IN_PROGRESS'),
    ('TASK1','TASK1 TEST',3,4,'QA'),
    ('TASK1','TASK1 TEST',4,4,'BACKLOG');

DROP TABLE IF EXISTS user_authority;
DROP TABLE IF EXISTS authority;
CREATE TABLE authority (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) UNIQUE
);
INSERT INTO authority (name) VALUES
    ('ADMIN'),
    ('MANAGER'),
    ('USER');


DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(250),
    password VARCHAR(250),
    first_name VARCHAR(250),
    last_name VARCHAR(250),
    email VARCHAR(250),
    activated BOOLEAN
);

INSERT INTO user(login, password, first_name, last_name, email, activated) VALUES
    ('pkaras','pkaras123','Patryk','Karas','patryk1karas@gmail.com',false),
    ('tnowacki','tnowak2222','Tomasz','Nowacki','tnowacki@gmail.com',false),
    ('admin','admin123','Admin','Adminowski','admin123@gmail.com',false);

DROP TABLE IF EXISTS user_authority;
CREATE TABLE user_authority (
    user_id INT,
    authority_name VARCHAR(250),

    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (authority_name) REFERENCES authority(name)
);

INSERT INTO user_authority (user_id, authority_name) VALUES
    (1,'ADMIN'),
    (1,'MANAGER'),
    (2,'USER'),
    (1,'MANAGER');

