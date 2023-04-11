import java.sql.*;
import javax.swing.*;


public class Registration {
Connection connection=null;

    public static void main(String arg[])

    {



        try {

            // below two lines are used for connectivity.

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(

                "jdbc:mysql://localhost:3306/mydb",

                "mydbuser", "mydbuser");

 

            // mydb is database

            // mydbuser is name of database

            // mydbuser is password of database

 

            Statement statement;

            statement = connection.createStatement();

            ResultSet resultSet;

            resultSet = statement.executeQuery(

                "select * from designation");

            int code;

            String title;

            while (resultSet.next()) {

                code = resultSet.getInt("code");

                title = resultSet.getString("title").trim();

                System.out.println("Code : " + code

                                   + " Title : " + title);

            }

            resultSet.close();

            statement.close();

            connection.close();

        }

        catch (Exception exception) {

            System.out.println(exception);

        }
        JFrame myframe=new JFrame("Registration");

    } // function ends

} // class ends
