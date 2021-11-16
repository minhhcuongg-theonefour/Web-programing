<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/home.css">
<title>Add Content</title>
</head>
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
                    <div class="card-header">Enter Content Elements</div>
                    <div class="card-body">
                       
                    </div>
                    </div>
                </div>   
            </div>
 
            </div>
    </div>
    </div>
    <!-- Core theme JS-->
    <script src="js/admin.js"></script>
	
</body>
</html>