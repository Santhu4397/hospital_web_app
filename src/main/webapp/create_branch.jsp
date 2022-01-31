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
    <div style="background-color:SlateBlue;"  align="center"><h1> Branch From</h1></div>
    <div class="content">
      <form action="createbranch" method="post">
      <% String id=request.getParameter("id"); %>
        <div class="user-details">
         <div class="input-box">
            <span class="details">Hospital ID</span>
            <input type="text" placeholder="Enter Branch name" value="<%=id %>" name="H_id"required>
          </div>
          
          <div class="input-box">
            <span class="details">Branch name</span>
            <input type="text" placeholder="Enter Branch name" name="b_name"required>
          </div>
          
          <div class="input-box">
            <span class="details">phone</span>
            <input type="text" placeholder="Enter phone number" name="numb" required>
          </div>
          
          <div class="input-box">
            <span class="details">email</span>
            <input type="text" placeholder="Enter email" name="email"required>
          </div>
          
          
        
    </div>
  </div>
  <div class="container">
    <div style="background-color:SlateBlue;"  align="center"><h1> Addresss From</h1></div>
    <div class="content">
     
        <div class="user-details">
          <div class="input-box">
            <span class="details"> Address</span>
            <input type="text" placeholder="Enter address" name="address"required>
          </div>
          
          <div class="input-box">
            <span class="details">State</span>
            <input type="text" placeholder="Enter your message" name="State" required>
          </div>
          <div class="input-box">
            <span class="details">PIN</span>
            <input type="text" placeholder="Enter your number" name="pin"required>
          </div>
         
          
        <div class="button">
          <input type="submit" value="submit">
        </div>
      </form>
    </div>
  </div>
</body>
</html>