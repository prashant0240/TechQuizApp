/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class QuestionStore {

    public QuestionStore() {
        questionList=new ArrayList<>();
    }
    ArrayList<QuestionPojo> questionList;
    public void addQuestion(QuestionPojo q){
        questionList.add(q);
    }
    public QuestionPojo getQuestion(int pos){
        return questionList.get(pos);
    }
    public void removeQuestion(int pos){
        questionList.remove(pos);
    }
    public void setQuestionAt(int pos,QuestionPojo q){
        questionList.add(pos,q);
    }
    public ArrayList<QuestionPojo> getAllQuestions(){
        return questionList;
    }
    public int getCount(){
        return questionList.size();
    }
    
}
