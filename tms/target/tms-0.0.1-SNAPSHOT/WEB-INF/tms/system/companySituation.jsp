<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>公司报表页面</title>

<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="row  border-bottom white-bg dashboard-header">
		<div class="col-sm-12">
			<p>
				ECharts开源来自百度商业前端数据可视化团队，基于html5
				Canvas，是一个纯Javascript图表库，提供直观，生动，可交互，可个性化定制的数据可视化图表。创新的拖拽重计算、数据视图、值域漫游等特性大大增强了用户体验，赋予了用户对数据进行挖掘、整合的能力。
				<a href="http://echarts.baidu.com/doc/about.html" target="_blank">了解更多</a>
			</p>
			<p>
				ECharts官网：<a href="http://echarts.baidu.com/" target="_blank">http://echarts.baidu.com/</a>
			</p>

		</div>

	</div>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-6">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>司机学历分布图</h5>
					</div>
					<div class="ibox-content">
						<div class="echarts" id="driver_education_echarts"></div>
						<div class="echarts" id="driver_education_echarts2"></div>
						<table id="driver_education_table" class='table table-bordered'>
						</table>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>司机政治面貌分布图</h5>
					</div>
					<div class="ibox-content">
						<div class="echarts" id="driver_politics_echarts"></div>
						<div class="echarts" id="driver_politics_echarts2"></div>
						<table id="driver_politics_table" class='table table-bordered'>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>近十二个月的违章记录次数</h5>
					</div>
					<div class="ibox-content">
						<div class="echarts" style="height: 500px" id="driver_illegal_echarts"></div>
						<table id="driver_illegal_table" class='table table-bordered'>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>近十二个月的维修记录次数</h5>
					</div>
					<div class="ibox-content">
						<div class="echarts" style="height: 500px" id="driver_maintain_echarts"></div>
						<table id="driver_maintain_table" class='table table-bordered'>
						</table>
					</div>
				</div>
			</div>
		</div>
		<shiro:hasPermission name="company:income">
			<div class="row">
				<div class="col-sm-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>公司近三十天的收入情况</h5>
						</div>
						<div id="driver_taximeter_ibox-content" class="ibox-content">
							<div class="echarts" style="height: 500px" id="driver_taximeter_echarts"></div>
							<table id="driver_taximeter_table" class='table table-bordered'>
							</table>
						</div>
					</div>
				</div>
			</div>
		</shiro:hasPermission>
		<shiro:hasPermission name="driver:personalIncome">
			<div class="row">
				<div class="col-sm-12">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>司机近三十天的收入情况</h5>
						</div>
						<div id="driverPersonal_taximeter_ibox-content" class="ibox-content">
							<div class="echarts" style="height: 500px" id="driverPersonal_taximeter_echarts"></div>
							<table id="driverPersonal_taximeter_table" class='table table-bordered'>
							</table>
						</div>
					</div>
				</div>
			</div>
		</shiro:hasPermission>

		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>中国地图</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="graph_flot.html#"> <i class="fa fa-wrench"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="graph_flot.html#">选项1</a></li>
								<li><a href="graph_flot.html#">选项2</a></li>
							</ul>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
						<div style="height: 600px" id="echarts-map-chart"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
	<script src="${ctx}/js/bootstrap.min.js?v=3.3.6"></script>


	<!-- Echarts -->
	<script src="${ctx}/js/echart/echarts.js"></script>

	<!-- 自定义js -->
	<script src="${ctx}/js/content.js?v=1.0.0"></script>
