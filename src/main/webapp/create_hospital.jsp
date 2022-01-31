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
<%@ include file="admin_navbar.jsp" %>
  <div class="container">
    <div style="background-color:SlateBlue;"  align="center"><h1> Hospital Registration From</h1></div>
    <div class="content">
      <form action="createhospital" method="post">
        <div >
          <div >
            <span class="details">Hospital Name</span>
            <input type="text" placeholder="Enter Hospital name" name="H_name" required>
          </div>
          
          <div class="input-box">
            <span class="details">Website</span>
            <input type="text" placeholder="Enter website address" name="H_web"required>
          </div>
          <div class="input-box">
            <span class="details">GST Number</span>
            <input type="text" placeholder="Enter GST number" name="H-number"required>
          </div>
         
          
       
        <div class="button">
          <input type="submit" value="submit">
        </div>
      </form>
    </div>
  </div>
</body>
</html>