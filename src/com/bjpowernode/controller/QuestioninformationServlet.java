package com.bjpowernode.controller;

import com.bjpowernode.Dao.QuestionDAO;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestioninformationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求行参数信息
        Question question2=null;
        Integer q=Integer.valueOf(request.getParameter("questionid"));
        QuestionDAO questionDAO=new QuestionDAO();
        question2=questionDAO.information(q);
        request.setAttribute("key",question2);
        request.getRequestDispatcher("/information.jsp").forward(request,response);
    }
}
