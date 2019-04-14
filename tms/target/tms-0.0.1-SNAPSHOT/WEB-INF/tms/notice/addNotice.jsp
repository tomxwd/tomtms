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


<title>添加公告页面</title>
<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/plugins/summernote/summernote.css"
	rel="stylesheet">
<link href="${ctx}/css/plugins/summernote/summernote-bs3.css"
	rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content">

		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>添加新公告</h5>
						<div align="right">
							<button id="edit" class="btn btn-primary" onclick="edit()"
								type="button">编辑</button>
							<button id="look" class="btn btn-info" onclick="look()"
								type="button">查看</button>
							<shiro:hasPermission name="notice:add">
								<button id="save" class="btn btn-success" onclick="save()"
									type="button">保存</button>
							</shiro:hasPermission>	
							<h2 class="col-sm-3 control-label">标题：</h2>
							<div class="col-sm-6">
								<input id="title" type="text" class="form-control">
							</div>
						</div>
					</div>
					
					<div class="ibox-content" id="eg">

						<div class="click2edit wrapper"></div>

					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- 全局js -->
	<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
	<script src="${ctx}/js/bootstrap.min.js?v=3.3.6"></script>

	<!-- layer javascript -->
	<script src="${ctx}/js/plugins/layer/layer.min.js"></script>

	<!-- 自定义js -->
	<script src="${ctx}/js/content.js?v=1.0.0"></script>


	<!-- SUMMERNOTE -->
	<script src="${ctx}/js/plugins/summernote/summernote.min.js"></script>
	<script src="${ctx}/js/plugins/summernote/summernote-zh-CN.js"></script>

	<script>
		var look = function() {
			$("#eg").removeClass("no-padding");
			var aHTML = $('.click2edit').code(); //save HTML If you need(aHTML: array).
			$('.click2edit').destroy();
		}
		var edit = function() {
			$("#eg").addClass("no-padding");
			$('.click2edit').summernote({
				lang : 'zh-CN',
				focus : true,
				height : 700,
				minHeight : 300,
				maxHeight : 700,
				onImageUpload : function(files, editor, $editable) {
					sendFile(files[0], editor, $editable);
				}
			});
		};
		var save = function() {
			var aHTML = $('.click2edit').code(); //save HTML If you need(aHTML: array).
			if(!$("#title").val()){
				layer.alert("请编写标题后再提交！", {
					title : "温馨提示",
					skin : 'layui-layer-molv'
				});
				return;
			}
			if (aHTML == "<p><br></p>" || !aHTML) {
				layer.alert("请编写公告内容后再提交！", {
					title : "温馨提示",
					skin : 'layui-layer-molv'
				});
				return;
			}
			layer.confirm("确定保存吗？", {
				title : '温馨提示',
				skin : 'layui-layer-molv'
			}, function(index) {
				$.ajax({
					url : "${ctx}/notice/addNotice",
					type : 'POST',
					data : {
						content:aHTML,
						title : $("#title").val()
					},
					success : function(data) {
						if (data.ok == 1) {
							layer.alert(data.msg, {
								skin : 'layui-layer-molv', //样式类名
								shift : 4
							}, function(index) {
								layer.close(index);
								$('.click2edit').code("");
								$("#title").val("");
							});
						} else {
							parent.layer.alert(data.msg, {
								skin : 'layui-layer-molv',
								shift : 4
							});
						}
					}
				});
			})

		};
		//图片上传
		function sendFile(file, editor, $editable) {

			var filename = false;
			try {
				filename = file['name'];
			} catch (e) {
				filename = false;
			}
			if (!filename) {
				$(".note-alarm").remove();
			}

			//以上防止在图片在编辑器内拖拽引发第二次上传导致的提示错误
			data = new FormData();
			data.append("file", file);
			data.append("key", filename); //唯一性参数

			$.ajax({
				data : data,
				type : "POST",
				url : "${ctx}/notice/imgUpload",
				cache : false,
				contentType : false,
				processData : false,
				success : function(url) {
					editor.insertImage($editable, url);
					//setTimeout(function(){$(".note-alarm").remove();},3000);
				},
				error : function() {
					alert("上传失败！");
					return;
					//setTimeout(function(){$(".note-alarm").remove();},3000);
				}
			});
		}
		$(document).ready(function() {
			$('.click2edit').summernote({
				lang : 'zh-CN',
				focus : true,
				height : 700,
				minHeight : 300,
				maxHeight : 700,
				onImageUpload : function(files, editor, $editable) {
					sendFile(files[0], editor, $editable);
				}
			});

		});
	</script>

</body>

</html>
