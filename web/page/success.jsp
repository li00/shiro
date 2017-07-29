
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="shir" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>登陆成功页面</h1>
    Welcome:<shiro:principal></shiro:principal>
    <a href="/page/user.jsp">user page</a>
    <shir:hasRole name="admin">
        <a href="/page/admin.jsp">admin page</a>
    </shir:hasRole>
    <br/>
    <a href="/shiro/shiroservice">Test ShiroService</a>
    <a href="/shiro/logout">logout</a>
</body>
</html>
