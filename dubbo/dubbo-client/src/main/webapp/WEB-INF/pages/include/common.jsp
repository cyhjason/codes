<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
%>

<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="<%=path%>/res/bootstrap/css/bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=path%>/res/dist/css/AdminLTE.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="<%=path%>/res/dist/css/skins/_all-skins.min.css">

<!-- iCheck -->
<link rel="stylesheet" href="<%=path%>/res/plugins/iCheck/square/blue.css">
<!-- DataTables -->
<link rel="stylesheet" href="<%=path%>/res/plugins/datatables/dataTables.bootstrap.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="<%=path%>/res/plugins/fontawesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="<%=path%>/res/plugins/ionicons/css/ionicons.min.css">
<!-- toastr -->
<link rel="stylesheet" href="<%=path%>/res/toastr/toastr.min.css">
<!-- sweetalert -->
<link rel="stylesheet" href="<%=path%>/res/sweetalert/sweetalert.css">
<!-- custom-->
<link rel="stylesheet" href="<%=path%>/res/sy.css">

<!-- jQuery 2.2.3 -->
<script src="<%=path%>/res/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="<%=path%>/res/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="<%=path%>/res/plugins/iCheck/icheck.min.js"></script>

<!-- DataTables -->
<script src="<%=path%>/res/plugins/datatables/jquery.dataTables.js"></script>
<script src="<%=path%>/res/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="<%=path%>/res/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- custom-->
<script src="<%=path%>/res/sy.js"></script>
<!-- toastr -->
<script src="<%=path%>/res/toastr/toastr.min.js"></script>
<!-- sweetalert -->
<script src="<%=path%>/res/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript">
<!--
	toastr.options = {  
        closeButton: false,  
        debug: false,  
        progressBar: true,  
        positionClass: "toast-bottom-center",  
        onclick: null,  
        showDuration: "300",  
        hideDuration: "1000",  
        timeOut: "2000",  
        extendedTimeOut: "1000",  
        showEasing: "swing",  
        hideEasing: "linear",  
        showMethod: "fadeIn",  
        hideMethod: "fadeOut"  
    };  
//-->
</script>
<!-- custom-->