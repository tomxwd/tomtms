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


<title>司机列表界面</title>
<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

<!-- jqgrid-->
<link href="${ctx}/css/plugins/jqgrid/ui.jqgrid.css?0820"
	rel="stylesheet">
<!-- 查看图片 -->
<link href="${ctx}/js/plugins/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">

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
								</div>
								<div class="col-sm-4">
									<input id="search" placeholder="请输入需要查询的司机名称" name="search" class="form-control"
										type="text" class="valid">
								</div>
								<button onclick="searchList()" class="btn btn-primary" type="submit">查询</button>
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
					<h4 class="modal-title">编辑司机</h4>
					<small class="font-bold"></small>
				</div>
					<form class="form-horizontal m-t" method="post" id="infoForm">
				<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-3 control-label">司机id：</label>
							<div class="col-sm-7">
								<input id="id" name="id" readonly="readonly"  placeholder="用户id" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">用户名：</label>
							<div class="col-sm-7">
								<input id="username" name="username" readonly="readonly"  placeholder="请输入用户名" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">昵称：</label>
							<div class="col-sm-7">
								<input id="nickname" name="nickname" placeholder="请输入昵称" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">用户角色：</label>
							<div class="col-sm-7">

								<div class="input-group">
									<input type="text" class="form-control" placeholder="必选" id="roleName" name="roleName">
									<input type="hidden" readonly="readonly" id="roleId" name="roleId"/>
									<div class="input-group-btn">
										<button type="button" class="btn btn-white dropdown-toggle"
											data-toggle="dropdown">
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu dropdown-menu-right" role="menu">
										</ul>
									</div>
								</div>
									<label style="color:#cc5965" id="roleNameMsg"></label>

							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">电话：</label>
							<div class="col-sm-7">
								<input id="phone" placeholder="必填" name="phone" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">电子邮箱：</label>
							<div class="col-sm-7">
								<input id="email" name="email" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">QQ：</label>
							<div class="col-sm-7">
								<input id="qq" name="qq" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">注册时间：</label>
							<div class="col-sm-7">
								<input id="regtime"  name="regtime" class="form-control"
									type="text"
									class="layer-date laydate-icon">
							</div>
						</div>

						<!-- <div class="form-group">
							<div class="col-sm-offset-3 col-sm-8">
								<button class="btn btn-sm btn-primary" type="submit">编辑完成</button>
							</div>
						</div> -->
						
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
					<shiro:hasPermission name="user:edit">
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
	
	<!-- Fancy box 查看图片 -->
	<script src="${ctx}/js/plugins/fancybox/jquery.fancybox.js"></script>

	<!-- Page-Level Scripts -->
	<script>
		//日期格式化
		function formatDate(value){
			var time = new Date(value);
			var year = time.getFullYear();
			var month = time.getMonth() + 1;
			if(month<10){
				month = "0"+month;
			}
			var day = time.getDate();
			if(day<10){
				day = "0"+day;
			}
			return year + "-" + month + "-" + day;
		}
	
		function formatter_date(cellvalue, options, rowObject) {
			return formatDate(cellvalue);
		}
		
		function formatter_gender(cellvalue, options, rowObject) {
			if(cellvalue==0){
				return "男";
			}else{
				return "女";
			}
		}
		
		function formatter_educate(cellvalue, options, rowObject) {
			if(cellvalue==0){
				return "小学";
			} else if(cellvalue==1){
				return "初中";
			} else if(cellvalue==2){
				return "高中";
			} else if(cellvalue==3){
				return "专科";
			} else {
				return "本科及以上";
			}
		}
		
		function formatter_politics(cellvalue, options, rowObject) {
			if(cellvalue==0){
				return "群众";
			} else if(cellvalue==1){
				return "团员";
			} else {
				return "党员";
			}
		}

		function formatter_status(cellvalue, options, rowObject) {
			if (cellvalue == 0) {
				return "<span style='color:yellow'>未审核</span>"
			} else if(cellvalue ==1){
				return "<span style='color:green'>审核通过</span>"
			} else {
				return "<span style='color:red'>审核未通过</span>"
			}
		}
		
		function  fromatter_headImg(cellvalue,options,rowObject){
			//<a class="fancybox" href="img/p3.jpg" title="图片11"> <img alt="image" src="img/p_big3.jpg" />
			return "<a class='fancybox' href='"+cellvalue+"' title='"+rowObject.driverName+"'><img alt='"+rowObject.driverName+"' style='width:100px;height:120px' src='"+cellvalue+"'/>";
		}

		function formatter_operation(cellvalue, options, rowObject) {
			var formObj = JSON.stringify(rowObject);
			//var editfunc = "onclick='editSysUser(" + formObj + ")'";
			//var dimissfunc = "onclick='dimissSysUser("+rowObject.id+","+rowObject.delstatus+")'";
			var examinefunc1 = "";
			var examinefunc2 = "";
			var removefunc = "onclick='deleteDriver("+rowObject.id+")'";
			var examineStr = "";
			var removeStr = "";
			//<shiro:hasPermission name="user:dimissOrRestore">
			if(rowObject.acountState==0){
				examinefunc1 = "onclick='examineDriver("+rowObject.id+",1)'";
				examinefunc2 = "onclick='examineDriver("+rowObject.id+",2)'";
				examineStr = "&nbsp;&nbsp;&nbsp;&nbsp;<a class='btn btn-info btn-sm'"+examinefunc1+"><i class='fa fa-check'></i>审核通过</a><br><br>";
				examineStr += "&nbsp;&nbsp;&nbsp;&nbsp;";
				examineStr += "<a class='btn btn-warning btn-sm'"+examinefunc2+"><i class='fa fa-times'></i>审核不通过</a><br><br>";
			}
			//</shiro:hasPermission>
			//<shiro:hasPermission name="user:delete">
				removeStr = "<a class='btn btn-danger btn-sm' "+removefunc+"><i class='fa fa-warning'>删除</a>";
			//</shiro:hasPermission>
			if(examineStr==""&&removeStr==""){
				return "您没有足够的权限操作用户";
			}
			return examineStr+"&nbsp;&nbsp;&nbsp;&nbsp;"+removeStr;
		}
		
		//审核该司机
		function examineDriver(id,opear){
			if(opear==1){
				statusStr = "确定该司机审核通过吗？";
			}else if(opear==2) {
				statusStr = "确定该司机审核不通过吗？";
			}
			layer.confirm(statusStr,{title:'温馨提示',skin: 'layui-layer-molv'},function(index){
				$.get("${ctx}/driver/examinerDriver",{id:id,acountState:opear},function(data){
					layer.alert(data.msg, {
						skin: 'layui-layer-molv', //样式类名
						shift:4
						});
					$("#table_list_1").trigger("reloadGrid");
					layer.close(index);
				});
			})
		}
		
		function editSysUser(obj) {
			/* $("#showModal").modal({
                remote: "${ctx}/sysuser/showInfo/?id="+id
            }); */
            $("#id").val(obj.id);
            $("#username").val(obj.username);
            $("#nickname").val(obj.nickname);
            $("#phone").val(obj.phone);
            $("#qq").val(obj.qq);
            $("#email").val(obj.email);
            $("#roleId").val(obj.roleId);
            $("#roleName").val(obj.roleName);
            $("#regtime").val(formatDate(obj.regtime));
            $("#myModal").modal('show');
		}
		
		//删除按钮事件
		function deleteDriver(id){
			layer.confirm('确定删除该司机吗？删除后不可恢复',{icon:2 ,title:'温馨提示',skin: 'layui-layer-molv'},function(index){
				$.get("${ctx}/driver/deleteDriver",{id:id},function(data){
					layer.alert(data.msg, {
						skin: 'layui-layer-molv', //样式类名
						shift:4
						});
					$("#table_list_1").trigger("reloadGrid");
					layer.close(index);
				});
			})
			
		}
		
		function searchList(){
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
			$("#table_list_1").jqGrid('setGridParam',{ 
                url:"${ctx}/driver/driverList",
                postData:{'keyword':search}, //发送数据 
                page:1 
            }).trigger("reloadGrid"); //重新载入
		}

		$(document).ready(
				function() {
					//初始化图片
					$('.fancybox').fancybox({
						openEffect : 'none',
						closeEffect : 'none'
					});
					
				//初始化日历插件	
				laydate({
					event:"focus",
					elem:"#regtime",
				});
				
				//搜索框绑定事件
				$("#search").keyup(function(event){
					if(event.keyCode==13){
						searchList();
					}
				});
				
				//为添加用户按钮绑定事件
				$("#add_driver").click(function(){
					layer.open({
						  type: 2, 
						  content: "${ctx}/sysuser/toAddSysuser", //这里content是一个普通的String
						  area: ['500px', '500px'],
						  btn: ['yes', 'no']
						});
				});
				

					$.jgrid.defaults.styleUI = 'Bootstrap';

					// Configuration for jqGrid Example 1
					$("#table_list_1").jqGrid(
							{
								mtype : 'POST',
								url : "${ctx}/driver/driverList",
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
								colNames : [ '序号', '证件照','姓名', '性别', '学历', '政治面貌',
										'身份证号', '审核状态', '操作' ],
								colModel : [ {
									name : 'id',
									width : 60,
								}, {
									name : 'headimg',
									width : 90,
									formatter : fromatter_headImg,
								}, {
									name : 'driverName',
									width : 60,
								}, {
									name : 'driverGender',
									width : 50,
									formatter : formatter_gender
								}, {
									name : "driverEducation",
									width : 80,
									formatter : formatter_educate
								}, {
									name : 'politicsStatus',
									width : 50,
									formatter : formatter_politics
								}, {
									name : 'identityNumber',
									width : 120,
								}, {
									name : 'acountState',
									width : 80,
									formatter : formatter_status
								}, {
									width : 100,
									formatter : formatter_operation,
								} ],
								pager : "#pager_list_1",
								viewrecords : true,
								caption : "司机信息列表",
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
					$.validator.addMethod("checkPhone",function(value,element,param){
						var pattern = /^1[3,4,5,8,9][0-9]{9}$/
						return pattern.test(value);
					},"请输入11位有效的手机号码")
					$.validator.addMethod("roleNameRequired",
					function(value, element, param) {
						/* var pattern = /^1[3,4,5,8,9][0-9]{9}$/
						return pattern.test(value); */
						var roleName = $("#roleName").val();
						if(roleName){
							$.get("${ctx}/role/checkRoleName",{roleName:roleName},function(data){
								if(data){
									//data true 说明没有输入正确
									$("#roleNameMsg").html("请选择正确的角色！");
								}else{
									//data false 说明输入正确
									if($("#roleId").val()){
										$("#roleNameMsg").html("");
									}else{
										$("#roleNameMsg").html("输入后请手动选择角色！")
									}
								}
							})
						}else{
							//无值
							$("#roleNameMsg").html("请选择正确的角色！");
						}
						return true;
					}, "用户角色不能为空")
					
					/* jquery Validate 初始化 */
					$("#infoForm").validate({
						rules:{
							nickname:"required",
							phone:{
								required:true,
								checkPhone:true
							},
							email:"required",
							qq:"required",
							regtime:"required",
							roleName : "roleNameRequired",
						},messages:{
							nickname:"昵称不能为空",
							phone:{
								required:"电话不能为空",
								checkPhone:"请输入11位有效的手机号码"
							},
							email:"邮箱不能为空",
							qq:"qq不能为空",
							regtime:" 注册日期不能为空",
							roleName :"用户角色不能为空"
						},submitHandler:function(){
							if(!$("#roleId").val()){
								return;
							}
							//1、序列化表单
							var formDate = $("#infoForm").serialize();
							//2、使用ajax请求提交
							/* $.post("${ctx}/sysuser/adduser",{uname:$("#uname").val(),pwd:$("#pwd").val(),nickname:$("#nickname").val(),regtime:$("#regtime").val()},function(data){
								console.log(data);
							}) */
							$.post("${ctx}/sysuser/editSysuser",formDate,function(data){
								if(data.ok==1){
									layer.alert(data.msg, {
										skin: 'layui-layer-molv', //样式类名
										shift:4
										},function(index){
											layer.close(index);
										});
								}else{
									parent.layer.alert(data.msg,{
										skin: 'layui-layer-molv',
										shift:4
									});
								}
								$("#myModal").modal('hide');
								$("#table_list_1").trigger("reloadGrid");
							})
						}
					});
					
					/*搜索自动补齐*/
					var testBsSuggest = $("#roleName").bsSuggest({
						url : "${ctx}/role/allRole",
						/*effectiveFields: ["userName", "shortAccount"],
						 searchFields: [ "shortAccount"],
						 effectiveFieldsAlias:{userName: "姓名"},*/
						idField : "id",
						keyField : "roleName",
						autoSelect : true,
						/* getDataMethod: "url", */
					}).on('onDataRequestSuccess', function(e, result) {
						//数据加载后执行
						//console.log('onDataRequestSuccess: ', result);
					}).on('onSetSelectValue', function(e, keyword) {
						//选择了之后执行
						//console.log('onSetSelectValue: ', keyword);
						$("#roleId").val(keyword.id);
					}).on('onUnsetSelectValue', function(e) {
						//没选择执行
						//console.log("onUnsetSelectValue");
						$("#roleId").val("");
					});

				});
	</script>

</body>

</html>