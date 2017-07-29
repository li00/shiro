
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登陆页面</title>
  </head>
  <body>
   <h1>登陆页面</h1>
   <form action="/shiro/login" method="post">
     用户名: <input type="text" name="username"><br/>
     密&nbsp;&nbsp;&nbsp;码: <input type="password" name="pwd"><br/>
     <input type="submit" value="登陆">
   </form>
  </body>
</html>
