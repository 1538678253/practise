package com.bjpowernode.controller;

import com.bjpowernode.Dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao=new UserDao();
        //1.[调用DAO]将查询命令推送到数据库服务器，得到用户信息【list]
        List<Users> userlist=dao.find();
        //2.[调用响应对象】将用户信息结合table标签写入到响应体
            //1)通过响应对象，索要输出流
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
            //2)通过输出流将执行结果写到响应体中
        out.print("<table border='2' align='center'");
        out.print("<tr>");
        out.print("<td>用户编号</td>");
        out.print("<td>用户姓名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户邮箱</td>");
        out.print("<td>操作</td>");
        out.print("</tr>");
            for(Users users:userlist){
                out.print("<tr>");
                out.print("<td>"+users.getUserId()+"</td>");
                out.print("<td>"+users.getUserName()+"</td>");
                out.print("<td>"+users.getPassword()+"</td>");
                out.print("<td>"+users.getSex()+"</td>");
                out.print("<td>"+users.getEamil()+"</td>");
                out.print("<td><a href='/myweb/delete?userid="+users.getUserId()+"'>删除用户</a></td>");
                out.print("</tr>");
            }
        out.print("</table>");
    }
}
