<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@include file="/adminCommon/header.jsp"%>
<div class="main-container" id="main-container">
	<div class="main-container-inner">
		<a class="menu-toggler" id="menu-toggler" href="#">
			<span class="menu-text"></span>
		</a>
		<!-- 左边菜单栏 -->
		<%@include file="/adminCommon/nav.jsp"%>
		<div class="main-content">
			<div class="breadcrumbs" id="breadcrumbs">
				<ul class="breadcrumb">
					<li>
						<i class="icon-home home-icon"></i>
						<a href="#">企秀AR管理平台</a>
					</li>
					<li>
						<a href="#">文章管理</a>
					</li>
					<li class="active">关于我们</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<div class="page-content">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
					
						<div class="table-header"></div>
						
						<div class="table-responsive">
							<table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable"
								aria-describedby="sample-table-2_info">
								<tr role="row">
								<th class="left sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 61px;">${detail.title}</th>
								</tr>
								<tr><td>${detail.img_url}</td></tr>
								<tr><td>${detail.content}</td></tr>
							</table>
						</div>
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
<script>
	$(document).ready(function() {
		$('table th input:checkbox').on('click', function() {
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox').each(function() {
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
		});
	});
</script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.dataTables.bootstrap.js"></script>
<!-- /.main-container -->
<%@include file="/adminCommon/footer.jsp"%>