
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% String path = request.getContextPath(); %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录页面</title>
</head>

<body>
    <form action="<%=path%>/servlet/LoginServlet" id="form" method="post">
        登录名:<input type="text" id="username" name="username"><br/>
        密码为:<input type="password" id="password" name="password"><br/>
        <button type="button" name="loginButton" onclick="loginVerify()">登录</button>
    </form>
</body>

<script>
    function loginVerify(){
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        document.getElementById("form").submit();
    }
</script>

</html>