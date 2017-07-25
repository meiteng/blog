<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/ace/css/font-awesome.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/ace/css/dropzone.css" />
<%@include file="/adminCommon/header.jsp"%>
<div class="main-container" id="main-container">
	<div class="main-container-inner">
		<!-- 左边菜单栏 -->
		<%@include file="/adminCommon/nav.jsp"%>
		<!-- HTML主页 -->
		<div class="main-content">
			<!-- 头部提示 -->
			<div class="breadcrumbs" id="breadcrumbs">
				<ul class="breadcrumb">
					<li>
						<i class="icon-home home-icon"></i>
						<a href="#">企秀AR管理平台</a>
					</li>
					<li>
						<a href="#">unity资源总文件</a>
					</li>
					<li class="active">添加资源总文</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<!-- 列表主页 -->
			<div class="page-content">

				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
					
					<form class="form-horizontal" id="validation-form">
						<div class="form-group">
							<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">android资源总文件:</label>
							<div class="col-xs-12 col-sm-9">
								<div class="clearfix">
									<input type="text" name="androidUrl" value="/upload/fixed/android_unity.manifest" class="col-xs-12 col-sm-5" />
								</div>
							</div>
							
						</div>
						<div class="space-2"></div>


						<div class="form-group">
							<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">ios资源总文件:</label>
							<div class="col-xs-12 col-sm-9">
								<div class="clearfix">
									<input type="text" name="iosUrl" value="/upload/fixed/ios_unity.manifest" class="col-xs-12 col-sm-5" />
								</div>
							</div>
						</div>
						<div class="space-2"></div>
					</form>
						<div class="form-group">
							<label class="control-label col-xs-12 col-sm-3 no-padding-right" style="text-align: right;" for="name">上传android资源包:</label>
							<div class="col-xs-12 col-sm-9">
								<div id="dropzone2" style="font-size: 14px;">
									<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/admin/admin/uploadFixPathAndroid"
										id="dropzone_android" class="dropzone" style="width: 400px; min-height: 250px;" name="form" method="post">
										<div class="fallback">
											<input name="file" type="file" />
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-xs-12 col-sm-3 no-padding-right" style="text-align: right;" for="name">上传ios资源包:</label>
							<div class="col-xs-12 col-sm-9">
								<div id="dropzone3" style="font-size: 14px;">
									<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/admin/admin/uploadFixPathIos"
										id="dropzone_ios" class="dropzone" style="width: 400px; min-height: 250px;" name="form" method="post">
										<div class="fallback">
											<input name="file" type="file" />
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="space-2"></div>

					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
		</div>
		<!-- /.page-content -->
	</div>
	<!-- /.main-container-inner -->
</div>
<!-- /.main-container -->
<script type="text/javascript">
	function submitAdd() {
		$("#validation-form").submit();
	}
	$(document).ready(function() {
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例

		try {
			$("#dropzone_android").dropzone({
				paramName : "file", // The name that will be used to transfer the file
				maxFilesize : 10, // MB
				params : {
					"flieName" : "android_unity"
				},
				addRemoveLinks : true,
				dictDefaultMessage : '<span class="bigger-100 bolder"><i class="icon-caret-right red"></i> Drop files</span> to upload \
                        <span class="smaller-80 grey">(or click)</span> <br /> \
                        <i class="upload-icon icon-cloud-upload blue icon-3x"></i>',
				dictResponseError : 'Error while uploading file!',
				
				acceptedFiles:".manifest",
				//change the previewTemplate to use Bootstrap progress bars
				previewTemplate : "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
				complete : function(response) {
					

				}
			});
		} catch (e) {
			alert('Dropzone.js does not support older browsers!');
		}
		try {
			$("#dropzone_ios").dropzone({
				paramName : "file", // The name that will be used to transfer the file
				maxFilesize : 10, // MB

				addRemoveLinks : true,
				dictDefaultMessage : '<span class="bigger-100 bolder"><i class="icon-caret-right red"></i> Drop files</span> to upload \
                        <span class="smaller-80 grey">(or click)</span> <br /> \
                        <i class="upload-icon icon-cloud-upload blue icon-3x"></i>',
				dictResponseError : 'Error while uploading file!',
				acceptedFiles:".manifest",
				//change the previewTemplate to use Bootstrap progress bars
				previewTemplate : "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
				complete : function(response) {
					
				}
			});
		} catch (e) {
			alert('Dropzone.js does not support older browsers!');
		}
	});
</script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/dropzone.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.maskedinput.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.hotkeys.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/bootstrap-wysiwyg.min.js"></script>
<%@include file="/adminCommon/ueditor.jsp"%>
<%@include file="/adminCommon/footer.jsp"%>