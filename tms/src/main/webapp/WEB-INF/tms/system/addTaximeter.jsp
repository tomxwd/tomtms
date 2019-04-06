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


<title>添加薪资记录页面</title>
<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">
<link href="${ctx}/css/plugins/ionRangeSlider/ion.rangeSlider.css"
	rel="stylesheet">
<link href="${ctx}/css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css"
	rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">

		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>添加薪资记录</h5>
				</div>
				<div class="ibox-content">

					<!-- enctype="multipart/form-data" -->
					<form class="form-horizontal m-t" method="post" id="addTaximeterForm">
						
						<div class="form-group">
							<label class="col-sm-3 control-label">选择司机：</label>
							<div class="col-sm-4">

								<div class="input-group">
									<input type="text" class="form-control" id="driverName" name="driverName">
									<input type="hidden" readonly="readonly" id="driverId" name="driverId"/>
									<div class="input-group-btn">
										<button type="button" class="btn btn-white dropdown-toggle"
											data-toggle="dropdown">
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu dropdown-menu-right" role="menu">
										</ul>
									</div>
								</div>
									<label style="color:#cc5965" id="modularNameMsg"></label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">此次收入：</label>
							<div class="col-sm-4">
								<div id="driver_income">
							
								</div>
							</div>
							<input type="hidden" id="driver_cost" name="cost">
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label"></label>
							<div style="color:red" id="driver_cost_msg"></div>
							</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-8">
								<shiro:hasPermission name="teximeter:add">
									<button class="btn btn-primary" type="submit">添加记录</button>
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
	
	<!-- IonRangeSlider -->
	<script src="${ctx}/js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>
	
	<script type="text/javascript">
	/*搜索自动补齐*/
	var driverSuggest = $("#driverName").bsSuggest({
		url : "${ctx}/driver/allDriver",
		effectiveFields: ["driverName"],
		/*effectiveFields: ["userName", "shortAccount"],
		 searchFields: [ "shortAccount"],
		 effectiveFieldsAlias:{userName: "姓名"},*/
		idField : "id",
		keyField : "driverName",
		autoSelect : true,
		/* getDataMethod: "url", */
	}).on('onDataRequestSuccess', function(e, result) {
		//数据加载后执行
		//console.log('onDataRequestSuccess: ', result);
	}).on('onSetSelectValue', function(e, keyword) {
		//选择了之后执行
		//console.log('onSetSelectValue: ', keyword);
		$("#driverId").val(keyword.id);
	}).on('onUnsetSelectValue', function(e) {
		//没选择执行
		//console.log("onUnsetSelectValue");
		$("#driverId").val("");
	});
	
		$(function() {
			
	        $("#driver_income").ionRangeSlider({
	            min: 0,
	            max: 500,
	            type: 'single',
	            to_shadow: true,
	            prefix: "&yen;",
	            keyboard: true,
	            step: 0.1,
	            postfix: " 元",
	            prettify: false,
	            hasGrid: true,
	            onFinish:function(data){
	            	$("#driver_cost").val(data.fromNumber);
	            },onChange:function(data){
	            	$("#driver_cost_msg").html("");
	            }
	        });
			
			/* jquery Validate 添加自定义校验规则 */
			/* $.validator.addMethod(name,method,message) */
			$.validator.addMethod("driverNameRequired",
					function(value, element, param) {
						/* var pattern = /^1[3,4,5,8,9][0-9]{9}$/
						return pattern.test(value); */
						var driverName = $("#driverName").val();
						if(driverName){
							if($("#driverId").val()){
								$("#modularNameMsg").html("");
							}else{
								$("#modularNameMsg").html("输入后请手动选择司机！")
							}
							return true;
						}else{
							//无值
							$("#modularNameMsg").html("请选择司机！");
						}
						return true;
					}, "请选择司机")

			/* jquery Validate 初始化 */
			$("#addTaximeterForm").validate({
				rules : {
					driverName : "driverNameRequired",
					cost:"required"
				},
				messages : {
					driverName : "请选择司机",
					cost:"请滑动滑块"
				},
				submitHandler : function() {
					
					if(!$("#driverId").val()){
						return;
					}
					console.log($("#driver_cost").val());
					if(!$("#driver_cost").val()){
						$("#driver_cost_msg").html("请滑动滑块")
						return;
					}else{
						$("#driver_cost_msg").html("");
					}
					
					//1、序列化表单
					var formData = $("#addTaximeterForm").serialize();
					//可以文件上传的
					//var formData = new FormData($("#addPowerForm")[0]);
					//2、使用ajax请求提交
					//{uname:$("#uname").val(),pwd:$("#pwd").val(),nickname:$("#nickname").val(),regtime:$("#regtime").val()}
					$.post("${ctx}/system/addTaximeter",formData,function(data){
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
					})
				}
			});
			
			

		})
	</script>

</body>

</html>
