package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int result=5;
        //1.得到请求头里面的请求参数，即用户id
       String userid=String.valueOf(request.getParameter("userid"));
        //2.将获取的参数给数据库，让数据库完成删除动作；
        UserDao dao=new UserDao();
        result=dao.delete(userid);
        //3.接收返回的响应结果
        response.setContentType("text/html;charset=utf-8");
        //1)索要输出流
        PrintWriter out=response.getWriter();
        out.print(result==1? "<font style='color:red;font-size:40'>用户信息删除成功</font>":"<font style=40'color:red;font-size:40'>用户信息删除失败</font>");
    }
}
