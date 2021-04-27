package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int result=0;
        UserDao dao=new UserDao();
        //1.通过获取请求头参数，得到用户信息,并将获取的参数给Users;
        Users users=null;
        String username,password,sex,eamil;
        username=request.getParameter("username");
        password=request.getParameter("password");
        sex=request.getParameter("sex");
        eamil=request.getParameter("email");
        users=new Users(null,username,password,sex,eamil);
        //2.将用户信息填充到insert命令并借助JDBC规范发送到服务器
        Date start=new Date();
        result=dao.add(users);
        Date end=new Date();
        System.out.println("此次服务时间为"+(start.getTime()-end.getTime())+"毫秒");
        //【调用响应对象】将【处理结果】二进制写入响应体中；
        response.setContentType("text/html;charset=utf-8");
        //1)索要输出流
        PrintWriter out=response.getWriter();
        out.print(result==1? "<font style='color:red;font-size:40'>用户信息注册成功</font>":"<font style=40'color:red;font-size:40'>用户信息注册失败</font>");
    }
}
