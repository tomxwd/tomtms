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
			if(rowObject.noticeShow==1){
				return "<a href='${ctx}/notice/lookNoticeContentDetailById?id="+rowObject.id+"' style='color:green'>"+cellvalue+"(已展示)"+"</a>";
			}
			return "<a href='${ctx}/notice/lookNoticeContentDetailById?id="+rowObject.id+"'>"+cellvalue+"</a>";;
		}
		
		function formatter_status(cellvalue,options,rowObject){
			if(cellvalue==0){
				return "<span style='color:red'>已删除</span>";
			}else{
				return "<span style='color:green'>未删除</span>";
			}
		}
		
		function formatter_show(cellvalue,options,rowObject){
			if(cellvalue==0){
				return "<span style='color:red'>未展示</span>";
			}else{
				return "<span style='color:green'>正在展示</span>";
			}
		}
		
		function contentDetailFun(id) {
			$.post("${ctx}/notice/getNoticeContentById",{id:id},function(data){
				$("#noticeContentModalBody").html(data.content);
				$("#noticeContentModal").modal('show');
			})
		}
		
		function showOrDownShowNotice(id,noticeShow,confirmMsg){
			layer.confirm(confirmMsg,{title:'温馨提示',skin: 'layui-layer-molv'},function(index){
				$.get("${ctx}/notice/showOrDownNotice",{id:id,noticeShow:noticeShow},function(data){
					layer.alert(data.msg, {
						skin: 'layui-layer-molv', //样式类名
						shift:4
						});
					if(data.ok==1){
						$("#table_list_1").trigger("reloadGrid");
					}
					layer.close(index);
				});
			})
		}
		
		function showNotice(id){
			showOrDownShowNotice(id,1,"确定展示这条公告吗？");
		}
		
		function downShowNotice(id){
			showOrDownShowNotice(id,0,"确定撤下这条公告吗？");
		}
		
		function deleteOrRestroeNotice(id,noticeStatus,confirmMsg){
			layer.confirm(confirmMsg,{title:'温馨提示',skin: 'layui-layer-molv'},function(index){
				$.get("${ctx}/notice/deleteOrRestroeNoticeById",{id:id,noticeStatus:noticeStatus,noticeShow:0},function(data){
					layer.alert(data.msg, {
						skin: 'layui-layer-molv', //样式类名
						shift:4
						});
					if(data.ok==1){
						$("#table_list_1").trigger("reloadGrid");
					}
					layer.close(index);
				});
			})
		}
		
		function deleteNotice(id,noticeShow) {
			deleteOrRestroeNotice(id,0,"确定要删除这条公告吗？");
		}
		
		function restroeNotice(id) {
			deleteOrRestroeNotice(id,1,"确定要恢复这条公告吗？");
		}
		
		function formatter_operation(cellvalue, options, rowObject) {
			var formObj = JSON.stringify(rowObject);
			//查看 前台展示 下架 删除
			var contentDetailFunc = "onclick='contentDetailFun(" + rowObject.id +")'";
			var showFunc = "onclick='showNotice("+rowObject.id+")'";
			var downShowFunc = "onclick='downShowNotice("+rowObject.id+")'";
			var deleteFunc = "onclick='deleteNotice("+rowObject.id+")'";
			var restroeFunc = "onclick='restroeNotice("+rowObject.id+")'";
			var contentDetailStr = "";
			var showStr = "";
			var deleteOrRestroeStr = "";
			var returnStr = "";
			contentDetailStr = "<a class='btn btn-info btn-sm'" + contentDetailFunc+">内容</a>";
			<shiro:hasPermission name="notice:showOrDown">
				if(rowObject.noticeShow==0){
					showStr = "<a class='btn btn-primary btn-sm'"+showFunc+">展示</a>";
				}else{
					showStr = "<a class='btn btn-danger btn-sm'"+downShowFunc+">撤下</a>";
				}
			</shiro:hasPermission>
			<shiro:hasPermission name="notice:deleteOrRestroe">
				if(rowObject.noticeStatus==1){
					deleteOrRestroeStr = "<a class='btn btn-danger btn-sm'"+deleteFunc+">删除</a>";
				}else {
					deleteOrRestroeStr = "<a class='btn btn-warning btn-sm'"+restroeFunc+">恢复</a>";
				}
			</shiro:hasPermission>
			returnStr = contentDetailStr+"&nbsp;&nbsp;"+showStr+"&nbsp;&nbsp;"+deleteOrRestroeStr;
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
                url:"${ctx}/notice/noticeList",
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
								url : "${ctx}/notice/noticeList",
								datatype : "json",
								jsonReader : {
									root : 'root',//数据
									page : 'page',//当前页数
									total : 'total',//总页数
									records : 'records',//总条数
									rows : 'size',
									id : 'id'
								},onSelectRow:function(rowid, status){
									
								},
								height : 470,
								autowidth : true,
								shrinkToFit : true,
								//shrinkToFit:false,
								//autoScroll: true,
								rowNum : 10,
								rowList : [ 10, 20, 30, 50 ],
								emptyrecords : '没有符合条件的数据！',
								colNames : [ '序号','标题','提交时间','删除状态', '有无展示', '操作'],
								colModel : [ {
									name : 'id',
									width : 50,
								}, {
									name : 'title',
									width : 250,
									formatter : formatter_title
								}, {
									name : 'createDate',
									width : 70,
									formatter : formatter_date
								}, {
									name : "noticeStatus",
									width : 32,
									formatter : formatter_status
								}, {
									name : 'noticeShow',
									width : 32,
									formatter : formatter_show
								}, {
									width:100,
									formatter : formatter_operation
								}],
								pager : "#pager_list_1",
								viewrecords : true,
								caption : "公告列表",
								hidegrid : false,
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