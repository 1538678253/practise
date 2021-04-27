package com.bjpowernode.Dao;

import com.bjpowernode.Util.JdbcUtil;
import com.bjpowernode.entity.Users;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    String sql1,sql2,sql3,sql4;
   private JdbcUtil jdu=new JdbcUtil();
    public int add(Users usr ,HttpServletRequest request){
        sql1="insert into users (UserName,password,sex,eamil)"+
                "values(?,?,?,?)";
        PreparedStatement ps=jdu.createStatement(sql1,request);
        int result=0;
        try {
            ps.setString(1,usr.getUserName());
            ps.setString(2,usr.getPassword());
            ps.setString(3,usr.getSex());
            ps.setString(4,usr.getEamil());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdu.close(request);
        }
        return result;
    }

    public int add(Users usr){
       sql1="insert into users (UserName,password,sex,eamil)"+
               "values(?,?,?,?)";
        PreparedStatement ps=jdu.createStatement(sql1);
        int result=0;
        try {
            ps.setString(1,usr.getUserName());
            ps.setString(2,usr.getPassword());
            ps.setString(3,usr.getSex());
            ps.setString(4,usr.getEamil());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdu.close();
        }
        return result;
    }
    public List find(){
        ResultSet rs=null;
        List list=new ArrayList();
        sql2="select * from users";
        PreparedStatement ps=jdu.createStatement(sql2);
        try {
           rs=ps.executeQuery();
            //取出结果集里面的数据，放在users里面，并把user放到集合里面。
            // 最后返回这个集合，那么调用这个方法就会返回带有结果集的数组
            while (rs.next()){
                Integer userId=rs.getInt("UseId");
                String usename=rs.getString("UserName");
                String password=rs.getString("password");
                String sex=rs.getString("sex");
                String email=rs.getString("eamil");
                Users users=new Users(userId,usename,password,sex,email);
                list.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdu.close(rs);
        }
        return list;
    }
    public int delete(String userid){
        sql3="delete from users where UseId=?";
        PreparedStatement ps=jdu.createStatement(sql3);
        int resut=0;
        try {
            ps.setString(1,userid);
            resut=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
          jdu.close();
        }
    return resut;
    }
    public int login(String username,String password){
        int result=3;
        sql4="select count(*) from users where UserName=? and password=?";
        PreparedStatement ps=jdu.createStatement(sql4);
        try {
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
             result=rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdu.close();
        }
        return result;
    }
}
