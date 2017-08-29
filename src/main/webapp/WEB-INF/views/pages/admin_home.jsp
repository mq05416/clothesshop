<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Page Header
        <small>Optional description</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Your Page Content Here -->
      <h1>Welcome to Admin Page. </h1>
      <h1>You can add, edit, update, delete products, categories, orders ...</h1>

    </section>
    <!-- /.content -->
  </div>
<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.0 -->
<script src="<c:url value='/plugins/jQuery/jQuery-2.2.0.min.js' />"></script>
<!-- Bootstrap 3.3.6 -->
<script src="<c:url value='/bootstrap/js/bootstrap.min.js' />"></script>
<!-- AdminLTE App -->
<script src="<c:url value='/dist/js/app.min.js' />"></script>