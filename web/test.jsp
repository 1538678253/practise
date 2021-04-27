<%@ page import="java.util.List" %>
<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/31
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body><%List list=(List)request.getAttribute("key");
%>
<center>
    <form action="/myweb/question/score">
<table border="2" ALIGN="CENTER">
    <tr>
        <td>试题编号</td>
        <td>试题信息</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
        <td colspan="4" align="center">答案</td>
    </tr>
    <%
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
        <td><input type="radio" name="<%=question.getQuestionid()%>" VALUE="A">A</td>
        <td><input type="radio" name="<%=question.getQuestionid()%>" VALUE="B">B</td>
        <td><input type="radio" name="<%=question.getQuestionid()%>" VALUE="C">C</td>
        <td><input type="radio" name="<%=question.getQuestionid()%>" VALUE="D">D</td>
    </tr>
    <%
        }
    %>
    <TR>
        <TD colspan="4"><input type="submit" value="交卷"></TD>
        <td colspan="6" align="right"><input type="reset"></td>
    </TR>
</table>
    </form>
</center>
</body>
</html>
