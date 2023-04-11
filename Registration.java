import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class Registration {
Connection connection=null;
    public static void main(String arg[])
    {     try{
        // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb",
                "mydbuser", "mydbuser");
            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database
    }catch (Exception e){
        System.out.println(e);
    }
        JFrame myframe=new JFrame("Registration");
        JPanel mypanel=new JPanel();
        mypanel.setLayout(new GridLayout(2,5));
        JLabel regNoLbl=new JLabel("Registration Number"),
        nameLbl=new JLabel("Name"),
        dobLbl=new JLabel("Date of Birth"),
        genderLbl=new JLabel("Gender");
        JTextField regNoBox=new JTextField(10),
        nameBox=new JTextField(10),
        dobBox=new JTextField(10),
        genderBox=new JTextField(10);
        JButton saveBtn=new JButton("Save");
        mypanel.add(regNoLbl);
        mypanel.add(regNoBox);
        mypanel.add(nameLbl);
        mypanel.add(nameBox);
        mypanel.add(dobLbl);
        mypanel.add(dobBox);
        mypanel.add(genderLbl);
        mypanel.add(genderBox);
        saveBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                addData(regNoBox.getText(),nameBox.getText(),dobBox.getText(),genderBox.getText());
                regN
            }
        mypanel.add(saveBtn);
        myframe.add(mypanel);
    } // function ends
private void addData(String regno, String name, String dob, String gender){
     try {
            Statement statement;
            statement = connection.createStatement();
            statement.executeUpdate(
                "INSERT INTO table_name (regno, name, dob, gender) VALUES ("+regno+","+name+","+dob+"," +gender+");"
            );
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
}
} // class ends
