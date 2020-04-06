<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/6
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>上传文件</h1>
  <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="上传">
  </form>
  <form action="${pageContext.request.contextPath}/upload2" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="上传2">
  </form>
  </body>

  <h1>下载文件</h1>
  <a href="./statics/1.png">点击链接1</a>
  <a href="${pageContext.request.contextPath}/download">下载文件</a>
</html>
