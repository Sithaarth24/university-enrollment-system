**University Enrollment System (Java)**

This Java project implements a simple enrollment system for a university using MySQL for database management. It allows both administrators and students to perform various operations related to enrollment, such as adding students, courses, departments, and enrolling in courses.

### Features
- **Admin Operations:**
  - Add new students with details including name, date of birth, gender, email, phone number, address, department, year of study, and enrollment date.
  - Add new courses with details including name, duration (in years), and fee.
  - Add new departments with details including department name and faculty count.

- **Student Operations:**
  - Verify student credentials using name and date of birth.
  - View student details including name, date of birth, gender, email, phone number, address, department, year of study, and enrollment date.
  - View available courses.
  - Add courses within the limit of three courses per student.
  - View enrolled courses.

### Setup
1. Ensure you have Java Development Kit (JDK) and MySQL installed on your system.
2. Import the provided SQL file ([`universityenrollment.sql`](universityenrollment.sql)) into your MySQL database to create the necessary tables.
3. Update the database connection details in the [`Main.java`](Main.java) file, including the URL, username, and password.
4. Compile and run the [`Main.java`](Main.java) file to start the enrollment system.

### Usage
1. Upon running the program, choose between admin and student access by entering `1` for admin, `2` for student, or `3` to exit.
2. For admin access, enter the password when prompted (`sithu123` by default).
3. Admins can perform operations such as adding students, courses, and departments.
4. For student access, verify credentials by entering the name and date of birth.
5. Students can view their details, available courses, enroll in courses, and view enrolled courses.

### Notes
- The admin password is hardcoded in the program (`sithu123`), which is not recommended for production use. Implement proper authentication mechanisms for security.
- Error handling is minimal in this implementation. Enhance error handling and input validation for robustness.
- Ensure to handle exceptions gracefully and close resources properly in a production environment.

### Contributors
- [Sithaarth24]

### License
This project is licensed under the [MIT License](LICENSE).
