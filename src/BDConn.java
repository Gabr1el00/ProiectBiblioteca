
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class BDConn {
    public static Connection getBDConn() throws SQLException{
       try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "student" , "student");
        return con;
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Nu avem conectare cu Baza de date");
        return null;
    }
    }
    
}
