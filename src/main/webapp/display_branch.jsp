<%@page import="com.hospital.dto.Address"%>
<%@page import="com.hospital.dto.Branch"%>
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
<% List<Branch> list=(List<Branch>)request.getAttribute("list");%>
<%@ include file="admin_navbar.jsp" %>
<table>
  <caption>Branch Details</caption>
  <thead>
    <tr>
      <th scope="col">Id</th>
       <th scope="col">Branch Name</th>
      <th scope="col">Email</th>
      <th scope="col">Phone</th>
      
    </tr>
  </thead>
  <tbody>
  <%for(Branch Branch:list){%>
	  
 <tr>
      <td data-label="ID"><%=Branch.getId() %></td>
      <td data-label="Creater Name"><%=Branch.getB_name()%></td>
      <td data-label="ADmit Date and time"><%=Branch.getEmail() %></td>
      <td data-label="ADmit Date and time"><%=Branch.getPhone()%></td>
        
    </tr>
	  
	<%  }  %>
    
  </tbody>
</table>
<% List<Address> address=(List<Address>)request.getAttribute("addresses");%>
<table>
  <caption>Address Details</caption>
  <thead>
    <tr>
      <th scope="col">Id</th>
       <th scope="col">Address</th>
      <th scope="col">State</th>
      <th scope="col">PIN</th>
      
    </tr>
  </thead>
  <tbody>
  <%for(Address add:address){%>
	  
 <tr>
      <td data-label="ID"><%=add.getId() %></td>
      <td data-label="Creater Name"><%=add.getAddress()%></td>
      <td data-label="ADmit Date and time"><%=add.getState() %></td>
      <td data-label="ADmit Date and time"><%=add.getPin()%></td>
        
    </tr>
	  
	<%  }  %>
    
  </tbody>
</table>
</body>
</html>