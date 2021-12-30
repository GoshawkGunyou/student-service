DROP TABLE IF EXISTS classes;
CREATE TABLE classes (
                         c_id INT auto_increment primary key,
                         c_serial VARCHAR(14),
                         c_name VARCHAR(30),
                         c_status INT,
                         c_creator VARCHAR(30),
                         c_creation_time DATETIME,
                         c_last_editor VARCHAR(30),
                         c_last_time DATETIME
);

DROP TABLE IF EXISTS students;
CREATE TABLE students (
                          s_id INT auto_increment primary key,
                          s_serial VARCHAR(18),
                          s_name VARCHAR(40),
                          s_sex ENUM('M','F'),
                          s_dob DATE,
                          s_address VARCHAR(50),
                          s_phone VARCHAR(15),
                          c_id INT,
                          s_status INT,
                          s_creator VARCHAR(30),
                          s_creation_time DATETIME,
                          s_last_editor VARCHAR(30),
                          s_last_time DATETIME
);


DROP TABLE IF EXISTS grades;
CREATE TABLE grades (
                        g_id INT auto_increment primary key,
                        s_id INT,
                        g_language DOUBLE,
                        g_math DOUBLE,
                        g_english DOUBLE,
                        g_status INT,
                        g_creator VARCHAR(30),
                        g_creation_time DATETIME,
                        g_last_editor VARCHAR(30),
                        g_last_time DATETIME
);