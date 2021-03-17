import java.sql.*;

public class JDBCIntro {
    public static void jdbcLoad() throws SQLException {
        try {
            // Load the SQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup the Connection
            String url = "jdbc:mysql://localhost:3306/demodb";
            String user = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement statement = con.createStatement();

            // Create the Queries
            String sql = "INSERT INTO sachin (id, name) VALUES (41, 'Sachin');";
            statement.executeUpdate(sql);
            String sql1 = "INSERT INTO sachin (id, name) VALUES (16, 'Sachin S');";
            statement.executeUpdate(sql1);
            String sql2 = "Select * from sachin where id = 41;";

//            statement.executeQuery(sql2);
            ResultSet resultSet = statement.executeQuery(sql2);
            while (resultSet.next()) {
                System.out.println("Name : " + resultSet.getString("name")
                        + "\tid : " + resultSet.getInt("id"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        jdbcLoad();
    }
}
