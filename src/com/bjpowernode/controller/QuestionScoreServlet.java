package com.bjpowernode.controller;

import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionScoreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int score = 0;
        String useranswer,answer ,questionid;
        List list=new ArrayList();
        Question question;
        HttpSession session=request.getSession(false);
       list=(List) session.getAttribute("key");
        for (int i=0;i<list.size();i++){
         question = (Question)list.get(i);
         questionid=String.valueOf(question.getQuestionid());
         answer=question.getAnswer();
         useranswer=request.getParameter(questionid);
         if (answer.equals(useranswer)){
             score+=25;
             request.setAttribute("info","您的成绩是"+score);
             System.out.println(answer);
             System.out.println(useranswer);
         }
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
