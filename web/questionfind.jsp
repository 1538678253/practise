<%@ page import="java.util.List" %>
<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/30
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="2" ALIGN="CENTER">
    <tr>
        <td>试题编号</td>
        <td>试题信息</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
        <td>正确答案</td>
        <td colspan="2" align="center">操作</td>
    </tr>
<%
    List list=(List)request.getAttribute("key");
    for (int i=0;i<list.size();i++){
        Question question=(Question) list.get(i);
%>
<tr>
    <td><%=question.getQuestionid()%></td>
    <td><%=question.getTitle()%></td>
    <td><%=question.getOptionA()%></td>
    <td><%=question.getOptionB()%></td>
    <td><%=question.getOptionC()%></td>
    <td><%=question.getOptionD()%></td>
    <td><%=question.getAnswer()%></td>
    <td><a href='/myweb/question/delete?questionid=<%=question.getQuestionid()%>'>删除试题</a></td>
    <td><a href='/myweb/question/information?questionid=<%=question.getQuestionid()%>'>详细信息</a></td>
</tr>
<%
    }
%>
</table>
</body>
</html>
