<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import="javax.servlet.http.HttpServletRequest"%>   
   
<%@ page import="javax.servlet.http.HttpServletResponse"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/addItem.css">
<jsp:include page="/header.jsp"></jsp:include>
</head>

<body>

<%
	//check if a user already signed in
	if(session.getAttribute("sellerID")==null){
		response.sendRedirect("sellerlogin.jsp");
	}
%>

<form name="itemadd" action="AddItem" style="border:1px solid #ccc" method="post">
  <div class="container">
    <h1 style="color: #FE980F;">Add new item</h1>
    <p>Please fill in this form to add an item.</p>
    <hr>

    <div class="form__group field">
  		<input type="input" class="form__field" name="itemName" id='itemName' required />
 	 	<label for="itemName" class="form__label">Item Name</label>
	</div><br>

	<div class="form__group field">
	<div class="select">
    <label for="itemCategory" style="color: #9b9b9b; padding-right: 20px; border: 0px;"><b>Item Category</b></label>
    
    <select id="itemCategory" name="itemCategory" width="50%" style="color: #000; border: 0px;">
    	<option value="" selected disabled>Please select your item category</option>
		<option value="Electronic">Electronic</option>
		<option value="Fashion">Fashion</option>
		<option value="Home & Garden">Home & Garden</option>
		<option value="Sporting Goods">Sporting Goods</option>
		<option value="Toys">Toys</option>
		<option value="Work and Education">Work and Education</option>
	</select>
	</div></div>
    <br>
    
   <!-- to avoid entering letters in quantity and price fields -->
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
  		<input type="input" class="form__field" name="qty" id='qty' onkeypress="return isNumber(event)" required />
 	 	<label for="qty" class="form__label">Quantity</label>
	</div><br><br>
    
    <div class="form__group field">
  		<input type="input" class="form__field" name="itemPrice" id='itemPrice' onkeypress="return isNumber(event)" required />
 	 	<label for="itemPrice" class="form__label">Item Price (Rs.)</label>
	</div><br>
    
    <div class="form__group field">
  		<input type="input" class="form__field" name="itemDesc" id='itemDesc' required />
 	 	<label for="itemDesc" class="form__label">Description</label>
	</div><br>
	
	<div class="form__group field">
	    <label for="itemPhoto" style="color: #9b9b9b"><b>Upload an Image</b></label>
	    <input type="file" class="file-browser" name="photo" id="photo" size="50"/><br>
	</div>
	
    <div class="form__group field">
    <div class="clearfix">
      <button type="submit" class="addItemButton">Add Item</button>
      <button type="reset" class="cancelbtn">Reset</button>
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
