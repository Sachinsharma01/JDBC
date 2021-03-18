package questions.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentDB {
    static Scanner sc = new Scanner(System.in);
    public static int getChoice() {
        System.out.println("Enter your Choice : ");
        System.out.println("1 => To add a Student\n" +
                "2 => To delete a Student\n" +
                "3 => To get Details of Student");
        int choice = sc.nextInt();
        return choice;
    }
    public static void excuteQueries(int choice) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/demodb", "root", "");
            switch (choice) {
                case 1:
                    System.out.print("Enter the Student Name : ");
                    String name = sc.next();
                    System.out.print("Enter the Student id : ");
                    int id = sc.nextInt();
                    System.out.print("Enter the Student RollNo : ");
                    int rollNo = sc.nextInt();
                    System.out.print("Enter the Course : ");
                    String course = sc.next();
                    String sql = "insert into student (id, name, rollNo, course) values(?, ?, ?, ?);";
                    PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setInt(1, id);
                    pstmt.setString(2, name);
                    pstmt.setInt(3, rollNo);
                    pstmt.setString(4, course);
                    pstmt.executeUpdate();
                    break;
                case 2:
                    System.out.print("Enter the Student ID you want to delete : ");
                    id = sc.nextInt();
                    sql = "delete from student where id = ?;";
                    pstmt = connection.prepareStatement(sql);
                    pstmt.setInt(1,id);
                    pstmt.executeUpdate();
                    break;
                case 3:
                    System.out.print("Enter the ID of the Student : ");
                    id = sc.nextInt();
                    sql = "select * from student where id = ?;";
                    pstmt = connection.prepareStatement(sql);
                    pstmt.setInt(1,id);
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        System.out.println("Name : " + rs.getString("name") + "\nId : " + rs.getInt("id")
                                + "\nRoll No : " + rs.getInt("rollNo") +
                                "\nCourse : " + rs.getString("course"));
                    }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        excuteQueries(getChoice());
    }
}
