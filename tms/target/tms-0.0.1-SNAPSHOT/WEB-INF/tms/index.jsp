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
<meta name="renderer" content="webkit">

<title>出租车管理系统</title>

<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">

<!-- 全局js -->
	<script src="${ctx}js/jquery.min.js?v=2.1.4"></script>
	<script src="${ctx}js/bootstrap.min.js?v=3.3.6"></script>
	<script src="${ctx}js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="${ctx}js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="${ctx}js/plugins/layer/layer.min.js"></script>

	<!-- 自定义js -->
	<script src="${ctx}js/hplus.js?v=4.1.0"></script>
	<script type="text/javascript" src="${ctx}js/contabs.js"></script>

	<!-- 第三方插件 -->
	<script src="${ctx}js/plugins/pace/pace.min.js"></script>
	
</head>

<body class="fixed-sidebar full-height-layout gray-bg"
	style="overflow:hidden">
	<div id="wrapper">
		<!--左侧导航开始-->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="nav-close">
				<i class="fa fa-times-circle"></i>
			</div>
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<span><img alt="image" id="my_head_img" class="img-circle" style="width:100px;height:100px"
								src="${sysuser.img}" /></span> <a data-toggle="dropdown"
								class="dropdown-toggle" href="#"> <span class="clear">
									<span class="block m-t-xs"><strong class="font-bold">${sysuser.username}</strong></span>
									<span id="current_roleName" class="text-muted text-xs block">
									<i class="fa fa-cog fa-spin"></i>	账号管理
									<b class="caret"></b></span>
							</span>
							</a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">
								<li><a class="J_menuItem" href="${ctx}/sysuser/goEditHeadImgPage">修改头像</a>
								</li>
								<li><a class="J_menuItem" href="${ctx}/sysuser/goEditPasswordPage">修改密码</a>
								</li>
								<li class="divider"></li>
								<li><a href="${ctx}/logout">安全退出</a></li>
							</ul>
						</div>
						<div class="logo-element"></div>
					</li>
					
					<!-- tomxwdpms -->
					<li><a href="#"> <i class="fa fa-cog fa-spin"></i> <span
							class="nav-label">账号管理</span> <span class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="${ctx}/sysuser/goEditHeadImgPage" data-index="0">修改头像</a></li>
							<li><a class="J_menuItem" href="${ctx}/sysuser/goEditPasswordPage" data-index="0">修改密码</a></li>
						</ul>
					</li>
					
					<li><a href="#"> <i class="fa fa-file-text"></i> <span
							class="nav-label">公告管理</span> <span class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level">
							<shiro:hasPermission name="notice:addPage">
								<li><a class="J_menuItem" href="${ctx}/notice/toAddNotice" data-index="0">添加公告</a></li>
							</shiro:hasPermission>
							<shiro:hasPermission name="notice:listPage">
								<li><a class="J_menuItem" href="${ctx}/notice/toNoticeList" data-index="0">公告列表</a></li>
							</shiro:hasPermission>
							<li><a class="J_menuItem" href="${ctx}/notice/toPublicNoticeList" data-index="0">公共公告列表</a></li>
						</ul>
					</li>
					
					<shiro:hasPermission name="company:chartPage">
						<li><a href="#"> <i class="fa fa-bar-chart"></i> <span
								class="nav-label">公司报表</span> <span class="fa arrow"></span>
						</a>
							<ul class="nav nav-second-level">
							<shiro:hasPermission name="company:chartPage">
								<li><a class="J_menuItem" href="${ctx}/system/toCompanySituation" data-index="0">公司报表</a></li>
							</shiro:hasPermission>
							</ul>
						</li>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="teximeter:addPage">
						<li><a href="#"> <i class="fa fa-dollar"></i> <span
								class="nav-label">模拟计费器</span> <span class="fa arrow"></span>
						</a>
							<ul class="nav nav-second-level">
							<shiro:hasPermission name="teximeter:addPage">
								<li><a class="J_menuItem" href="${ctx}/system/toAddTaximeter" data-index="0">添加收入记录</a></li>
							</shiro:hasPermission>
							</ul>
						</li>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="car:rentPage or car:infoPage">
						<li><a href="#"> <i class="fa fa-user"></i> <span
								class="nav-label">个人信息</span> <span class="fa arrow"></span>
						</a>
							<ul class="nav nav-second-level">
							<shiro:hasPermission name="car:rentPage">
								<li><a class="J_menuItem" href="${ctx}/car/toRentCar" data-index="0">租车</a></li>
							</shiro:hasPermission>
							<shiro:hasPermission name="car:infoPage">
								<li><a class="J_menuItem" href="${ctx}/car/toCarInfo" data-index="0">我的车辆</a></li>
							</shiro:hasPermission>
							<shiro:hasPermission name="driver:chartPage">
								<li><a class="J_menuItem" href="${ctx}/driver/toDriverChart" data-index="0">个人报表</a></li>
							</shiro:hasPermission>
								<li><a class="J_menuItem" href="${ctx}/driver/toUseCarRecord" data-index="0">车辆使用记录</a></li>
								
							</ul>
						</li>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="illegal:listPage or illegal:addPage">
						<li><a href="#"> <i class="fa fa-ban"></i> <span
								class="nav-label">违章管理</span> <span class="fa arrow"></span>
						</a>
							<ul class="nav nav-second-level">
								<shiro:hasPermission name="illegal:addPage">
									<li><a class="J_menuItem" href="${ctx}/illegal/toAddIllegal" data-index="0">添加违章记录</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="illegal:listPage">
									<li><a class="J_menuItem" href="${ctx}/illegal/toIllegalList" data-index="0">违章记录</a></li>
								</shiro:hasPermission>
							</ul>
						</li>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="maintain:listPage or maintain:maintainPage">
						<li><a href="#"> <i class="fa fa-wrench"></i> <span
								class="nav-label">维修管理</span> <span class="fa arrow"></span>
						</a>
							<ul class="nav nav-second-level">
								<shiro:hasPermission name="maintain:listPage">
									<li><a class="J_menuItem" href="${ctx}/carMaintain/toCarMaintainList" data-index="0">维修记录</a></li>
								</shiro:hasPermission>
								<shiro:hasPermission name="maintain:maintainPage">
									<li><a class="J_menuItem" href="${ctx}/car/toCarList" data-index="0">维修车辆</a></li>
								</shiro:hasPermission>
							</ul>
						</li>
					</shiro:hasPermission>
					
					
					<shiro:hasPermission name="driver:listPage">
						<li><a href="#"> <i class="fa fa-male"></i> <span
								class="nav-label">司机管理</span> <span class="fa arrow"></span>
						</a>
							<ul class="nav nav-second-level">
							<shiro:hasPermission name="driver:listPage">
								<li><a class="J_menuItem" href="${ctx}/driver/toDriverList" data-index="0">司机列表</a></li>
							</shiro:hasPermission>
							</ul>
						</li>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="car:addPage or car:listPage">
						<li><a href="#"> <i class="fa fa-taxi"></i> <span
								class="nav-label">车辆管理</span> <span class="fa arrow"></span>
						</a>
							<ul class="nav nav-second-level">
							<shiro:hasPermission name="car:addPage">
								<li><a class="J_menuItem" href="${ctx}/car/toAddCar" data-index="0">添加车辆</a></li>
							</shiro:hasPermission>
							<shiro:hasPermission name="car:listPage">
								<li><a class="J_menuItem" href="${ctx}/car/toCarList" data-index="0">车辆列表</a></li>
							</shiro:hasPermission>
							</ul>
						</li>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="user:addPage or user:listPage">
					<li><a href="#"> <i class="fa fa-group"></i> <span
							class="nav-label">用户管理</span> <span class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level">
						<shiro:hasPermission name="user:addPage">
							<li><a class="J_menuItem" href="${ctx}/sysuser/toAddSysuser" data-index="0">添加用户</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="user:listPage">
							<li><a class="J_menuItem" href="${ctx}/sysuser/toSysuserList" data-index="0">用户列表</a></li>
						</shiro:hasPermission>
						</ul>
					</li>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="modular:addPage or modular:listPage">
						<li id="modular_li"><a href="#"> <i class="fa fa-cog"></i> <span
								class="nav-label">模块管理</span> <span class="fa arrow"></span>
						</a>
							<ul class="nav nav-second-level">
							<shiro:hasPermission name="modular:addPage">
								<li><a class="J_menuItem" href="${ctx}/modular/toAddModular" data-index="0">添加模块</a></li>
							</shiro:hasPermission>
							<shiro:hasPermission name="modular:listPage">
								<li><a class="J_menuItem" href="${ctx}/modular/toModularList" data-index="0">模块列表</a></li>
							</shiro:hasPermission>
							</ul>
						</li>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="power:addPage or power:listPage">
					<li><a href="#"> <i class="fa fa-cogs"></i> <span
							class="nav-label">权限管理</span> <span class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level">
						<shiro:hasPermission name="power:addPage">
							<li><a class="J_menuItem" href="${ctx}/power/toAddPower" data-index="0">添加权限</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="power:listPage">
							<li><a class="J_menuItem" href="${ctx}/power/toPowerList" data-index="0">权限列表</a></li>
						</shiro:hasPermission>
						</ul>
					</li>
					</shiro:hasPermission>
					
					<shiro:hasPermission name="role:addPage or role:listPage">
					<li><a href="#"> <i class="fa fa-users"></i> <span
							class="nav-label">角色管理</span> <span class="fa arrow"></span>
					</a>
						<ul class="nav nav-second-level">
						<shiro:hasPermission name="role:addPage">
							<li><a class="J_menuItem" href="${ctx}/role/toAddRole" data-index="0">添加角色</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="role:listPage">
							<li><a class="J_menuItem" href="${ctx}/role/toRoleList" data-index="0">角色列表</a></li>
						</shiro:hasPermission>
						</ul>
					</li>
					</shiro:hasPermission>
				</ul>
			</div>
		</nav>
		<!--左侧导航结束-->
		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
							href="#"><i class="fa fa-bars"></i> </a>
					</div>
					<ul class="nav navbar-top-links navbar-right">
					</ul>
				</nav>
			</div>
			<div class="row content-tabs">
				<button class="roll-nav roll-left J_tabLeft">
					<i class="fa fa-backward"></i>
				</button>
				<nav class="page-tabs J_menuTabs">
					<div class="page-tabs-content">
						<a href="javascript:;" class="active J_menuTab"
							data-id="index_v1.html">首页</a>
					</div>
				</nav>
				<button class="roll-nav roll-right J_tabRight">
					<i class="fa fa-forward"></i>
				</button>
				<div class="btn-group roll-nav roll-right">
					<button class="dropdown J_tabClose" data-toggle="dropdown">
						关闭操作<span class="caret"></span>

					</button>
					<ul role="menu" class="dropdown-menu dropdown-menu-right">
						<li class="J_tabShowActive"><a>定位当前选项卡</a></li>
						<li class="divider"></li>
						<li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
						<li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
					</ul>
				</div>
				<a href="${ctx}/logout" class="roll-nav roll-right J_tabExit"><i
					class="fa fa fa-sign-out"></i> 退出</a>
			</div>
			<div class="row J_mainContent" id="content-main">
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
					src="${ctx}/public/publicIndex" frameborder="0" data-id="index_v1.html"
					seamless></iframe>
			</div>
			<div class="footer">
				<div class="pull-right">
					&copy; 2019-2020 <a href="http://www.tomxwd.top/" target="_blank">tomxwd</a>
				</div>
			</div>
		</div>
		<!--右侧部分结束-->
		<!--右侧边栏开始-->
		<div id="right-sidebar">
			<div class="sidebar-container">


			</div>
		</div>
		<!--右侧边栏结束-->
	</div>
	
	<script type="text/javascript">
	</script>
	
</body>

</html>
