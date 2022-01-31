<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CreateUser</title>
</head>
<body style="background-color:Orange;"align="center">
<!-- MediumSeaGreen,Tomato,DodgerBlue,Gray,SlateBlue,Orange,Viole -->
  <div class="container">
    <div style="background-color:SlateBlue;"  align="center"><h1> User Registration From</h1></div>
    <div class="content">
      <form action="createuser" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Full Name</span>
            <input type="text" placeholder="Enter your name" name="name" required>
          </div>
          
          <div class="input-box">
            <span class="details">Email</span>
            <input type="text" placeholder="Enter your email" name="email" required>
          </div>
          <div class="input-box">
            <span class="details">Phone Number</span>
            <input type="text" placeholder="Enter your number" name="phone"required>
          </div>
          <div class="input-box">
            <span class="details">Password</span>
            <input type="text" placeholder="Enter your password" name="password" required>
          </div>
          <div>Role <select name="role" >
            <option value="admin" >Admin</option>
            <option value="staff" >Staff</option>
            <option value="user" >User</option>
           
        </select></div>
        <div name="gender">Gender
          <input type="radio"  value="femle">Female
          <input type="radio"  value="male">Male
          <input type="radio"  value="other">other
          </div>
        </div>
        <div class="button">
          <input type="submit" value="Register">
        </div>
      </form>
    </div>
  </div>


</body>
</html>