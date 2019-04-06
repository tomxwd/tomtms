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


<title>租车列表界面</title>
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
							<div class="row">
								<div class="col-sm-3">
								</div>
								<div class="col-sm-4">
									<input id="search" placeholder="请输入需要查询车辆的车牌号" name="search"
										class="form-control" type="text">
								</div>
								<div class="col-sm-2">
									<span onclick="searchList()" class="btn btn-primary">查询</span>
								</div>
								<div class="col-sm-2">
									<input type="hidden" id="rentCarId">
								</div>
								<div class="col-sm-1">
									<shiro:hasPermission name="car:rent">
										<span  onclick="rentCar()" class="btn btn-info">租车</span>
									</shiro:hasPermission>
								</div>
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
		
		function  fromatter_carImg(cellvalue,options,rowObject){
			return "<a class='fancybox' href='"+cellvalue+"' title='"+rowObject.brand+" "+rowObject.model+"'><img alt='"+rowObject.brand+" "+rowObject.model+"' style='width:120px;height:80px' src='"+cellvalue+"'/>";
		}

		function formatter_operation(cellvalue, options, rowObject) {
			var formObj = JSON.stringify(rowObject);
			var carInfofunc = "onclick='carInfo(" + rowObject.id + ")'";
			var carInfoStr = "";
			carInfoStr = "<a class='btn btn-info btn-sm'"+carInfofunc+"><i class='fa fa-check'></i>车辆详情</a>";
			if(carInfoStr==""){
				return "您没有足够的权限操作";
			}
			return carInfoStr;
		}
		
		function rentCar(){
			var id = $("#rentCarId").val();
			if(!id){
				layer.alert("请选择车辆再进行此操作！", {
					skin: 'layui-layer-molv', //样式类名
					shift:4
					});
				return;
			}
			$.get("${ctx}/car/checkDriverOwnCar",function(data){
				if(data.ok==0){
					layer.alert(data.msg, {
						skin: 'layui-layer-molv', //样式类名
						shift:4
						});
				}else{
					layer.confirm("确定租用这辆车吗？",{title:'温馨提示',skin: 'layui-layer-molv'},function(index){
						$.get("${ctx}/car/rentCarByCarId",{id:id},function(data){
							layer.alert(data.msg, {
								skin: 'layui-layer-molv', //样式类名
								shift:4
								});
							$("#table_list_1").trigger("reloadGrid");
							layer.close(index);
						});
					})
				}
			});
			
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
                url:"${ctx}/car/rentCarList",
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
			/* 	laydate({
					event:"focus",
					elem:"#regtime",
				}); */
				
				//搜索框绑定事件
				$("#search").keyup(function(event){
					if(event.keyCode==13){
						searchList();
					}
				});
					$.jgrid.defaults.styleUI = 'Bootstrap';

					// Configuration for jqGrid Example 1
					$("#table_list_1").jqGrid(
							{
								mtype : 'POST',
								url : "${ctx}/car/rentCarList",
								datatype : "json",
								jsonReader : {
									root : 'root',//数据
									page : 'page',//当前页数
									total : 'total',//总页数
									records : 'records',//总条数
									rows : 'size',
									id : 'id'
								},
								onSelectRow:function(rowid, status){
									$("#rentCarId").val(rowid);
								},
								height : 470,
								autowidth : true,
								shrinkToFit : true,
								//shrinkToFit:false,
								//autoScroll: true,
								rowNum : 10,
								rowList : [ 10, 20, 30, 50 ],
								emptyrecords : '没有符合条件的数据！',
								colNames : [ '序号','图片','车牌','燃油补贴费', '承包费用', '类型',
										'品牌','型号','价值/万元','购置日期','操作'],
								colModel : [ {
									name : 'id',
									width : 50,
								}, {
									name : 'carImg',
									width : 130,
									formatter : fromatter_carImg,
								}, {
									name : 'carNumber',
									width : 80
								}, {
									name : "fuelSubsidy",
									width : 80,
								}, {
									name : 'contractCost',
									width : 50,
									
								}, {
									name : 'speedChanger',
									width : 50,
									formatter : formatter_speedChanger
								}, {
									name : 'brand',
									width : 80,
								}, {
									name : "model",
									width : 80
								}, {
									name : 'carPrice',
									width : 80,
									formatter : formatter_carPrice
								}, {
									name : 'buyDate',
									width:80,
									formatter : formatter_date
								}, {
									width:80,
									formatter : formatter_operation
								}],
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

					/* jquery Validate 添加自定义校验规则 */
					/* $.validator.addMethod(name,method,message) */
					$.validator.addMethod("checkPhone",function(value,element,param){
						var pattern = /^1[3,4,5,8,9][0-9]{9}$/
						return pattern.test(value);
					},"请输入11位有效的手机号码")
					
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
					
					

				});
	</script>

</body>

</html>