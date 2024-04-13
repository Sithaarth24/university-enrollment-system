CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    date_of_birth DATE,
    gender ENUM('Male', 'Female', 'Other'),
    email VARCHAR(255),
    phone_number VARCHAR(20),
    address VARCHAR(255),
    department VARCHAR(100),
    year_of_study INT,
    enrollment_date DATE,
    FOREIGN KEY (department) REFERENCES departments(department_name)
);

CREATE TABLE departments (
     department_id INT AUTO_INCREMENT PRIMARY KEY,
     department_name VARCHAR(100),
     faculty_count INT,
     UNIQUE (department_name)
);

CREATE TABLE courses (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255),
     course_duration_years FLOAT,
     fee FLOAT
);


CREATE TABLE enrollment (
    student_id INT,
    course_id INT,
    course_name VARCHAR(255)
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);
