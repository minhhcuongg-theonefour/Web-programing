<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	
<jsp:include page="checkLogged.jsp" />
<%
	int role = (int) session.getAttribute("role");
	if(role != 1){
%>
<script>
	window.location.replace("home");
</script>
<% 	
	}
%>

<%--
<tiles:insertDefinition name="admin" />
 --%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/home.css">
<title>Home Page</title>
</head>
<jsp:include page="checkLogged.jsp" />
<body>
	<div class="d-flex" id="wrapper">
        <jsp:include page="slidebar.jsp" />
        <!-- Page content wrapper-->
        <div id="page-content-wrapper">
            <jsp:include page="topNavigation.jsp" />
            <!-- Page content-->
            <div class="container-fluid">
				     <h1 class="mt-4">Admin Page</h1>

                <div class="card mb-4">
                    <div class="card-header">Admin Page</div>
                    
                    </div>
                </div>   
            </div>
 
            </div>
    </div>
    </div>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="../js/admin.js"></script>
	
</body>
</html>
	