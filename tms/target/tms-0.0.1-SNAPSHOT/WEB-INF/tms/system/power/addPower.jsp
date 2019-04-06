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


<title>添加权限页面</title>
<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">
<link href="${ctx}/css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">

		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>添加权限</h5>
				</div>
				<div class="ibox-content">

					<!-- enctype="multipart/form-data" -->
					<form class="form-horizontal m-t" method="post" id="addPowerForm">
						<div class="form-group">
							<label class="col-sm-3 control-label">权限名：</label>
							<div class="col-sm-4">
								<input id="powerName" name="powerName" placeholder="请输入权限名"
									class="form-control" type="text" class="valid">
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
							<label class="col-sm-3 control-label">权限编码：</label>
							<div class="col-sm-4">
								<input id="precode" name="precode" placeholder="请输入权限编码，例：user:add"
									class="form-control" type="text" class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">是否显示：</label>
							<div class="col-sm-4">
								<div class="radio i-checks">
									<label> <input type="radio" value="1" checked="checked"
										name="powerDisplay"> <i></i> 是 <input type="radio"
										value="0" name="powerDisplay"> <i></i> 否
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">所属模块：</label>
							<div class="col-sm-4">

								<div class="input-group">
									<input type="text" class="form-control" id="modularName" name="modularName">
									<input type="hidden" readonly="readonly" id="modularId" name="modularId"/>
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
							<div class="col-sm-offset-3 col-sm-8">
								<shiro:hasPermission name="power:add">
									<button class="btn btn-primary" type="submit">添加权限</button>
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

	<!-- iCheck图标 -->
	<script src="${ctx}/js/plugins/iCheck/icheck.min.js"></script>

	<script type="text/javascript">
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
		$(function() {
			$('.i-checks').iCheck({
				checkboxClass : 'icheckbox_square-green',
				radioClass : 'iradio_square-green',
			});
			/* jquery Validate 添加自定义校验规则 */
			/* $.validator.addMethod(name,method,message) */
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

			/* jquery Validate 初始化 */
			$("#addPowerForm").validate({
				rules : {
					powerName : {
						required : true,
						remote : {
							url : "${ctx}/power/checkPowerName",
							type : "get",
							dataType : "json",
							data : {
								powerName : function() {
									return $("#powerName").val();
								}
							},

						},
					},
					powerAction : "required",
					precode : "required",
					powerDisplay : "required",
					modularName : "modularNameRequired",
				},
				messages : {
					powerName : {
						required : "权限名不能为空",
						remote : "该权限已存在"
					},
					powerAction : "权限路径不能为空",
					precode : "权限编码不能为空",
					powerDisplay : "请选择是否显示",
					modularName : "所属模块不能为空",
				},
				submitHandler : function() {
					
					if(!$("#modularId").val()){
						return;
					}
					
					//1、序列化表单
					var formData = $("#addPowerForm").serialize();
					//可以文件上传的
					//var formData = new FormData($("#addPowerForm")[0]);
					//2、使用ajax请求提交
					//{uname:$("#uname").val(),pwd:$("#pwd").val(),nickname:$("#nickname").val(),regtime:$("#regtime").val()}
					$.post("${ctx}/power/addPower",formData,function(data){
						if(data.ok==1){
							layer.alert(data.msg, {
								skin: 'layui-layer-molv', //样式类名
								shift:4
								},function(index){
									layer.close(index);
									$("#addPowerForm").resetForm();
								});
						}else{
							parent.layer.alert(data.msg,{
								skin: 'layui-layer-molv',
								shift:4
							});
						}
					})
					/*$.ajax({
						url : "${ctx}/power/addPower",
						type : 'POST',
						data : formData,
						processData : false,
						contentType : false,
						success : function(data) {
							if (data.ok == 1) {
								layer.alert(data.msg, {
									skin : 'layui-layer-molv', //样式类名
									shift : 4
								}, function(index) {
									layer.close(index);
									$("#addUserForm").resetForm();
								});
							} else {
								parent.layer.alert(data.msg, {
									skin : 'layui-layer-molv',
									shift : 4
								});
							}
						}
					})*/
				}
			});
			
			

		})
	</script>

</body>

</html>
