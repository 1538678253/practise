package com.bjpowernode;

import com.bjpowernode.Util.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OneListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map map=new HashMap();
        JdbcUtil jdbcUtil=new JdbcUtil();
        for (int i=0;i<=20;i++) {
            Connection con = jdbcUtil.createCon();
            System.out.println(con);
            map.put(con,true);
        }
        //1.索要全局作用域，把map放在全局作用域里面，这样map在服务器销毁时才会关闭
            ServletContext application = sce.getServletContext();
        //2.把集合放在全局作用域里面
            application.setAttribute("keys1",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //1.在关闭服务器时把通道关闭
        ServletContext application = sce.getServletContext();
        Map map=(Map) application.getAttribute("keys1");
        Set set=map.keySet();
        Iterator it=set.iterator();
        while (it.hasNext()){
            Connection con=(Connection) it.next();
            System.out.println(con);
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

