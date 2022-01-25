<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Item</title>
<link rel="stylesheet" href="css/updateItems.css">
<jsp:include page="/header.jsp"></jsp:include>

</head>
<body>
<%
	if(session.getAttribute("sellerID")==null){
		response.sendRedirect("sellerlogin.jsp");
	}
%>

<%
	String sellerID = request.getParameter("sellerID");
	String itemID = request.getParameter("itemID");
	String itemName = request.getParameter("itemName");
	String itemCategory = request.getParameter("itemCategory");
	String qty = request.getParameter("qty");
	String itemPrice = request.getParameter("itemPrice");
	String itemDesc = request.getParameter("itemDesc");

%>

<div class="table-users">
   
   <form action="UpdateItem" method="post">
   
   <div class="header"><%=itemName %></div>
   <table cellspacing="0">
   		<tr></tr>
   		<tr>
			<td>Item ID</td>
			<td width="50%"><input type="text" name="itemID" value="<%=itemID %>" readonly></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="itemName" value="<%=itemName %>"></td>
		</tr>
		<tr>
			<td>Category</td>
			<td>
				<div class="select" >
					<select id="itemCategory" name="itemCategory" style="color: #000; border: 0px;">
				    	<option value="<%=itemCategory %>" selected ><%=itemCategory %></option>
						<option value="Electronic">Electronic</option>
						<option value="Fashion">Fashion</option>
						<option value="Home & Garden">Home & Garden</option>
						<option value="Sporting Goods">Sporting Goods</option>
						<option value="Toys">Toys</option>
						<option value="Work and Education">Work and Education</option>
					</select>
				</div>
			</td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><input type="text" name="qty" value="<%=qty %>"></td>
		</tr>
		<tr>
			<td>Price (Rs.)</td>
			<td><input type="text" name="itemPrice" value="<%=itemPrice %>"></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><textarea name="itemDesc"><%=itemDesc %></textarea></td>
			
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" name = "submit" value="Update Details" id="buttonEdit"></td>
		</tr>
   </table>
   </form>
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