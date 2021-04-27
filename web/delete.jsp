<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/30
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
   Integer result= (Integer) request.getAttribute("key");
   if (result==0){
%>
    <td style="color: blue " align="center" >试题删除失败</td>
<%   }else {%>
    <td style="color: blue " align="center" >试题删除成功</td>
<%}%>
</body>
</html>
