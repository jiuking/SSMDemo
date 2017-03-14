<html>
<head>
    <script type="text/javascript" src="./resource/jquery-3.1.1.min.js"></script>
</head>
<body>
<h2>Hello New World!</h2>
<input type="button" value="退出" onclick="logout();" />
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
