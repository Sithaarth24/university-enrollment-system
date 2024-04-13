import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/universityenrollment";
            Scanner inp = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(URL,"root","#sithu24");
            while(true) {
                System.out.println("Enter:\n1 for admin\n2 for student\n3 to close");
                int type = inp.nextInt();
                inp.nextLine();
                if(type==1){
                    do{
                        System.out.println("Enter password:");
                    }while(!inp.nextLine().equals("sithu123"));
                    System.out.println("HELLO ADMIN!!");
                    while(true){
                        boolean back = false;
                        System.out.println("Enter:\n1 - add student\n2 - add course\n3 - add department\n4 - back");
                        int operation = inp.nextInt();
                        inp.nextLine();
                        switch(operation){
                            case 4:
                                back = true;
                                break;
                            case 1:
                                String query = "insert into students values(?,?,?,?,?,?,?,?,?)";
                                PreparedStatement StudentPreparedStatement = connection.prepareStatement(query);

                                System.out.println("Enter student details:");

                                System.out.print("Name: ");
                                String name = inp.nextLine();

                                System.out.print("Date of Birth (YYYY-MM-DD): ");
                                String dateOfBirth = inp.nextLine();

                                System.out.print("Gender (Male/Female/Other): ");
                                String gender = inp.nextLine();

                                System.out.print("Email: ");
                                String email = inp.nextLine();

                                System.out.print("Phone Number: ");
                                String phoneNumber = inp.nextLine();

                                System.out.print("Address: ");
                                String address = inp.nextLine();

                                System.out.print("Department: ");
                                String department = inp.nextLine();

                                System.out.print("Year of Study: ");
                                int yearOfStudy = inp.nextInt();
                                inp.nextLine();

                                System.out.print("Enrollment Date (YYYY-MM-DD): ");
                                String enrollmentDate = inp.nextLine();

                                StudentPreparedStatement.setString(1, name);
                                StudentPreparedStatement.setString(2, dateOfBirth);
                                StudentPreparedStatement.setString(3, gender);
                                StudentPreparedStatement.setString(4, email);
                                StudentPreparedStatement.setString(5, phoneNumber);
                                StudentPreparedStatement.setString(6, address);
                                StudentPreparedStatement.setString(7, department);
                                StudentPreparedStatement.setInt(8, yearOfStudy);
                                StudentPreparedStatement.setString(9, enrollmentDate);

                                int rowsInserted = StudentPreparedStatement.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("Student details inserted successfully.");
                                } else {
                                    System.out.println("Failed to insert Student details.");
                                }

                                break;

                            case 2:
                                String sql = "INSERT INTO courses (name, course_duration_years, fee) VALUES (?, ?, ?)";
                                PreparedStatement CoursesPreparedStatement = connection.prepareStatement(sql);


                                System.out.println("Enter course details:");
                                System.out.print("Name of course:");
                                name = inp.nextLine();

                                System.out.print("Duration (in years) of course: ");
                                float duration = inp.nextFloat();
                                inp.nextLine();

                                System.out.print("Fee of course: ");
                                float fee = inp.nextFloat();
                                inp.nextLine();

                                CoursesPreparedStatement.setString(1, name);
                                CoursesPreparedStatement.setFloat(2, duration);
                                CoursesPreparedStatement.setFloat(3, fee);

                                rowsInserted = CoursesPreparedStatement.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("course details inserted successfully.");
                                } else {
                                    System.out.println("Failed to insert course details.");
                                }

                                break;
                            case 3:
                                query = "INSERT INTO departments(department_name,faculty_count) VALUES (?, ?)";
                                PreparedStatement DepartmentPreparedStatement = connection.prepareStatement(query);

                                Scanner scanner = new Scanner(System.in);
                                System.out.println("Enter department details:");

                                System.out.print("Department Name: ");
                                String departmentName = scanner.nextLine();

                                System.out.print("Faculty Count: ");
                                int facultyCount = scanner.nextInt();
                                scanner.nextLine();

                                DepartmentPreparedStatement.setString(1, departmentName);
                                DepartmentPreparedStatement.setInt(2, facultyCount);

                                rowsInserted = DepartmentPreparedStatement.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("Department details inserted successfully.");
                                } else {
                                    System.out.println("Failed to insert department details.");
                                }
                        }
                        if(back){
                            break;
                        }
                    }
                }
                else if(type==2){

//                    System.err.println("working on it!!");
                    System.out.println("Student Verification");
                    System.out.print("name: ");
                    Date dob = null;
                    String name = inp.nextLine();
                    do{
                        try{
                            System.out.print("Date of Birth (YYYY-MM-DD): ");
                            dob = Date.valueOf(inp.nextLine());
                        }
                        catch(IllegalArgumentException e){
                            System.out.println("wrong date format!! Enter again");
                        }
                    }while(dob==null);

                    PreparedStatement preparedStatement = connection.prepareStatement("select * from students where name=? and date_of_birth=?;");
                    preparedStatement.setString(1,name);
                    preparedStatement.setDate(2,dob);

                    ResultSet StudentResultSet = preparedStatement.executeQuery();

                    if(StudentResultSet.next()){
                        System.out.println("Hello "+StudentResultSet.getString("name"));
                        boolean back1 = false;
                        while(!back1) {
                            System.out.println("Enter:\n1 - view your details\n2 - view courses\n3 - add course\n4 - view your courses\n5 back\nNote:you can take only upto three courses");
                            int choice = inp.nextInt();
                            inp.nextLine();
                            switch (choice) {
                                case 1:
                                    do {
                                        System.out.println("Name:" + StudentResultSet.getString("name"));
                                        System.out.println("Dob:" + StudentResultSet.getString("date_of_birth"));
                                        System.out.println("Gender:" + StudentResultSet.getString("gender"));
                                        System.out.println("Email:" + StudentResultSet.getString("email"));
                                        System.out.println("Phone no:" + StudentResultSet.getString("phone_number"));
                                        System.out.println("Address:" + StudentResultSet.getString("address"));
                                        System.out.println("Department:" + StudentResultSet.getString("department"));
                                        System.out.println("YearOfStudy:" + StudentResultSet.getString("year_of_study"));
                                        System.out.println("JoinedOn:" + StudentResultSet.getString("enrollment_date"));
                                    } while (StudentResultSet.next());
                                    break;

                                case 2:
                                    Statement statement = connection.createStatement();
                                    ResultSet resultSet = statement.executeQuery("select * from courses");
                                    ResultSetMetaData metaData = resultSet.getMetaData();
                                    int columnCount = metaData.getColumnCount();
                                    for (int i = 1; i <= columnCount; i++) {
                                        System.out.printf("%-40s", metaData.getColumnLabel(i));
                                    }
                                    System.out.println();

                                    // Print the table data
                                    while (resultSet.next()) {
                                        for (int i = 1; i <= columnCount; i++) {
                                            System.out.printf("%-40s", resultSet.getString(i));
                                        }
                                        System.out.println();
                                    }
                                    break;
                                case 3:
                                    System.out.print("Enter course name:");
                                    String courseName = inp.nextLine();
                                    preparedStatement = connection.prepareStatement("select * from courses where name = ?");
                                    preparedStatement.setString(1,courseName);

                                    ResultSet resultSet1 = preparedStatement.executeQuery();
                                    if(resultSet1.next()){
                                        PreparedStatement checkCourseLimit = connection.prepareStatement("select * from enrollment where student_id = ?");
                                        checkCourseLimit.setInt(1,StudentResultSet.getInt("student_id"));
                                        ResultSet enrollments = checkCourseLimit.executeQuery();
                                        int rowCount = enrollments.getRow();
                                        if(rowCount<3){
                                            preparedStatement = connection.prepareStatement("insert into enrollment(student_id,course_id,course_name) values(?,?,?)");
                                            preparedStatement.setInt(1,StudentResultSet.getInt("student_id"));
                                            preparedStatement.setInt(2,resultSet1.getInt("id"));
                                            preparedStatement.setString(3,resultSet1.getString("name"));

                                            preparedStatement.executeUpdate();
                                            System.out.println("Course added successfully!\nCourse left:"+(2-rowCount));
                                        }
                                        else{
                                            System.out.println("Course Limit Exceeded!");
                                        }
                                    }
                                    else{
                                        System.out.println("Course Not found");
                                    }
                                    break;
                                case 4:
                                    PreparedStatement preparedStatement1 = connection.prepareStatement("select course_name from enrollment where student_id=?");
                                    preparedStatement1.setInt(1,StudentResultSet.getInt("student_id"));

                                    ResultSet resultSet2 = preparedStatement1.executeQuery();
                                    while(resultSet2.next()){
                                        System.out.println(resultSet2.getString("course_name"));
                                    }
                                    break;
                                case 5:
                                    back1 = true;
                                    break;
                            }

                        }
                    }
                    else{
                        System.out.println("No user found");
                    }
                }
                else if(type==3){
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}