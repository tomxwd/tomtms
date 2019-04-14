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


<title>个人车辆信息页面</title>
<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight blog">
		<div class="row">
			<div class="col-lg-4">
				<div class="ibox">
					<div class="ibox-content">
						<a class="btn-link">
							<h2>车辆信息</h2>
						</a>
						<br>
					<div id="carInfoDiv">	
							<div class="row form-group" align="center">
						<img id="info_carImg" alt="车辆图片" style="width: 300px;height: 200px">
					</div>
						<div class="row form-group">
							<div class="col-sm-1"></div>
							<label class="col-sm-4 control-label">品牌：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_brand"></label>
							</div>
						</div>
						<div class="row form-group">
						<div class="col-sm-1"></div>
							<label class="col-sm-4 control-label">型号：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_model"></label>
							</div>
						</div>
						<div class="row form-group">
						<div class="col-sm-1"></div>
							<label class="col-sm-4 control-label">车牌号：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_carNumber"></label>
							</div>
						</div>
						<div class="row form-group">
						<div class="col-sm-1"></div>
							<label class="col-sm-4 control-label">发动机号：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_engineNumber"></label>
							</div>
						</div>
						<div class="row form-group">
						<div class="col-sm-1"></div>
							<label class="col-sm-4 control-label">车架号：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_vinNum"></label>
							</div>
						</div>
						
						<div class="row form-group">
						<div class="col-sm-1"></div>
							<label class="col-sm-4 control-label">购置时间：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_buyDate"></label>
							</div>
						</div>
						
						<div class="row form-group">
						<div class="col-sm-1"></div>
							<label class="col-sm-4 control-label">车辆价值：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_carPrice"></label>
							</div>
						</div>
						
						<div class="row form-group">
						<div class="col-sm-1"></div>
							<label class="col-sm-4 control-label">燃油补贴：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_fuelSubsidy"></label>
							</div>
						</div>
						
						<div class="row form-group">
						<div class="col-sm-1"></div>
							<label class="col-sm-4 control-label">承包费用：</label>
							<div class="col-sm-7">
								<label class="control-label" id="info_contractCost"></label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-3">
								<shiro:hasPermission name="car:back">
									<button class="btn btn-primary" onclick="backCar()" type="button">退车</button>
								</shiro:hasPermission>
							</div>
							<div class="col-md-6">
								<shiro:hasPermission name="maintain:add">
									<button class="btn btn-warning" onclick="maintainCar()" type="button">报修</button>
								</shiro:hasPermission>
							</div>
						</div>
						</div>
					</div>
				</div>
				<div class="ibox">
					<div class="ibox-content">
						<a href="article.html" class="btn-link">
							<h2>半数用户弃用 Apple Music？苹果发话了</h2>
						</a>
						<div class="small m-b-xs">
							<strong>周 欣</strong> <span class="text-muted"><i
								class="fa fa-clock-o"></i> 3 小时前</span>
						</div>
						<p>前不久，苹果公司高级副总裁 Eddy Cue 还在宣称 Apple Music 试用期用户超 1100
							万，最近就有一份来自 MusicWatch 的调查报告，让人大跌眼镜。</p>
						<p>MusicWatch 针对美国 5000 名 13 岁以上人群进行抽样调查，得出数据：约有 77% 的 iOS
							用户知道 Apple Music，只有 11% 的用户正在使用它；而在已经注册 Apple Music
							三个月免费试用服务的用户中，48% 表示已经弃用，61% 称已关闭 iTunes 中的自动订阅功能。</p>
						<div class="row">
							<div class="col-md-6">
								<h5>标签：</h5>
								<button class="btn btn-primary btn-xs" type="button">调查</button>
								<button class="btn btn-white btn-xs" type="button">用户</button>
								<button class="btn btn-white btn-xs" type="button">Apple
									Music</button>
							</div>
							<div class="col-md-6">
								<div class="small text-right">
									<h5>状态：</h5>
									<div>
										<i class="fa fa-comments-o"> </i> 36 评论
									</div>
									<i class="fa fa-eye"> </i> 100 浏览
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="ibox">
					<div class="ibox-content">
						<a href="article.html" class="btn-link">
							<h2>关于新 Apple TV，这里有几点你应该知道的</h2>
						</a>
						<div class="small m-b-xs">
							<strong>李 谋</strong> <span class="text-muted"><i
								class="fa fa-clock-o"></i> 2 小时前</span>
						</div>
						<p>新版的 Apple TV 之前一直有传闻将在 WWDC 上亮相，可是事与愿违。下一代 iPhone
							即将于下月与大家见面，新版 Apple TV 将同新 iPhone 一起亮相的传言又是四起。而且现在的传言中还加入了新料。</p>
						<p>据 9to5Mac 的消息，Apple TV 不仅要在九月亮相，其诸多细节也一并被曝出。</p>
						<div class="row">
							<div class="col-md-6">
								<h5>标签：</h5>
								<button class="btn btn-white btn-xs" type="button">apple</button>
								<button class="btn btn-white btn-xs" type="button">tv</button>
								<button class="btn btn-white btn-xs" type="button">苹果</button>
							</div>
							<div class="col-md-6">
								<div class="small text-right">
									<h5>状态：</h5>
									<div>
										<i class="fa fa-comments-o"> </i> 11 评论
									</div>
									<i class="fa fa-eye"> </i> 46 浏览
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-8">
				<div class="ibox">
					<div class="ibox-content">
						<a class="btn-link">
							<h2>我的车辆维修记录</h2>
						</a>
						<br>
						<div id="maintainInfoDiv">
							
						</div>
						<div class="row">
							<div class="col-md-6">
							</div>
							<div class="col-md-6">
							</div>
						</div>
					</div>
				</div>
				<div class="ibox">
					<div class="ibox-content">
						<a class="btn-link">
							<h2>我的车辆违章记录</h2>
						</a>
						<br>
						<div id="illegalInfoDiv">
							
						</div>
						<div class="row">
							<div class="col-md-6">
							</div>
							<div class="col-md-6">
							</div>
						</div>
					</div>
				</div>
				<div class="ibox">
					<div class="ibox-content">
						<a  class="btn-link">
							<h2>薪水</h2>
						</a>
						<div class="small m-b-xs">
							<strong>陈一斌</strong> <span class="text-muted"><i
								class="fa fa-clock-o"></i> 7 小时前</span>
						</div>
						<div id="salaryInfoDiv"></div>
						<div class="row">
							<div class="col-md-6">
								<h5>标签：</h5>
								<button class="btn btn-white btn-xs" type="button">蔺德刚</button>
								<button class="btn btn-white btn-xs" type="button">性快乐</button>

							</div>
							<div class="col-md-6">
								<div class="small text-right">
									<h5>状态：</h5>
									<div>
										<i class="fa fa-comments-o"> </i> 22 评论
									</div>
									<i class="fa fa-eye"> </i> 17 浏览
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	
	
	<div class="modal inmodal" id="maintainModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">填写车辆报修信息</h4>
					<small class="font-bold"></small>
				</div>
					<form class="form-horizontal m-t" method="post" id="maintainForm">
				<div class="modal-body">
						<div class="form-group">
							<label class="col-sm-3 control-label">维修原因：</label>
							<div class="col-sm-7">
								<input id="maintainReson" name="maintainReson" placeholder="请简要说明报修原因" class="form-control"
									type="text"
									class="valid">
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
	
		<div class="modal inmodal" id="payMaintainModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">维修缴费</h4>
					<small class="font-bold"></small>
				</div>
					<form id="payMaintainForm" class="form-horizontal m-t" method="post">
				<div class="modal-body">
					<div class="form-group" align="center">
						<img alt="微信支付" src="${ctx}/tmsresource/payImg/wechatPay.jpg" style="width: 250px;height: 300px">
						&nbsp;<img alt="支付宝支付" src="${ctx}/tmsresource/payImg/aliPay.jpg" style="width: 250px;height: 300px">
					</div>
						<div class="form-group" align="center">
							<input type="hidden" name="id" id="payMaintain_id">
							<label id="payMaintain_cost" class="col-sm-8 control-label" style="font-size:20px">需缴费金额：</label>
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
	
	function formatter_insuranceType(cellvalue,options,rowObject){
		if(cellvalue==0){
			return "<span style='color:red'>不保修</span>";
		}else if(cellvalue==1){
			return "<span style='color:blue'>保修</span>";
		}else{
			return "<span style='color:yellow'>待定</span>";
		}
	}
	
	function formatter_payState(cellvalue,options,rowObject){
		if(cellvalue==0){
			return "<span style='color:red'>未支付</span>";
		}else{
			return "<span style='color:green'>已支付</span>";
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
	
	function backCar(){
		
		$.get("${ctx}/car/checkDriverOwnExam",function(data){
			if(data.ok==0){
				layer.alert(data.msg, {
					skin: 'layui-layer-molv', //样式类名
					shift:4
					});
			}else{
				layer.confirm("确定退了这辆车吗？",{title:'温馨提示',skin: 'layui-layer-molv'},function(index){
					$.get("${ctx}/car/backCarByCarId",function(data){
						if(data.ok==1){
							layer.alert(data.msg, {
								skin: 'layui-layer-molv', //样式类名
								shift:4
								},function(index){
									layer.close(index);
									window.location.href=window.location.href
								});
						}else{
							parent.layer.alert(data.msg,{
								skin: 'layui-layer-molv',
								shift:4
							});
						}
					})
				})
			}
		});
		
		
	}
	
	function maintainCar(){
		$.get("${ctx}/car/checkDriverOwnMaintain",function(data){
			if(data.ok==0){
				layer.alert(data.msg, {
					skin: 'layui-layer-molv', //样式类名
					shift:4
					});
			}else{
				$("#maintainModal").modal('show');
			}
		});
	}
	
	//显示车辆信息
	function carInfo(){
		$.get("${ctx}/carInfo/getCarInfo",function(data){
			if(!data){
				$("#carInfoDiv").html("您还没有租借车辆");
				return;
			}
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
	//显示维修记录信息
	function maintainInfo(){
		$.get("${ctx}/driverAndCarInfo/getMaintainInfo",function(data){
			console.log(data.length)
			if(data.length==0){
				$("#maintainInfoDiv").html("您的车辆保养的很好，暂时没有维修过！");
				return;
			}
			var record="";
			var records = "";
			var maintainInfoFun = "";
			var payMaintainFun = "";
			records += "<table  class='table table-bordered'><tbody>"
			for(var i=0;i<data.length;i++){
				maintainInfoFun = "onclick='maintainDetailInfo(" + data[i].id + ")'";
				payMaintainFun = "onclick='maintainPay("+data[i].id+","+data[i].maintainCost+")'"
				record = "<tr><td>时间："+formatDate(data[i].maintaintime)+"</td><td>原因："+data[i].maintainReson+"</td>";
				if(data[i].maintainCost){
					record+="<td>费用："+data[i].maintainCost+"元</td>";
				}else{
					record+="<td><span style='color:yellow'>未维修</span></td>"
				}
				if(data[i].payState==0){
					if(data[i].maintainCost){
						record += "<td><a class='btn btn-primary btn-sm'"+payMaintainFun+">点击缴费</a></td>"
					}else{
						record += "<td><span style='color:yellow'>未维修</span></td>"
					}
				}else{
					record += "<td><span style='color:green'>已缴费</span></td>"
				}
				if(data[i].maintainState==0){
					record += "<td><span style='color:yellow'>未维修</span></td>";
				}else{
					record += "<td><a class='btn btn-info btn-sm'"+maintainInfoFun+">维修详情</a></td>";
				}
				record += "</tr>"
				records += record;
			}
			records +="</tbody></table>"
			$("#maintainInfoDiv").html(records);
		})
	}
	//显示维修详情函数
	function maintainDetailInfo(id){
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
	}
	//维修缴费函数
	function maintainPay(id,cost){
		$("#payMaintain_id").val(id);
		var costHtml = "需缴费金额："+cost+"元";
		$("#payMaintain_cost").html(costHtml);
		$("#payMaintainModal").modal('show');
	}
	
	//显示车辆违章信息
	function illegalInfo(){
		$.get("${ctx}/driverAndCarInfo/getIllegalInfo",function(data){
			if(data.length==0){
				$("#illegalInfoDiv").html("您的驾驶技术很棒！未违章行驶过！");
				return;
			}
			var record="";
			var records = "";
			var payIllegalFun = "";
			records += "<table  class='table table-bordered'><tbody>"
			for(var i=0;i<data.length;i++){
				payIllegalFun = "onclick='illegalPay("+data[i].id+","+data[i].illegalCost+")'"
				record = "<tr><td>时间："+formatDate(data[i].recordDate)+"</td><td>原因："+data[i].illegalReson+"</td><td>费用："+data[i].illegalCost+"元</td>";
				if(data[i].payState==0){
					record += "<td><a class='btn btn-primary btn-sm'"+payIllegalFun+">点击缴费</a></td>"
				}else{
					record += "<td><span style='color:green'>已缴费</span></td>"
				}
				record += "</tr>"
				records += record;
			}
			records +="</tbody></table>"
			$("#illegalInfoDiv").html(records);
		})
	}
	//违章缴费函数
	function illegalPay(id,illegalCost){
		$("#payIllegal_id").val(id);
		var payIllegal_costHtml = "需缴费金额："+illegalCost;
		$("#payIllegal_cost").html(payIllegal_costHtml);
		$("#payIllegalModal").modal('show');
	}
	
	$(function(){
		
		carInfo();
		maintainInfo();
		illegalInfo();
		
		/* //外部js调用
		laydate({
			elem : '#buyDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event : 'focus' //响应事件。如果没有传入event，则按照默认的click
		}); */
		
		/* jquery Validate 添加自定义校验规则 */
		/* $.validator.addMethod(name,method,message) */
		$.validator.addMethod("checkPhone",function(value,element,param){
			var pattern = /^1[3,4,5,8,9][0-9]{9}$/
			return pattern.test(value);
		},"请输入11位有效的手机号码")

		
		$("#maintainForm").validate({
			rules:{
				maintainReson: "required",
			},messages:{
				maintainReson: "请填写报修原因",
			},submitHandler:function(){
				//1、序列化表单
				var formDate = $("#maintainForm").serialize();
				//2、使用ajax请求提交
				$.post("${ctx}/carMaintain/addMaintain",formDate,function(data){
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
					$("#maintainForm").resetForm();
					$("#maintainModal").modal('hide');
					maintainInfo();
				})
			}
		});
		
		// 维修缴费
		$("#payMaintainForm").validate({
			rules:{
				id:"required",
			},messages:{
				id:"维修记录序号不能为空",
			},submitHandler:function(){
				var formDate = $("#payMaintainForm").serialize();
				$.post("${ctx}/carMaintain/payMaintain",formDate,function(data){
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
					$("#payMaintainModal").modal('hide');
					maintainInfo();
				})
			}
		})
		// 违章缴费
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
					illegalInfo();
				})
			}
		})
		
	})
	
	</script>
	
</body>

</html>
