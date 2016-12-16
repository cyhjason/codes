<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/pages/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>AdminLTE 2 | Data Tables</title>
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		  <![endif]-->
	</head>
	<body class="hold-transition skin-blue sidebar-mini">
		<div >
			<!-- Left side column. contains the logo and sidebar -->
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1> 商品信息管理</h1>
					<ol class="breadcrumb">
				        <li><a href="#"><i class="fa fa-home"></i> 首页</a></li>
				        <li class="active">商品管理</li>
				    </ol>
				</section>
				
				<!-- Content Header (Page header) -->
	
				<!-- Main content -->
				<section class="content">
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<!-- /.box-header -->
								<div class="box-body">
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>商品类型</th>
												<th>商品名称</th>
												<th>净含量</th>
												<th>建议零售价</th>
												<th>原产国</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th>商品类型</th>
												<th>商品名称</th>
												<th>净含量</th>
												<th>建议零售价</th>
												<th>原产国</th>
											</tr>
										</tfoot>
									</table>
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
		</div>
		<!-- ./wrapper -->
	
		<!-- FastClick -->
		<script src="<%=path%>/res/plugins/fastclick/fastclick.js"></script>
		<!-- AdminLTE App -->
		<script src="<%=path%>/res/dist/js/app.min.js"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="<%=path%>/res/dist/js/demo.js"></script>
		<!-- page script -->
		<script>
		var dataSet = [
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['食品','牛栏奶粉','850g','149 人民币','荷兰'],
		               ['食品','爱他美奶粉','800g','169 人民币','德国'],
		               ['Trident','Internet Explorer 6','Win 98+','6','A'],
		               ['Trident','Internet Explorer 7','Win XP SP2+','7','A'],
		               ['Trident','AOL browser (AOL desktop)','Win XP','6','A'],
		               ['Gecko','Firefox 1.0','Win 98+ / OSX.2+','1.7','A'],
		               ['Gecko','Firefox 1.5','Win 98+ / OSX.2+','1.8','A'],
		               ['Gecko','Firefox 2.0','Win 98+ / OSX.2+','1.8','A'],
		               ['Gecko','Firefox 3.0','Win 2k+ / OSX.3+','1.9','A'],
		               ['Gecko','Camino 1.0','OSX.2+','1.8','A'],
		               ['Gecko','Camino 1.5','OSX.3+','1.8','A'],
		               ['Gecko','Netscape 7.2','Win 95+ / Mac OS 8.6-9.2','1.7','A'],
		               ['Gecko','Netscape Browser 8','Win 98SE+','1.7','A'],
		               ['Gecko','Netscape Navigator 9','Win 98+ / OSX.2+','1.8','A'],
		               ['Gecko','Mozilla 1.0','Win 95+ / OSX.1+',1,'A'],
		               ['Gecko','Mozilla 1.1','Win 95+ / OSX.1+',1.1,'A'],
		               ['Gecko','Mozilla 1.2','Win 95+ / OSX.1+',1.2,'A'],
		               ['Gecko','Mozilla 1.3','Win 95+ / OSX.1+',1.3,'A'],
		               ['Gecko','Mozilla 1.4','Win 95+ / OSX.1+',1.4,'A'],
		               ['Gecko','Mozilla 1.5','Win 95+ / OSX.1+',1.5,'A'],
		               ['Gecko','Mozilla 1.6','Win 95+ / OSX.1+',1.6,'A'],
		               ['Gecko','Mozilla 1.7','Win 98+ / OSX.1+',1.7,'A'],
		               ['Gecko','Mozilla 1.8','Win 98+ / OSX.1+',1.8,'A'],
		               ['Gecko','Seamonkey 1.1','Win 98+ / OSX.2+','1.8','A'],
		               ['Gecko','Epiphany 2.20','Gnome','1.8','A'],
		               ['Webkit','Safari 1.2','OSX.3','125.5','A'],
		               ['Webkit','Safari 1.3','OSX.3','312.8','A'],
		               ['Webkit','Safari 2.0','OSX.4+','419.3','A'],
		               ['Webkit','Safari 3.0','OSX.4+','522.1','A'],
		               ['Webkit','OmniWeb 5.5','OSX.4+','420','A'],
		               ['Webkit','iPod Touch / iPhone','iPod','420.1','A'],
		               ['Webkit','S60','S60','413','A'],
		               ['Presto','Opera 7.0','Win 95+ / OSX.1+','-','A'],
		               ['Presto','Opera 7.5','Win 95+ / OSX.2+','-','A'],
		               ['Presto','Opera 8.0','Win 95+ / OSX.2+','-','A'],
		               ['Presto','Opera 8.5','Win 95+ / OSX.2+','-','A'],
		               ['Presto','Opera 9.0','Win 95+ / OSX.3+','-','A'],
		               ['Presto','Opera 9.2','Win 88+ / OSX.3+','-','A'],
		               ['Presto','Opera 9.5','Win 88+ / OSX.3+','-','A'],
		               ['Presto','Opera for Wii','Wii','-','A'],
		               ['Presto','Nokia N800','N800','-','A'],
		               ['Presto','Nintendo DS browser','Nintendo DS','8.5','C/A<sup>1</sup>'],
		               ['KHTML','Konqureror 3.1','KDE 3.1','3.1','C'],
		               ['KHTML','Konqureror 3.3','KDE 3.3','3.3','A'],
		               ['KHTML','Konqureror 3.5','KDE 3.5','3.5','A'],
		               ['Tasman','Internet Explorer 4.5','Mac OS 8-9','-','X'],
		               ['Tasman','Internet Explorer 5.1','Mac OS 7.6-9','1','C'],
		               ['Tasman','Internet Explorer 5.2','Mac OS 8-X','1','C'],
		               ['Misc','NetFront 3.1','Embedded devices','-','C'],
		               ['Misc','NetFront 3.4','Embedded devices','-','A'],
		               ['Misc','Dillo 0.8','Embedded devices','-','X'],
		               ['Misc','Links','Text only','-','X'],
		               ['Misc','Lynx','Text only','-','X'],
		               ['Misc','IE Mobile','Windows Mobile 6','-','C'],
		               ['Misc','PSP browser','PSP','-','C'],
		               ['Other browsers','All others','-','-','U']
		           ];
		  $(function () {
		    $('#example1').DataTable({
		    	"data": dataSet,
		      	"paging": true,
		      	"lengthChange": false,
		      	"ordering": false,
		      	"info": true,
		    });
		  });
		</script>
	</body>
</html>
