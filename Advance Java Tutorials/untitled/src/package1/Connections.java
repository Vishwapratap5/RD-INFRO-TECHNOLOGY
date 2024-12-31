package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

    static Connection connect;

    public static Connection getConnection() {
        try {
           Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connect;
    }
}
