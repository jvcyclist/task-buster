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

    ('TASK1','TASK1 TEST',2,4,'BACKLOG'),
    ('TASK1','TASK1 TEST',2,4,'BACKLOG'),

    ('TASK1','TASK1 TEST',3,4,'BACKLOG'),
    ('TASK1','TASK1 TEST',3,4,'BACKLOG'),
    ('TASK1','TASK1 TEST',3,4,'BACKLOG'),
    ('TASK1','TASK1 TEST',4,4,'BACKLOG');
