package com.bjpowernode.controller;

import com.bjpowernode.Dao.QuestionDAO;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionupdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title,optionA,optionB,optionC,optionD,answer;
        int result=0;
        Integer questionid;
        Question question;
        //从请求行获取参数
        questionid=Integer.valueOf(request.getParameter("questionid"));
        title=request.getParameter("title");
        optionA=request.getParameter("optionA");
        optionB=request.getParameter("optionB");
        optionC=request.getParameter("optionC");
        optionD=request.getParameter("optionD");
        answer=request.getParameter("answer");
        question=new Question(questionid,title,optionA,optionB,optionC,optionD,answer);
        QuestionDAO questionDAO=new QuestionDAO();
        result= questionDAO.update(question);
        if(result!=0){
            request.setAttribute("info","试题更新成功");
        }else{
            request.setAttribute("info","试题更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
