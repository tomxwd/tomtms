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


<title>添加车辆页面</title>
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
					<h5>添加车辆</h5>
				</div>
				<div class="ibox-content">
				
				<!-- enctype="multipart/form-data" -->
					<form class="form-horizontal m-t" method="post" id="addCarForm" enctype="multipart/form-data">
						
						<div class="form-group">
							<label class="col-sm-3 control-label">品牌：</label>
							<div class="col-sm-4">
								<input id="brand" name="brand" placeholder="请输入车辆品牌" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">型号：</label>
							<div class="col-sm-4">
								<input id="model" name="model" placeholder="请输入车辆型号" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">车牌号：</label>
							<div class="col-sm-4">
								<input id="carNumber" name="carNumber" placeholder="请输入车牌号" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">发动机号：</label>
							<div class="col-sm-4">
								<input id="engineNumber" placeholder="必填" name="engineNumber" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">车架号：</label>
							<div class="col-sm-4">
								<input id="vinNum" name="vinNum" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">购置时间：</label>
							<div class="col-sm-4">
								<input id="buyDate" name="buyDate" class="form-control"
									type="text"
									class="layer-date laydate-icon">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">车辆价值(/万元)：</label>
							<div class="col-sm-4">
								<input id="carPrice" name="carPrice" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">燃油补贴：</label>
							<div class="col-sm-4">
								<input id="fuelSubsidy" name="fuelSubsidy" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">承包费用(/月)：</label>
							<div class="col-sm-4">
								<input id="contractCost" name="contractCost" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">车辆图片：</label>
							<div class="col-sm-4">
								<input id="car_Img" name="car_Img" class="form-control"
									type="file">
							</div>
						</div>
						
						

						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-8">
								<shiro:hasPermission name="car:add">
									<button class="btn btn-primary" type="submit">添加车辆</button>
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
			elem : '#buyDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event : 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
		
		/* jquery Validate 添加自定义校验规则 */
		/* $.validator.addMethod(name,method,message) */
		$.validator.addMethod("checkPhone",function(value,element,param){
			var pattern = /^1[3,4,5,8,9][0-9]{9}$/
			return pattern.test(value);
		},"请输入11位有效的手机号码")

		
		
		/* jquery Validate 初始化 */
		$("#addCarForm").validate({
			rules:{
				brand: "required",
				model:"required",
				carNumber:"required",
				engineNumber:"required",
				vinNum:"required",
				buyDate:"required",
				carPrice:"required",
				fuelSubsidy:"required",
				contractCost: "required",
				car_Img : "required"
			},messages:{
				brand: "车辆品牌不能为空",
				model:"车辆型号不能为空",
				carNumber:"车牌号不能为空",
				engineNumber:"发动机号不能为空",
				vinNum:"车架号不能为空",
				buyDate:"购置日期不能为空",
				carPrice:"价值不能为空",
				fuelSubsidy:"燃油补贴不能为空",
				contractCost: "承包费不能为空",
				car_Img : "图片不能为空"
			},submitHandler:function(){
				//1、序列化表单
				//var formData = $("#addUserForm").serialize();
				//可以文件上传的
				var formData = new FormData($("#addCarForm")[0]); 
				//2、使用ajax请求提交
				$.ajax({url:"${ctx}/car/addCar",type:'POST',data:formData,processData:false,contentType:false,success:function(data){
					if(data.ok==1){
						layer.alert(data.msg, {
							skin: 'layui-layer-molv', //样式类名
							shift:4
							},function(index){
								layer.close(index);
								$("#addCarForm").resetForm();
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
