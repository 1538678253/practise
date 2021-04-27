package com.bjpowernode.controller;

import com.bjpowernode.Dao.QuestionDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int result=0;
        //1.获取请求行参数信息
        String questionid=request.getParameter("questionid");
        QuestionDAO questionDAO=new QuestionDAO();
        result=questionDAO.delete(Integer.valueOf(questionid));
        request.setAttribute("key",result);
        request.getRequestDispatcher("/delete.jsp").forward(request,response);
    }
}
