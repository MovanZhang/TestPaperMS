<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <% 
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    %>
    <title>TestLogin</title>
    <link rel="stylesheet" type="text/css" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
</head>
<body>
    <div class="container">
          <h2>Please input your name and password</h2>
          <form action="${basepath}doLogin">
          
              <div class="input-group">
                <span class="input-group-addon" >UserName</span>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">Password</span>
                <input type="password" id="password" name="password" class="form-control" >
            </div>
            <br>    
            <div class="input-group">
                <button id="fat-btn" class="btn btn-success" type="submit">登录</button>
            </div>
              
          </form>
          
    </div>
<script type="text/javascript" src="bower_components/angular/angular.min.js"></script>
</body>
</html>