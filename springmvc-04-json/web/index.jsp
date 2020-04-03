<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/3
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <form action="/springmvc/mapping" method="post">
      <div>post方式</div>
      <input type="text" name="id" placeholder="id">
      <input type="text" name="username" placeholder="中文名字">
      <input type="text" name="password" placeholder="password">
      <input type="date" name="gmtCreate" placeholder="gmt_create">
      <input type="submit" value="post方式提交按钮">
    </form>

    <hr>此为分割线

    <form action="/springmvc/mapping" method="get">
      <div>get提交方式</div>
      <input type="text" name="username" placeholder="中文名字">
      <input type="submit" value="get方式提交按钮">
    </form>

  </body>
</html>
