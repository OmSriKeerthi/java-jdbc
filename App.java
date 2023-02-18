package org.example;
import java.sql.*;
import java.util.Scanner;
   class App{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1.Enter the record you wanted to insert");
            System.out.println("2.Enter the record you wanted to delete ");
            System.out.println("3.Enter the record you wanted to update");
            System.out.println("4.To print the list of records");
            System.out.println("5.Exit");

        int n = s.nextInt();
        switch (n) {
            case 1:
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/books", "root", "akdeae@431");
                    PreparedStatement stmt = con.prepareStatement("insert into book values(?,?)");
                    stmt.setInt(1, 1);
                    stmt.setString(2, "atomichabits");
                    stmt.setInt(1, 2);
                    stmt.setString(2, "wings of fire");
                    stmt.setInt(1, 4);
                    stmt.setString(2, "Myjourney");
                    stmt.setInt(1, 5);
                    stmt.setString(2, "The-Autobiography");
                    int i = stmt.executeUpdate();
                    System.out.println(i+ "records inserted");
                    con.close();
                }
                catch(SQLException e){
                    System.out.println(e);
                }
                break;
            case 2:
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/books", "root", "akdeae@431");
                    PreparedStatement stmt = con.prepareStatement("delete from book where book_id=?");
                    stmt.setInt(1, 3);
                    int i = stmt.executeUpdate();
                    System.out.println(i + " records deleted");
                    con.close();
                }
                catch(SQLException e){
                    System.out.println(e);
                }
                break;
            case 3:
                try{
                    Connection con=DriverManager.getConnection("jdbc:mysql://@localhost:3306/books", "root", "akdeae@431");

                    PreparedStatement stmt=con.prepareStatement("update book set book_name=? where book_id=?");
                    stmt.setString(1,"The success");
                    stmt.setInt(2,4);
                    int i=stmt.executeUpdate();
                    System.out.println(i+" records updated");
                    con.close();
                }
                catch(SQLException e){
                    System.out.println(e);

            }
                case 4:

                try {
                System.out.println("Printing the list of all books ");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "akdeae@431");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from book");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2));
                }
                con.close();
            }
            catch (SQLException e) {

            }
            break;
            case 5:
                flag=false;
                break;
        }

        }
    }

}



