<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@include file="/adminCommon/header.jsp"%>
<div class="main-container" id="main-container">
	<script type="text/javascript">
		try {
			ace.settings.check('main-container', 'fixed');
		} catch (e) {
		}
	</script>

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
						<a href="#">内部资源管理</a>
					</li>
					<li class="active">内部资源列表</li>
				</ul>
				<!-- .breadcrumb -->
			</div>

			<div class="page-content">
				<!-- PAGE CONTENT BEGINS -->
				
				<!-- 虚线分割 -->
				<div class="hr hr-18 dotted hr-double"></div>
				<button class="btn btn-success" onclick="redirctUrl('admin/resourcesinner/add?id=${resourcesId}')">
					添加资源
				</button>
				<!-- 虚线分割 -->
				<div class="hr hr-18 dotted hr-double"></div>
				
				<div class="row">
					<div class="col-xs-12">
						<div class="table-header">内部资源管理</div>
						<div class="table-responsive">
							<table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable"
								aria-describedby="sample-table-2_info">
								<thead>
									<tr role="row">
										<th class="center sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="" style="width: 61px;">
											<label>
												<input type="checkbox" class="ace">
												<span class="lbl"></span>
											</label>
										</th>
										<th>资源id</th>
										<th>识别图url</th>
										<th>识别图名字</th>
										<th>android资源包url</th>
										<th>ios资源包url</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody role="alert" aria-live="polite" aria-relevant="all">
									<c:forEach items="${list}" var="item">
										<tr class="even">
											<td class="center  sorting_1">
												<label>
													<input type="checkbox" class="ace">
													<span class="lbl"></span>
												</label>
											</td>

											<td>${item.resourcesid}</td>
											<td>
												<a href="${pageContext.request.contextPath}/${item.identificationUrl}" target="_blank">
													<img src="${pageContext.request.contextPath}/${item.identificationUrl}" style="height: 50px;" />
												</a>
											</td>
											<td>${item.identificationName}</td>
		                                    <td>${item.androidUrl}</td>
		                                    <td>${item.iosUrl}</td>
											<td class=" ">
												<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
													
													<a class="green" href="${pageContext.request.contextPath}/admin/resourcesinner/update?id=${item.id}">
														<i class="icon-pencil bigger-130"></i>
													</a>

													<a class="red" href="${pageContext.request.contextPath}/admin/resourcesinner/delete?id=${item.id}">
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
<!-- /.main-container -->
<%@include file="/adminCommon/footer.jsp"%>