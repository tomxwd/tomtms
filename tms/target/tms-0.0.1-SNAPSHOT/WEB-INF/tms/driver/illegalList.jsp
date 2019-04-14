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


<title>违章记录列表界面</title>
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
								<div class="col-sm-2">
								</div>
								<div class="col-sm-8">
									<div class="col-sm-4">
									<input id="search" placeholder="请输入需要查询的司机姓名" name="search"
										class="form-control" type="text">
									</div>
										<div class="col-sm-4">
											<input placeholder="开始日期" class="form-control layer-date"
												id="start"> 
										</div>
										<div class="col-sm-4">
											<input placeholder="结束日期" class="form-control layer-date" 
												id="end">
										</div>
										
								</div>
								<div class="col-sm-2">
									<span onclick="searchList()" class="btn btn-primary">查询</span>
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
	
	<div class="modal inmodal" id="payIllegalModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">违章缴费</h4>
					<small class="font-bold"></small>
				</div>
					<form id="payIllgalForm" class="form-horizontal m-t" method="post">
				<div class="modal-body">
					<div class="form-group" align="center">
						<img alt="微信支付" src="${ctx}/tmsresource/payImg/wechatPay.jpg" style="width: 250px;height: 300px">
						&nbsp;<img alt="支付宝支付" src="${ctx}/tmsresource/payImg/aliPay.jpg" style="width: 250px;height: 300px">
					</div>
						<div class="form-group" align="center">
							<input type="hidden" name="id" id="payIllegal_id">
							<label id="payIllegal_cost" class="col-sm-8 control-label" style="font-size:20px">需缴费金额：</label>
						</div>
						
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">完成</button>
					<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
				</div>
					</form>
			</div>
		</div>
	</div>
	
	<div class="modal inmodal" id="editIllegalModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
			
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">编辑违章记录</h4>
					<small class="font-bold"></small>
				</div>
					<form id="editIllgalForm" class="form-horizontal m-t" method="post">
				<div class="modal-body">
						<input type="hidden" id="editIllegal_id" name="id">
						<div class="form-group">
							<label class="col-sm-3 control-label">违章原因：</label>
							<div class="col-sm-7">
								<input id="editIllegal_reson" name="illegalReson" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">违规费用：</label>
							<div class="col-sm-7">
								<input id="editIllegal_cost" name="illegalCost" class="form-control"
									type="text"
									class="valid">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">违章时间：</label>
							<div class="col-sm-7">
								<input id="editIllegal_date"  name="recordDate" class="form-control"
									type="text"
									class="layer-date laydate-icon">
							</div>
						</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">完成</button>
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
	<!-- jqueryform表单插件 -->
	<script src="${ctx}/js/jquery.form.js"></script>
	
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
		//日期范围限制
		var start = {
			elem : '#start',
			//format : 'YYYY/MM/DD hh:mm:ss',
			format : 'YYYY-MM-DD',
			//min : laydate.now(), //设定最小日期为当前日期
			//max : '2099-06-16 23:59:59', //最大日期
			min : '2000-01-01 23:59:59',
			max : laydate.now(),
			istime : true,
			istoday : false,
			choose : function(datas) {
				end.min = datas; //开始日选好后，重置结束日的最小日期
				end.start = datas //将结束日的初始值设定为开始日
			}
		};
		var end = {
			elem : '#end',
			//format : 'YYYY/MM/DD hh:mm:ss',
			format : 'YYYY-MM-DD',
			//min : laydate.now(),
			//max : '2099-06-16 23:59:59',
			min : '2000-01-01 23:59:59',
			max : laydate.now(),
			istime : true,
			istoday : false,
			choose : function(datas) {
				start.max = datas; //结束日选好后，重置开始日的最大日期
			}
		};
		laydate(start);
		laydate(end);
	
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
		
		function formatter_payDate(cellvalue, options, rowObject){
			if(cellvalue){
				return formatDate(cellvalue);
			}else{
				return "<span style='color:red'>待缴费</span>";
			}
		}
		
		function formatter_driverInfo(cellvalue, options, rowObject){
			var driverInfofunc = "onclick='driverInfo(" + rowObject.carId + ")'";
			return "<a "+driverInfofunc+">"+cellvalue+"</a>";
		}
		
		function formatter_carInfo(cellvalue,options,rowObject){
			var carInfofunc = "onclick='carInfo(" + rowObject.carId + ")'";
			return "<a class='btn btn-primary btn-sm'"+carInfofunc+">车辆详情</a>";
		}
		
		function formatter_payState(cellvalue, options, rowObject) {
			if(cellvalue==1){
				return "<span style='color:green'>已支付</span>";
			}else{
				return "<a class='btn btn-success btn-sm' onclick='payIllegal(" + rowObject.id + ","+rowObject.illegalCost+")'>支付</a>";
			}
		}
		
		function payIllegal(id,illegalCost){
			$("#payIllegal_id").val(id);
			var payIllegal_costHtml = "需缴费金额："+illegalCost;
			$("#payIllegal_cost").html(payIllegal_costHtml);
			$("#payIllegalModal").modal('show');
		}
		/* --------------------------------------------- */
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
		
		function formatter_driverName(cellvalue,options,rowObject){
			var driverInfofunc = "onclick='driverInfo(" + rowObject.carId + ")'";
			return "<a "+driverInfofunc+">"+cellvalue+"</a>";
		}

		function formatter_operation(cellvalue, options, rowObject) {
			var formObj = JSON.stringify(rowObject);
			var editInfofunc = "onclick='editIllegal(" + formObj + ")'";
			var removeInfofunc = "onclick='removeIllegal(" + rowObject.id + ")'";
			var editInfoStr = "";
			var removeInfoStr = "";
			<shiro:hasPermission name="illegal:edit">
				editInfoStr = "<a class='btn btn-info btn-sm'"+editInfofunc+">编辑</a>";
			</shiro:hasPermission>
			<shiro:hasPermission name="illegal:add">
				removeInfoStr = "&nbsp;&nbsp;&nbsp;&nbsp;<a class='btn btn-danger btn-sm'"+removeInfofunc+">删除</a>"
			</shiro:hasPermission>
			if(editInfoStr==""&&removeInfoStr==""){
				return "无法操作";
			}
			return editInfoStr+removeInfoStr;
		}
		
		function editIllegal(obj){
			$("#editIllegal_id").val(obj.id);
			$("#editIllegal_reson").val(obj.illegalReson);
			$("#editIllegal_date").val(formatter_date(obj.recordDate));
			if(obj.payState==1){
				$("#editIllegal_cost").attr("readonly","readonly");
			}else{
				$('#editIllegal_cost').removeAttr("readonly");
			}
			$("#editIllegal_cost").val(obj.illegalCost);
			$("#editIllegalModal").modal("show");
		}
		
		function removeIllegal(id){
			layer.confirm('确定删除该违章记录吗？删除后不可恢复',{icon:2 ,title:'温馨提示',skin: 'layui-layer-molv'},function(index){
				$.get("${ctx}/illegal/deleteIllegalRecord",{id:id},function(data){
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
			var startDate = $("#start").val();
			var endDate = $("#end").val();
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
                url:"${ctx}/illegal/illegalList",
                postData:{'keyword':search,'startDate':startDate,'endDate':endDate}, //发送数据 
                page:1 
            }).trigger("reloadGrid"); //重新载入
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
					elem:"#editIllegal_date",
				});
				
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
								url : "${ctx}/illegal/illegalList",
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
									
								},
								height : 470,
								autowidth : true,
								shrinkToFit : true,
								//shrinkToFit:false,
								//autoScroll: true,
								rowNum : 10,
								rowList : [ 10, 20, 30, 50 ],
								emptyrecords : '没有符合条件的数据！',
								colNames : [ '序号','违章原因','违章时间','违章费用', '支付状态', '缴费时间',
									'违章车辆','违章人','操作'],
								colModel : [ {
									name : 'id',
									width : 50,
								}, {
									name : 'illegalReson',
									width : 50,
								}, {
									name : 'recordDate',
									width : 100,
									formatter : formatter_date
								}, {
									name : "illegalCost",
									width : 50,
								}, {
									name : 'payState',
									width : 50,
									formatter : formatter_payState
								}, {
									name : 'payDate',
									width : 80,
									formatter : formatter_payDate
								}, {
									name : "carId",
									width : 80,
									formatter :formatter_carInfo
								}, {
									name : 'driverName',
									width : 80,
									formatter :formatter_driverInfo
								}, {
									width:80,
									formatter : formatter_operation
								}],
								pager : "#pager_list_1",
								viewrecords : true,
								caption : "违章信息列表",
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
					
					// 缴费
					$("#payIllgalForm").validate({
						rules:{
							id:"required",
						},messages:{
							id:"违章序号不能为空",
						},submitHandler:function(){
							var formDate = $("#payIllgalForm").serialize();
							$.post("${ctx}/illegal/payIllegal",formDate,function(data){
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
								$("#payIllegalModal").modal('hide');
								$("#table_list_1").trigger("reloadGrid");
							})
						}
					})
					//编辑记录
					$("#editIllgalForm").validate({
						rules:{
							id:"required",
							illegalReson:"required",
							illegalCost:"required",
							recordDate:"required",
						},messages:{
							id:"违章序号不能为空",
							illegalReson:"违章原因不能为空",
							illegalCost:"违章处罚费用不能为空",
							recordDate:"请选择违章日期",
						},submitHandler:function(){
							var formDate = $("#editIllgalForm").serialize();
							$.post("${ctx}/illegal/editIllegalRecord",formDate,function(data){
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
								$("#editIllegalModal").modal('hide');
								$("#table_list_1").trigger("reloadGrid");
							})
						}
					})
					

				});
	</script>

</body>

</html>