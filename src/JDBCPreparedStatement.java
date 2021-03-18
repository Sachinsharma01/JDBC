import java.sql.*;
import java.util.Scanner;

public class JDBCPreparedStatement {
    public static void jdbcLoad(){
        try {
            // Load the SQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup the Connection
            String url = "jdbc:mysql://localhost:3306/demodb";
            String user = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "insert into sachin (id, name) values(?, ?);";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the id of the Student : ");
            int id = sc.nextInt();
            System.out.print("Enter the Student Name : ");
            String name = sc.next();

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        jdbcLoad();
    }
}
