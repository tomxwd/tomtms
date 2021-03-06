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
									<shiro:hasPermission name="power:add">
										<span id="add_power" class="btn btn-primary">添加权限</span>
									</shiro:hasPermission>
								</div>
								<div class="col-sm-4">
									<input id="search" placeholder="请输入需要查询的权限" name="search"
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
					<h4 class="modal-title">编辑权限</h4>
					<small class="font-bold"></small>
				</div>
				<form class="form-horizontal m-t" method="post" id="infoForm">
					<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-3 control-label">权限序号：</label>
							<div class="col-sm-4">
								<input id="id" name="id" placeholder="权限序号" readonly="readonly"
									class="form-control" type="text" class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">权限名：</label>
							<div class="col-sm-4">
								<input id="powerName" name="powerName" placeholder="请输入权限名"
									class="form-control" type="text" class="valid">
								<input id="powerNameCheck" type="hidden">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">权限路径：</label>
							<div class="col-sm-4">
								<input id="powerAction" name="powerAction" placeholder="请输入权限路径"
									class="form-control" type="text" class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">是否显示：</label>
							<div class="col-sm-4">
								<div class="radio i-checks">
									<label> <input type="radio" id="powerDisplay1" value="1" 
										name="powerDisplay"> <i></i> 是 <input id="powerDisplay2" type="radio"
										value="0" name="powerDisplay"> <i></i> 否
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">所属模块：</label>
							<div class="col-sm-4">

								<div class="input-group">
									<input type="text" class="form-control" id="modularName"
										name="modularName"> <input type="hidden"
										readonly="readonly" id="modularId" name="modularId" />
									<div class="input-group-btn">
										<button type="button" class="btn btn-white dropdown-toggle"
											data-toggle="dropdown">
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu dropdown-menu-right" role="menu">
										</ul>
									</div>
								</div>
								<label style="color: #cc5965" id="modularNameMsg"></label>


							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
						<shiro:hasPermission name="power:edit">
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

	<!-- 搜索自动补全插件 -->
	<script src="${ctx}/js/plugins/suggest/bootstrap-suggest.min.js"></script>

	<!-- iCheck图标 -->
	<script src="${ctx}/js/plugins/iCheck/icheck.min.js"></script>

	<!-- Page-Level Scripts -->
	<script>
		$('.i-checks').iCheck({
			checkboxClass : 'icheckbox_square-green',
			radioClass : 'iradio_square-green',
		});

		function formatter_display(cellvalue, options, rowObject) {
			if (cellvalue == 1) {
				return "<span style='color:green'>显示</span>"
			} else {
				return "<span style='color:red'>不显示</span>"
			}
		}

		function formatter_operation(cellvalue, options, rowObject) {
			var formObj = JSON.stringify(rowObject);
			var editfunc = "onclick='editPower(" + formObj + ")'";
			var removefunc = "onclick='deletePower(" + rowObject.id + ")'";
			var editStr = "";
			var removeStr = "";
			<shiro:hasPermission name="power:edit">
				editStr = "<a  class='btn btn-primary btn-sm'"+editfunc+"><i class='fa fa-paste'></i>编辑</a>";
			</shiro:hasPermission>
			<shiro:hasPermission name="power:delete">
				removeStr = "<a class='btn btn-danger btn-sm' "+removefunc+"><i class='fa fa-warning'>删除</a>";
			</shiro:hasPermission>
			if(editStr==""&&removeStr==""){
				return "您没有足够的权限操作权限";
			}
			return editStr + "&nbsp;&nbsp;&nbsp;&nbsp;" + removeStr;
		}

		function editPower(obj) {
			/* $("#showModal").modal({
			    remote: "${ctx}/sysuser/showInfo/?id="+id
			}); */
			$("#id").val(obj.id);
			$("#powerName").val(obj.powerName);
			$("#powerNameCheck").val(obj.powerName);
			$("#powerAction").val(obj.powerAction);
			//$("#powerDisplay").val(obj.powerDisplay);
			if(obj.powerDisplay==1){
				$("#powerDisplay1").iCheck('check');
			}else{
				$("#powerDisplay2").iCheck('check');
			}
			$("#modularName").val(obj.modularName);
			$("#modularId").val(obj.modularId);
			$("#myModal").modal('show');
		}

		//删除按钮事件
		function deletePower(id) {
			layer.confirm('确定删除该权限吗？删除后不可恢复', {
				icon : 2,
				title : '温馨提示',
				skin : 'layui-layer-molv'
			}, function(index) {
				$.get("${ctx}/power/deletePower", {
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
				url : "${ctx}/power/powerList",
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
							//校验添加方法
							$.validator.addMethod("modularNameRequired",
									function(value, element, param) {
										/* var pattern = /^1[3,4,5,8,9][0-9]{9}$/
										return pattern.test(value); */
										var modularName = $("#modularName").val();
										if(modularName){
											$.get("${ctx}/modular/checkModularName",{modularName:modularName},function(data){
												if(data){
													//data true 说明没有输入正确
													$("#modularNameMsg").html("请选择正确的模块！");
												}else{
													//data false 说明输入正确
													if($("#modularId").val()){
														$("#modularNameMsg").html("");
													}else{
														$("#modularNameMsg").html("输入后请手动选择模块！")
													}
												}
											})
										}else{
											//无值
											$("#modularNameMsg").html("请选择正确的模块！");
										}
										return true;
									}, "所属模块不能为空")

							//为添加权限按钮绑定事件
							$("#add_power").click(function() {
								layer.open({
									type : 2,
									content : "${ctx}/power/toAddPower", //这里content是一个普通的String
									area : [ '500px', '500px' ],
									btn : [ 'yes', 'no' ]
								});
							});

							$.jgrid.defaults.styleUI = 'Bootstrap';

							// Configuration for jqGrid Example 1
							$("#table_list_1").jqGrid(
									{
										mtype : 'POST',
										url : "${ctx}/power/powerList",
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
										colNames : [ '序号', '权限名', '权限路径',
												'是否显示','权限编码', '所属模块', '操作' ],
										colModel : [ {
											name : 'id',
											width : 60,
										}, {
											name : 'powerName',
											width : 100,
										}, {
											name : 'powerAction',
											width : 250,
										}, {
											name : 'powerDisplay',
											width : 80,
											formatter : formatter_display,
										}, {
											name : 'precode',
											width : 200,
										}, {
											name : 'modularName',
											width : 100,
										}, {
											width : 150,
											formatter : formatter_operation,
										} ],
										pager : "#pager_list_1",
										viewrecords : true,
										caption : "权限列表",
										hidegrid : false
									});
							$("#table_list_1").jqGrid('navGrid', '#pager_list_1', {
								edit : false,
								add : false,
								refresh: true,
								del : false,
								search : false
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
							/* $.validator.addMethod("checkPowerNameExistOrSame", function(value,
									element, param) {
								var powerNameCheck = $("#powerNameCheck").val();
								console.log(powerNameCheck,"值")
								if(powerNameCheck==value){
									console.log(powerNameCheck==value)
									return true;
								}else{
									 $.get("${ctx}/power/checkPowerName",{powerName:$("#powerName").val()},function(data){
										console.log("data",data)
										return eval("("+data+")");
									}); 
									$.ajax({ 
								          type : "get", 
								          url : "${ctx}/power/checkPowerName", 
								          data : {powerName:$("#powerName").val()}, 
								          async : false, 
								          success : function(data){ 
								        	  console.log("data",data)
												return data;
								          } 
								          }); 
								}
							}, "该权限已存在") */

							/* jquery Validate 初始化 */
							$("#infoForm")
									.validate(
											{
												rules : {
													powerName : {
														required : true,
														//checkPowerNameExistOrSame :true,
														remote : {
															url : "${ctx}/power/checkPowerNameExistOrSame",
															type : "get",
															dataType : "json",
															data : {
																powerName : function() {
																	return $("#powerName").val();
																},powerNameCheck :function(){
																	return $("#powerNameCheck").val();
																}
															},

														},
													},
													powerAction : "required",
													powerDisplay : "required",
													modularName : "modularNameRequired",
												},
												messages : {
													powerName : {
														required : "权限名不能为空",
														remote : "该权限已存在"
														//checkPowerNameExistOrSame:"该权限已存在"
													},
													powerAction : "权限路径不能为空",
													powerDisplay : "请选择是否显示",
													modularName : "所属模块不能为空",
												},
												submitHandler : function() {
													//1、序列化表单
													var formDate = $(
															"#infoForm")
															.serialize();
													//2、使用ajax请求提交
													/* $.post("${ctx}/sysuser/adduser",{uname:$("#uname").val(),pwd:$("#pwd").val(),nickname:$("#nickname").val(),regtime:$("#regtime").val()},function(data){
														console.log(data);
													}) */
													$
															.post(
																	"${ctx}/power/editPower",
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
							/*搜索自动补齐*/
							var testBsSuggest = $("#modularName").bsSuggest({
								url : "${ctx}/modular/allModular",
								/*effectiveFields: ["userName", "shortAccount"],
								 searchFields: [ "shortAccount"],
								 effectiveFieldsAlias:{userName: "姓名"},*/
								idField : "id",
								keyField : "modularName",
								autoSelect : true,
							/* getDataMethod: "url", */
							}).on('onDataRequestSuccess', function(e, result) {
								//数据加载后执行
								//console.log('onDataRequestSuccess: ', result);
							}).on('onSetSelectValue', function(e, keyword) {
								//选择了之后执行
								//console.log('onSetSelectValue: ', keyword);
								$("#modularId").val(keyword.id);
							}).on('onUnsetSelectValue', function(e) {
								//没选择执行
								//console.log("onUnsetSelectValue");
								$("#modularId").val("");
							});
						});
	</script>

</body>

</html>