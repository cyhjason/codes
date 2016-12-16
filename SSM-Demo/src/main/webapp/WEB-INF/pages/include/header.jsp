<%@ page language="java" pageEncoding="UTF-8" import="java.util.*,com.cyh.sy.entity.*"%>
<%
	Company user = (Company)session.getAttribute("currentUser"); //登录用户
	if(user == null){
%>
	<jsp:forward page="/WEB-INF/pages/timeout.jsp"/>
<%
	}
%>

<header class="main-header">
	<!-- Logo -->
	<a href="<%=path%>" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini">SSM</span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b><sp:message code="sys.name"/></b></span> 
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button 菜单收缩按钮 -->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> 
			<span class="sr-only">Toggle navigation</span> 
		</a>
		

		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li class="dropdown user user-menu">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
						<!-- <img src="<%=path%>/res/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">  -->
						<span class="hidden-xs">${currentUser.companyName}</span>, <sp:message code="sys.wel"/>
					</a>
					<ul class="dropdown-menu">
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="<%=path%>/com/show" class="btn btn-default btn-flat"><sp:message code="user.info"/></a>
							</div>
							<div class="pull-right">
								<a href="<%=path%>/account/out" class="btn btn-default btn-flat"><sp:message code="sys.out"/></a>
							</div>
						</li>
						
					</ul>
				</li>
				<!-- Control Sidebar Toggle Button -->
			</ul>
		</div>
	</nav>
</header>