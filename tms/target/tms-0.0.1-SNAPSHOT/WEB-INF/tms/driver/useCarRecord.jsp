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


<title>查看租赁记录</title>
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
									<input id="search" placeholder="请输入需要查询的车牌号" name="search"
										class="form-control" type="text">
								</div>
								<div class="col-sm-2">
									<span onclick="searchList()" class="btn btn-primary">查询</span>
								</div>
								<div class="col-sm-2">
									<input type="hidden" id="rentCarId">
								</div>
								<div class="col-sm-1">
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
	
	<div class="modal inmodal" id="maintainInfoModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">维修详情</h4>
					<small class="font-bold"></small>
				</div>
					<form class="form-horizontal m-t" method="post">
				<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-3 control-label">维修时间：</label>
							<div class="col-sm-7">
								<label class="control-label" id="maintain_info_maintainTime"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">维修费(/元)：</label>
							<div class="col-sm-7">
								<label class="control-label" id="maintain_info_maintain_cost"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">报修原因：</label>
							<div class="col-sm-7">
								<label class="control-label" id="maintain_info_maintain_reson"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">维修详情：</label>
							<div class="col-sm-7">
								<label class="control-label" id="maintain_info_maintain_detail"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">维修反馈：</label>
							<div class="col-sm-7">
								<label class="control-label" id="maintain_info_feedback"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">保修类型：</label>
							<div class="col-sm-7">
								<label class="control-label" id="maintain_info_insurance_type"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">支付情况：</label>
							<div class="col-sm-7">
								<label class="control-label" id="maintain_info_pay_state"></label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">维修完成时间：</label>
							<div class="col-sm-7">
								<label class="control-label" id="maintain_info_complete_date"></label>
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
	
	<div class="modal inmodal" id="maintainFeedback" tabindex="-1" role="dialog"
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
					<shiro:hasPermission name="maintain:feedback">
						<button type="submit" class="btn btn-primary">保存</button>
					</shiro:hasPermission>
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
			if(!cellvalue){
				return "未完成租赁";
			}
			return formatDate(cellvalue);
		}
		
		function formatter_carNumber(cellvalue, options, rowObject) {
			return "<a href='#' onclick='carInfo("+rowObject.carId+")'>"+cellvalue+"</a>";
		}
		
		function formatter_carState(cellvalue, options, rowObject) {
			//车辆状态，0未使用，1已使用，2维修中，3租车审核 4退车审核
			var stateStr = "";
			if(cellvalue==0){
				stateStr = "<span style='color:green'>未使用</span>";
			}else if(cellvalue==1){
				stateStr = "<span style='color:red'>使用中</span>";
			}else if(cellvalue==2){
				stateStr = "<span style='color:yellow'>维修中</span>";
			}else if(cellvalue==3){
				stateStr = "<span style='color:blue'>租车审核</span>";
			}else{
				stateStr = "<span style='color:blue'>退车审核</span>";
			}
			return stateStr;
		}
		
		function formatter_rentState(cellvalue, options, rowObject){
			//租借状态 0审核中 1使用中 2使用审核未通过 3退车审核未通过 4已作废
			var rentStateStr = "";
			if(cellvalue==0){
				rentStateStr = "<span style='color:yellow'>审核中</span>";
			}else if(cellvalue==1){
				rentStateStr = "<span style='color:green'>使用中</span>";
			}else if(cellvalue==2){
				rentStateStr = "<span style='color:red'>使用审核未通过</span>";
			}else if(cellvalue==3){
				rentStateStr = "<span style='color:red'>退车审核未通过</span>";
			}else{
				rentStateStr = "<span style='color:gray'>已作废</span>";
			}
			return rentStateStr;
		}
		
		function formatter_deleteState(cellvalue, options, rowObject){
			//车辆删除状态 默认存在1 删除为0
			var deleteState = "";
			if(cellvalue==0){
				deleteState = "<span style='color:gray'>已报废</span>"
			}else{
				deleteState = "<span style='color:green'>仍在库</span>"
			}
			return deleteState;
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
		
		function formatter_driverName(cellvalue,options,rowObject){
			var driverInfofunc = "onclick='driverInfo(" + rowObject.carId + ")'";
			return "<a "+driverInfofunc+">"+cellvalue+"</a>";
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
                url:"${ctx}/driver/useCarRecordList",
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
								url : "${ctx}/driver/useCarRecordList",
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
								colNames : [ '车牌号','车辆状态','日期','租赁状态', '拒绝理由', '车辆状态',
										],
								colModel : [ {
									name : 'carNumber',
									width : 50,
									formatter : formatter_carNumber
								}, {
									name : 'carState',
									width : 50,
									formatter : formatter_carState
								}, {
									name : "rentTime",
									width : 50,
									formatter : formatter_date
								}, {
									name : 'rentState',
									width : 60,
									formatter : formatter_rentState
								}, {
									name : 'refuseReson',
									width : 250,
								}, {
									name : 'deleteState',
									width : 50,
									formatter : formatter_deleteState
								}],
								pager : "#pager_list_1",
								viewrecords : true,
								caption : "车辆使用记录列表",
								hidegrid : false
							});
					$("#table_list_1").jqGrid('navGrid', '#pager_list_1', {
						edit : false,
						add : false,
						refresh: true,
						del : false,
						search : false
					});

				});
	</script>

</body>

</html>