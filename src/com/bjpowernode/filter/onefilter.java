package com.bjpowernode.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class onefilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.获取请求行
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session=null;
        //获取请求地址
        String uri=request.getRequestURI();
        if (uri.indexOf("login")!=-1 ||"/myweb/".equals(uri)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
         session=request.getSession(false);
        if (session!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            request.getRequestDispatcher("/login-error.html").forward(servletRequest,servletResponse);
        }
    }
}
