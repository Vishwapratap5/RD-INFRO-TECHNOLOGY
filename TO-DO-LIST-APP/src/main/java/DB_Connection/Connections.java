package DB_Connection;

import static Constants.Constant.*; // Imports all static members from the Constant class
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
    static Connection con;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
}

}
