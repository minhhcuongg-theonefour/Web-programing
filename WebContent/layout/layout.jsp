<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title><tiles:getAsString name="title" /></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/home.css">
</head>
<body>
	<div class="d-flex" id="wrapper">
         <tiles:insertAttribute name="menu" />
        <!-- Page content wrapper-->
        <div id="page-content-wrapper">
            <tiles:insertAttribute name="header" />
            <!-- Page content-->
            <tiles:insertAttribute name="body" />
    </div>
    </div>
    <!-- Core theme JS-->
    <script src="js/admin.js"></script>
</body>
</html>