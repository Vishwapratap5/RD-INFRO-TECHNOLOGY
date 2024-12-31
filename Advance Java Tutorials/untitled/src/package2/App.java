package package2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import package1.*;
public class App {

    public static void main(String[] args) {

        Connection connect=Connections.getConnection();
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("--------------->>Menu<<---------------");
            System.out.println("1. Reserve A Room");
            System.out.println("2. See Reservations");
            System.out.println("3. Get Room Number");
            System.out.println("4.Update reservations");
            System.out.println("5. Delete Reservations");

            System.out.println("Enter your choice ::>");
            int choice=sc.nextInt();

            switch(choice)
            {
                case 1:
                    Reserve_Room(connect,sc);
                    break;

                case 2 :
                    See_Reservation(connect,sc);
                    break;

                case 3 :
                    Get_RoomNumber(connect,sc);
                    break;

                case 4 :
                    Update_reservation(connect,sc);
                    break;

                case 5 :
                    Delete_reservation(connect,sc);
                    break;

                case 6 :
                    break;

                default :
                    System.out.println("Please Enter valid choice..!");
                    break;
            }
        }


    }



    static void Reserve_Room(Connection connect, Scanner sc)
    {
        String sql="Insert into reservations(Guest_name,Room_no,Contact_number) values(?,?,?)";
        System.out.println("Enter Room Number :: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name ::  ");
        String name=sc.nextLine();
        System.out.println("Enter Mobile number:: ");
        String Mo_num=sc.nextLine();
        try {
            PreparedStatement ps=connect.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.setString(3, Mo_num);
            int RowAffected=ps.executeUpdate();

            if(RowAffected==1)
            {
                System.out.println("Reservation Successfull..!");
            }
            else {
                System.out.println("Reservation failed..!");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    static void See_Reservation(Connection connect,Scanner sc)
    {
        String sql="Select * from reservations;";
        try {
            Statement ps=connect.createStatement();
            ResultSet rs=ps.executeQuery(sql);
            System.out.print("Reservation ID\t"+"Guest Name\t"+"Room_No\t"+"Contact Number\t"+"Reseration date");
            while(rs.next()) {
                System.out.println();
                System.out.print(rs.getInt("Reservation_ID"));
                System.out.print("\t\t");
                System.out.print(rs.getString("Guest_name"));
                System.out.print("\t\t");
                System.out.print(rs.getInt("Room_no"));
                System.out.print("\t\t");
                System.out.print(rs.getString("Contact_number"));
                System.out.print("\t\t");
                System.out.print(rs.getTimestamp("reservation_date"));
                System.out.println();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }



    static void Get_RoomNumber(Connection connect, Scanner sc)
    {
        String sql="Select * from reservations where Reservation_ID=?;";
        System.out.println("Enter Your Reservation ID :: ");
        int id=sc.nextInt();
        try {
            PreparedStatement ps=connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                System.out.println("Room Number is :: "+rs.getInt("Room_no"));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }



    static void Update_reservation(Connection connect, Scanner sc) {
        System.out.println("Enter Reservation Number :: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the newline left by nextInt()

        if (ReservationExist(connect, id)) {
            String sql = "UPDATE reservations SET Guest_name = ?, Room_no = ?, Contact_number = ? WHERE Reservation_ID = ?";

            System.out.println("Enter new Room number :: ");
            int room_no = sc.nextInt();
            sc.nextLine(); // Consume the newline left by nextInt()

            System.out.println("Enter new Name :: ");
            String name = sc.nextLine();

            System.out.println("Enter new Mobile number :: ");
            String Mo_num = sc.nextLine();

            try {
                PreparedStatement ps = connect.prepareStatement(sql);
                ps.setString(1, name);    // Set Guest_name
                ps.setInt(2, room_no);    // Set Room_no
                ps.setString(3, Mo_num);  // Set Contact_number
                ps.setInt(4, id);         // Set Reservation_ID

                int RowAffected = ps.executeUpdate();

                if (RowAffected == 1) {
                    System.out.println("Reservation Updated Successfully!");
                } else {
                    System.out.println("Reservation Update Failed!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Reservation ID does not exist.");
        }
    }


    static boolean ReservationExist(Connection connect,int id)
    {
        String sql="Select 1 from reservations where  Reservation_ID=?; ";
        try {
            PreparedStatement  ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    static void Delete_reservation(Connection connect, Scanner sc)
    {
        System.out.println("Enter Reservation ID :: ");
        int id=sc.nextInt();
        if(ReservationExist(connect,id))
        {
            String sql="delete  from reservations where Reservation_ID=?; ";
            try {
                PreparedStatement stm=connect.prepareStatement(sql);
                stm.setInt(1, id);
                int RowAffected=stm.executeUpdate();
                if(RowAffected==1)
                {
                    System.out.println("Deletion Successfull..!");
                }
                else {
                    System.out.println("Reservation failed..!");
                }
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }


}
