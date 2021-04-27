<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/30
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    Question question3=(Question) request.getAttribute("key");
%>
<body>
<center>
    <form action="/myweb/question/update">
        <table border="2">
            <tr>
                <td>题目编号</td>
                <td><input type="text" name="questionid" value="<%=question3.getQuestionid()%>"></td>
            </tr>
            <tr>
                <td>题目:</td>
                <td><input type="text" name="title" value="<%=question3.getTitle()%>"></td>
            </tr>
            <tr>
                <td>A</td>
                <td><input type="text" name="optionA" value="<%=question3.getOptionA()%>"></td>
            </tr>
            <tr>
                <td>B</td>
                <td><input type="text" name="optionB" value="<%=question3.getOptionB()%>"></td>
            </tr>
            <tr>
                <td>C</td>
                <td><input type="text" name="optionC" value="<%=question3.getOptionC()%>"></td>
            </tr>
            <tr>
                <td>D</td>
                <td><input type="text" name="optionD" value="<%=question3.getOptionD()%>"></td>
            </tr>
            <tr>
                <td>正确答案:</td>
                <td><input type="radio" name="answer" value="A" <%="A".equals(question3.getAnswer())? "checked":""%>>A
                    <input type="radio" name="answer" value="B"<%="B".equals(question3.getAnswer())? "checked":""%>>B
                    <input type="radio" name="answer" value="C"<%="C".equals(question3.getAnswer())? "checked":""%>>C
                    <input type="radio" name="answer" value="D"<%="D".equals(question3.getAnswer())? "checked":""%>>D
                </td>
            </tr>
            <div>
                <tr>
                    <td>
                        <input type="submit" value="更新试题:" style="vertical-align:middle;">
                    </td>
                    <td>
                        <input type="reset" align="right" style="vertical-align: center">
                    </td>
                </tr>
            </div>
        </table>
        </form>
</center>
</body>
</html>
