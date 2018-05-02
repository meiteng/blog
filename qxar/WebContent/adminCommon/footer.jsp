</body>
<!-- basic scripts -->
<!--[if !IE]> -->
<script type="text/javascript">
	window.jQuery || document.write("<script src='${pageContext.request.contextPath}/plugin/ace/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
        <script type="text/javascript">
        window.jQuery || document.write("<script src='${pageContext.request.contextPath}/plugin/ace/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
        </script>
        <![endif]-->

<script type="text/javascript">
	if ("ontouchend" in document)
		document.write("<script src='${pageContext.request.contextPath}/plugin/ace/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>

<script src="${pageContext.request.contextPath}/plugin/ace/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->


<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.ui.touch-punch.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.slimscroll.min.js"></script>

<!-- ace scripts -->

<script src="${pageContext.request.contextPath}/plugin/ace/js/ace-elements.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/ace.min.js"></script>
<script type="text/javascript">
	try {
		ace.settings.check('main-container', 'fixed');
		ace.settings.check('breadcrumbs', 'fixed');
	} catch (e) {
		
	}
	
</script>
</html>