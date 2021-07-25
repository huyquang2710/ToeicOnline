<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <title><dec:title default="Admin Page" /> </title>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css'/>" />
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css'/>" />

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/fonts/fonts.googleapis.com.css'/>" />

    <!-- ace styles -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css'/>" class="ace-main-stylesheet" id="main-ace-style" />

    <!-- ace settings handler -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/js/ace-extra.min.js'/>" />

    <dec:head />
</head>
<body class="no-skin">
    <%--Header--%>
    <%@ include file="/common/admin/header.jsp" %>
    <div class="main-container" id="main-container">
        <script type="text/javascript">
            try{ace.settings.check('main-container' , 'fixed')}catch(e){}
        </script>

        <%@ include file="/common/admin/menu.jsp" %>
        <%--Body--%>

        <dec:body />
        <%--Footer--%>
        <%@ include file="/common/admin/footer.jsp" %>

        <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
            <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
        </a>
    </div>

    <!-- page specific plugin scripts -->

    <!--[if lte IE 8]>
    <script src="<c:url value='/template/admin/assets/js/excanvas.min.js' /> "></script>
    <![endif]-->
    <script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' /> "></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' /> "></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' /> "></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' /> "></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' /> "></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' /> "></script>
    <script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' /> "></script>

    <!-- ace scripts -->
    <script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' /> "></script>
    <script src="<c:url value='/template/admin/assets/js/ace.min.js' /> "></script>
</body>
</html>