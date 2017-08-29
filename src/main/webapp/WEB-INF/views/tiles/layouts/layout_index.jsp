<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	 
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); }

</script>
<!-- //for-mobile-apps -->
<link href="<c:url value='/resources/css/bootstrap.css'/>" rel="stylesheet" type="text/css"
	media="all"></link>
<link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" type="text/css" media="all"></link>
<!-- js -->
<script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<!-- //js -->
<!-- cart -->
<%-- <script src="<c:url value='/resources/js/simpleCart.min.js'/>"></script> --%>
<!-- cart -->
<!-- for bootstrap working -->
<script type="text/javascript" src="<c:url value='/resources/js/bootstrap-3.1.1.min.js'/>"></script>
<!-- //for bootstrap working -->
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<!-- timer -->
<link rel="stylesheet" href="<c:url value='/resources/css/jquery.countdown.css'/>"></link>
<!-- //timer -->
<!-- animation-effect -->
<link href="<c:url value='/resources/css/animate.min.css'/>" rel="stylesheet"></link>
<script src="<c:url value='/resources/js/wow.min.js'/>"></script>
<link href="<c:url value='/resources/css/sweetalert2.min.css'/>" rel="stylesheet"></link>
<script src="<c:url value='/resources/js/sweetalert2.min.js'/>"></script>
<script>
	new WOW().init();
</script>
<!-- //animation-effect -->
</head>
<body>
		
            <tiles:insertAttribute name="header" />
      
        	<tiles:insertAttribute name="body" />
        
             
      
         
        
            <tiles:insertAttribute name="footer" />
        

</body>
</html>