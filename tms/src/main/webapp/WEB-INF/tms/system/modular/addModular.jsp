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
					<h5>添加模块</h5>
				</div>
				<div class="ibox-content">
				
				<!-- enctype="multipart/form-data" -->
					<form class="form-horizontal m-t" method="post" id="addModularForm">
						<div class="form-group">
							<label class="col-sm-3 control-label">模块名：</label>
							<div class="col-sm-4">
								<input id="modularName" name="modularName" placeholder="请输入模块名" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						

						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-8">
								<shiro:hasPermission name="modular:add">
									<button class="btn btn-primary" type="submit">添加模块</button>
								</shiro:hasPermission>
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
		
		/* jquery Validate 添加自定义校验规则 */
		/* $.validator.addMethod(name,method,message) */
		/* $.validator.addMethod("checkPhone",function(value,element,param){
			var pattern = /^1[3,4,5,8,9][0-9]{9}$/
			return pattern.test(value);
		},"请输入11位有效的手机号码") */
		/* $.validator.addMethod("checkPhone",function(value,element,param){
			var pattern = /^1[3,4,5,8,9][0-9]{9}$/
			return pattern.test(value);
		},"请输入11位有效的手机号码") */
		
		/* jquery Validate 初始化 */
		$("#addModularForm").validate({
			rules:{
				modularName:{
					required:true,
					remote:{
						url:"${ctx}/modular/checkModularName",
						type:"get",
						dataType:"json",
						data:{
							modularName:function(){
								return $("#modularName").val();
							}
						},
						
					},
				},
			},messages:{
				modularName:{
					required:"模块名不能为空",
					remote:"该模块已存在"
				}
			},submitHandler:function(){
				//1、序列化表单
				var formData = $("#addModualrForm").serialize();
				//可以文件上传的
				//var formData = new FormData($("#addUserForm")[0]); 
				//2、使用ajax请求提交
				//{uname:$("#uname").val(),pwd:$("#pwd").val(),nickname:$("#nickname").val(),regtime:$("#regtime").val()}
				$.post("${ctx}/modular/addModular",formData,function(data){
					if(data.ok==1){
						layer.alert(data.msg, {
							skin: 'layui-layer-molv', //样式类名
							shift:4
							},function(index){
								layer.close(index);
								$("#addModularForm").resetForm();
							});
					}else{
						parent.layer.alert(data.msg,{
							skin: 'layui-layer-molv',
							shift:4
						});
					}
				})
/* 				$.ajax({url:"${ctx}/modular/addModular",type:'POST',data:formData,processData:false,contentType:false,success:function(data){
					if(data.ok==1){
						layer.alert(data.msg, {
							skin: 'layui-layer-molv', //样式类名
							shift:4
							},function(index){
								layer.close(index);
								$("#addModularForm").resetForm();
							});
					}else{
						parent.layer.alert(data.msg,{
							skin: 'layui-layer-molv',
							shift:4
						});
					}
				}
				}) */
			}
		});
		
		
	})
	
	</script>
	
</body>

</html>
