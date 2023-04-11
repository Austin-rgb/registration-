import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Registration {
Connection connection=null;

    public static void main(String arg[])

    {



       
        JFrame myframe=new JFrame("Registration");
        JPanel mypanel=new JPanel();
        JLabel regNoLbl=new JLabel("Registration Number"),
        nameLbl=new JLabel("Name"),
        dobLbl=new JLabel("Date of Birth"),
        genderLbl=new JLabel("Gender");
        JTextField regNoBox=new JTextField(10),
        nameBox=new JTextField(10),
        dobBox=new JTextField(10),
        genderBox=new JTextField(10);
        JButton saveBtn=new JButton("Save");
        saveBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
        myframe.add(mypanel);
    } // function ends
private void add(int regno, String name, String dob, String gender){
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

                "INSERT INTO table_name (regno, name, dob, gender)
VALUES ("+regno+","+name+","+dob+"," +gender+");"
            );

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
}
} // class ends
