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
						<a href="#">发现管理</a>
					</li>
					<li class="active">添加发现</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<!-- 列表主页 -->
			<div class="page-content">

				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
					
						<!-- 添加的form表单 -->
						<form class="form-horizontal" id="validation-form" action="${pageContext.request.contextPath}/admin/suggestion/doAdd" method="post">


								



							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">联系方式:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" name="contact" class="col-xs-12 col-sm-5" />
									</div>
								</div>
							</div>
							<div class="space-2"></div>

					

							
						

							<!-- 发现内容--HTML文本 -->
							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">发现内容:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<script id="editor" name="content" type="text/plain" style="width: 800px; height: 500px;"></script>
									</div>
								</div>
							</div>
							<div class="space-2"></div>

						</form>


						
					<div class="space-2"></div>
					<div style="width: 60%; margin: 10px auto;" onclick="submitAdd();">
						<button class="btn btn-danger btn-block">提交</button>
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
		alert(111);
		$("#validation-form").submit();
	}
	$(document).ready(function() {

		$.mask.definitions['~'] = '[+-]';
		$(".select2").css('width', '200px').select2({
			allowClear : true
		}).on('change', function() {
			$(this).closest('form').validate().element($(this));
		});
		$('#phone').mask('(999) 999-9999');
		jQuery.validator.addMethod("phone", function(value, element) {
			return this.optional(element) || /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
		}, "Enter a valid phone number.");
		/* $('#validation-form').validate({
			errorElement : 'div',
			errorClass : 'help-block',
			focusInvalid : false,
			rules : {
				email : {
					required : true,
					email : true
				},
				password : {
					required : true,
					minlength : 5
				},
				password2 : {
					required : true,
					minlength : 5,
					equalTo : "#password"
				},
				name : {
					required : true
				},
				phone : {
					required : true,
					phone : 'required'
				},
				url : {
					required : true,
					url : true
				},
				comment : {
					required : true
				},
				state : {
					required : true
				},
				platform : {
					required : true
				},
				subscription : {
					required : true
				},
				gender : 'required',
				agree : 'required'
			},

			messages : {
				email : {
					required : "Please provide a valid email.",
					email : "Please provide a valid email."
				},
				password : {
					required : "Please specify a password.",
					minlength : "Please specify a secure password."
				},
				subscription : "Please choose at least one option",
				gender : "Please choose gender",
				agree : "Please accept our policy"
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
				if (element.is(':checkbox') || element.is(':radio')) {
					var controls = element.closest('div[class*="col-"]');
					if (controls.find(':checkbox,:radio').length > 1)
						controls.append(error);
					else
						error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
				} else if (element.is('.select2')) {
					error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
				} else if (element.is('.chosen-select')) {
					error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
				} else
					error.insertAfter(element.parent());
			},
			submitHandler : function(form) {

			}
		}); */

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