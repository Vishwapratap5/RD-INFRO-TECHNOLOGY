import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Calculator","root","vishwanj@2316");
        String SQL = "INSERT INTO Operation (num1 ,operation,num2 ) VALUES (?,?,?);";
        PreparedStatement stm=connect.prepareStatement(SQL);
        int num1,num2;
        String operation;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First number :");
        num1=sc.nextInt();
        System.out.println("Enter Second number :");
        num2=sc.nextInt();
        System.out.println("Enter Operation :");
        operation=sc.next();
        stm.setInt(1,num1);
        stm.setString(2,operation);
        stm.setInt(3,num2);
        int resultset=stm.executeUpdate();
        System.out.println(resultset);

        String Query="Select * from Operation";
        ResultSet rs=stm.executeQuery(Query);
        while(rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        }


    }
}