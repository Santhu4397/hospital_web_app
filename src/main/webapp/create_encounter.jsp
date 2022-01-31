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
    <div style="background-color:SlateBlue;"  align="center"><h1> Encounter From</h1></div>
    <div class="content">
      <form action="createencounter" method="post">
        <div class="user-details">
        <%String id= request.getParameter("id"); %>
          <div class="input-box">
            <span class="details">ID</span>
            <input type="text" placeholder="Enter ID"  name="p_id" readonly="readonly" value="<%=id%>">
          </div>
          
          
          <div class="input-box">
            <span class="details">Date time</span>
            <input type="datetime-local" placeholder="Enter Admited Date&Time " required name="date">
          </div>
          <div class="input-box">
            <span class="details">message</span>
            <input type="text" placeholder="Enter your message" required name="message">
          </div>
         
          
        <div class="button">
          <input type="submit" value="submit">
        </div>
      </form>
    </div>
  </div>
</body>
</html>