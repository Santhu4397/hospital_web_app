<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<body style="background-color:Orange;"align="center">
<!-- MediumSeaGreen,Tomato,DodgerBlue,Gray,SlateBlue,Orange,Viole -->
<%@ include file="staf_navbar.jsp" %>
  <div class="container">
    <div style="background-color:SlateBlue;"  align="center"><h1> Item From</h1></div>
    <div class="content">
      <form action="createitem" method="post">
     <% String id=request.getParameter("id"); %>
       <div class="input-box">
            <span class="details"> Order ID</span>
            <input type="text" value="<%=id %>" name="id"required readonly="readonly">
          </div>
       
        
          <div class="input-box">
            <span class="details"> Name</span>
            <input type="text" placeholder="Enter Item name"  name="name"required>
          </div>
         
          <div class="input-box">
            <span class="details">quantity</span>
            <input type="number" placeholder="Enter Item quantity" required name="qty">
          </div>
         <div class="input-box">
            <span class="details">cost</span>
            <input type="number" placeholder="Enter Item cost" required name="cost">
          </div>
           <div class="input-box">
            <span class="details">message</span>
            <input type="text" placeholder="Enter Item Type " required name="message">
          </div>
        <div class="button">
          <input type="submit" value="submit">
        </div>
      </form>
    </div>
  </div>
</body>
</body>
</html>