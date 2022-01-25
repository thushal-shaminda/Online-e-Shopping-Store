<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

body {

  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}

#profile {
 border-collapse: collapse;
 width: 100%;
 margin: 10px 100px;
}

#profile td {
  text-align: left;
  padding: 8px;
  width: 50%;
}

#all td{
  text-align: left;
  padding: 8px;
  width: 50%;
}

#profile tr:nth-child(even){background-color: #f2f2f2}
#profile tr:hover{background-color: #ddd}

#button1 {
  width: 40%;
  background-color: #FE980F;
  color: white;
  padding: 14px 20px;
   margin: 8px 300px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

#button1:hover {
  background-color: white;
  padding: 12px 18px;
  border: 2px solid #FE980F;
  color: black;
  
}

#button2 {
  width: 40%;
  background-color: #ff2e01;
  color: white;
  padding: 14px 20px;
  margin: 8px 300px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

#button2:hover {
  background-color: white;
  padding: 12px 18px;
  border: 2px solid #ff2e01;
  color: black;
  
}

.login {
background-color: white;

  
  border-radius: 5px;
  overflow: hidden;    
  padding: 8px 50px;
  margin: 10px 100px;
  
}

</style>
<meta charset="ISO-8859-1">

<title>Seller Profile</title>
<jsp:include page="/header.jsp"></jsp:include>
</head>
<body>

<%
	if(session.getAttribute("sellerID")==null){
		response.sendRedirect("sellerlogin.jsp");
	}
%>

<div class="login">	
<table id="all">
<tr>
	<td><table id="profile">

	<c:forEach var="sel" items="${selDetails}">
	
	<c:set var="sellerID" value="${sel.sellerID}" />
	<c:set var="fullname" value="${sel.fullname}" />
	<c:set var="address" value="${sel.address}" />
	<c:set var="nic" value="${sel.nic}" />
	<c:set var="phone" value="${sel.phone}" />
	<c:set var="email" value="${sel.email}" />
	<c:set var="username" value="${sel.username}" />
	<c:set var="password" value="${sel.password}" />
	<c:set var="producttypes" value="${sel.producttypes}" />
	
	<tr>
	<th><h1>My Profile</h1></th>
	</tr>
  <tr>
    <td>My ID </td>
    <td> ${sel.sellerID} </td>
  </tr>
  <tr>
    <td>Full Name </td>
    <td>${sel.fullname}</td>
  </tr>

  <tr>
    <td>Address </td>
    <td>${sel.address}</td>
  </tr>
  <tr>
    <td>NIC Number </td>
    <td>${sel.nic}</td>
  </tr>
  <tr>
    <td>Phone Number </td>
    <td>${sel.phone}</td>
  </tr>
  <tr>
    <td>Email </td>
    <td>${sel.email}</td>
  </tr>
  <tr>
    <td>User Name </td>
    <td>${sel.username}</td>
  </tr>
  <tr>
    <td>Password </td>
    <td>${sel.password}</td>
  </tr>
  <tr>
    <td>Product Types </td>
    <td>${sel.producttypes}</td>
   
  </tr>
  
	</c:forEach>
</table></td>

<c:url value="updateseller.jsp" var="selupdate">

	<c:param name="sellerID" value="${sellerID}"/>
	<c:param name="fullname" value="${fullname}"/>
	<c:param name="address" value="${address}"/>
	<c:param name="nic" value="${nic}"/>
	<c:param name="phone" value="${phone}"/>
	<c:param name="email" value="${email}"/>
	<c:param name="username" value="${username}"/>
	<c:param name="password" value="${password}"/>
	<c:param name="producttypes" value="${producttypes}"/>
	

</c:url>

<td ><a href ="${selupdate}">

<input type ="button" name="update" value="Update Profile" id="button1" >
</a>

<c:url value="deleteseller.jsp" var="seldelete">
	<c:param name="sellerID" value="${sellerID}"/>
	<c:param name="fullname" value="${fullname}"/>
	<c:param name="address" value="${address}"/>
	<c:param name="nic" value="${nic}"/>
	<c:param name="phone" value="${phone}"/>
	<c:param name="email" value="${email}"/>
	<c:param name="username" value="${username}"/>
	<c:param name="password" value="${password}"/>
	<c:param name="producttypes" value="${producttypes}"/>
	
	
</c:url>

<form action="AddItem" method="get">
<input type ="submit" name="AddItem" value="AddItem" id="button1" >
</form>

<form action="MyItems" method="post">
<input type="submit" name="MyItems" value="My Items" id="button1">
</form>

<a href ="LogoutSellerServlet">
<input type ="button" name="logout" value="Logout" id="button1" >
</a>

<a href ="${seldelete}">

<input type ="button" name="delete" value="Delete Profile" id="button2" >
</a></td>

</tr>
</table>
</div>

<jsp:include page="/footer.jsp"></jsp:include>

	

  
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>