<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- cac san pham ben phai -->
<div class="col-md-8 products-right">
	<div class="products-right-grid">
		<div class="products-right-grids animated wow slideInRight"
			data-wow-delay=".5s">
			<div class="sorting">
				<form
					action="${pageContext.request.contextPath}/views/viewproductsortitem">
					<select id="itemSort" name="sort" class="frm-field required sect"
						onchange="this.form.submit()" disabled>
						<option value="default">Default sorting</option>
						<option value="latest">Sort by latest</option>
						<option value="price">Sort by price</option>
					</select>
				</form>
			</div>
			<!-- onchange="viewItemPages(this.value)" -->
			<div class="sorting-left">
				<form
					action="${pageContext.request.contextPath}/views/viewproductnumberitem">
					<select id="itemNumber" name="numberitem"
						onchange="this.form.submit()" class="frm-field required sect" disabled>
						<option value="9">Item on page 9</option>
						<option value="18">Item on page 18</option>
						<option value="27">Item on page 27</option>
						<option value="null">All</option>
					</select>
				</form>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="products-right-grids-position animated wow slideInRight"
			data-wow-delay=".5s">
			<img src="<c:url value="/resources/images/18.jpg"/>" alt=" "
				class="img-responsive" />
			<div class="products-right-grids-position1">
				<h4>2017 New Collection</h4>
				<p>This is the online fashion retailer offering thousands of
					styles across womenswear and menswear so that you stay ahead of the
					trends. Shop our huge range of women's fashion items including
					dresses, tops, knitwear, coats, onesies, shoes, accessories. You
					want it - we've got it! We launch up to 100 new styles every day so
					whatever you're looking for, this site is at your choices</p>
			</div>
		</div>
	</div>
	<div class="products-right-grids-bottom">
		<div id="productsajax"></div>
		
		<div class="clearfix"></div>
	</div>
	
			
		
	<nav class="numbering animated wow slideInRight" data-wow-delay=".5s">
		<ul class="pagination paging">
			<c:forEach var="i" begin="1" end="${numberOfPages}">
				<li id="pageNumber_${i}">
					<a href="javascript:void(0);"
						onclick="viewproductsearchpageajax(${i});"><c:out
							value="${i}" /></a>
				</li>
			</c:forEach>
		</ul>
	</nav>
