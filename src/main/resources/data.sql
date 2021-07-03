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
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    planned_story_points INT NOT NULL,
    project_id INT,
    FOREIGN KEY (project_id) REFERENCES project(id)
);


INSERT INTO sprint (start_date, end_date, planned_story_points, project_id ) VALUES
    ('2021-03-01 20:26:02','2021-03-12 20:26:02',4,1),
    ('2021-03-15 20:26:02','2021-03-26 20:26:02',4,2),
    ('2021-06-22 20:26:02','2021-06-30 20:26:02',4,3),
     ('2021-06-22 20:26:02','2021-07-03 20:26:02',4,1),
    ('2021-07-05 20:26:02','2021-07-16 20:26:02',4,2),
    ('2021-07-19 20:26:02','2021-07-30 20:26:02',4,3),
    ('2021-04-05 20:26:02','2021-04-05 20:26:02',4,1);



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

    ('TASK1','TASK1 TEST',4,4,'BACKLOG'),
    ('TASK2','TASK1 TEST',4,4,'QA'),
    ('TASK3','TASK1 TEST',4,4,'TODO'),
    ('TASK4','TASK1 TEST',4,4,'BACKLOG'),
    ('TASK5','TASK1 TEST',4,4,'IN_PROGRESS'),
    ('TASK6','TASK1 TEST',4,4,'BACKLOG');

DROP TABLE IF EXISTS users;

create table users(
    id integer not null primary key,
	username varchar_ignorecase(50) not null
);

INSERT INTO users(id, username) VALUES
    (1, 'patryk1karas@gmail.com'),
    (2, 'kolarz9000@gmail.com'),
    (3, 'kar_patryk8@wp.pl');

DROP TABLE IF EXISTS authorities;

create table authorities (
    id integer not null,
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

INSERT INTO authorities (id, username, authority) VALUES
 (500, 'patryk1karas@gmail.com','ROLE_USER'),
 (501, 'kar_patryk8@wp.pl','ROLE_ADMIN'),
 (502, 'kar_patryk8@wp.pl','ROLE_USER');

create unique index ix_auth_username on authorities (username,authority);
