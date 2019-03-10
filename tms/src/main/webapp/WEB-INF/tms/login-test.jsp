<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<title>出租车管理系统-登录</title>
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css" rel="stylesheet">
<link href="${ctx}/css/login.css" rel="stylesheet">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<!--[if lt IE 9]>
<meta http-equiv="refresh" content="0;ie.html" />
<![endif]-->
<script>
	if (window.top !== window.self) {
		window.top.location = window.location;
	}
</script>

</head>
<script type="text/javascript">
	//抖动js
	jQuery.fn.shake = function(intShakes /*Amount of shakes*/,
			intDistance /*Shake distance*/, intDuration /*Time duration*/) {
		this.each(function() {
			var jqNode = $(this);
			jqNode.css({
				position : 'relative'
			});
			for (var x = 1; x <= intShakes; x++) {
				var a = intDuration / intShakes;
				var b = intDuration / intShakes;
				var c = intDuration / intShakes;
				jqNode.animate({
					left : (intDistance * -1)
				}, (a / 4)).animate({
					left : intDistance
				}, (b / 2)).animate({
					left : 0
				}, (c / 4));
			}
		});
		return this;
	};

	function changeInput(idName, msg) {
		var idNameVal = $("#" + idName).val();
		if (!idNameVal) {
			$("#" + idName).attr("placeholder", msg);
			$("#" + idName).shake(2, 10, 400);
			$("#" + idName).css("border", "1px solid red");
		} else {
			$("#" + idName).css("border", "")
		}
	}

	$(function() {
		//为验证码图片以及”看不清“文字绑定事件
		$("#verify_img,#verId2").click(
				function() {
					$("#verify_img").attr(
							"src",
							"${ctx}/validate/image.jsp?time="
									+ new Date().getTime());
				});
		//点击登录按钮进行登录操作
		$("#submit_btn").click(function() {
			var uname = $("#uname").val();
			var pwd = $("#pwd").val();
			var verify = $("#verify_code").val();
			if (!uname.length) {
				$("#uname").attr("placeholder", "账号不能为空！");
				$("#uname").shake(2, 10, 400);
				$("#uname").css("border", "1px solid red");
			}
			if (!pwd.length) {
				$("#pwd").attr("placeholder", "密码不能为空！");
				$("#pwd").shake(2, 10, 400);
				$("#pwd").css("border", "1px solid red");
			}
			if (!verify.length) {
				$("#verify_code").attr("placeholder", "验证码不能为空！");
				$("#verify_code").shake(2, 10, 400);
				$("#verify_code").css("border", "1px solid red");
			}
			if (uname.length && pwd.length && verify.length) {
				/* $.post("${ctx}/sysuser/login",{username:uname,password:pwd,verify:verify},function(data){
					if(data.ok==0){
						//$("#submit_btn").before("<span style='color:red;font-size:20px'>"+data.msg+"</span>")
						//$("#errorMsg").text(data.msg);
						$("#submit_btn").html("<span style='color:red;font-weight:bold;font-size:16px'>"+data.msg+"</span>");
						$("#submit_btn").shake(2,10,400);
						setTimeout(function(){
							$("#submit_btn").text("登录");
						},3000)
					}else if(data.ok==1){
						window.location.href="${ctx}/toIndex"
					}else{
						alert("网络错误，请稍后再试");
					} 
				}); */
				$("#loginForm").submit();
			}
		});

	});
</script>
<body class="gray-bg">

	<div class="middle-box text-center loginscreen  animated fadeInDown">
		<div>
			<div>

				<h1 class="logo-name">H+</h1>

			</div>
			<h3>欢迎使用 H+</h3>

			<form class="m-t" method="POST" role="form" action="${ctx}/sysuser/login">
				<div class="form-group">
					<input type="text" name="username" class="form-control" placeholder="用户名"
						required="">
				</div>
				<div class="form-group">
					<input type="password" name="password" class="form-control" placeholder="密码"
						required="">
				</div>
				<button type="submit" class="btn btn-primary block full-width m-b">登
					录</button>


				<p class="text-muted text-center">
					<a href="login.html#"><small>忘记密码了？</small></a> | <a
						href="register.html">注册一个新账号</a>
				</p>

			</form>
		</div>
	</div>
</body>

</html>
