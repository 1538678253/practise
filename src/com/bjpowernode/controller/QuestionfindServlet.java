package com.bjpowernode.controller;

import com.bjpowernode.Dao.QuestionDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionfindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDAO questionDAO=new QuestionDAO();
        List list=(List)questionDAO.find();
        request.setAttribute("key",list);
        request.getRequestDispatcher("/questionfind.jsp").forward(request,response);
    }
}
