<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%--
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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
	<div class="d-flex" id="wrapper">
        <jsp:include page="slidebar.jsp" />
        <!-- Page content wrapper-->
        <div id="page-content-wrapper">
            <jsp:include page="topNavigation.jsp" />
            <!-- Page content-->
            <div class="container-fluid">
				    <h1 class="mt-4">Search Content</h1>

          <div class="card mb-4">
            <div class="card-header">Search Content list</div>
            <div class="card-body">
              <table class="table table-striped table-bordered">
                <thead>
                  <tr>
                    <th width="50">ID</th>
                    <th width="400">AuthorId</th>
                    <th width="400">Title</th>
                    <th>Brief</th>
                    <th width="200">Content</th>
                    <th width="150">Actions</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${listSearch}" var="content">
                	<tr>
                    <td>${content.id}</td>
                    <td>${content.authorID}</td>
                    <td>${content.title }</td>
                    <td>${content.brief }</td>
                    <td>${content.brief }</td>
                    <td>${content.content }</td>
                    <td> 
                      <button class="btn btn-primary" id="button-edit" type="button">
              <i class="fa fa-edit" aria-hidden="true"></i> </button>
                       <button class="btn btn-primary" id="button-delete" type="button">
              <i class="fa fa-trash" aria-hidden="true"></i>
            </button>
                    </td>
                  </tr>
                </c:forEach>
                
                </tbody>
              </table>
              <ul class="pagination">
                <li class="page-item">
                  <a class="page-link" href="#">Previous</a>
                </li>
                <c:forEach begin="i" end="${endPage }" var="i">
                	<li class="page-item">
                		<a class="page-link" href="search?index=${i}&txtSearch=${save}">
                			${i}
                		</a>
                	</li>
                </c:forEach>
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
    <!-- Core theme JS-->
    <script src="js/admin.js"></script>
	
</body>
</html>