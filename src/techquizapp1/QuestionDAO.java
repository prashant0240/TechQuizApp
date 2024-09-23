/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import techquizapp.pojo.QuestionPojo;
import techquizapp.pojo.QuestionStore;
import texhQuizApp.dbutil.DBConnection;
import static texhQuizApp.dbutil.DBConnection.conn;

/**
 *
 * @author LENOVO
 */
public class QuestionDAO {
    public static void addQuestion(QuestionStore qstore)throws SQLException{
        String qry="insert into question values(?,?,?,?,?,?,?,?,?)";
        ArrayList<QuestionPojo> questionList=qstore.getAllQuestions();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
            for(QuestionPojo obj:questionList){
                ps.setString(1, obj.getExamId());
                ps.setInt(2,obj.getQno());
                ps.setString(3, obj.getQuestion());
                ps.setString(4, obj.getAnswer1());
                ps.setString(5, obj.getAnswer2());
                ps.setString(6, obj.getAnswer3());
                ps.setString(7, obj.getAnswer4());
                ps.setString(8,obj.getCorrectAnswer());
                ps.setString(9, obj.getLanguage());
                ps.executeUpdate();
        }
    }
    public static ArrayList <QuestionPojo> getQuestionsByExamId(String examId)throws SQLException{
        return null;
    }
}
