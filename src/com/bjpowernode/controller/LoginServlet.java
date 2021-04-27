package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int result=3;
        //1.请求体中含有汉字，所以首先要解决的是编译问题
        request.setCharacterEncoding("utf-8");
        //2.获取请求体中的参数信息
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //3.将获取到的参数信息传给数据库，让数据库执行操作
        UserDao dao=new UserDao();
        result=dao.login(username,password);
        //4.将返回的结果回馈给响应头，根据不同的结果，返回浏览器不同的结果
        if (result==1){
            HttpSession session=request.getSession();
            response.sendRedirect("/myweb/index.html");
        }else if (result==0){
            response.sendRedirect("/myweb/login-error.html");
        }
    }
}
