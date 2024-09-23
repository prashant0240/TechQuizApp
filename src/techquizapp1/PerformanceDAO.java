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
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.pojo.Performance;
import techquizapp.pojo.StudentScorePojo;
import texhQuizApp.dbutil.DBConnection;

/**
 *
 * @author LENOVO
 */
public class PerformanceDAO {
    public static ArrayList<String> getAllStudentId()throws SQLException
    {
       String qry="select distinct userid from performance";
       ArrayList<String> studentIdList=new ArrayList<>();
       Connection conn=DBConnection.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery(qry);
           
           while(rs.next()){
               String id=rs.getString(1);
               studentIdList.add(id);
           }
               
    return studentIdList;                      
   }
    public static ArrayList<String> getAllExamId(String studentId)throws SQLException
    {
        String qry="select examid from performance where userid=?";
        ArrayList<String> ExamIdList=new ArrayList<>();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,studentId);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            String ExamId=rs.getString(1);
            ExamIdList.add(ExamId);
        }
        return ExamIdList;
    }
    public static StudentScorePojo getScore(String studentId,String examId)throws SQLException
    {
        String qry="select language,per from performance where userid=? and examid=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,studentId);
        ps.setString(2,examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        StudentScorePojo scoreObj=new StudentScorePojo();
        scoreObj.setLanguage(rs.getString(1));
        scoreObj.setPer(rs.getDouble(2));
        return scoreObj;
                
    }
    public static void addPerformance(Performance performance)throws SQLException{
  String qry="Insert into performance values(?,?,?,?,?,?,?)";
  Connection conn=DBConnection.getConnection();
  PreparedStatement ps=conn.prepareStatement(qry);
  ps.setString(1, performance.getUserId());
  ps.setString(2, performance.getExamId());
           ps.setInt(3,performance.getRight());
           ps.setInt(4,performance.getWrong());
           ps.setInt(5,performance.getUnattempted());
           ps.setDouble(6,performance.getPer());
           ps.setString(7,performance.getLanguage());
           ps.executeUpdate();
           }


}
