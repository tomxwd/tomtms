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


<title>公告详情页面</title>
<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight article">
		<div class="row">
			<div class="col-lg-10 col-lg-offset-1">
				<div class="ibox">
					<div class="ibox-content">
						
						<div class="pull-left">
							<a href="javascript:window.history.back(-1)" class="btn btn-primary" type="button">返回</a>
						</div>
						<div class="pull-right">
							<button class="btn btn-white btn-xs" type="button">公告</button>
						</div>
						<div class="text-center article-title">
							<h1>${notice.notice.title}</h1>
						</div>
							${notice.content.content}
						<hr>
						<h3 class="pull-right text-navy noticeDate"><fmt:formatDate value="${notice.notice.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></h3>
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
		
		$(function(){
			
		})
	</script>

</html>