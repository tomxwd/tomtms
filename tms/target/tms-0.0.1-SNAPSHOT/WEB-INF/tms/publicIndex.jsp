<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
 
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - 个人资料</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="row animated fadeInRight">

			<div class="col-sm-8">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>公告栏</h5>
					</div>
					<div class="ibox-content">
						<div>
							<div class="feed-activity-list">
								<c:forEach items="${notices}" var="notice">
									<div class="feed-element">
									<div class="media-body ">
										<small class="pull-right text-navy noticeDate"><fmt:formatDate value="${notice.createDate}" pattern="yyyy-MM-dd HH:mm"/></small>
										<a onclick="noticeContent('${notice.id}')" style="font-size:16px" class="btn-link">${notice.title}</a>
									</div>
								</div>
								</c:forEach>
							</div>

							<button id="lookMoreNotice" class="btn btn-primary btn-block m">
								点击查看更多
							</button>

						</div>

					</div>
				</div>

			</div>

			<div class="col-sm-4">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>公司简介</h5>
					</div>
					<div>
						<div class="ibox-content no-padding border-left-right">
							<img alt="image" class="img-responsive" src="http://www.tomxwd.top:8080/tms/carImg/tomxwd910ad1bca0584544a568dc833b0ae74e.jpg">
						</div>
						<div class="ibox-content profile-content">
							<h2>
								<strong>tomxwd出租车公司</strong>
							</h2>
							<p>
								<br>
								<i class="fa fa-map-marker"></i> 深圳市宝安区宝安中心XXXA座2606室
							</p>
							<h5>关于公司</h5>
							<p>
								深圳市城市公共交通客运管理处将竭诚为您服务<br>
							</p>
							<h3>
								如有遇到问题，请致电：
							</h3>
							<h3 style="color:#1ab394">
									<i class="fa fa-phone"></i>&nbsp;联系方式：13242342356<br><br>
									<i class="fa fa-fax"></i>&nbsp;固定电话：0723-24423456
							</h3>
							<div class="row m-t-lg">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<h5>
										
									</h5>
								</div>
							</div>
							<div class="user-button">
								<div class="row">
									<div class="col-sm-6">
										<button type="button" class="btn btn-primary btn-sm btn-block">
											<i class="fa fa-envelope"></i> 发送消息
										</button>
									</div>
									<div class="col-sm-6">
										<button type="button" class="btn btn-default btn-sm btn-block">
											<i class="fa fa-coffee"></i> 赞助
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- 全局js -->
	<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
	<script src="${ctx}/js/bootstrap.min.js?v=3.3.6"></script>



	<!-- 自定义js -->
	<script src="${ctx}/js/content.js?v=1.0.0"></script>


	<!-- Peity -->
	<script src="${ctx}/js/plugins/peity/jquery.peity.min.js"></script>

	<!-- Peity -->
	<script src="${ctx}/js/demo/peity-demo.js"></script>

</body>
<script type="text/javascript">
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
	
	function noticeContent(id){
		window.location.href="${ctx}/notice/lookNoticeContentDetailById?id="+id;
	}
	
	$("#lookMoreNotice").click(function(){
		window.location.href="${ctx}/notice/toPublicNoticeList";
	})
	
	$(function(){
		
	})
	
</script>

</html>



