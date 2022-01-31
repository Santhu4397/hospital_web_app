<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body style="background-color:Tomato;" >
<h1 style="background-color:Gray;" align="center">Hospital Login Page</h1>

<form action="login" method="post">
 
  <div class="container">
    <label for="uname" ><b>Username</b></label>
    <input type="text"  placeholder="Enter Username" name="uname" required><br>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required><br>

    <button type="submit">Login</button>
   	 <a href="create_user.jsp">Create new user</a>
  </div>

  
</form>

</body>
</html>