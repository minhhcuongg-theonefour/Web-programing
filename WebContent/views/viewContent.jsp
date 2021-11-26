<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>	

<%--
	<tiles:insertDefinition name="view-content" />
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/home.css">
<title>View Content</title>
</head>
<body>
<jsp:include page="checkLogged.jsp" />
	
    <div class="d-flex" id="wrapper">
        <jsp:include page="slidebar.jsp" />
        <!-- Page content wrapper-->
        <div id="page-content-wrapper">
            <jsp:include page="topNavigation.jsp" />
            <!-- Page content-->
            <div class="container-fluid">
            <jsp:include page="loading.jsp" />
				    <h1 class="mt-4">View Content</h1>

          <div class="card mb-4">
            <div class="card-header">View Content list</div>
            <div class="card-body">
              <table class="table table-striped table-bordered">
                <thead>
                  <tr>
                    <th width="50">#</th>
                    <th width="400">Title</th>
                    <th>Brief</th>
                    <th width="200">Created Date</th>
                    <th width="150">Actions</th>
                  </tr>
                </thead>
                <tbody>
                				<c:forEach items="${list}" var="content">
                                <tr>
                                    <td>
                                        ${content.contentId} 
                                    </td>
                                    <td>
                                        ${content.title}
                                    </td>
                                    <td>
                                        ${content.brief}
                                    </td>
                                    <td>
                                        ${content.getDate()} 
                                    </td>
                                    
                                    <td><a href="edit-content?contentID=${content.contentId}">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete-content?contentId=${content.contentId}">Delete</a></td>
                                </tr>
                                </c:forEach>
                        </tbody>
              </table>
              <ul class="pagination">
                <li class="page-item">
                  <a class="page-link" href="#">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                  <a class="page-link" href="#">Next</a>
                </li>
              </ul>
            </div>
          </div>
 
            </div>
    </div>
    </div>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/loader.js"></script>
    <!-- Core theme JS-->
    <script src="js/admin.js"></script>
	
</body>
</html>