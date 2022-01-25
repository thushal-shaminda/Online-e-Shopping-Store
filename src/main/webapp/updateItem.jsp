<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Item</title>
<link rel="stylesheet" href="css/addItem.css">
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

<form name="itemadd" action="UpdateItem" style="border:1px solid #ccc" method="post">
  <div class="container">
    <h1 style="color: #FE980F;"><%=itemName %></h1>
    <p>Please update the fields that you want to update.</p>
    <hr>

	<div class="form__group field">
  		<input type="input" class="form__field" name="itemID" id='itemID' value="<%=itemID %>" readonly/>
 	 	<label for="itemName" class="form__label">Item ID</label>
	</div><br>

    <div class="form__group field">
  		<input type="input" class="form__field" name="itemName" id='itemName' value="<%=itemName %>"/>
 	 	<label for="itemName" class="form__label">Item Name</label>
	</div><br>

	<div class="form__group field">
	<div class="select">
    <label for="itemCategory" style="color: #9b9b9b; padding-right: 20px; border: 0px;"><b>Item Category</b></label>
    
    <select id="itemCategory" name="itemCategory" width="50%" style="color: #000; border: 0px;">
    	<option value="<%=itemCategory %>" selected><%=itemCategory %></option>
		<option value="Electronic">Electronic</option>
		<option value="Fashion">Fashion</option>
		<option value="Home & Garden">Home & Garden</option>
		<option value="Sporting Goods">Sporting Goods</option>
		<option value="Toys">Toys</option>
		<option value="Work and Education">Work and Education</option>
	</select>
	</div></div>
    <br>
    
    <script type="text/javascript">
	   function isNumber(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		        return false;
		    }
		    return true;
		}
   	</script>
   
    <div class="form__group field">
  		<input type="input" class="form__field" name="qty" id="qty" onkeypress="return isNumber(event)" value="<%=qty %>" />
 	 	<label for="qty" class="form__label">Quantity</label>
	</div><br><br>
    
    <div class="form__group field">
  		<input type="input" class="form__field" name="itemPrice" id="itemPrice" onkeypress="return isNumber(event)" value="<%=itemPrice %>" />
 	 	<label for="itemPrice" class="form__label">Item Price (Rs.)</label>
	</div><br>
    
    <div class="form__group field">
  		<input type="input" class="form__field" name="itemDesc" id='itemDesc' value="<%=itemDesc %>" />
 	 	<label for="itemDesc" class="form__label">Description</label>
	</div><br>
	
    <div class="form__group field">
    <div class="clearfix">
      <button type="submit" class="addItemButton">Update Details</button>
    </div></div><br><br>
  </div>
</form>

	<jsp:include page="/footer.jsp"></jsp:include>

	

  
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>