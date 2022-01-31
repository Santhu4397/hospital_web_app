<%@page import="com.hospital.dto.MedOrder"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
table {
  border: 1px solid #ccc;
  border-collapse: collapse;
  margin: 0;
  padding: 0;
  width: 100%;
  table-layout: fixed;
}

table caption {
  font-size: 1.5em;
  margin: .5em 0 .75em;
}

table tr {
  background-color: #f8f8f8;
  border: 1px solid #ddd;
  padding: .35em;
}

table th,
table td {
  padding: .625em;
  text-align: center;
}

table th {
  font-size: .85em;
  letter-spacing: .1em;
  text-transform: uppercase;
}

@media screen and (max-width: 600px) {
  table {
    border: 0;
  }

  table caption {
    font-size: 1.3em;
  }
  
  table thead {
    border: none;
    clip: rect(0 0 0 0);
    height: 1px;
    margin: -1px;
    overflow: hidden;
    padding: 0;
    position: absolute;
    width: 1px;
  }
  
  table tr {
    border-bottom: 3px solid #ddd;
    display: block;
    margin-bottom: .625em;
  }
  
  table td {
    border-bottom: 1px solid #ddd;
    display: block;
    font-size: .8em;
    text-align: right;
  }
  
  table td::before {
    /*
    * aria-label has no advantage, it won't be read inside a table
    content: attr(aria-label);
    */
    content: attr(data-label);
    float: left;
    font-weight: bold;
    text-transform: uppercase;
  }
  
  table td:last-child {
    border-bottom: 0;
  }
}
</style>
</head>
<body>
<% List<MedOrder> list=(List<MedOrder>)request.getAttribute("list");%>
<%@ include file="staf_navbar.jsp" %>
<table>
  <caption>Order Details</caption>
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Creator name</th>
      <th scope="col">Date and time</th>
      <th scope="col">Message</th>
       <th>Create Item</th>
          <th>View Item</th>
    </tr>
  </thead>
  <tbody>
  <%for(MedOrder medOrder:list){%>
	  
 <tr>
      <td data-label="ID"><%=medOrder.getId() %></td>
      <td data-label="Creater Name"><%=medOrder.getCreatorName()%></td>
      <td data-label="ADmit Date and time"><%=medOrder.getCreatedDateTime() %></td>
      <td data-label="ADmit Date and time"><%=medOrder.getMessage() %></td>
        <td><a href="create_item.jsp?id=<%=medOrder.getId() %>">Create Item</a></td>
        <td><a href="getitem?id=<%=medOrder.getId() %>">view</a></td>
    </tr>
	  
	<%  }  %>
    
  </tbody>
</table>
</body>
</html>