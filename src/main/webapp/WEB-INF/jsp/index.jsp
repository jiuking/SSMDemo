<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="./resource/jquery-3.1.1.min.js"></script>
</head>
<body>
<h2>Hello New World!</h2>
<input type="button" value="退出" onclick="logout();" />
<form name="userForm2" action="./upload/uploadFile" enctype="multipart/form-data" method="post">
<div id="newUpload2">
    <input type="file" name="file">
</div>
<input type="submit" value="上传" >
</form>
<script>
    function logout(){
        $.ajax({
            type: "POST",
            url: "./logout",
            data: $("#formId").serialize(),
            async: false,
            error: function (e) {
                console.log(e)
                alert("Connection error");
            },
            success: function (data) {
                console.log(data)
                alert(data.message);
                location.href="./index";
            }
        });
    }
</script>
</body>
</html>
