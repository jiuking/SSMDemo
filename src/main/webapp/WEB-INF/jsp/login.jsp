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
    <script type="text/javascript" src="./resource/jquery-3.1.1.min.js"></script>
</head>
<body>
<form id="formId">
    name:<input id="name" type="text" name="username" /><br/>
    pawd:<input id="pwd" type="password" name="pwd" /><br/>
    <input type="hidden" name="hidden" value="隐藏" />
    验证码：<input type="text" name="validateCode" />&nbsp;&nbsp;<img id="validateCodeImg" src="./validateCode" />
    <input type="button" value="submit" onclick="test();"/>

</form>
<script>
    function test() {
        $.ajax({
            type: "POST",
            url: "./login",
            data: $("#formId").serialize(),
            async: false,
            error: function (e) {
                console.log(e)
                alert("Connection error");
            },
            success: function (data) {
                console.log(data)
                if(data.status == "F"){
                    alert(data.message);
                    location.href="./index";
                    return;
                }
                location.href="./success";
            }
        });
    }
</script>
</body>
</html>
