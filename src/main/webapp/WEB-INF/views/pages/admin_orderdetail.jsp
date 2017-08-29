s<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Data Tables</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="<c:url value='/plugins/datatables/dataTables.bootstrap.css'/>">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value='/dist/css/AdminLTE.min.css'/>">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="<c:url value='/dist/css/skins/_all-skins.min.css'/>">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">


		<!-- Left side column. contains the logo and sidebar -->


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="panel panel-primary">
					<div class="panel-heading">Order Information</div>
					<div class="panel-body">
						<fmt:setLocale value="vi_VN" scope="session" />
						<p>Customer Name: ${order.user.firstname }
							${order.user.lastname }</p>
						<p>Customer Address: ${order.address }</p>
						<p>Customer Email: ${order.user.email }</p>

						<p>
							Total amount:
							<fmt:formatNumber value="${order.amount } " type="currency" />
						</p>
						<p>Status:</p>
						<c:if test="${order.isProcessing eq true}">
							<span class="label label-info">Processing</span>
						</c:if>
						<c:if test="${order.isShipped eq true}">
							<span class="label label-success">Shipped</span>
						</c:if>

						<c:if test="${order.isCompleted eq true}">
							<span class="label label-primary">Completed</span>
						</c:if>

						<c:if test="${order.isCancel eq true}">
							<span class="label label-danger">Canceled</span>
						</c:if>

					</div>
				</div>

				<h1>
					Order Detail
				</h1>
				
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">

						<!-- /.box -->

						<div class="box">
							
							<!-- /.box-header -->
							<div class="box-body">


								<form
									action="${pageContext.request.contextPath}/admin/order/updatestatus/${order.id}"
									method="post">
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>Product Id</th>
												<th>Product Name</th>
												<th>Price</th>
												<th>Quantity</th>
												<th>Discount</th>
												<th>Amount</th>

											</tr>
										</thead>

										<tbody>

											<c:forEach items="${orderdetails}" var="item"
												varStatus="status">


												<tr>

													<td>${item.product.id }</td>
													<td>${item.product.name }</td>
													<td>${item.product.price }</td>
													<td>${item.quantity }</td>
													<td>${item.discount }</td>
													<td>
														<c:choose>
															<c:when test="${item.discount eq null}">

																<fmt:formatNumber
																	value="${item.product.price*item.quantity} "
																	type="currency" />
															</c:when>
															<c:otherwise>

																<fmt:formatNumber
																	value="${item.product.price*item.quantity*(1-item.discount)} "
																	type="currency" />
															</c:otherwise>
														</c:choose>

													</td>


												</tr>

											</c:forEach>



										</tbody>

									</table>


									
									<select class="input-small" name="status">
										<option value="Processing">Processing</option>
										<option value="Shipped">Shipped</option>
										<option value="Completed">Completed</option>
										<option value="Canceled">Canceled</option>
									</select>

									<button type="submit" class="btn btn-primary">Update
										Status</button>
								</form>

								<br>
								<br>
								<a href="${pageContext.request.contextPath}/admin/order/view"
									class="btn btn-primary">Return to orders page</a>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->














			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->





	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.2.0 -->
	<script src="<c:url value='/plugins/jQuery/jQuery-2.2.0.min.js'/>"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
	<!-- DataTables -->
	<script
		src="<c:url value='/plugins/datatables/jquery.dataTables.min.js'/>"></script>
	<script
		src="<c:url value='/plugins/datatables/dataTables.bootstrap.min.js'/>"></script>
	<!-- SlimScroll -->
	<script
		src="<c:url value='/plugins/slimScroll/jquery.slimscroll.min.js'/>"></script>
	<!-- FastClick -->
	<script src="<c:url value='/plugins/fastclick/fastclick.js'/>"></script>
	<!-- AdminLTE App -->
	<script src="<c:url value='/dist/js/app.min.js'/>"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<c:url value='/dist/js/demo.js'/>"></script>
	<!-- page script -->
	<script>
		$(function() {
			$("#example1").DataTable();
			$('#example2').DataTable({
				"paging" : true,
				"lengthChange" : false,
				"searching" : false,
				"ordering" : true,
				"info" : true,
				"autoWidth" : false
			});
		});
	</script>
</body>
</html>