</body>
<script type="text/javascript">
	//基于准备好的dom，初始化echarts实例
	var driver_education_echarts = echarts.init(document
			.getElementById("driver_education_echarts"));
	// 指定图表的配置项和数据
	var driver_education_echarts_option;
	// 使用刚指定的配置项和数据显示图表。
	//driver_education_echarts.setOption(driver_education_echarts_option);
	//$(window).resize(driver_education_echarts.resize);

	var driver_education_echarts2 = echarts.init(document
			.getElementById("driver_education_echarts2"));
	// 指定图表的配置项和数据
	var driver_education_echarts2_option;
	/* 政治面貌 */
	var driver_politics_echarts = echarts.init(document
			.getElementById("driver_politics_echarts"));
	var driver_politics_echarts_option;
	var driver_politics_echarts2 = echarts.init(document
			.getElementById("driver_politics_echarts2"));
	var driver_politics_echarts2_option;
	/* 违章记录 */
	var driver_illegal_echarts = echarts.init(document
			.getElementById("driver_illegal_echarts"));
	var driver_illegal_echarts_option;
	/* 维修记录 */
	var driver_maintain_echarts = echarts.init(document
			.getElementById("driver_maintain_echarts"));
	var driver_maintain_echarts_option;
	/* 公司薪资记录 */
	var driver_taximeter_echarts = echarts.init(document
			.getElementById("driver_taximeter_echarts"));
	var driver_taximeter_echarts_option;
	/* 司机个人薪资记录 */
	var driverPersonal_taximeter_echarts = echarts.init(document
			.getElementById("driverPersonal_taximeter_echarts"));
	var driverPersonal_taximeter_echarts_option;
	
	

	$(function() {

		//加载driver_education_echarts数据
		$.get("${ctx}/system/chartDriverEducation",
						function(data) {
							//driver_education_echarts_option.series.data=data;
							driver_education_echarts_option = {
								title : {
									text : '司机学历分布统计',
									subtext : '学历',
									x : 'center'
								},
								tooltip : {
									trigger : 'item',
									formatter : "{a} <br/>{b} : {c} ({d}%)"
								},
								legend : {
									orient : 'vertical',
									left : 'left',
									data : [ '小学', '初中', '高中', '专科', '本科及以上' ]
								},
								series : [ {
									name : '学历',
									type : 'pie',
									radius : '55%',
									center : [ '50%', '60%' ],
									data : data,
									itemStyle : {
										emphasis : {
											shadowBlur : 10,
											shadowOffsetX : 0,
											shadowColor : 'rgba(0, 0, 0, 0.5)'
										}
									}
								} ]
							};
							driver_education_echarts
									.setOption(driver_education_echarts_option);
							var tbody = "<thead><tr><th>学历</th><th>人数</th></tr></thead><tbody>";
							var education_name = new Array();
							var education_value = new Array();
							for (var i = 0; i < data.length; i++) {
								tbody += "<tr><td>" + data[i].name
										+ "</td><td>" + data[i].value
										+ "</td></tr>"
								education_name.push(data[i].name);
								education_value.push(data[i].value);
							}
							tbody += "</tbody>";
							driver_education_echarts2_option = {
								xAxis : {
									type : 'category',
									data : education_name
								},
								yAxis : {
									type : 'value'
								},
								series : [ {
									data : education_value,
									type : 'bar'
								} ]
							}
							driver_education_echarts2
							.setOption(driver_education_echarts2_option);
							$("#driver_education_table").html(tbody);
						})
						
		//加载driver_politics_echarts数据
		$.get("${ctx}/system/chartDriverPolitics",
						function(data) {
								driver_politics_echarts_option = {
								title : {
									text : '司机政治面貌分布统计',
									subtext : '政治面貌',
									x : 'center'
								},
								tooltip : {
									trigger : 'item',
									formatter : "{a} <br/>{b} : {c} ({d}%)"
								},
								legend : {
									orient : 'vertical',
									left : 'left',
									data : [ '群众', '团员', '党员']
								},
								series : [ {
									name : '面貌',
									type : 'pie',
									radius : '55%',
									center : [ '50%', '60%' ],
									data : data,
									itemStyle : {
										emphasis : {
											shadowBlur : 10,
											shadowOffsetX : 0,
											shadowColor : 'rgba(0, 0, 0, 0.5)'
										}
									}
								} ]
							};
							driver_politics_echarts
									.setOption(driver_politics_echarts_option);
							var tbody = "<thead><tr><th>政治面貌</th><th>人数</th></tr></thead><tbody>";
							var politics_name = new Array();
							var politics_value = new Array();
							for (var i = 0; i < data.length; i++) {
								tbody += "<tr><td>" + data[i].name
										+ "</td><td>" + data[i].value
										+ "</td></tr>"
									politics_name.push(data[i].name);
									politics_value.push(data[i].value);
							}
							tbody += "</tbody>";
							driver_politics_echarts2_option = {
								xAxis : {
									type : 'category',
									data : politics_name
								},
								yAxis : {
									type : 'value'
								},
								series : [ {
									data : politics_value,
									type : 'bar'
								} ]
							}
							driver_politics_echarts2
							.setOption(driver_politics_echarts2_option);
							$("#driver_politics_table").html(tbody);
						})
		//违章记录报表
		$.get("${ctx}/system/chartDriverIllegal",function(data) {
			driver_illegal_echarts_option={
				title : {
		        text: '近十二个月司机违章记录统计',
		        subtext: '违章记录'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['违章数']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            data : data.name
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'违章数',
		            type:'bar',
		            data:data.value,
		            markPoint : {
		                data : [
		                    {type : 'max', name: '最大值'},
		                    {type : 'min', name: '最小值'}
		                ]
		            },
		            markLine : {
		                data : [
		                    {type : 'average', name: '平均值'}
		                ]
		            }
		        }
		    ]
			}
			var thead = "<thead><tr>"
			var tbody = "<tbody><tr>";
			for (var i = 0; i < data.name.length; i++) {
				thead += "<th>"+data.name[i]+"</th>";
				tbody += "<td>"+data.value[i]+"</td>";
			}
			thead += "</tr></thead>";
			tbody += "</tr></tbody>";
			driver_illegal_echarts
			.setOption(driver_illegal_echarts_option);
			$("#driver_illegal_table").html(thead+tbody)
		})
		//维修记录报表
		$.get("${ctx}/system/chartDriverMaintain",function(data) {
			driver_maintain_echarts_option={
				title : {
		        text: '近十二个月车辆维修记录统计',
		        subtext: '维修记录'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['维修数']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            data : data.name
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'维修数目',
		            type:'bar',
		            data:data.value,
		            markPoint : {
		                data : [
		                    {type : 'max', name: '最大值'},
		                    {type : 'min', name: '最小值'}
		                ]
		            },
		            markLine : {
		                data : [
		                    {type : 'average', name: '平均值'}
		                ]
		            }
		        }
		    ]
			}
			var thead = "<thead><tr>"
			var tbody = "<tbody><tr>";
			for (var i = 0; i < data.name.length; i++) {
				thead += "<th>"+data.name[i]+"</th>";
				tbody += "<td>"+data.value[i]+"</td>";
			}
			thead += "</tr></thead>";
			tbody += "</tr></tbody>";
			driver_maintain_echarts
			.setOption(driver_maintain_echarts_option);
			$("#driver_maintain_table").html(thead+tbody)
		})
		
		//司机薪资报表
		$.get("${ctx}/system/chartDriverTaximeter",function(data) {
			if(!data){
				$("#driver_taximeter_ibox-content").html("您无权限！无法显示！")
			}
			driver_taximeter_echarts_option={
				title : {
		        text: '近30天收入记录',
		        subtext: '收入记录'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['金额']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            data : data.name
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'收入金额',
		            type:'bar',
		            data:data.value,
		            markPoint : {
		                data : [
		                    {type : 'max', name: '最大值'},
		                    {type : 'min', name: '最小值'}
		                ]
		            },
		            markLine : {
		                data : [
		                    {type : 'average', name: '平均值'}
		                ]
		            }
		        }
		    ]
			}
			var table = ""
			var thead = "<thead><tr><th>日期</th>"
			var tbody = "<tbody><tr><td>金额</td>";
			for (var i = 0; i < data.name.length; i++) {
				thead += "<th>"+data.name[i]+"</th>";
				tbody += "<td>"+data.value[i]+"</td>";
				if((i+1)%8==0){
					table += thead+"</tr></thead>"+tbody+"</tr></tbody>";
					thead = "<thead><th>日期</th>";
					tbody = "<tbody><td>金额</td>";
				}
			}
			thead += "</tr></thead>";
			tbody += "</tr></tbody>";
			table += thead+tbody;
			driver_taximeter_echarts
			.setOption(driver_taximeter_echarts_option);
			$("#driver_taximeter_table").html(table)
		})
		
		//司机个人薪资报表
		$.get("${ctx}/system/chartDriverPersonalTaximeter",function(data) {
			if(!data){
				$("#driverPersonal_taximeter_ibox-content").html("您的身份不是司机，无法显示！")
			}
			driverPersonal_taximeter_echarts_option={
				title : {
		        text: '近30天收入记录',
		        subtext: '收入记录'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['金额']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            data : data.name
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'收入金额',
		            type:'bar',
		            data:data.value,
		            markPoint : {
		                data : [
		                    {type : 'max', name: '最大值'},
		                    {type : 'min', name: '最小值'}
		                ]
		            },
		            markLine : {
		                data : [
		                    {type : 'average', name: '平均值'}
		                ]
		            }
		        }
		    ]
			}
			var table = ""
			var thead = "<thead><tr><th>日期</th>"
			var tbody = "<tbody><tr><td>金额</td>";
			for (var i = 0; i < data.name.length; i++) {
				thead += "<th>"+data.name[i]+"</th>";
				tbody += "<td>"+data.value[i]+"</td>";
				if((i+1)%8==0){
					table += thead+"</tr></thead>"+tbody+"</tr></tbody>";
					thead = "<thead><th>日期</th>";
					tbody = "<tbody><td>金额</td>";
				}
			}
			thead += "</tr></thead>";
			tbody += "</tr></tbody>";
			table += thead+tbody;
			driverPersonal_taximeter_echarts
			.setOption(driverPersonal_taximeter_echarts_option);
			$("#driverPersonal_taximeter_table").html(table)
		})
		

	})
</script>
</html>
