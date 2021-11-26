<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%--
<tiles:insertDefinition name="admin" />
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../css/home.css">
<title>Home Page</title>
</head>
<jsp:include page="checkLogged.jsp" />
<body>
<jsp:include page="checkLogged.jsp" />
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
					<div class="card-body">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th width="20px">ID</th>
									<th width="30px">User</th>
									<th width="200px">Title</th>
									<th width="200px">Brief</th>
									<th width="50px">Created Date</th>
									<th width="50px">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listContentS}" var="content">
									<tr>
										<td>${content.contentId}</td>
										<td>${content.authorID}</td>
										<td style="word-break: break-word;">${content.title}</td>
										<td style="word-break: break-word;">${content.brief}</td>	
										<td>${content.createdDate}</td>
										<td>
										<a href="delete?id=${content.contentId}" class="btn btn-primary" style="background:#11ca3e;border-color:#11ca3e;" id="button-delete" type="button">
										<i class="fa fa-trash" aria-hidden="true"></i></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<ul class="pagination">
							<c:forEach begin="1" end="${end}" var="i">
							<a class="page-item"><a class="page-link" href="home?index=${i}">${i}</a>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>
	</div>
	</div>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
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
	<script src="../js/admin.js"></script>

</body>
</html>