</div>
<!-- end cac san pham ben phai -->
<br>
<h1 id="productsajax"></h1>
<div class="clearfix"></div>
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

			
			
			
			function additemtocart(itemid) {
				var xmlHttpRequest = getXMLHttpRequest();
				xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest);

				var queryString = "/" + itemid;

				xmlHttpRequest.open("GET",
						"${pageContext.request.contextPath}/shopping/additemtocartajax"
								+ queryString, true);
				xmlHttpRequest.send();
			}
			
			
			function viewproductsearchpageajax(pageNumber) {
				var xmlHttpRequest = getXMLHttpRequest();
				xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest);

				
				var queryString = "?pageNumber=" + pageNumber;

				xmlHttpRequest.open("GET",
						"${pageContext.request.contextPath}/views/viewproductsearchpageajax"
								+ queryString, true);
				xmlHttpRequest.send();
			}
			

			function getReadyStateHandler(xmlHttpRequest) {
				return function() {

					if (xmlHttpRequest.readyState == 4) {
						if (xmlHttpRequest.status == 200) {
							
							
							
							var jsonObject = JSON.parse(xmlHttpRequest.responseText);
							
							
							var jsonFunction = jsonObject.jsonFunction;
							
							if (jsonFunction == "jsonfunction_addtocart")
								
								showCartInfo(xmlHttpRequest.responseText);
							if (jsonFunction == "jsonfunction_products_search") {
								fillTable(xmlHttpRequest.responseText);
								$('.new-collections-grid1-right span.stars').stars();
							}

						} else {
							alert("HTTP error " + xmlHttpRequest.status + ": "
									+ xmlHttpRequest.statusText);
						}
					}
				};
			}

			function fillTable(response){
				var obj = JSON.parse(response);
				var arr = obj.jsonObject; //list (mang) products
				
				console.log("Array length: "+arr.length);
				var i;
				var out='';
				for(i = 0; i < arr.length; i++){
					out+='<div class="col-md-4 products-right-grids-bottom-grid">'+
					'				<div'+
					'					class="new-collections-grid1 products-right-grid1 animated wow slideInUp"'+
					'					data-wow-delay=".5s">'+
					'					<div class="new-collections-grid1-image">'+
					
					'						<a'+
					'							href="${pageContext.request.contextPath}/views/viewproductdetails/'+arr[i].id+'"'+
					'							class="product-image">'+
					'							<img src="<c:url value="/images/'+arr[i].image+'" />"'+
					'								style="border: none; width: 100%; height: 250px" alt=" "'+
					'								class="img-responsive" />'+
					'						</a>'+
					'						<div'+
					'							class="new-collections-grid1-image-pos products-right-grids-pos">'+
					'							<a'+
					'								href="${pageContext.request.contextPath}/views/viewproductdetails/'+arr[i].id+'">Quick'+
					'								View</a>'+
					'						</div>'+
					
					
					'						<div'+
					'							class="new-collections-grid1-right products-right-grids-pos-right">'+
					'									<span class="stars">'+arr[i].rating+'</span>';
					
					    
					
					out+=
					'								<div class="clearfix"></div>'+
					
					'						</div>'+
					
					
					
					
					'					</div>'+
					'					<h4>'+
					'						<a'+
					'							href="${pageContext.request.contextPath}/views/viewproductdetails/'+arr[i].id+'">'+
					arr[i].name+
					'						</a>'+
					'					</h4>'+
					arr[i].description.substring(0, 30)+
					'					<div class="simpleCart_shelfItem products-right-grid1-add-cart">'+
					'						<p>'+
					''+
					''+
					''+
					'';
					
					
					
					// Get today's date
					var todaysDate = new Date();
					
					
					if (arr[i].discountStartDate!=null && arr[i].discountEndDate!=null && arr[i].discount!=null){
						// Create date from input value
						var discountStartDate = new Date(arr[i].discountStartDate);
						var discountEndDate = new Date(arr[i].discountEndDate);
						// call setHours to take the time out of the comparison
						if(discountStartDate.setHours(0,0,0,0) < todaysDate.setHours(0,0,0,0) &&todaysDate.setHours(0,0,0,0) <discountEndDate.setHours(0,0,0,0)) {
						
						
					    // discount
					    out+=
					    	'									<i>'+arr[i].price+'đ</i>'+
						'									<span class="item_price">'+
						Math.round(arr[i].price*(1-arr[i].discount))+
						'đ									</span>';
					    
					    
					} else {
						// ko discount
						
						out+= '									<span class="item_price">'+
						arr[i].price+
						'đ									</span>';
					}
					} else{
					    // ko discount
						out+= '									<span class="item_price">'+
						arr[i].price+
						'đ									</span>';
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					out+=
					''+
					''+
					''+
					''+
					'							<a class="item_add" href="javascript:void(0);"'+
					'								onclick="additemtocart('+arr[i].id+');">add to cart </a>'+
					'						</p>'+
					'					</div>'+
					'				</div>'+
					'			</div>';
							

				}

				document.getElementById("productsajax").innerHTML = out;
					

				
			}
			

			
			

			
			$(document).ready(function() {

				$('span.stars').stars();
				
				/* hien thi trang san pham dau tien khi moi vo  */
				viewproductsearchpageajax(1);
				/* hien thi option tag xo xuong */
				
				
				
				
				
				$("div.sorting-left select").val("${pageSize}");
				$("div.sorting select").val("${sort}");
				
			});
			 
			$(document).load(function () {
				$('.new-collections-grid1-right span.stars').stars();
				});
		</script>