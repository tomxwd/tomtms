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


<title>司机个人报表页面</title>

<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<!-- 	<div class="row  border-bottom white-bg dashboard-header">
		<div class="col-sm-12">
		</div>

	</div> -->
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>近十二个月的违章记录次数</h5>
					</div>
					<div id="driver_personal_illegal_ibox-content" class="ibox-content">
						<div class="echarts" style="height: 500px" id="driver_personal_illegal_echarts"></div>
						<table id="driver_personal_illegal_table" class='table table-bordered'>
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
					<div id="driver_personal_maintain_ibox-content" class="ibox-content">
						<div class="echarts" style="height: 500px" id="driver_personal_maintain_echarts"></div>
						<table id="driver_personal_maintain_table" class='table table-bordered'>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>司机近三十天的收入情况</h5>
					</div>
					<div id="driver_personal_taximeter_ibox-content" class="ibox-content">
						<div class="echarts" style="height: 500px" id="driver_personal_taximeter_echarts"></div>
						<table id="driver_personal_taximeter_table" class='table table-bordered'>
						</table>
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
	/* 违章记录 */
	var driver_personal_illegal_echarts = echarts.init(document
			.getElementById("driver_personal_illegal_echarts"));
	var driver_personal_illegal_echarts_option;
	/* 维修记录 */
	var driver_personal_maintain_echarts = echarts.init(document
			.getElementById("driver_personal_maintain_echarts"));
	var driver_personal_maintain_echarts_option;
	/* 司机个人薪资记录 */
	var driver_personal_taximeter_echarts = echarts.init(document
			.getElementById("driver_personal_taximeter_echarts"));
	var driver_personal_taximeter_echarts_option;
	
	

	$(function() {

		//违章记录报表
		$.get("${ctx}/driver/chartDriverPersonalIllegal",function(data) {
			if(!data){
				$("#driver_personal_illegal_ibox-content").html("找不到记录！")
			}
			driver_personal_illegal_echarts_option={
				title : {
		        text: '近十二个月违章记录统计',
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
			driver_personal_illegal_echarts
			.setOption(driver_personal_illegal_echarts_option);
			$("#driver_personal_illegal_table").html(thead+tbody)
		})
		//维修记录报表
		$.get("${ctx}/driver/chartDriverPersonalMaintain",function(data) {
			if(!data){
				$("#driver_personal_maintain_ibox-content").html("找不到记录！")
			}
			driver_personal_maintain_echarts_option={
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
			driver_personal_maintain_echarts
			.setOption(driver_personal_maintain_echarts_option);
			$("#driver_personal_maintain_table").html(thead+tbody)
		})
		
		//司机个人薪资报表
		$.get("${ctx}/driver/chartDriverPersonalTaximeter",function(data) {
			if(!data){
				$("#driver_personal_taximeter_ibox-content").html("找不到记录！")
			}
			driver_personal_taximeter_echarts_option={
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
			driver_personal_taximeter_echarts
			.setOption(driver_personal_taximeter_echarts_option);
			$("#driver_personal_taximeter_table").html(table)
		})
		

	})
</script>
</html>
