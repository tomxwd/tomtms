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


<title>维修记录列表界面</title>
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
									<input id="search" placeholder="请输入需要查询车主的姓名" name="search"
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
			return formatDate(cellvalue);
		}
		
		function formatter_completeDate(cellvalue,options,rowObject){
			if(cellvalue){
				return formatter_date(cellvalue,options,rowObject);
			}else{
				return  "<span style='color:yellow'>未维修</span>";
			}
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
		
		function formatter_driverName(cellvalue,options,rowObject){
			var driverInfofunc = "onclick='driverInfo(" + rowObject.carId + ")'";
			return "<a "+driverInfofunc+">"+cellvalue+"</a>";
		}
		
		function formatter_maintainState(cellvalue,options,rowObject){
			if(cellvalue==0){
				return "<span style='color:red'>维修中</span>";
			}else{
				return "<span style='color:green'>已维修</span>";
			}
		}
		
		function formatter_payState(cellvalue,options,rowObject){
			if(cellvalue==0){
				return "<span style='color:red'>未支付</span>";
			}else{
				return "<span style='color:green'>已支付</span>";
			}
		}
		
		function formatter_insuranceType(cellvalue,options,rowObject){
			if(cellvalue==0){
				return "<span style='color:red'>不保修</span>";
			}else if(cellvalue==1){
				return "<span style='color:blue'>保修</span>";
			}else{
				return "<span style='color:yellow'>待定</span>";
			}
		}
		
		function formatter_operation(cellvalue, options, rowObject) {
			var formObj = JSON.stringify(rowObject);
			var maintainInfofunc = "onclick='maintainInfo(" + rowObject.id + ","+rowObject.maintainState+")'";
			var maintainInfoStr = "";
			if(rowObject.maintainState==0){
				maintainInfoStr = "<a class='btn btn-warning btn-sm'"+maintainInfofunc+">维修反馈</a>";
			}else {
				maintainInfoStr = "<a class='btn btn-info btn-sm'"+maintainInfofunc+">维修详情</a>";
			}
			return maintainInfoStr;
		}
		
		function maintainInfo(id,state){
			if(state==1){
				//已维修 维修详情
				$.get("${ctx}/carMaintain/getMaintainInfoById",{id:id},function(data){
					$("#maintain_info_maintainTime").html(formatDate(data.maintaintime));
					$("#maintain_info_maintain_cost").html(data.maintainCost);
					$("#maintain_info_maintain_reson").html(data.maintainReson);
					$("#maintain_info_maintain_detail").html(data.maintainDetail);
					$("#maintain_info_feedback").html(data.feedback);
					$("#maintain_info_insurance_type").html(formatter_insuranceType(data.insuranceType));
					$("#maintain_info_pay_state").html(formatter_payState(data.payState));
					$("#maintain_info_complete_date").html(formatDate(data.completeDate));
					
					
					$("#maintainInfoModal").modal('show');
				});
			}else{
				//未维修 可执行完成反馈操作
				$.get("${ctx}/carMaintain/getMaintainInfoById",{id:id},function(data){
					
					$("#maintain_car_id").val(data.carId);
					$("#maintain_time").html(formatDate(data.maintaintime));
					$("#maintain_reson").html(data.maintainReson);
					$("#maintainFeedback").modal('show');
					
				});
			}
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
                url:"${ctx}/carMaintain/carMaintainList",
                postData:{'keyword':search}, //发送数据 
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
								url : "${ctx}/carMaintain/carMaintainList",
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
								colNames : [ '序号','报修人','原因','报修时间', '状态', '联系人电话',
										'支付状态','是否保修','完成时间','操作'],
								colModel : [ {
									name : 'id',
									width : 50,
								}, {
									name : 'driverName',
									width : 50,
									formatter : formatter_driverName
								}, {
									name : 'maintainReson',
									width : 100
								}, {
									name : "maintainTime",
									width : 50,
									formatter : formatter_date
								}, {
									name : 'maintainState',
									width : 50,
									formatter : formatter_maintainState
								}, {
									name : 'phone',
									width : 80,
								}, {
									name : 'payState',
									width : 80,
									formatter : formatter_payState
								}, {
									name : "insuranceType",
									width : 80,
									formatter : formatter_insuranceType
								}, {
									name : 'completeDate',
									width : 80,
									formatter : formatter_completeDate
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
											$("#maintainFeedback").modal('hide');
											$("#table_list_1").trigger("reloadGrid");
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