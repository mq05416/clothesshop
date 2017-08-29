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

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">


		<!-- Left side column. contains the logo and sidebar -->


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Report
				</h1>
				
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">

						<!-- /.box -->

						<div class="box">
							<div class="box-header">
								<h3 class="box-title">Data Table With Full Features</h3>
							</div>
							<!-- /.box-header -->

							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->


				<div class="bootstrap-iso">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-6 col-sm-6 col-xs-12">
								<form method="post"
									action="${pageContext.request.contextPath}/admin/report" target="_blank">
									<div class="form-group ">
										<label class="control-label " for="date"> Start Date </label>
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-calendar"> </i>
											</div>
											<input class="form-control" id="date" name="startDate"
												placeholder="YYYY-MM-DD" type="text" />
										</div>
									</div>

<br/><br/><br/>
									<div class="form-group ">
										<label class="control-label " for="date"> End Date </label>
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-calendar"> </i>
											</div>
											<input class="form-control" id="date" name="endDate"
												placeholder="YYYY-MM-DD" type="text" />
										</div>
									</div>
									<div class="form-group">
										<div>
											<button class="btn btn-primary " name="submit" type="submit">
												Submit</button>
										</div>
									</div>
								</form>
							</div>
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
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>


	<script>
		$(document).ready(
				function() {
					var startDate = $('input[name="startDate"]'); 
					var endDate = $('input[name="endDate"]');
					var container = $('.bootstrap-iso form').length > 0 ? $(
							'.bootstrap-iso form').parent() : "body";
					startDate.datepicker({
						format : 'yyyy-mm-dd',
						container : container,
						todayHighlight : true,
						autoclose : true,
					});
					endDate.datepicker({
						format : 'yyyy-mm-dd',
						container : container,
						todayHighlight : true,
						autoclose : true,
					});
				})
	</script>
</body>
</html>
