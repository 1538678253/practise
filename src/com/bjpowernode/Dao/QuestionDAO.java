package com.bjpowernode.Dao;

import com.bjpowernode.Util.JdbcUtil;
import com.bjpowernode.entity.Question;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    JdbcUtil jdbcUtil = new JdbcUtil();
    String sq1 = "insert into question(title,optionA,optionB,optionC,optionD,answer)" + "values(?,?,?,?,?,?)";
    int result = 0;

    public int add(Question question, HttpServletRequest request) {
        PreparedStatement ps = jdbcUtil.createStatement(sq1);
        try {
            ps.setString(1, question.getTitle());
            ps.setString(2, question.getOptionA());
            ps.setString(3, question.getOptionB());
            ps.setString(4, question.getOptionC());
            ps.setString(5, question.getOptionD());
            ps.setString(6, question.getAnswer());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(request);
        }
        return result;
    }

    public List find() {
        ResultSet resultSet = null;
        List list = new ArrayList();
        Integer questionid;
        String title, optionA, optionB, optionC, optionD, answer;
        String sq2 = "select * from question";
        PreparedStatement ps = jdbcUtil.createStatement(sq2);
        try {
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                questionid = resultSet.getInt("questionid");
                title = resultSet.getString("title");
                optionA = resultSet.getString("optionA");
                optionB = resultSet.getString("optionB");
                optionC = resultSet.getString("optionC");
                optionD = resultSet.getString("optionD");
                answer = resultSet.getString("answer");
                Question question = new Question(questionid, title, optionA, optionB, optionC, optionD, answer);
                list.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return list;
    }

    public int delete(Integer q) {
        int result = 0;
        String sq3 = "delete from question where questionid=?";
        PreparedStatement ps = jdbcUtil.createStatement(sq3);
        try {
            ps.setInt(1, q);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Question information(Integer s) {
        Question question1 = null;
        ResultSet resultSet = null;
        Integer questionid;
        String title, optionA, optionB, optionC, optionD, answer;
        String sq4 = "select * from question where questionid=?";
        PreparedStatement ps = jdbcUtil.createStatement(sq4);
        try {
            ps.setInt(1, s);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                questionid = resultSet.getInt("questionid");
                title = resultSet.getString("title");
                optionA = resultSet.getString("optionA");
                optionB = resultSet.getString("optionB");
                optionC = resultSet.getString("optionC");
                optionD = resultSet.getString("optionD");
                answer = resultSet.getString("answer");
                question1 = new Question(questionid, title, optionA, optionB, optionC, optionD, answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close(resultSet);
        }
        return question1;
    }

    public int update(Question question) {
        int result=0;
        String sq4 = "update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionid=?";
        PreparedStatement ps = jdbcUtil.createStatement(sq4);
        try {
            ps.setString(1, question.getTitle());
            ps.setString(2, question.getOptionA());
            ps.setString(3, question.getOptionB());
            ps.setString(4, question.getOptionC());
            ps.setString(5, question.getOptionD());
            ps.setString(6, question.getAnswer());
            ps.setInt(7,question.getQuestionid());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.close();
        }
        return result;

    }
    public List test(){
        List list=new ArrayList();
        Integer questionid;
        String title, optionA, optionB, optionC, optionD, answer;
        ResultSet resultSet=null;
        String sq5="select * from question order by  rand() limit 0,4";
        PreparedStatement ps=jdbcUtil.createStatement(sq5);
        try {
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                questionid = resultSet.getInt("questionid");
                title = resultSet.getString("title");
                optionA = resultSet.getString("optionA");
                optionB = resultSet.getString("optionB");
                optionC = resultSet.getString("optionC");
                optionD = resultSet.getString("optionD");
                answer = resultSet.getString("answer");
                Question question = new Question(questionid, title, optionA, optionB, optionC, optionD, answer);
                list.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtil.close(resultSet);
        }
        return list;
    }
}
