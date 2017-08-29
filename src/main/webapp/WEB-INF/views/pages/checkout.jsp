<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- breadcrumbs -->
<div class="breadcrumbs">
	<div class="container">
		<ol class="breadcrumb breadcrumb1 animated wow slideInLeft"
			data-wow-delay=".5s">
			<li>
				<a href="${pageContext.request.contextPath}">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					Home
				</a>
			</li>
			<li class="active">Checkout Page</li>
		</ol>
	</div>
</div>
<!-- //breadcrumbs -->
<!-- checkout -->
<div class="checkout">
	<div class="container">
		<c:set var="totalitem" value="${0}" />
		<!-- <li>Total Service Charges <i>-</i> <span>$15.00</span></li> -->
		<c:forEach items="${cartsSession}" var="item">
			<c:set var="totalitem" value="${totalitem + item.quantity}" />
		</c:forEach>
		<h3 class="animated wow slideInLeft" data-wow-delay=".5s">
			Your shopping cart contains:
			<span>${totalitem} Products</span>
		</h3>
		<div class="checkout-right animated wow slideInUp"
			data-wow-delay=".5s">
			<form action="${pageContext.request.contextPath}/shopping/updatecart"
				method="post">
				<table class="timetable_sub">
					<thead>
						<tr>
							<th>SL No.</th>
							<th>Product Id</th>
							<th>Product</th>
							<th>Quantity</th>
							<th>Product Name</th>
							<th>Discount</th>
							<th>Price</th>
							<th>Remove</th>
						</tr>
					</thead>
					<!--  Dat bien dem cho so thu tu trong gio hang-->
					<c:set var="count" value="0" scope="page" />
					<c:forEach items="${cartsSession}" var="item">
						<c:set var="count" value="${count + 1}" scope="page" />
						<tr class="rem${count}">
							<td class="invert">${count}</td>
							<td class="invert">${item.product.id}</td>
							<td class="invert-image">
								<a
									href="${pageContext.request.contextPath}/views/viewproductdetails/${item.product.id}">
									<img src="<c:url value="/images/${item.product.image}" />"
										alt=" " class="img-responsive" />
								</a>
							</td>
							<td class="invert">
								<div class="quantity">
									<div class="quantity-select">
										<%-- <div class="entry value-minus">&nbsp;</div>
									<div class="entry value"><span>${item.quantity}</span></div>
									<div class="entry value-plus active">&nbsp;</div> --%>
										<input type="text" id="quantity${item.product.id}"
											name="quantity" value="${item.quantity }"
											style="text-align: center; width: 50px" />
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</div>
								</div>
							</td>
							<td class="invert">${item.product.name}</td>
							<td class="invert"><jsp:useBean id="now"
									class="java.util.Date" />
								<c:choose>
									<c:when
										test="${item.product.discountStartDate le now && item.product.discountEndDate ge now  && item.product.discount ne null}">
   										${item.product.discount}
 									 </c:when>
									<c:otherwise>
   										---
  									</c:otherwise>
								</c:choose>
							</td>
							<td class="invert">${item.product.price}</td>
							<td class="invert">
								<div class="rem">
									<div class="close${count}"></div>
								</div>
								<script>$(document).ready(function(c) {
								$('.close${count}').on('click', function(c){
									deleteitemnumber(${item.product.id});
									$('.rem${count}').fadeOut('slow', function(c){
										$('.rem${count}').remove();
									});
									});	  
								});
						   </script>
								<!-- xu ly onblur tren input quantity -->
								<script>$(document).ready(function(c) {
							   $("#quantity${item.product.id}").blur(function(){
								    /* alert("This input field has lost its focus."+${item.product.id}+$("#quantity${item.product.id}").val()); */
								    if ($("#quantity${item.product.id}").val()> ${item.product.quantity}) {swal(
								    		  'Oops...',
								    		  'The value you entered is greater than the number of available products!',
								    		  'error'
								    		);
								    
								    $("#quantity${item.product.id}").focus();
								    }
								    
								});  
								});
						   </script>
							</td>
						</tr>
					</c:forEach>
					<!--quantity-->
					<script>
									$('.value-plus').on('click', function(){
										var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)+1;
										divUpd.text(newVal);
									});

									$('.value-minus').on('click', function(){
										var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)-1;
										if(newVal>=1) divUpd.text(newVal);
									});
									</script>
					<!--quantity-->
				</table>
				<input type="submit" class="btn btn-success" value="Update Cart" />
			</form>
		</div>
		<div class="checkout-left">
			<div class="checkout-left-basket animated wow slideInLeft"
				data-wow-delay=".5s">
				<h4>Continue to basket</h4>
				<fmt:setLocale value="vi_VN" scope="session" />
				<ul>
					<c:forEach items="${cartsSession}" var="item">
						<c:choose>
							<c:when
								test="${item.product.discountStartDate le now && item.product.discountEndDate ge now && item.product.discount ne null}">
								<c:set var="discountafter" value="${1-item.product.discount}"
									scope="page" />
							</c:when>
							<c:otherwise>
								<c:set var="discountafter" value="1" scope="page" />
							</c:otherwise>
						</c:choose>
						<li>${item.product.name}<i>-</i>
							<span>
								<fmt:formatNumber
									value="${item.product.price*item.quantity*discountafter}"
									type="currency" />
							</span>
						</li>
					</c:forEach>
					<c:set var="total" value="${0}" />
					<!-- <li>Total Service Charges <i>-</i> <span>$15.00</span></li> -->
					<c:forEach items="${cartsSession}" var="item">
						<c:choose>
							<c:when
								test="${item.product.discountStartDate le now && item.product.discountEndDate ge now}">
								<c:set var="discountafter" value="${1-item.product.discount}"
									scope="page" />
							</c:when>
							<c:otherwise>
								<c:set var="discountafter" value="1" scope="page" />
							</c:otherwise>
						</c:choose>
						<c:set var="total"
							value="${total + item.product.price*item.quantity*discountafter}" />
					</c:forEach>
					<li>
						Total
						<i>-</i>
						<span>
							<fmt:formatNumber value="${total}" type="currency" />
						</span>
					</li>
				</ul>
			</div>
			<div class="checkout-right-basket animated wow slideInRight"
				data-wow-delay=".5s">
				<a
					href="${pageContext.request.contextPath}/views/viewproductlist/1/1/9">
					<span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>
					Continue Shopping
				</a>
			</div>
			
			<div class="checkout-right-basket animated wow slideInRight"
				data-wow-delay=".5s">
				<a
					href="${pageContext.request.contextPath}/shopping/confirmorder">
					<span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>
					Confirm Order
				</a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
	
	
			function getXMLHttpRequest() {
				var xmlHttpReq = false;
				if (window.XMLHttpRequest) {
					xmlHttpReq = new XMLHttpRequest();
				} else if (window.ActiveXObject) {
					try {
						xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
					} catch (exp1) {
						try {
							xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
						} catch (exp2) {
							xmlHttpReq = false;
						}
					}
				}
				return xmlHttpReq;
			}

			function deleteitemnumber(itemid) {
				var xmlHttpRequest = getXMLHttpRequest();
				xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest);

				var queryString = "/" + itemid;

				xmlHttpRequest.open("GET",
						"${pageContext.request.contextPath}/shopping/deleteitemnumberajax"
								+ queryString, true);
				xmlHttpRequest.send();
			}

			function getReadyStateHandler(xmlHttpRequest) {
				return function() {

					if (xmlHttpRequest.readyState == 4) {
						if (xmlHttpRequest.status == 200) {
							
							console.log(xmlHttpRequest.responseText);
							var jsonObject = JSON.parse(xmlHttpRequest.responseText);
							
							
							var jsonFunction = jsonObject.jsonFunction;
							if (jsonFunction == "jsonfunction_deleteall")
								showCartInfo(xmlHttpRequest.responseText);
							
							if (jsonFunction == "jsonfunction_deleteitem")
								showCartInfo(xmlHttpRequest.responseText);
							

						} else {
							alert("HTTP error " + xmlHttpRequest.status + ": "
									+ xmlHttpRequest.statusText);
						}
					}
				};
			}
			
			
			function showCartInfo(response){
				var obj = JSON.parse(response);
				var arr = obj.jsonObject; //list (mang) cart
				console.log("Array length: "+arr.length);
				
				var i;
				var totalprice = 0;
				var totalitem = 0;
				var out='';
				for(i = 0; i < arr.length; i++){
					
					totalitem += arr[i].quantity;
					
					
					var todaysDate = new Date();

					if (arr[i].product.discountStartDate != null && arr[i].product.discountEndDate != null
							&& arr[i].product.discount != null) {
						// Create date from input value
						var discountStartDate = new Date(arr[i].product.discountStartDate);
						var discountEndDate = new Date(arr[i].product.discountEndDate);
						// call setHours to take the time out of the comparison
						if (discountStartDate.setHours(0, 0, 0, 0) < todaysDate
								.setHours(0, 0, 0, 0)
								&& todaysDate.setHours(0, 0, 0, 0) < discountEndDate.setHours(0, 0,
										0, 0)) {

							// discount
							totalprice += arr[i].product.price * (1-arr[i].product.discount) * arr[i].quantity;
							continue;

						} else {
							// ko discount

							totalprice += arr[i].product.price * arr[i].quantity;
							continue;
						}
					} else {
						// ko discount
						totalprice += arr[i].product.price *  arr[i].quantity;
						continue;
					}
					
					
					
				}
				
				
				$(".simpleCart_total").text(totalprice + "đ");
				$(".simpleCart_totalitem").text("("+totalitem+" items)");
				
			}
			
			</script>
<!-- //checkout -->