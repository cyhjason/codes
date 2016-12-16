<%@page language="java" %>
<%@ page contentType="text/html; charset=GB2312"%>
<%@ include file="include/common.jsp"%>

<HTML>
<HEAD>
</HEAD>
<BODY >
<SCRIPT LANGUAGE="JavaScript">
<!--
	$(function(){
		var msg = "${msgView.msg}";
		swal({
			  title: "<sp:message code='sys.sign.timeout'/>",
			  text: msg,
			  timer: 3000,
			  showConfirmButton: true,
			  confirmButtonText: "<sp:message code='sys.sign'/>"
			},
			function (){
				top.window.location.href="<%=request.getContextPath()%>/";
			}
		);
	    window.setTimeout("ok();",3000);
	
		function ok(){
			top.window.location.href="<%=request.getContextPath()%>/";
	 	}
	}) 
		
//-->
</SCRIPT>
</BODY>
</HTML>