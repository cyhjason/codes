<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/common.jsp"%>

<!DOCTYPE html>
<html>
	<head>
		<!--title-->
       	<%@ include file="include/title.jsp" %>
		
	</head>
	
	<body class="hold-transition skin-blue sidebar-mini">
		<div class="wrapper">
			<!--header-->
       		<%@ include file="include/header.jsp" %>
			
			<!--menu-->
       		<%@ include file="include/menu.jsp" %>
	
			<!-- Left side column. contains the logo and sidebar -->
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<!-- 路径导航 -->
					<a href="<%=path%>/"><i class="fa fa-home"></i> <sp:message code="sys.home"/></a> > 
					<a href="<%=path%>/area/list"><sp:message code="menu.area"/></a>&nbsp;&nbsp;<small><sp:message code="area.list"/></small>
				</section>
			
				<!-- Main content -->
				<section class="content">
					<!-- 查询、添加、批量删除、导出、刷新 -->
					<div class="row-fluid">
					
						<div class="pull-right">
							<div class="btn-group">
								<button type="button" class="btn btn-primary btn-sm"  id="btn-add">
									<i class="fa fa-plus"></i> <sp:message code="sys.add"/>
								</button>
								<!-- 
								<button type="button" class="btn btn-primary btn-sm" id="btn-delAll">
									<i class="fa fa-remove"></i> <sp:message code="sys.delAll"/>
								</button>
								<button type="button" class="btn btn-primary btn-sm" id="btn-export">
									<i class="fa fa-sign-in"></i> <sp:message code="sys.export"/>
								</button>
								-->
								<button type="button" class="btn btn-primary btn-sm" id="btn-re">
									<i class="fa fa-refresh"></i> <sp:message code="sys.refresh"/>
								</button>
							</div>
						</div>

						<div class="row">
							<form id="queryForm" action="<%=path%>/area/list" method="post">
								<div class="col-xs-2">
									<input type="text" id="keyword" name="keyword" class="form-control input-sm"
										placeholder="<sp:message code="sys.keyword"/>">
								</div>
								<button type="button" class="btn btn-primary btn-sm" id="btn-query">
									<i class="fa fa-search"></i> <sp:message code="sys.query"/>
								</button>
							</form>
						</div>
					</div>
	                
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-body">
									<table id="dataTable" class="table table-striped table-bordered table-hover table-condensed" align="center">
										<thead>
											<tr class="info">
												<!-- <td><input type="checkbox" id="checkAll"></td> -->
												<th><sp:message code="sys.no"/></th>
												<th><sp:message code="area.name.cn"/></th>
												<th><sp:message code="area.name.en"/></th>
												<th><sp:message code="sys.create.time"/></th>
												<th><sp:message code="sys.update.time"/></th>
												<th><sp:message code="sys.oper"/></th>
											</tr>
										</thead>
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

			</div>
	
			<!--footer-->
	       	<%@ include file="include/footer.jsp" %>
			<div class="control-sidebar-bg"></div>
		</div>
		
		<!-- msgModal -->
		<div class="modal fade bs-example-modal-sm" id="msgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only"><sp:message code="sys.close" /></span>
						</button>
						<h5 class="modal-title" id="myModalLabel"><sp:message code="sys.msg.tips" /></h5>
					</div>
					<div class="modal-body" id=regModelContent></div>
					<!-- 
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<sp:message code="sys.close" />
						</button>
						<a href="<%=path%>/" class="btn btn-primary"><sp:message code="sys.sign" /></a>
					</div>
					-->
				</div>
			</div>
		</div>
		
		<!-- EditUser -->
		<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
				
					<div class="modal-header" style="background-color: #307095;">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only"><sp:message code="sys.close" /></span>
						</button>
						<h4 class="modal-title" id="myModalLabel"><sp:message code="area.info"/>-<sp:message code="sys.edit"/></h4>
					</div>
					
					<div class="modal-body">
						<form class="form-horizontal"  id="editForm" action="<%=path%>/area/update" method="post">
							<input type="hidden" class="form-control" name="areaId">
							<div class="form-group">
								<label for="inputName" class="col-sm-3 control-label"><sp:message code="area.name.cn"/></label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="areaNameCn">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-3 control-label"><sp:message code="area.name.en"/></label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="areaNameEn">
								</div>
							</div>
						</form>
					</div>
					<!-- modal-body END -->
					
					<div class="modal-footer">
						<button type="submit" id="btn-submit" class="btn btn-primary"><sp:message code="sys.submit"/></button>
					</div>
				</div>
			</div>
		</div>
	
		<!-- page script -->
		<script>
			$(function () {
		  		//
		  		var url = "";
		  		
				var tables = $("#dataTable").dataTable({
			    	serverSide: true,//分页，取数据等等的都放到服务端去
			        processing: true,//载入数据的时候是否显示“载入中”
			        pageLength: 10,  //首次加载的数据条数
			        ordering: false, //排序操作在服务端进行，所以可以关了。
			        pagingType: "full_numbers",
			        autoWidth: false,
			        stateSave: true,//保持翻页状态，和comTable.fnDraw(false);结合使用
			        searching: false,
			        ajax: {   
			        	type: "post",
			            url: "<%=path%>/area/getData",
			            dataSrc: "data",
	                    data: function (d) {
	                        var param = {};
	                        param.draw = d.draw;
	                        param.start = d.start;
	                        param.length = d.length;
	                        var formData = $("#queryForm").serializeArray();//把form里面的数据序列化成数组
	                        formData.forEach(function (e) {
	                            param[e.name] = e.value;
	                        });
                        	return param;//自定义需要传递的参数。
			       		},
			    	},
	                columns: [//对应上面thead里面的序列
	                    //{"data": null,"width":"10px"},
	                    {"data": null},
	               		{"data": 'areaNameCn' }, 
	               		{"data": 'areaNameEn' },
  	                    {"data": 'createTime', 
  	                    	"render":function(data,type,full,callback) {
  	                    		return data.substr(0,19) 
	                    	}
	               		},
	               		{"data": 'updateTime', defaultContent: "", 
  	                    	"render":function(data,type,full,callback) {
  	                    		if(data != null && data != ""){
  	                    			return data.substr(0,19) 
  	                    		}else{
  	                    			return data;
  	                    		}
	                    	}
	               		},
  	                  	{"data": null,"width":"60px"}
	                ],
	                //操作按钮
	                columnDefs: [
	                    /**{
		                    targets: 0,
		                    defaultContent: "<input type='checkbox' name='checkList'>"
		                },*/
		                {
		                    targets: -1,
		                    defaultContent: "<div class='btn-group'>"+
		                    				"<button id='editRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-edit'></i></button>"+
		                    				"<button id='delRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-trash-o'></i></button>"+
		                    				"</div>"
		                }
	                ],
	                language: {
	                	lengthMenu: "",
	                  	processing: "<sp:message code='sys.load'/>",
	                    paginate: {
	                   		previous: "<",
	                     	next: ">",
	                     	first: "<<",
	                     	last: ">>"
	                    },
	                    zeroRecords: "<sp:message code='sys.nodata'/>",
	                    info: "<sp:message code='sys.pages'/>",
	                    infoEmpty: "",
	                    infoFiltered: "",
	                   	sSearch: "<sp:message code='sys.keyword'/>：",
	                },
	              	//每加载完一行的回调函数
	                createdRow: function( row, data, index ) {
	                },
	              	//初始化完成之后回调函数
			        initComplete: function (setting, json) {
	                },
	              	//在每次table被draw完后回调函数
	                fnDrawCallback: function(){
                		var api = this.api();
                		//获取到本页开始的条数
                	　　	var startIndex= api.context[0]._iDisplayStart;
                	　　	api.column(0).nodes().each(function(cell, i) {
                	　　　　	cell.innerHTML = startIndex + i + 1;
                	　　 }); 
                	}
	            });
				
				//查询按钮
				$("#btn-query").on("click", function () {
					tables.fnDraw();
				});
				
				//添加
	            $("#btn-add").on("click", function () {
	            	url = "<%=path%>/area/add";
	            	$("input[name=areaId]").val(0);
					$("input[name=areaNameCn]").val("");
					$("input[name=areaNameEn]").val("");
	            	$("#editModal").modal("show");
	            });
				
	          	//批量删除
	            $("#btn-delAll").on("click", function () {
	            	tables.draw( false );
	            });
	          	
	         	//导出
	            $("#btn-export").on("click", function () {
	            	tables.fnDraw();
	            });
				
				//刷新
	            $("#btn-re").on("click", function () {
	            	tables.fnDraw(false);
	            });
				
	          	//checkbox全选
	            $("#checkAll").on("click", function () {
	                if ($(this).prop("checked") === true) {
	                    $("input[name='checkList']").prop("checked", $(this).prop("checked"));
	                    $('#tables tbody tr').addClass('selected');
	                } else {
	                    $("input[name='checkList']").prop("checked", false);
	                    $('#tables tbody tr').removeClass('selected');
	                }
	            });
	          	
	          	//修改
				$("#dataTable tbody").on("click", "#editRow", function () {
					var data = tables.api().row($(this).parents("tr")).data();
					
					$("input[name=areaId]").val(data.areaIdStr);
					$("input[name=areaNameCn]").val(data.areaNameCn);
					$("input[name=areaNameEn]").val(data.areaNameEn);
					
					url = "<%=path%>/area/update";
					
					$("#editModal").modal("show");
		        });
	          	
	          	//添加、修改  表单异步提交
				$("#btn-submit").on("click", function(){
	          		$.ajax({
		                cache: false,
		                type: "POST",
		                url: url,
		                data: $("#editForm").serialize(),
		                async: false,
		                error: function(request) {
		                	toastr.error("Server Connection Error...");
		                },
		                success: function(data) {
		                	if(data.status == 1){
		                		$("#editModal").modal("hide");
		                		tables.fnDraw();
		                		//showSuccess("<sp:message code='sys.oper.success'/>");
		                		toastr.success("<sp:message code='sys.oper.success'/>");
		                	}else{
		                		//showFail("<sp:message code='sys.oper.fail'/>");
		                		toastr.error("<sp:message code='sys.oper.fail'/>");
		                	}
		                }
		            });
	          	});
	          	
				//删除
				$("#dataTable tbody").on("click", "#delRow", function () {
					var data = tables.api().row($(this).parents("tr")).data();
		            if(confirm("是否确认删除这条信息?")){
		                $.ajax({
		                    url:'<%=path%>/area/del/'+data.areaIdStr,
		                    type:'delete',
		                    dataType: "json",
		                    cache: "false",
		                    success:function(data){
		                        if(data.status == 1){
		                        	toastr.success("<sp:message code='sys.oper.success'/>");
		                        	tables.api().row().remove().draw(false);
		                        }else{
		                        	toastr.error("<sp:message code='sys.oper.fail'/>");
		                        }
		                    },
		                    error:function(err){
		                    	toastr.error("Server Connection Error...");
		                    }
		                });
		            }
		        });
			});
		</script>
	
		<!-- AdminLTE App -->
		<script src="<%=path%>/res/dist/js/app.min.js"></script>
	</body>
</html>
