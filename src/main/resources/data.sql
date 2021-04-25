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
