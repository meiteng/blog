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
					<li class="active">文章列表</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<div class="page-content">
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">

						<!-- 虚线分割 -->
						<div class="hr hr-18 dotted hr-double"></div>
						<button class="btn btn-success" onclick="redirctUrl('admin/article/add')">添加文章</button>
						<!-- 虚线分割 -->
						<div class="hr hr-18 dotted hr-double"></div>

						<div class="table-header">文章管理</div>
						<div class="table-responsive">
							<table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable"
								aria-describedby="sample-table-2_info">
								<thead>
									<tr role="row">
										<th class="center sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 61px;">文章类型</th>
										<th class="center sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 61px;">文章内容</th>
										<th class="center sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 61px;">创建时间</th>
										<th class="center sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 61px;">操作</th>
									</tr>
								</thead>

								<tbody role="alert" aria-live="polite" aria-relevant="all">
									<c:forEach items="${articleList}" var="item">
										<tr class="even">
											<td align="center">${item.title}</td>
											<td align="center">
												<a href="${pageContext.request.contextPath}/admin/article/detail?id=${item.id}">增强现实(Augmented
													Reality，简称AR)，也被称为扩增现实(中国台湾地区)</a>
											</td>
											<td align="center">
											      ${item.addtime}
											 
											<%-- 	<jsp:useBean id="dateValue" class="java.util.Date" />
												<jsp:setProperty name="dateValue" property="time" value="${item.addtime}" />
											      <fmt:formatDate value="${dateValue}" pattern="yyyy-mm-dd hh:mm:ss" /> --%>
											</td>
											<td class=" ">
												<div align="center" class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
													<a class="blue" href="${pageContext.request.contextPath}/admin/article/add">
														<i class="icon-zoom-in bigger-130"></i>
													</a>
													<a class="green" href="${pageContext.request.contextPath}/admin/article/update?id=${item.id}">
														<i class="icon-pencil bigger-130"></i>
													</a>
													<a class="red" href="${pageContext.request.contextPath}/admin/article/delete?id=${item.id}">
														<i class="icon-trash bigger-130"></i>
													</a>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
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
<script src="${pageContext.request.contextPath}/resources/admin/js/article.js" type="text/javascript"></script>
<!-- /.main-container -->
<%@include file="/adminCommon/footer.jsp"%>