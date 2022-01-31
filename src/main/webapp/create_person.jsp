<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:Orange;"align="center">
<!-- MediumSeaGreen,Tomato,DodgerBlue,Gray,SlateBlue,Orange,Viole -->
<%@ include file="staf_navbar.jsp" %>
  <div class="container">
    <div style="background-color:SlateBlue;"  align="center"><h1> Person Registration From</h1></div>
    <div class="content">
      <form action="createperson" method="post">
        <div >
          <div >
            <span class="details">Full Name</span>
            <input type="text" placeholder="Enter your name" name="U_name" required>
          </div>
          
          <div class="input-box">
            <span class="details">Email</span>
            <input type="text" placeholder="Enter your email" name="U_email"required>
          </div>
          <div class="input-box">
            <span class="details">Phone Number</span>
            <input type="text" placeholder="Enter your number" name="U-number"required>
          </div>
          <div >
            <span >Age</span>
            <input type="text" placeholder="Enter your age" name="U_age" required>
          </div>
          
        <div  class="gender">Gender
          <input type="radio"  value="femle" name="gender">Female
          <input type="radio"  value="male" name="gender">Male
          <input type="radio"  value="other"  name="gender">other
          </div>
        </div>
        <div class="button">
          <input type="submit" value="submit">
        </div>
      </form>
    </div>
  </div>
</body>
</html>