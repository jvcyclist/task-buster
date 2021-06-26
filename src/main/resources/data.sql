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
    planned_story_points INT NOT NULL
);


INSERT INTO sprint (start_date, end_date, planned_story_points ) VALUES
    ('2021-03-01 20:26:02','2021-03-12 20:26:02',4),
    ('2021-03-15 20:26:02','2021-03-26 20:26:02',4),
    ('2021-06-22 20:26:02','2021-06-30 20:26:02',4),
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

DROP TABLE IF EXISTS users;

create table users(
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(250) not null,
	enabled boolean not null
);

INSERT INTO users(username, password, enabled) VALUES
    ('pkaras','$2y$12$Y.bzq8y2.1LY6B9zfNTGnuHYyPENJoNdz9AOtOV2/gqkbRNXLXiJ.',true),
    ('tnowacki','tnowak2222',false),
    ('admin','$2y$12$ohgSlGpcPTLwxC2u1LRKFuzLo3YF0Aobdedv3UXGOBDDLVDKLXuzO',true);

DROP TABLE IF EXISTS authorities;

create table authorities (
    id integer not null,
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

INSERT INTO authorities (id, username, authority) VALUES
 (500, 'pkaras','ROLE_USER'),
 (501, 'admin','ROLE_ADMIN'),
 (502, 'tnowacki','ROLE_USER');




create unique index ix_auth_username on authorities (username,authority);




