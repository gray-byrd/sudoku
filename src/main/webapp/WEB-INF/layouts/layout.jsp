<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
        <title><tiles:insertAttribute name="title" /></title>
    </head>
    <body>
        <div class="page-container d-flex w-100 h-100 p-3 mx-auto flex-column">
            <header class="header mb-5">
                <tiles:insertAttribute name="header" />
            </header>
            <main role="main" class="container">
                <tiles:insertAttribute name="body" />
            </main>
            <footer class="footer mt-4">
                <tiles:insertAttribute name="footer" />
            </footer>
        </div>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/fieldValidators.js"></script>
    </body>
</html>