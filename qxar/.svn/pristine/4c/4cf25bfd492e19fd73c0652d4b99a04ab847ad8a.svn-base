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
						<a href="#">用户管理</a>
					</li>
					<li class="active">修改用户信息</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<!-- 列表主页 -->
			<div class="page-content">

				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">

						<!-- 添加的form表单 -->
						<form class="form-horizontal" id="validation-form" action="${pageContext.request.contextPath}/admin/user/doUpdate" method="post">

							<input type="hidden" name="id" value="${detail.id}" />
							<div class="form-group">
								
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
							
									</div>
								</div>
							</div>



							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">修改用户昵称:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" value="${detail.nickName}" name="nickName" class="col-xs-12 col-sm-5" />
									</div>
								</div>
							</div>
							<div class="space-2"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">修改手机号:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" value="${detail.phone}" name="phone" class="col-xs-12 col-sm-5" style="width: 600px;" />
									</div>
								</div>
							</div>
							<div class="space-2"></div>

							<div class="space-2"></div>
							
							<!-- imgUrl -->
							<input type="hidden" value="${detail.headUrl}" name="headUrl" />
							
							<!-- 发现内容--HTML文本 -->
							
							<div class="space-2"></div>

						</form>


						<div class="form-group">
							<label class="control-label col-xs-12 col-sm-3 no-padding-right" style="text-align: right;" for="name">上传新头像预览图:</label>
							<div class="col-xs-12 col-sm-9">
								<div id="dropzone4" style="font-size: 14px;">
									<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/admin/admin/upload" id="dropzone_url"
										class="dropzone" style="width: 400px; min-height: 250px;float:left;" name="form" method="post">
										<div class="fallback">
											<input type="hidden" name="dirName" value="find" /> <input name="file" type="file" multiple />
										</div>
									</form>
									<div style="float:left;margin-left: 15px;text-align: center;width:200px;padding-top: 40px;">
										<span>原图：</span><a href="${pageContext.request.contextPath}/${detail.headUrl}" target="_blank"><img src="${pageContext.request.contextPath}/${detail.headUrl}" style="width:100%;margin-top:10px;max-height:180px;"/></a>
									</div>
								</div>
							</div>
						</div>
			
					</div>
					<div class="space-2"></div>
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
		ue.ready(function() {//编辑器初始化完成再赋值  
        });  
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