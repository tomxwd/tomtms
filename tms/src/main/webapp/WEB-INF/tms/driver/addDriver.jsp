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


<title>注册司机页面</title>
<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-content">
						<div class="row">
							<div class="col-sm-7 b-r">
								<h3 class="m-t-none m-b">注册</h3>
								<form class="form-horizontal m-t" method="post" id="addDriverForm" enctype="multipart/form-data">
						
						
						<div class="form-group">
							<label class="col-sm-3 control-label">用户名：</label>
							<div class="col-sm-7">
								<input id="uname" name="username" placeholder="请输入用户名" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">密码：</label>
							<div class="col-sm-7">
								<input id="pwd" name="password" placeholder="请输入密码" class="form-control"
									type="password"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">确认密码：</label>
							<div class="col-sm-7">
								<input id="check_pwd" name="check_pwd" placeholder="请再次输入密码" class="form-control"
									type="password"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">真实姓名：</label>
							<div class="col-sm-7">
								<input id="driverName" name="driverName" placeholder="请输入真实姓名" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">性别：</label>
							<div class="col-sm-7">
								<select class="form-control" id="driverGender" name="driverGender">
									<option value="0">男</option>
									<option value="1">女</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">教育程度：</label>
							<div class="col-sm-7">
								<select class="form-control" id="driverEducation" name="driverEducation">
									<option value="0">小学</option>
									<option value="1">初中</option>
									<option value="2">高中</option>
									<option value="3">专科</option>
									<option value="4">本科及以上</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">政治面貌：</label>
							<div class="col-sm-7">
								<select class="form-control" id="politicsStatus" name="politicsStatus">
									<option value="0">群众</option>
									<option value="1">共青团员</option>
									<option value="2">中共党员</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">身份证号：</label>
							<div class="col-sm-7">
								<input id="identityNumber" placeholder="填写身份证号" name="identityNumber" class="form-control"
									type="text"
									class="valid">
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
							<label class="col-sm-3 control-label">地址：</label>
							<div class="col-sm-7">
								<input id="driverAddress" placeholder="必填" name="driverAddress" class="form-control"
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
							<label class="col-sm-3 control-label">上传个人照片：</label>
							<div class="col-sm-7">
								<input id="myheadImg" name="myheadImg" class="form-control"
									type="file">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2"></label>
							<label class="control-label">我已阅读右侧相关注册需求说明:</label>
								<input id="check_read" name="check_read"
									type="checkbox">
							<p id="check_read_msg" style="color:red"></p>
						</div>
						
						

						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-8">
								<button class="btn btn-primary" type="submit">注册</button>
								<button class="btn btn-default" type="reset">重置</button>
							</div>
						</div>
						
					</form>
							</div>
							<div class="col-sm-5">
								<h4>还不是会员？</h4>
								<p>您可以注册一个新账户</p>
								<p class="text-center">
									<a href="form_basic.html"><i class="fa fa-sign-in big-icon"></i></a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

				
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
	
	<script type="text/javascript">
	$(function(){
		//外部js调用
		/* laydate({
			elem : '#regtime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event : 'focus' //响应事件。如果没有传入event，则按照默认的click
		}); */
		
		/* jquery Validate 添加自定义校验规则 */
		/* $.validator.addMethod(name,method,message) */
		$.validator.addMethod("checkPhone",function(value,element,param){
			var pattern = /^1[3,4,5,8,9][0-9]{9}$/
			return pattern.test(value);
		},"请输入11位有效的手机号码")
		
		
		/* jquery Validate 初始化 */
		$("#addDriverForm").validate({
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
				driverName:"required",
				password:"required",
				check_pwd:{
					required:true,
					equalTo:"#pwd"
				},
				driverGender :"required",
				driverEducation : "required",
				politicsStatus : "required",
				phone:{
					required:true,
					checkPhone:true
				},
				email:"required",
				qq:"required",
				regtime:"required",
				identityNumber : "required",
				driverAddress : "required",
				myheadImg : "required"
			},messages:{
				username:{
					required:"用户名不能为空",
					remote:"该用户名已存在"
				},
				driverName:"请输入真实姓名",
				password:"密码不能为空",
				check_pwd:{
					required:"确认密码为空",
					equalTo:"两次输入的密码不一样"
				},
				driverGender :"请选择性别",
				driverEducation : "请选择文化程度",
				politicsStatus : "required",
				phone:{
					required:"电话不能为空",
					checkPhone:"请输入11位有效的手机号码"
				},
				email:"邮箱不能为空",
				qq:"qq不能为空",
				regtime:" 注册日期不能为空",
				roleName :"用户角色不能为空",
				identityNumber : "请输入身份证号",
				driverAddress : "请输入联系地址",
				myheadImg : "请上传个人照片"
			},submitHandler:function(){
				$("#check_read_msg").html("");
				//1、序列化表单
				//var formData = $("#addUserForm").serialize();
				if(!$("#check_read").is(":checked")){
					$("#check_read_msg").html("<label class='col-sm-2'></label>请阅读相关要求并打钩")
					return;
				}
				//可以文件上传的
				var formData = new FormData($("#addDriverForm")[0]); 
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
				$.ajax({url:"${ctx}/driver/addDriver",type:'POST',data:formData,processData:false,contentType:false,success:function(data){
					if(data.ok==1){
						layer.alert(data.msg, {
							skin: 'layui-layer-molv', //样式类名
							shift:4
							},function(index){
								layer.close(index);
								$("#addDriverForm").resetForm();
								var index2 = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
								parent.layer.close(index2); //再执行关闭 
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
		
	
		
	})
	
	</script>
	
</body>

</html>
