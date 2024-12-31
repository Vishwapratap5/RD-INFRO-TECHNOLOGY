package Con;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections {
    public static void main(String[] args)  {
        String URL = "jdbc:mysql://127.0.0.1:3306/Calculator";
        String PASSWORD="Vishwanj@2316";
        String USERNAME="root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect= DriverManager.getConnection(URL,PASSWORD,USERNAME );
            Statement stm=connect.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
