/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texhQuizApp.dbutil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class DBConnection {
    public static Connection conn;
    static{
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@//Prashant:1521/XE","onlineexam","student");
        JOptionPane.showMessageDialog(null,"Connected");
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"not Connected");
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null,"Connection Close");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Connection Not Close");
        }
        
    }
}
