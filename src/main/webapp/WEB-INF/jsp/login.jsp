<%--
  Created by IntelliJ IDEA.
  User: Bravowhale
  Date: 2017/3/10
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="../ssmdemo/login" method="post">
    name:<input type="text" name="username" /><br/>
    pawd:<input type="password" name="pwd" /><br/>
    <input type="hidden" name="hidden" value="隐藏" />
    <input type="submit" value="submit"/>
</form>
</body>
</html>
