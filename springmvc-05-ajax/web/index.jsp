<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/5
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
      $(function () {
          $("#username").keyup(function () {
              $.ajax({
                  url:"${pageContext.request.contextPath}/ajax",
                  data:{"name":$("#username").val()},
                  success: function(result){
                      var html = "";
                      for(var i=0; i<result.length;i++){
                          var date = new Date(result[i].birth);
                          html += "<tr>" +
                              "<td>" + result[i].id + "</td>"+
                              "<td>" + result[i].username + "</td>"+
                              "<td>" + date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate() + " " +
                              date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "</td>"+
                              "</tr>"
                      }
                      $("#result").html(html);
                  }
              });
          });
          $("#myname").keyup(function () {
              $.ajax({
                  url:"${pageContext.request.contextPath}/myname",
                  data:{"myname":$("#myname").val()},
                  success:function (result) {
                      if (result == "ok"){
                          $("#mynameInfo").css("color","green");
                      }
                      else{
                          $("#mynameInfo").css("color","red");
                      }
                      $("#mynameInfo").html(result);
                  }
              });
          });
          $("#mypassword").keyup(function () {
              $.ajax({
                  url:"${pageContext.request.contextPath}/myname",
                  data:{"mypassword":$("#mypassword").val()},
                  success:function (result) {
                      if (result == "ok"){
                          $("#mypasswordInfo").css("color","green");
                      }
                      else{
                          $("#mypasswordInfo").css("color","red");
                      }
                      $("#mypasswordInfo").html(result);
                  }
              });
          });
      });
    </script>
  </head>
  <body>
  <p>键盘弹起，获取时间</p>
  <input type="text" id="username">
  <div style="color: red">
    <table>
      <thead>
        <tr>
          <td>id</td>
          <td>username</td>
          <td>birth</td>
        </tr>
      </thead>
      <tbody id="result">
      </tbody>
    </table>
  </div>
  <hr>
  <p>校验用户名</p>
  <p>
    用户名：<input type="text" id="myname">
    <span id="mynameInfo"></span>
  </p>
  <p>
    密码：<input type="text" id="mypassword">
    <span id="mypasswordInfo"></span>
  </p>

  </body>
</html>
