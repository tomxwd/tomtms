<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>添加用户页面</title>
<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">

		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>添加用户</h5>
				</div>
				<div class="ibox-content">
				
				<!-- enctype="multipart/form-data" -->
					<form class="form-horizontal m-t" method="post" id="addUserForm" enctype="multipart/form-data">
						
						<div class="form-group">
							<label class="col-sm-3 control-label">用户名：</label>
							<div class="col-sm-4">
								<input id="uname" name="username" placeholder="请输入用户名" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">昵称：</label>
							<div class="col-sm-4">
								<input id="nickname" name="nickname" placeholder="请输入昵称" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">密码：</label>
							<div class="col-sm-4">
								<input id="pwd" name="password" placeholder="请输入密码" class="form-control"
									type="password"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">确认密码：</label>
							<div class="col-sm-4">
								<input id="check_pwd" name="check_pwd" placeholder="请再次输入密码" class="form-control"
									type="password"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">用户角色：</label>
							<div class="col-sm-4">

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
							<div class="col-sm-4">
								<input id="phone" placeholder="必填" name="phone" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">电子邮箱：</label>
							<div class="col-sm-4">
								<input id="email" name="email" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">QQ：</label>
							<div class="col-sm-4">
								<input id="qq" name="qq" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">注册时间：</label>
							<div class="col-sm-4">
								<input id="regtime" name="regtime" class="form-control"
									type="text"
									class="layer-date laydate-icon">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">上传头像：</label>
							<div class="col-sm-4">
								<input id="head_img" name="headImg" class="form-control"
									type="file">
							</div>
						</div>
						
						

						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-8">
								<button class="btn btn-primary" type="submit">添加用户</button>
								<button class="btn btn-default" type="reset">重置</button>
							</div>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- 全局js -->
	<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
	<script src="${ctx}/js/bootstrap.min.js?v=3.3.6"></script>

	<!-- 自定义js -->
	<script src="${ctx}/js/content.js?v=1.0.0"></script>

	<!-- jQuery Validation plugin javascript-->
	<script src="${ctx}/js/plugins/validate/jquery.validate.min.js"></script>
	<script src="${ctx}/js/plugins/validate/messages_zh.min.js"></script>

	<script src="${ctx}/js/demo/form-validate-demo.js"></script>
	
	<!-- layerDate plugin javascript -->
	<script src="${ctx}/js/plugins/layer/laydate/laydate.js"></script>
	
	<!-- 表单校验jqueryvalidate -->
	<script src="${ctx}/js/plugins/validate/jquery.validate.min.js"></script>
	<!-- 表单校验默认的提示字 -->
	<script src="${ctx}/js/plugins/validate/messages_zh.min.js"></script>
	
	<!-- jqueryform表单插件 -->
	<script src="${ctx}/js/jquery.form.js"></script>
	
	<!-- layer javascript -->
	<script src="${ctx}/js/plugins/layer/layer.min.js"></script>
	
	<!-- 搜索自动补全插件 -->
	<script src="${ctx}/js/plugins/suggest/bootstrap-suggest.min.js"></script>
	
	<script type="text/javascript">
	$(function(){
		
		//外部js调用
		laydate({
			elem : '#regtime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event : 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
		
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
		$("#addUserForm").validate({
			rules:{
				username:{
					required:true,
					remote:{
						url:"${ctx}/sysuser/checkSysuserName",
						type:"get",
						dataType:"json",
						data:{
							uname:function(){
								return $("#uname").val();
							}
						},
						
					},
				},
				nickname:"required",
				password:"required",
				check_pwd:{
					required:true,
					equalTo:"#pwd"
				},
				phone:{
					required:true,
					checkPhone:true
				},
				email:"required",
				qq:"required",
				regtime:"required",
				roleName : "roleNameRequired",
			},messages:{
				username:{
					required:"用户名不能为空",
					remote:"该用户名已存在"
				},
				nickname:"昵称不能为空",
				password:"密码不能为空",
				check_pwd:{
					required:"确认密码为空",
					equalTo:"两次输入的密码不一样"
				},
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
				//var formData = $("#addUserForm").serialize();
				//可以文件上传的
				var formData = new FormData($("#addUserForm")[0]); 
				//2、使用ajax请求提交
				//{uname:$("#uname").val(),pwd:$("#pwd").val(),nickname:$("#nickname").val(),regtime:$("#regtime").val()}
				/* $.post("${ctx}/sysuser/addSysuser",formData,function(data){
					if(data.ok==1){
						layer.alert(data.msg, {
							skin: 'layui-layer-molv', //样式类名
							shift:4
							},function(index){
								layer.close(index);
								$("#addUserForm").resetForm();
							});
					}else{
						parent.layer.alert(data.msg,{
							skin: 'layui-layer-molv',
							shift:4
						});
					}
				})*/
				$.ajax({url:"${ctx}/sysuser/addSysuser",type:'POST',data:formData,processData:false,contentType:false,success:function(data){
					if(data.ok==1){
						layer.alert(data.msg, {
							skin: 'layui-layer-molv', //样式类名
							shift:4
							},function(index){
								layer.close(index);
								$("#addUserForm").resetForm();
							});
					}else{
						parent.layer.alert(data.msg,{
							skin: 'layui-layer-molv',
							shift:4
						});
					}
				}
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
		
	})
	
	</script>
	
</body>

</html>
