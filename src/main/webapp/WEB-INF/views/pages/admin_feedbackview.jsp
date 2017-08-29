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
			

			<!-- Main content -->
			<section class="content">



				<div class="row">
					<div class="col-xs-12">
						<div class="box box-warning">
							<div class="box-header with-border">
								<h3 class="box-title">Feedback</h3>
								<p style="color: red; font-weight: bold">${error }</p>
							</div>
							<!-- /.box-header -->
							<div class="box-body">

								<section class="content-header">
									<div class="panel panel-primary">
										<div class="panel-heading">Customer Information</div>
										<div class="panel-body">
											<p>Feedback Id: ${feedback.id }</p>
											<p>Customer Name: ${feedback.name } </p>
											<p>Customer Phone: ${feedback.contactNumber }</p>
											<p>Customer Email: ${feedback.email }</p>

											

										</div>
									</div>

									

								</section>

								<form role="form"
									action="${pageContext.request.contextPath}/admin/product/edit"
									enctype="multipart/form-data" method="post">
									<!-- text input -->
									
									
									
									<h1>${feedback.subject }</h1>


									<!-- textarea -->
									<div class="form-group">
										<label>Message</label>
										<textarea class="form-control" rows="15"
											placeholder="Enter ..." name="description" readonly>${feedback.message}</textarea>
									</div>


















									<a href="${pageContext.request.contextPath}/admin/feedback/view"
									class="btn btn-primary">Return to feedbak page</a>
								</form>
							</div>
							<!-- /.box-body -->
						</div>
					</div>


				</div>











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
