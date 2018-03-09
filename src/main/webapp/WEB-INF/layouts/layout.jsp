<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
        <title><tiles:insertAttribute name="title" /></title>
    </head>
    <body>
        <div class="container">
            <tiles:insertAttribute name="header" />
            <br />
            <br />
            <tiles:insertAttribute name="body" />
            <br />
            <br />
            <tiles:insertAttribute name="footer" />
        </div>

        <script type="text/javascript" src="/resources/js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/resources/js/app.js"></script>
    </body>
</html>