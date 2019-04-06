<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>用户列表界面</title>
<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

<!-- jqgrid-->
<link href="${ctx}/css/plugins/jqgrid/ui.jqgrid.css?0820"
	rel="stylesheet">

<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">
<link href="${ctx}/css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox ">
					<div class="ibox-title">
						<div>
							<div class="">
								<div class="col-sm-3">
								<shiro:hasPermission name="role:add">
									<span id="add_role" class="btn btn-primary">添加角色</span>
								</shiro:hasPermission>
								</div>
								<div class="col-sm-4">
									<input id="search" placeholder="请输入需要查询的角色名" name="search"
										class="form-control" type="text" class="valid">
								</div>
								<button onclick="searchList()" class="btn btn-primary"
									type="submit">查询</button>
							</div>
						</div>
					</div>
					<div class="ibox-content">
						<div class="jqGrid_wrapper">
							<table id="table_list_1"></table>
							<div id="pager_list_1"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal inmodal" id="myModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">编辑角色</h4>
					<small class="font-bold"></small>
				</div>
				<form class="form-horizontal m-t" method="post" id="infoForm">
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-3 control-label">角色序号：</label>
							<div class="col-sm-7">
								<input id="id" name="id" readonly="readonly" placeholder="角色id"
									class="form-control" type="text" class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">角色名：</label>
							<div class="col-sm-7">
								<input id="roleName" name="roleName" 
									placeholder="请输入角色" class="form-control" type="text"
									class="valid">
								<input id="roleNameCheck" type="hidden">
							</div>
						</div>
						<label class="col-sm-3 control-label">修改角色权限：</label>
						<div class="form-group">
							<div class="col-sm-3"></div>
							<div id="powerTable" class="col-sm-6"></div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
						<shiro:hasPermission name="role:edit">
							<button type="submit" class="btn btn-primary">保存</button>
						</shiro:hasPermission>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 全局js -->
	<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
	<script src="${ctx}/js/bootstrap.min.js?v=3.3.6"></script>

	<!-- Peity -->
	<script src="${ctx}/js/plugins/peity/jquery.peity.min.js"></script>

	<!-- jqGrid -->
	<script src="${ctx}/js/plugins/jqgrid/i18n/grid.locale-cn.js?0820"></script>
	<script src="${ctx}/js/plugins/jqgrid/jquery.jqGrid.min.js?0820"></script>

	<!-- 自定义js -->
	<script src="${ctx}/js/content.js?v=1.0.0"></script>

	<!-- layerDate plugin javascript -->
	<script src="${ctx}/js/plugins/layer/laydate/laydate.js"></script>

	<!-- layer javascript -->
	<script src="${ctx}/js/plugins/layer/layer.min.js"></script>

	<!-- 表单校验jqueryvalidate -->
	<script src="${ctx}/js/plugins/validate/jquery.validate.min.js"></script>
	<!-- 表单校验默认的提示字 -->
	<script src="${ctx}/js/plugins/validate/messages_zh.min.js"></script>
	
	<!-- iCheck图标 -->
	<script src="${ctx}/js/plugins/iCheck/icheck.min.js"></script>

	<!-- Page-Level Scripts -->
	<script>
		function formatter_operation(cellvalue, options, rowObject) {
			var formObj = JSON.stringify(rowObject);
			var editfunc = "onclick='editRole(" + formObj + ")'";
			var removefunc = "onclick='deleteRole(" + rowObject.id + ")'";
			var editStr = "";
			var removeStr = "";
			<shiro:hasPermission name="role:edit">
				editStr = "<a  class='btn btn-primary btn-sm'"+editfunc+"><i class='fa fa-paste'></i>编辑</a>";
			</shiro:hasPermission>
			<shiro:hasPermission name="role:delete">
				removeStr = "<a class='btn btn-danger btn-sm' "+removefunc+"><i class='fa fa-warning'>删除</a>";
			</shiro:hasPermission>
			if(editStr==""&&removeStr==""){
				return "您没有足够的权限操作角色";
			}
			return editStr + "&nbsp;&nbsp;&nbsp;&nbsp;" + removeStr;
		}

		function editRole(obj) {
			/* $("#showModal").modal({
			    remote: "${ctx}/sysuser/showInfo/?id="+id
			}); */
			$("#id").val(obj.id);
			$("#roleName").val(obj.roleName);
			$("#roleNameCheck").val(obj.roleName);
		
			//塞内容
			$.ajax({
			    url: "${ctx}/power/getAllPowerToRole",
			    async: false,
			    success: function(data) {
			    	var htmlVal = "";
					var dt;
					var power;
					var count;
					for(var i=0;i<data.length;i++){
						dt = data[i];
						htmlVal += "<br><b>"+dt.modular.modularName+"</b>"
						htmlVal += "<table  class='table table-bordered'><tbody><tr>";
						count = 0;
						for(var j=0;j<dt.powers.length;j++){
							count++;
							power = dt.powers[j];
							htmlVal += "<td><input type='checkbox' value='"+power.id+"' class='i-checks' name='powers'> <i><i>"+power.powerName+"</td>"
							if(count%2==0){
								htmlVal += "</tr><tr>"
							}
						}
						htmlVal += "</tr></tbody></table>";
					}
					$("#powerTable").html(htmlVal);
					$.get("${ctx}/power/getRoleOwnPowers",{roleId:obj.id},function(powerIds){
						var powers = $("input[name='powers']");
						for(var i=0;i<powers.length;i++){
							for(var j=0;j<powerIds.length;j++){
								if(powerIds[j]==powers[i].value){
									$(powers[i]).parent().addClass("checked")
									$(powers[i]).iCheck('check');
								}
							}
						}
					})
			    }
			});
			
			//iCheck初始化
			$('.i-checks').iCheck({
				checkboxClass : 'icheckbox_square-green',
				radioClass : 'iradio_square-green',
			});

			$("#myModal").modal('show');
		}

		//删除按钮事件
		function deleteRole(id) {
			layer.confirm('确定删除该角色吗？删除后不可恢复', {
				icon : 2,
				title : '温馨提示',
				skin : 'layui-layer-molv'
			}, function(index) {
				$.get("${ctx}/role/deleteRole", {
					id : id
				}, function(data) {
					layer.alert(data.msg, {
						skin : 'layui-layer-molv', //样式类名
						shift : 4
					});
					$("#table_list_1").trigger("reloadGrid");
					layer.close(index);
				});
			})

		}

		function searchList() {
			var search = $("#search").val();
			/* if(search){
				console.log(search);
				$("#table_list_1").jqGrid('setGridParam',{ 
			        url:"${ctx}/sysuser/sysuserlist",
			        postData:{'searchNameOrNickName':search}, //发送数据 
			        page:1 
			    }).trigger("reloadGrid"); //重新载入
			}else{
				layer.alert("查询条件不能为空！", {
					skin: 'layui-layer-molv', //样式类名
					shift:4
					});
			} */
			$("#table_list_1").jqGrid('setGridParam', {
				url : "${ctx}/role/roleList",
				postData : {
					'keyword' : search
				}, //发送数据 
				page : 1
			}).trigger("reloadGrid"); //重新载入
		}

		$(document)
				.ready(
						function() {

							//搜索框绑定事件
							$("#search").keyup(function(event) {
								if (event.keyCode == 13) {
									searchList();
								}
							});

							//为添加用户按钮绑定事件
							$("#add_role").click(function() {
								layer.open({
									type : 2,
									content : "${ctx}/role/toAddRole", //这里content是一个普通的String
									area : [ '500px', '500px' ],
									btn : [ 'yes', 'no' ]
								});
							});

							$.jgrid.defaults.styleUI = 'Bootstrap';

							// Configuration for jqGrid Example 1
							$("#table_list_1").jqGrid({
								mtype : 'POST',
								url : "${ctx}/role/roleList",
								datatype : "json",
								jsonReader : {
									root : 'root',//数据
									page : 'page',//当前页数
									total : 'total',//总页数
									records : 'records',//总条数
									rows : 'size',
									id : 'id'
								},
								height : 470,
								autowidth : true,
								shrinkToFit : true,
								rowNum : 10,
								rowList : [ 10, 20, 30, 50 ],
								emptyrecords : '没有符合条件的数据！',
								colNames : [ '序号', '角色名', '操作' ],
								colModel : [ {
									name : 'id',
									width : 170,
								}, {
									name : 'roleName',
									width : 170,
								}, {
									width : 200,
									formatter : formatter_operation,
								} ],
								pager : "#pager_list_1",
								viewrecords : true,
								caption : "角色信息列表",
								hidegrid : false
							});
							//使用自带的查询添加等功能
							/* $("#table_list_1").jqGrid('navGrid', '#pager_list_1', {
								edit : false,
								add : false,
								refresh: false,
								del : false,
								search : false
							}, {
								height : 200,
								reloadAfterSubmit : true
							}).jqGrid('navButtonAdd','#pager_list_1',{
								caption:"<span style='width:100px;heigth:100px' class='btn-primary'>添加</span>",
								buttonicon:"ui-icon-del",
								onClickButton: function(){   
									alert("Deleting Row");  
								},   
							}); */

							/* jquery Validate 添加自定义校验规则 */
							/* $.validator.addMethod(name,method,message) */
							$.validator.addMethod("checkPhone", function(value,
									element, param) {
								var pattern = /^1[3,4,5,8,9][0-9]{9}$/
								return pattern.test(value);
							}, "请输入11位有效的手机号码")

							/* jquery Validate 初始化 */
							$("#infoForm")
									.validate(
											{
												rules : {
													roleName : {
														required : true,
														remote : {
															url : "${ctx}/role/checkRoleNameExistOrSame",
															type : "get",
															dataType : "json",
															data : {
																roleName : function() {
																	return $(
																			"#roleName")
																			.val();
																},
																roleNameCheck : function() {
																	return $(
																			"#roleNameCheck")
																			.val();
																}
															},

														},
													},
												},
												messages : {
													roleName : {
														required : "角色名不能为空",
														remote : "该角色已存在"
													}
												},
												submitHandler : function() {
													//1、序列化表单
													var formDate = $(
															"#infoForm")
															.serialize();
													//2、使用ajax请求提交
													/* $.post("${ctx}/roleList/adduser",{uname:$("#uname").val(),pwd:$("#pwd").val(),nickname:$("#nickname").val(),regtime:$("#regtime").val()},function(data){
														console.log(data);
													}) */
													$
															.post(
																	"${ctx}/role/editRole",
																	formDate,
																	function(
																			data) {
																		if (data.ok == 1) {
																			layer
																					.alert(
																							data.msg,
																							{
																								skin : 'layui-layer-molv', //样式类名
																								shift : 4
																							},
																							function(
																									index) {
																								layer
																										.close(index);
																							});
																		} else {
																			parent.layer
																					.alert(
																							data.msg,
																							{
																								skin : 'layui-layer-molv',
																								shift : 4
																							});
																		}
																		$(
																				"#myModal")
																				.modal(
																						'hide');
																		$(
																				"#table_list_1")
																				.trigger(
																						"reloadGrid");
																	})
												}
											});

						});
	</script>

</body>

</html>