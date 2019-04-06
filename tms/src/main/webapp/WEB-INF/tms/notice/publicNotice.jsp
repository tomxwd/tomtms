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


<title>公告列表界面</title>
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
									<a href="javascript:window.location.href='${ctx}/public/publicIndex'" class="btn btn-primary" type="button">返回</a>
								</div>
								<div class="col-sm-4">
									<input id="search" placeholder="请输入需要查询的公告标题" name="search"
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
	
	<div class="modal inmodal" id="noticeContentModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content animated flipInY">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">公告内容</h4>
					<small class="font-bold"></small>
				</div>
					<form class="form-horizontal m-t" method="post">
				<div id="noticeContentModalBody" class="modal-body">
					
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
		function dateAddZero(value){
			if(value<10){
				return "0"+value;
			}
			return value;
		}
		function formatDateLong(value){
			var time = new Date(value);
			var year = time.getFullYear();
			var month = time.getMonth() + 1;
			month = dateAddZero(month);
			var day = time.getDate();
			day = dateAddZero(day);
			var hour = time.getHours();
			hour = dateAddZero(hour);
			var minutes = time.getMinutes();
			minutes = dateAddZero(minutes);
			var second = time.getSeconds();
			second = dateAddZero(second);
			return year + "-" + month + "-" + day+" "+hour+":"+minutes+":"+second;
		}
	
		function formatter_date(cellvalue, options, rowObject) {
			return formatDateLong(cellvalue);
		}
		
		function formatter_title(cellvalue, options, rowObject) {
			return "<a href='${ctx}/notice/lookNoticeContentDetailById?id="+rowObject.id+"'>"+cellvalue+"</a>";;
		}
		
		function contentDetailFun(id) {
			$.post("${ctx}/notice/getNoticeContentById",{id:id},function(data){
				$("#noticeContentModalBody").html(data.content);
				$("#noticeContentModal").modal('show');
			})
		}
		
		function formatter_operation(cellvalue, options, rowObject) {
			var formObj = JSON.stringify(rowObject);
			//查看 
			var contentDetailFunc = "onclick='contentDetailFun(" + rowObject.id +")'";
			var contentDetailStr = "";
			contentDetailStr = "<a class='btn btn-info btn-sm'" + contentDetailFunc+">查看内容</a>";
			returnStr = contentDetailStr
			if(!returnStr){
				return "您没有权限操作！";
			}
			return returnStr;
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
                url:"${ctx}/notice/publicNoticeList",
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
								url : "${ctx}/notice/publicNoticeList",
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
								colNames : [ '标题','日期','操作'],
								colModel : [ {
									name : 'title',
									width : 250,
									formatter : formatter_title
								}, {
									name : 'createDate',
									width : 70,
									formatter : formatter_date
								}, {
									width:30,
									formatter : formatter_operation
								}],
								pager : "#pager_list_1",
								viewrecords : true,
								caption : "公告列表",
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