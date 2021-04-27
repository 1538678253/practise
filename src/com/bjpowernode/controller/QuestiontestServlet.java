package com.bjpowernode.controller;

import com.bjpowernode.Dao.QuestionDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestiontestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List list=new ArrayList();
        HttpSession session=request.getSession(false);
        QuestionDAO questionDAO=new QuestionDAO();
        list=questionDAO.test();
        session.setAttribute("key",list);
        request.setAttribute("key",list);
        request.getRequestDispatcher("/test.jsp").forward(request,response);
    }
}
