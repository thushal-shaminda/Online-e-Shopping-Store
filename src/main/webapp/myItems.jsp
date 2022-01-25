<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.ItemUtil"%>
<%@page import="model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlet.MyItemsServlet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Items</title>

<link rel="stylesheet" href="css/myItems.css">

<jsp:include page="/header.jsp"></jsp:include>

</head>
<body>

<%
	if(session.getAttribute("sellerID")==null){
		response.sendRedirect("sellerlogin.jsp");
	}
%>

<div class="table-users">
   <div class="header">My Items</div>
 <form action="MyItems" method="get">
   <table>
      <tr>
      	 <th>Item ID</th>
         <th>Picture</th>
         <th>Name</th>
         <th>Category</th>
         <th>Quantity</th>
         <th>Price (Rs.)</th>
         <th width="300">Description</th>
         <th>Options</th><th></th>
      </tr>
      
<c:forEach var="item" items="${items}">
			
      <tr>
      	 <td>${item.itemNumber }</td>
         <td><img class="imgPic" src="data:image/gif;base64,${item.itemPhoto }" /></td>
         <td>${item.itemName }</td>
         <td>${item.itemCategory }</td>
         <td>${item.qty }</td>
         <td>${item.itemPrice }</td>
         <td>${item.itemDesc }</td>
         <td>
         	<!-- to send the item details to the servlet -->
         	<form name="edit" action="updateItem.jsp"></form>
         	<form name="edit" action="updateItem.jsp" method="post">
         		<input type="hidden" name="itemID" value="${item.itemNumber }">
         		<input type="hidden" name="itemName" value="${item.itemName }">
         		<input type="hidden" name="itemCategory" value="${item.itemCategory }">
         		<input type="hidden" name="qty" value="${item.qty }">
         		<input type="hidden" name="itemPrice" value="${item.itemPrice }">
         		<input type="hidden" name="itemDesc" value="${item.itemDesc }">
         		<input type="hidden" name="sellerID" value="${sellerID }">
				<input form="edit" type="submit" name="EditItems" value="Edit" id="buttonEdit">
         	</form>

         	<form action="DeleteItem" method="post">
         		<input type="hidden" name="itemID" value="${item.itemNumber }">
				<input type="submit" name="DeleteItems" value="Delete" id="buttonDelete">
         	</form>
         
         </td>
         <td></td>
      </tr>
      
</c:forEach>

      
   </table>
  </form>
</div>
<br><br>
<jsp:include page="/footer.jsp"></jsp:include>

	

  
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>