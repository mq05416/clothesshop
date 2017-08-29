<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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
				<h1>
					Orders
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


								<%-- <form
									action="${pageContext.request.contextPath}/admin/order/deleteselected"
									method="post"> --%>
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>Select</th>
												<th>Id</th>
												<th>Email</th>
												<th>Amount</th>
												<th>Address</th>
												<th>Order Date</th>
												<th>Status</th>
												
												<th>View</th>

											</tr>
										</thead>

										<tbody>

											<c:forEach items="${orders}" var="item" varStatus="status">


												<tr>
													<td>
														<input type="checkbox" name="list" value="${item.id}">
													</td>
													<td>${item.id }</td>
													<td>${item.user.email }</td>
													<td>${item.amount }</td>
													<td>${item.address }</td>
													<td>${item.orderDate }</td>
													<td>
														<c:if test="${item.isProcessing eq true}">
															<span class="label label-info">Processing</span>
														</c:if>
														<c:if test="${item.isShipped eq true}">
															<span class="label label-success">Shipped</span>
														</c:if>

														<c:if test="${item.isCompleted eq true}">
															<span class="label label-primary">Completed</span>
														</c:if>

														<c:if test="${item.isCancel eq true}">
															<span class="label label-danger">Canceled</span>
														</c:if>


													</td>
													


													<th>
														<a
															href="${pageContext.request.contextPath}/admin/orderdetail/view/${item.id}">View</a>


													</th>
												</tr>

											</c:forEach>



										</tbody>

									</table>

									<!-- <button type="submit" class="btn btn-primary">Delete
										selected</button>
								</form> -->



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
