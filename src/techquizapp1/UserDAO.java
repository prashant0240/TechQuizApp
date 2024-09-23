/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import techquizapp.pojo.UserPojo;
import texhQuizApp.dbutil.DBConnection;

/**
 *
 * @author LENOVO
 */
public class UserDAO {
    public static boolean validateUser(UserPojo user)throws SQLException{
        String password=user.getPassword();
        String userid=user.getUserId();
        String usertype=user.getUserType();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password=? and usertype=?");
        ps.setString(1, userid);
        ps.setString(2, password);
        ps.setString(3, usertype);
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    public static boolean addUser(UserPojo user)throws SQLException{
        String qry="select * from users where userid=?";
        boolean status=true;
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,user.getUserId());
        ResultSet rs=ps.executeQuery();
        if(rs.next())
            return false;
        else{
            qry="insert into users values(?,?,?)";
            ps=conn.prepareStatement(qry);
            ps.setString(1,user.getUserId());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getUserType());
            ps.executeUpdate();
        }
        return status;
    }
    public static boolean updateUser(UserPojo user)throws SQLException
    {
        String qry="update users set password=? where userid=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,user.getPassword());
        ps.setString(2,user.getUserId());
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
}
