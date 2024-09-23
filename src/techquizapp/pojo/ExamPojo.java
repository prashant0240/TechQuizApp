/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

/**
 *
 * @author LENOVO
 */
public class ExamPojo {

    @Override
    public String toString() {
        return "ExamPojo{" + "ExamId=" + ExamId + ", language=" + language + ", totalQuestiopn=" + totalQuestiopn + '}';
    }
     private String ExamId;
    private String language;
    private int totalQuestiopn;

    public ExamPojo(String ExamId, String language, int totalQuestiopn) {
        this.ExamId = ExamId;
        this.language = language;
        this.totalQuestiopn = totalQuestiopn;
    }

    public String getExamId() {
        return ExamId;
    }

    public void setExamId(String ExamId) {
        this.ExamId = ExamId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTotalQuestiopn() {
        return totalQuestiopn;
    }

    public void setTotalQuestiopn(int totalQuestiopn) {
        this.totalQuestiopn = totalQuestiopn;
    }
}
