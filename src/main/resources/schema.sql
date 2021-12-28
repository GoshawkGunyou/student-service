DROP TABLE IF EXISTS classes;
CREATE TABLE classes (
                         id INT auto_increment primary key,
                         serial VARCHAR(14),
                         name VARCHAR(30),
                         status ENUM('ACTIVE','INACTIVE','GRADUATED','WAITING'),
                         creator VARCHAR(30),
                         creation_time DATETIME,
                         last_editor VARCHAR(30),
                         last_time DATETIME
);

DROP TABLE IF EXISTS students;
CREATE TABLE students (
                          id INT auto_increment primary key,
                          serial VARCHAR(18),
                          name VARCHAR(40),
                          sex ENUM('M','F'),
                          dob DATE,
                          address VARCHAR(50),
                          phone VARCHAR(15),
                          class_id INT,
                          creator VARCHAR(30),
                          creation_time DATETIME,
                          last_editor VARCHAR(30),
                          last_time DATETIME
);


DROP TABLE IF EXISTS grades;
CREATE TABLE grades (
                        id INT auto_increment primary key,
                        student_id INT,
                        language DOUBLE,
                        math DOUBLE,
                        english DOUBLE,
                        creator VARCHAR(30),
                        creation_time DATETIME,
                        last_editor VARCHAR(30),
                        last_time DATETIME
);

SELECT g.id, g.language, g.math, g.english, s.last_time, s.id, s.serial, s.name, s.sex, s.dob, s.address, s.phone,
       s.class_id FROM grades g left outer join students s on g.student_id = s.id;

SELECT *
FROM grades g left outer join
     (SELECT s.id s_id, s.serial s_serial, s.name s_name, s.sex, s.dob, s.address, s.phone, s.creator s_creator, s.creation_time s_creation_time,
             s.last_editor s_last_editor, s.last_time s_last_time, c.id c_id, c.serial c_serial, c.name c_name, c.status, c.creator c_creator,
             c.creation_time c_creation, c.last_editor c_last_editor, c.last_time c_last_time
      FROM students s left outer join classes c on s.class_id = c.id WHERE c.id = 1) as sc
     on g.student_id = sc.s_id;

SELECT s_id, AVG(math) as math, AVG(english) as english, AVG(language) as language, s_serial, s_name, sex, dob, address, phone, s_creator, s_creation_time, s_last_editor, s_last_time, c_id, c_serial, c_name, c_status, c_creator, c_creation_time, c_last_editor, c_last_time
FROM grades g left outer join
     (SELECT s.id s_id, s.serial s_serial, s.name s_name, s.sex, s.dob, s.address, s.phone, s.creator s_creator, s.creation_time s_creation_time,
             s.last_editor s_last_editor, s.last_time s_last_time, c.id c_id, c.serial c_serial, c.name c_name, c.status c_status, c.creator c_creator,
             c.creation_time c_creation_time, c.last_editor c_last_editor, c.last_time c_last_time
      FROM students s left outer join classes c on s.class_id = c.id) as sc
     on g.student_id = sc.s_id
WHERE s_id=1
group by s_id;


SELECT id, name from students WHERE class_id=1;

SELECT (null + 0) FROM dual;
SELECT COUNT(english) FROM grades WHERE student_id=1;