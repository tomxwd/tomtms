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


<title>车辆列表界面</title>
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

	<style> 
 	.ui-jqgrid .ui-jqgrid-bdiv { 
 	    border-top: 1px solid #E1E1E1; 
 	    overflow-x: auto; 
 	} 
 	.frozen-div, .frozen-bdiv {
 	    background-color: #E4E6E9;/*与网页背景色一致*/ */
 	} 
 	</style>

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
									<input id="search" placeholder="请输入需要查询的车牌号" name="search" class="form-control"
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
	
	<div class="modal inmodal" id="maintain" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">填写维修反馈</h4>
					<small class="font-bold"></small>
				</div>
					<form class="form-horizontal m-t" method="post" id="maintainForm">
				<div class="modal-body">
						<!-- 隐藏域 -->
						<input type="hidden" id="maintain_car_id" name="carId"/>
						<div class="form-group">
							<label class="col-sm-3 control-label">维修原因：</label>
							<div class="col-sm-7">
								<label class="control-label" id="maintain_reson"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">报修时间：</label>
							<div class="col-sm-7">
								<label class="control-label" id="maintain_time"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">维修费用(/元)：</label>
							<div class="col-sm-7">
								<input id="maintain_cost" name="maintainCost" class="form-control" placeholder="必填" type="text"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">是否保修：</label>
							<div class="col-sm-7">
								<select id="insurance_type" name="insuranceType" class="form-control">
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">维修具体内容：</label>
							<div class="col-sm-7">
								<textarea id="maintain_detail" name="maintainDetail" class="form-control"  placeholder="必填"  rows="3" cols="20"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">维修反馈：</label>
							<div class="col-sm-7">
								<textarea id="maintain_feedback" name="feedback" class="form-control"  rows="3" cols="20" placeholder="选填"></textarea>
							</div>
						</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
					<%-- <shiro:hasPermission name="user:edit"> --%>
						<button type="submit" class="btn btn-primary">保存</button>
					<%-- </shiro:hasPermission> --%>
				</div>
					</form>
			</div>
		</div>
	</div>
	
	<div class="modal inmodal" id="reson" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">填写拒绝理由</h4>
					<small class="font-bold"></small>
				</div>
					<form class="form-horizontal m-t" method="post" id="resonForm">
				<div class="modal-body">
						<!-- 隐藏域 -->
						<input type="hidden" id="car_id" name="reson_car_id"/>
						<input type="hidden" id="opear" name="carState"/>
						<input type="hidden" id="refuse_state" name="rentState"/>
						<div class="form-group">
							<label class="col-sm-3 control-label">理由：</label>
							<div class="col-sm-7">
								<textarea id="refuseReson" name="refuseReson" class="form-control"  rows="3" cols="20"></textarea>
							</div>
						</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
					<%-- <shiro:hasPermission name="user:edit"> --%>
						<button type="submit" class="btn btn-primary">保存</button>
					<%-- </shiro:hasPermission> --%>
				</div>
					</form>
			</div>
		</div>
	</div>
	
	<div class="modal inmodal" id="editCarModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">编辑车辆</h4>
					<small class="font-bold"></small>
				</div>
					<form class="form-horizontal m-t" method="post" enctype="multipart/form-data" id="editCarForm">
				<div class="modal-body">
					<div class="form-group" align="center">
						<img id="edit_carImg" alt="车辆图片" style="width: 450px;height: 300px">
					</div>
					<div class="form-group">
							<label class="col-sm-3 control-label">品牌：</label>
							<div class="col-sm-7">
								<input id="edit_brand" name="brand" placeholder="请输入车辆品牌" class="form-control"
									type="text"
									class="valid">
								<input id="edit_car_id" name="id" type="hidden">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">型号：</label>
							<div class="col-sm-7">
								<input id="edit_model" name="model" placeholder="请输入车辆型号" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">车牌号：</label>
							<div class="col-sm-7">
								<input id="edit_carNumber" name="carNumber" placeholder="请输入车牌号" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">发动机号：</label>
							<div class="col-sm-7">
								<input id="edit_engineNumber" placeholder="必填" name="engineNumber" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">车架号：</label>
							<div class="col-sm-7">
								<input id="edit_vinNum" name="vinNum" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">购置时间：</label>
							<div class="col-sm-7">
								<input id="edit_buyDate" name="buyDate" class="form-control"
									type="text"
									class="layer-date laydate-icon">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">车辆价值(/万元)：</label>
							<div class="col-sm-7">
								<input id="edit_carPrice" name="carPrice" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">燃油补贴：</label>
							<div class="col-sm-7">
								<input id="edit_fuelSubsidy" name="fuelSubsidy" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">承包费用(/月)：</label>
							<div class="col-sm-7">
								<input id="edit_contractCost" name="contractCost" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">车辆图片：</label>
							<div class="col-sm-7">
								<input name="car_Img" class="form-control"
									type="file">
							</div>
						</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">保存</button>
				</div>
					</form>
			</div>
		</div>
	</div>
	
	<div class="modal inmodal" id="carInfoModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">车辆详情</h4>
					<small class="font-bold"></small>
				</div>
					<form class="form-horizontal m-t" method="post" enctype="multipart/form-data">
				<div class="modal-body">
					<div class="form-group" align="center">
						<img id="info_carImg" alt="车辆图片" style="width: 450px;height: 300px">
					</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">品牌：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_brand"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">型号：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_model"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">车牌号：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_carNumber"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">发动机号：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_engineNumber"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">车架号：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_vinNum"></label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">购置时间：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_buyDate"></label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">车辆价值(/万元)：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_carPrice"></label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">燃油补贴：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_fuelSubsidy"></label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">承包费用(/月)：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_contractCost"></label>
							</div>
						</div>
						
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
				</div>
					</form>
			</div>
		</div>
	</div>
	
	<div class="modal inmodal" id="driverInfoModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">司机信息</h4>
					<small class="font-bold"></small>
				</div>
					<form class="form-horizontal m-t" method="post">
				<div class="modal-body">
					<div class="form-group" align="center">
						<img id="info_driver_Img" alt="司机图片" style="width: 120px;height: 150px">
					</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">姓名：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_driver_name"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">性别：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_driver_gender"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">电话：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_driver_phone"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">教育程度：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_driver_education"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">地址：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_driver_address"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">面貌：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_politics_status"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">身份证号：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_identity_number"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">电子邮箱：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_driver_email"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">qq：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_driver_qq"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">注册时间：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_regtime"></label>
							</div>
						</div>
						
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
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
	<!-- jqueryform表单插件 -->
	<script src="${ctx}/js/jquery.form.js"></script>
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
		
		function formatter_speedChanger(cellvalue, options, rowObject) {
			if(cellvalue==0){
				return "自动挡";
			}else{
				return "手动挡";
			}
		}
		
		function formatter_carPrice(cellvalue, options, rowObject) {
			return cellvalue+"万元";
		}
		
		//查看信息 包括两个按钮 一个编辑车辆 一个查看车主信息
		function formatter_info(cellvalue,options,rowObject){
			//车辆状态，0未使用，1已使用，2维修中，3租车审核 4退车审核
			var formObj = JSON.stringify(rowObject);
			var carInfofunc = "onclick='carInfo(" + rowObject.id + ")'";
			var driverInfofunc = "onclick='driverInfo(" + rowObject.id + ")'";
			var editfunc = "onclick='editCar(" + rowObject.id + ")'";
			var carInfoStr = "";
			var driverInfoStr = "";
			var editCarStr = "";
			carInfoStr = "&nbsp;&nbsp;&nbsp;&nbsp;<a class='btn btn-info btn-sm'"+carInfofunc+"><i class='fa fa-check'></i>车辆详情</a><br><br>";
			driverInfoStr = "&nbsp;&nbsp;&nbsp;&nbsp;<a class='btn btn-primary btn-sm'"+driverInfofunc+"><i class='fa fa-check'></i>司机信息</a><br><br>";
			<shiro:hasPermission name="car:edit">
				editCarStr = "&nbsp;&nbsp;&nbsp;&nbsp;<a class='btn btn-warning btn-sm'"+editfunc+"><i class='fa fa-check'></i>编辑车辆</a>";
			</shiro:hasPermission>
			if(rowObject.carState==0){
				driverInfofunc = "";
				driverInfoStr = "";
			}
			if(carInfoStr==""&&driverInfoStr==""&&editCarStr==""){
				return "您没有足够的权限操作";
			}
			return carInfoStr+driverInfoStr+editCarStr;
		}
		//查看司机信息
		function driverInfo(id){
			$.get("${ctx}/driver/getDriverInfoByCarId",{id:id},function(data){
				$("#info_driver_name").html(data.driverName);
				if(data.driverGender==0){
					$("#info_driver_gender").html("男");
				}else{
					$("#info_driver_gender").html("女");
				}
				if(data.driverEducation==0){
					$("#info_driver_education").html("小学");
				}else if(data.driverEducation==1){
					$("#info_driver_education").html("初中");
				}else if(data.driverEducation==2){
					$("#info_driver_education").html("高中");
				}else if(data.driverEducation==3){
					$("#info_driver_education").html("专科");
				}else {
					$("#info_driver_education").html("本科及以上");
				}
				$("#info_driver_address").html(data.driverAddress);
				if(data.politicsStatus==0){
					$("#info_politics_status").html("群众");
				}else if(data.politicsStatus==1){
					$("#info_politics_status").html("团员");
				}else {
					$("#info_politics_status").html("党员");
				}
				$("#info_driver_qq").html(data.qq);
				$("#info_driver_phone").html(data.phone);
				$("#info_driver_email").html(data.email);
				$("#info_regtime").html(formatDate(data.regtime))
				$("#info_identity_number").html(data.identityNumber);
				$("#info_driver_Img").attr("src",data.headimg);
				$("#driverInfoModal").modal('show');
			});
		}
		//查看车辆信息
		function carInfo(id){
			$.get("${ctx}/car/getOneCarInfo",{id:id},function(data){
				$("#info_brand").html(data.brand);
				$("#info_model").html(data.model);
				$("#info_carNumber").html(data.carNumber);
				$("#info_engineNumber").html(data.engineNumber);
				$("#info_vinNum").html(data.vinNum);
				$("#info_buyDate").html(formatDate(data.buyDate));
				$("#info_carPrice").html(data.carPrice);
				$("#info_fuelSubsidy").html(data.fuelSubsidy);
				$("#info_contractCost").html(data.contractCost);
				$("#info_carImg").attr("src",data.carImg);
				$("#carInfoModal").modal('show');
			});
		}
		//编辑车辆信息
		function editCar(id){
			$.get("${ctx}/car/getOneCarInfo",{id:id},function(data){
				$("#edit_car_id").val(data.id);
				$("#edit_brand").val(data.brand);
				$("#edit_model").val(data.model);
				$("#edit_carNumber").val(data.carNumber);
				$("#edit_engineNumber").val(data.engineNumber);
				$("#edit_vinNum").val(data.vinNum);
				//$("#edit_byDate").val(data.byDate);
				$("#edit_buyDate").val(formatDate(data.buyDate));
				$("#edit_carPrice").val(data.carPrice);
				$("#edit_fuelSubsidy").val(data.fuelSubsidy);
				$("#edit_contractCost").val(data.contractCost);
				$("#edit_carImg").attr("src",data.carImg);
				$("#editCarModal").modal('show');
			});
			
		}
		
		function formatter_carState(cellvalue, options, rowObject) {
			//车辆状态，0未使用，1已使用，2维修中，3租车审核 4退车审核
			if(cellvalue==0){
				return "<span style='color:green'>未使用</span>";
			} else if(cellvalue==1){
				return "<span style='color:red'>正在使用</span>";
			} else if(cellvalue==2){
				return "<span style='color:yellow'>维修中</span>";
			} else if(cellvalue==3){
				return "<span style='color:#00FFFF'>租车审核</span>";
			} else {
				//cellvalue==4
				return "<span style='color:saddlebrown'>退车审核</span>";
			}
			
		}
		
		function  fromatter_carImg(cellvalue,options,rowObject){
			return "<a class='fancybox' href='"+cellvalue+"' title='"+rowObject.brand+" "+rowObject.model+"'><img alt='"+rowObject.brand+" "+rowObject.model+"' style='width:120px;height:80px' src='"+cellvalue+"'/>";
		}

		function formatter_operation(cellvalue, options, rowObject) {
			var formObj = JSON.stringify(rowObject);
			//var dimissfunc = "onclick='dimissSysUser("+rowObject.id+","+rowObject.delstatus+")'";
			var rentExaminefunc1 = "";
			var rentExaminefunc2 = "";
			var backExaminefunc1 = "";
			var backExaminefunc2 = "";
			var maintainfunc = "";
			var removefunc = "onclick='deleteCar("+rowObject.id+")'";
			var examineStr = "";
			var maintainStr = "";
			var removeStr = "";
			//<shiro:hasPermission name="user:dimissOrRestore">
			<shiro:hasPermission name="car:">
				
			</shiro:hasPermission>
			if(rowObject.carState==3){
				//租车审核 1通过 2不通过
				rentExaminefunc1 = "onclick='examineCar("+rowObject.id+",1)'";
				rentExaminefunc2 = "onclick='examineCar("+rowObject.id+",2)'";
				<shiro:hasPermission name="car:examinerPass">
					examineStr = "&nbsp;&nbsp;&nbsp;&nbsp;<a class='btn btn-primary btn-sm'"+rentExaminefunc1+"><i class='fa fa-check'></i>审核通过</a>";
					examineStr += "<br><br>";
				</shiro:hasPermission>
				<shiro:hasPermission name="car:examinerRefuse">
					examineStr += "&nbsp;&nbsp;&nbsp;&nbsp;<a class='btn btn-default btn-sm'"+rentExaminefunc2+"><i class='fa fa-times'></i>驳回请求</a><br><br>";
				</shiro:hasPermission>
			}else if(rowObject.carState==4){
				//退车审核 3通过 4不通过
				backExaminefun1 = "onclick='examineCar("+rowObject.id+",3)'";
				backExaminefun2 = "onclick='examineCar("+rowObject.id+",4)'";
				<shiro:hasPermission name="car:examinerPass">
					examineStr = "&nbsp;&nbsp;&nbsp;&nbsp;<a class='btn btn-primary btn-sm'"+backExaminefun1+"><i class='fa fa-check'></i>审核通过</a>";
					examineStr += "<br><br>";
				</shiro:hasPermission>
				<shiro:hasPermission name="car:examinerRefuse">
					examineStr += "&nbsp;&nbsp;&nbsp;&nbsp;<a class='btn btn-default btn-sm'"+backExaminefun2+"><i class='fa fa-times'></i>驳回请求</a><br><br>";
				</shiro:hasPermission>
			}else if(rowObject.carState==2){
				//维修中 反馈
				<shiro:hasPermission name="maintain:feedback">
					maintainfunc = "onclick='maintainCar("+rowObject.id+")'";
					maintainStr = "&nbsp;&nbsp;&nbsp;&nbsp;<a class='btn btn-warning btn-sm'"+maintainfunc+"><i class='fa fa-check'></i>维修反馈</a><br><br>"
				</shiro:hasPermission>
			}
			//</shiro:hasPermission>
			<shiro:hasPermission name="car:delete">
				if(rowObject.carState==0){
					removeStr = "&nbsp;&nbsp;&nbsp;&nbsp;<a class='btn btn-danger btn-sm' "+removefunc+"><i class='fa fa-warning'>删除</a>";
				}
			</shiro:hasPermission>
			if(examineStr==""&&maintainStr==""&&removeStr==""){
				return "无法操作";
			}
			return examineStr+maintainStr+removeStr;
		}
		
		//维修反馈
		function maintainCar(id){
			//先回显基本信息
			$.get("${ctx}/carMaintain/getMaintainInfoByCarId",{carId:id},function(data){
				$("#maintain_car_id").val(data.carId);
				$("#maintain_time").html(formatDate(data.maintaintime));
				$("#maintain_reson").html(data.maintainReson);
				$("#maintain").modal('show');
			});
			
			
		}
		
		//审核该司机
		function examineCar(id,opear){
			var carState;
			var rentState;
			if(opear==1){
				statusStr = "确定该司机承包此车辆审核通过吗？";
				carState = 1;
				rentState = 1;
			}else if(opear==2) {
				statusStr = "确定该司机承包此车审核不通过吗？";
				carState = 0;
				rentState = 2;
			}else if(opear==3){
				statusStr = "确定该司机退车审核通过吗？";
				carState = 0;
				rentState = 4;
			}else {
				carState = 1;
				rentState = 3;
				statusStr = "确定该司机退车审核不通过吗？";
			}
			if(opear==2||opear==4){
				$("#car_id").val(id);
				$("#opear").val(carState);
				$("#refuseReson").val("");
				$("#refuse_state").val(rentState)
				$("#reson").modal('show');
			}else{
				layer.confirm(statusStr,{title:'温馨提示',skin: 'layui-layer-molv'},function(index){
					$.get("${ctx}/car/examinerPassDriverAndCar",{id:id,carState:carState,rentState:rentState},function(data){
						layer.alert(data.msg, {
							skin: 'layui-layer-molv', //样式类名
							shift:4
							});
						$("#table_list_1").trigger("reloadGrid");
						layer.close(index);
					});
				})
			}
		}
		
		//删除按钮事件
		function deleteCar(id){
			layer.confirm('确定删除这辆车吗？删除后不可恢复',{icon:2 ,title:'温馨提示',skin: 'layui-layer-molv'},function(index){
				$.get("${ctx}/car/deleteCar",{id:id},function(data){
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
                url:"${ctx}/car/carList",
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
				//外部js调用
				laydate({
					elem : '#edit_buyDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
					event : 'focus' //响应事件。如果没有传入event，则按照默认的click
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
								url : "${ctx}/car/carList",
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
								//shrinkToFit:false,
								//autoScroll: true,
								rowNum : 10,
								rowList : [ 10, 20, 30, 50 ],
								emptyrecords : '没有符合条件的数据！',
								colNames : [ '序号','图片', '车牌号', '类型', '品牌',
										'型号','购置日期','价值/万元','车架号','相关信息', '状态','操作' ],
								colModel : [ {
									name : 'id',
									width : 50,
								}, {
									name : 'carImg',
									width : 130,
									formatter : fromatter_carImg,
								}, {
									name : "carNumber",
									width : 80,
								}, {
									name : 'speedChanger',
									width : 50,
									formatter : formatter_speedChanger
								}, {
									name : 'brand',
									width : 50,
								}, {
									name : 'model',
									width : 80,
								}, {
									name : 'buyDate',
									width:80,
									formatter : formatter_date
								}, {
									name : 'carPrice',
									width : 80,
									formatter : formatter_carPrice
								}, {
									name : 'vinNum',
									width : 80
								}, {
									width : 100,
									formatter : formatter_info
								}, {
									name :'carState',
									width : 80,
									formatter : formatter_carState
								}, {
									width : 100,
									formatter : formatter_operation,
								} ],
								pager : "#pager_list_1",
								viewrecords : true,
								caption : "车辆信息列表",
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
					
					// 拒绝理由表单提交
					$("#resonForm").validate({
						rules:{
							car_id:"required",
							refuseReson:"required",
							rentState:"required",
							carState:"required"
						},messages:{
							car_id:"车辆序号不能为空",
							refuseReson:"拒绝理由不能为空！",
							rentState:"租借状态不能为空",
							carState:"车辆状态不能为空"
						},submitHandler:function(){
							if(!$("#car_id").val()){
								return;
							}
							var formDate = $("#resonForm").serialize();
							$.post("${ctx}/car/examinerRefuseDriver",formDate,function(data){
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
								$("#reson").modal('hide');
								$("#table_list_1").trigger("reloadGrid");
							})
						}
					})
					
					/* jquery Validate 初始化 */
					$("#editCarForm").validate({
						rules:{
							id:"required",
							brand: "required",
							model:"required",
							carNumber:"required",
							engineNumber:"required",
							vinNum:"required",
							buyDate:"required",
							carPrice:"required",
							fuelSubsidy:"required",
							contractCost: "required",
						},messages:{
							id:"车辆序号不能为空",
							brand: "车辆品牌不能为空",
							model:"车辆型号不能为空",
							carNumber:"车牌号不能为空",
							engineNumber:"发动机号不能为空",
							vinNum:"车架号不能为空",
							buyDate:"购置日期不能为空",
							carPrice:"价值不能为空",
							fuelSubsidy:"燃油补贴不能为空",
							contractCost: "承包费不能为空",
						},submitHandler:function(){
							//1、序列化表单
							//var formData = $("#addUserForm").serialize();
							//可以文件上传的
							var formData = new FormData($("#editCarForm")[0]); 
							//2、使用ajax请求提交
							$.ajax({url:"${ctx}/car/editCar",type:'POST',data:formData,processData:false,contentType:false,success:function(data){
								if(data.ok==1){
									layer.alert(data.msg, {
										skin: 'layui-layer-molv', //样式类名
										shift:4
										},function(index){
											layer.close(index);
											$("#editCarForm").resetForm();
											$("#table_list_1").trigger("reloadGrid");
											$("#editCarModal").modal('hide');
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
					
					$("#maintainForm").validate({
						rules:{
							carId:"required",
							maintainCost: "required",
							insuranceType:"required",
							maintainDetail:"required",
						},messages:{
							carId:"车辆id不能为空",
							maintainCost: "维修费用不能为空",
							insuranceType:"请选择是否保修",
							maintainDetail:"请填写维修细节",
						},submitHandler:function(){
							//1、序列化表单
							//var formData = $("#addUserForm").serialize();
							//可以文件上传的
							var formData = new FormData($("#maintainForm")[0]); 
							//2、使用ajax请求提交
							$.ajax({url:"${ctx}/carMaintain/maintainFeedBack",type:'POST',data:formData,processData:false,contentType:false,success:function(data){
								if(data.ok==1){
									layer.alert(data.msg, {
										skin: 'layui-layer-molv', //样式类名
										shift:4
										},function(index){
											layer.close(index);
											$("#maintainForm").resetForm();
											$("#table_list_1").trigger("reloadGrid");
											$("#maintain").modal('hide');
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
					
					

				});
	</script>

</body>

</html>