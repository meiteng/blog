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
						<a href="#">企业管理</a>
					</li>
					<li class="active">添加企业</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<!-- 列表主页 -->
			<div class="page-content">

				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">

						<!-- 添加的form表单 -->
						<form class="form-horizontal" id="validation-form" action="${pageContext.request.contextPath}/admin/companymanage/doAdd" method="post">

                                            
							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">公司名字:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" name="companyName" class="col-xs-12 col-sm-5" />
									</div>
								</div>
							</div>
							<div class="space-2"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">公司地址:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" name="address" class="col-xs-12 col-sm-5" style="width: 600px;" />
									</div>
								</div>
							</div>
							<div class="space-2"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">联系电话:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" name="contact" class="col-xs-12 col-sm-5" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">公司注册号:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" name="registerNum" class="col-xs-12 col-sm-5" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">公司唯一识别码:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" name="apptoken" class="col-xs-12 col-sm-5" />
									</div>
								</div>
							</div>
							
							

						</form>
			
					</div>
				
					<br>
					<br>
					<div class="submit_cancle" onclick="submitAdd();">
						<button class="btn btn-danger">提交</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="btn">取消</button>
					</div>
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
		var identificationName = $("#identificationName").val();
		$("input[name='identificationName']").val(identificationName);
		$("#validation-form").submit();
	}
	$(document).ready(function() {

		$('#validation-form').validate({
			errorElement : 'div',
			errorClass : 'help-block',
			focusInvalid : false,
			rules : {              
				companyName:{
					required:true
				},
				address : {
					required : true,
					minlength : 5,
					maxlength : 30
				},
				contact : {
					required : true,
					minlength : 5,
					maxlength : 11
				},
				registerNum : {
					required : true,
					minlength : 5,
					maxlength : 20
				},
				apptoken : {
					required : true,
					minlength : 5,
					maxlength : 30
				}	
			},

			messages : {
				companyName:{
					required:"请输入公司名字"
				},
				address : {
					required : "请输入公司地址",
					minlength : "地址为为5—30个字符",
					maxlength : "地址为5—30个字符"
				},
				contact : {
					required : "请输入公司电话",
					minlength : "电话为5—11个字符",
					maxlength : "电话描述为5—11个字符"
				},
				registerNum : {
					required : "请输入公司注册信息",
					minlength : "信息为5—20个字符",
					maxlength : "信息描述为5—20个字符"
				},
			
				apptoken : {
					required : "输入唯一密钥",
					minlength : "密钥为5—30个字符",
					maxlength : "密钥描述为5—30个字符"
				}	
			},
			invalidHandler : function(event, validator) { //display error alert on form submit   
				$('.alert-danger', $('.login-form')).show();
			},
			highlight : function(e) {
				$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
			},
			success : function(e) {
				$(e).closest('.form-group').removeClass('has-error').addClass('has-info');
				$(e).remove();
			},
			errorPlacement : function(error, element) {
				if (element.is('.select2')) {
					error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
				} else if (element.is('.chosen-select')) {
					error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
				} else
					error.insertAfter(element.parent());
			},
			submitHandler : function(form) {
				form.submit();
			}
		});

		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor');

		try {
			$("#dropzone_android").dropzone({
				paramName : "file", // The name that will be used to transfer the file
				maxFilesize : 10, // MB

				addRemoveLinks : true,
				dictDefaultMessage : '<span class="bigger-100 bolder"><i class="icon-caret-right red"></i> Drop files</span> to upload \
                        <span class="smaller-80 grey">(or click)</span> <br /> \
                        <i class="upload-icon icon-cloud-upload blue icon-3x"></i>',
				dictResponseError : 'Error while uploading file!',

				//change the previewTemplate to use Bootstrap progress bars
				previewTemplate : "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
				complete : function(response) {
					console.log(response);
					if (response != null && response.status == "success") {
						var returnObj = eval("(" + response.xhr.response + ")");
						$("input[name='androidUrl']").val(returnObj.o);
					}

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

				//change the previewTemplate to use Bootstrap progress bars
				previewTemplate : "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
				complete : function(response) {
					console.log(response);
					if (response != null && response.status == "success") {
						var returnObj = eval("(" + response.xhr.response + ")");
						$("input[name='iosUrl']").val(returnObj.o);
					}

				}
			});
		} catch (e) {
			alert('Dropzone.js does not support older browsers!');
		}
		try {
			$("#dropzone_url").dropzone({
				paramName : "file", // The name that will be used to transfer the file
				maxFilesize : 10, // MB

				addRemoveLinks : true,
				dictDefaultMessage : '<span class="bigger-100 bolder"><i class="icon-caret-right red"></i> Drop files</span> to upload \
                        <span class="smaller-80 grey">(or click)</span> <br /> \
                        <i class="upload-icon icon-cloud-upload blue icon-3x"></i>',
				dictResponseError : 'Error while uploading file!',

				//change the previewTemplate to use Bootstrap progress bars
				previewTemplate : "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",
				complete : function(response) {
					console.log(response);
					if (response != null && response.status == "success") {
						var returnObj = eval("(" + response.xhr.response + ")");
						$("input[name='imgUrl']").val(returnObj.o);
					}

				}
			});
		} catch (e) {
			alert('Dropzone.js does not support older browsers!');
		}
	});
</script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/dropzone.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.maskedinput.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.hotkeys.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/bootstrap-wysiwyg.min.js"></script>
<%@include file="/adminCommon/ueditor.jsp"%>
<%@include file="/adminCommon/footer.jsp"%>