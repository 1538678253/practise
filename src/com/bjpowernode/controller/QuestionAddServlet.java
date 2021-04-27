package com.bjpowernode.controller;

import com.bjpowernode.Dao.QuestionDAO;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获取请求头参数信息
        int result=0;
        Question question=null;
        String title,optionA,optionB,optionC,optionD,answer;
        title=request.getParameter("title");
        optionA=request.getParameter("optionA");
        optionB=request.getParameter("optionB");
        optionC=request.getParameter("optionC");
        optionD=request.getParameter("optionD");
        answer=request.getParameter("answer");
        QuestionDAO questionDAO=new QuestionDAO();
        question=new Question(null,title,optionA,optionB,optionC,optionD,answer);
        result=questionDAO.add(question,request);
    if(result!=0){
            request.setAttribute("info","试题新增成功");
        }else{
        request.setAttribute("info","试题新增失败");
    }
    request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
