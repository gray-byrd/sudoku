<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
        <title><tiles:insertAttribute name="title" /></title>
    </head>
    <body>
        <div id="page-container">
            <header id="header-container">
                <tiles:insertAttribute name="header" />
            </header>
            <main id="main-container">
                <tiles:insertAttribute name="body" />
            </main>
            <footer id="footer-container">
                <tiles:insertAttribute name="footer" />
            </footer>
        </div>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.mask.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.mask-password.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/validate.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/game.js"></script>
    </body>

</html>