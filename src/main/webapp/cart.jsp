<%@page import="model.Item"%>
<%@page import="model.ItemUtil"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cart | E-Store</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
	<link href="cart.css" rel="stylesheet">        
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>

	<jsp:include page="/header.jsp"></jsp:include>
	

	<section id="cart_items">
		<div class="container">			
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Product</td>
							<td class="description"></td>
							<td class="price">Unit Price</td>
							<td class="quantity">Quantity</td>			
							<td></td>
							<td></td>
						</tr>
					</thead>
					
					
					<%float tot=0;%>
                                             
		   					 <% List<Item> itemlist1=ItemUtil.getcartItemList();%>
		   					 <%for(Item i:itemlist1){ %>
		   					 
		   					 <%tot=tot+(i.getItemPrice())*(i.getQty()); %>
					
					<tbody>
						<tr>
							<td class="cart_product">
								<a href=""><img style="width: 80px; height: 80px;"src="data:image/gif;base64,<%=i.getItemPhoto() %>" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><%=i.getItemName() %></h4>
								<p>Category: <%=i.getItemCategory() %></p>
							</td>
							<td class="cart_price">
								<p>Rs. <%=i.getItemPrice() %></p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<form action="edititem" id="edititem" method="post">
                                		<input type="text" form="edititem" class="form-control-input-text" name="quantity" value="<%=i.getQty() %>">
                                		<input type="hidden" name="edit" value="<%=i.getItemNumber()%>"></td>
                                		<td><button type="submit" form="edititem" class="btn-btn-light-update" onkeypress="return isNumber(event)" > Update </button></td>                                		
                                	</form>
									</div>
															
							
							<td class="cart_delete">
								<form action="deleteCartitem" method="post">                             	
                                	<button type="submit" form="deleteitem" class="btn-btn-light-delete" name="delete" value="<%=i.getItemNumber()%>"> Remove </button>                                	
                                </form>
							</td>
						</tr>
						<%} %>						
					</tbody>
				</table>
			</div>
		</div>		
	</section>

	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>What would you like to do next?</h3>
				<p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p>
			</div>
			<div class="row">				
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Discounts <span>Rs. 0.00</span></li>							
							<li>Shipping Cost <span>Free</span></li>
							<li>Total <span>Rs. <%=tot %></span></li>
						</ul>
							<form action="orderitem" method="post" >
							<input type="hidden" name="total" value="<%=tot%>">
							<input type="submit" class="btn-btn-default-check_out" value="Proceed to Check Out">
							</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	
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

	<jsp:include page="/footer.jsp"></jsp:include>
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>