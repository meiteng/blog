<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
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
					<li class="active">发现列表</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<!-- 列表主页 -->
			<div class="page-content">
				<!-- 虚线分割 -->
				<div class="hr hr-18 dotted hr-double"></div>
				<button class="btn btn-success" onclick="redirctUrl('admin/find/add')">
					添加发现
				</button>
				<!-- 虚线分割 -->
				<div class="hr hr-18 dotted hr-double"></div>
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<div class="table-header">发现管理</div>
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
										<th>发现id</th>
										<th>发现标题</th>
										<th>图片</th>
										<th>添加时间</th>
										<th>描述</th>
										<th>资源昵称</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody role="alert" aria-live="polite" aria-relevant="all">
									<c:forEach items="${findList}" var="item">
										<tr class="even">
											<td class="center  sorting_1">
												<label>
													<input type="checkbox" class="ace" />
													<span class="lbl"></span>
												</label>
											</td>
											<td>${item.id}</td>
											<td>${item.title}</td>
											<td>
												<a href="${pageContext.request.contextPath}/${item.imgUrl}" target="_blank">
													<img src="${pageContext.request.contextPath}/${item.imgUrl}" style="height: 50px;" />
												</a>
											</td>
											<td>
												<jsp:useBean id="dateValue" class="java.util.Date" />
												<jsp:setProperty name="dateValue" property="time" value="${item.addtime*1000}" />
												<fmt:formatDate value="${dateValue}" pattern="yyyy-mm-dd" />
											</td>
											<td>${item.desc}</td>
											<td>${item.identificationName}</td>
											<td class="">
												<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
													<a class="green" href="${pageContext.request.contextPath}/admin/find/update?id=${item.id}">
														<i class="icon-pencil bigger-130"></i>
													</a>
													<a class="red" href="${pageContext.request.contextPath}/admin/find/delete?id=${item.id}">
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
<!-- /.main-container -->
<script type="text/javascript">
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
<%@include file="/adminCommon/footer.jsp"%>