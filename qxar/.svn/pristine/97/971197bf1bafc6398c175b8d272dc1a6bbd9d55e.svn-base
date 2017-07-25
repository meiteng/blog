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
						<a href="#">公司信息</a>
					</li>
					<li class="active">公司信息</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<!-- 列表主页 -->
			<div class="page-content">

				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">

						<!-- 添加的form表单 -->
						<form class="form-horizontal" id="validation-form" action="" method="post">
                            <br>
                            <br>           
							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">公司名字:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" value="${company.companyName}" name="companyName" class="col-xs-12 col-sm-5" />
									</div>
								</div>
							</div>
							<div class="space-2"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">公司地址:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" value="${company.address}" name="address" class="col-xs-12 col-sm-5" style="width: 600px;" />
									</div>
								</div>
							</div>
							<div class="space-2"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">联系电话:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" value="${company.contact}" name="contact" class="col-xs-12 col-sm-5" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">公司注册号:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" value="${company.registerNum}" name="registerNum" class="col-xs-12 col-sm-5" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">公司唯一识别码:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" value="${company.apptoken}" name="apptoken" class="col-xs-12 col-sm-5" />
									</div>
								</div>
							</div>
							
							

						</form>
			
					</div>
				
					<br>
					<br>
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

<script src="${pageContext.request.contextPath}/plugin/ace/js/dropzone.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.maskedinput.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.hotkeys.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/bootstrap-wysiwyg.min.js"></script>
<%@include file="/adminCommon/ueditor.jsp"%>
<%@include file="/adminCommon/footer.jsp"%>