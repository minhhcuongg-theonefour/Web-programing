<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/home.css">
<title>Insert title here</title>
</head>
<body>
	<div class="d-flex" id="wrapper">
        <jsp:include page="slidebar.jsp" />
        <!-- Page content wrapper-->
        <div id="page-content-wrapper">
            <jsp:include page="topNavigation.jsp" />
            <!-- Page content-->
            <div class="container-fluid">
				     <h1 class="mt-4">View Content</h1>

                <div class="card mb-4">
                    <div class="card-header">View Content list</div>
                    <div class="card-body">
                        
                    <table class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th width ="50">#</th>
                                <th width ="400">Title</th>
                                <th >Brief</th>
                                <th width ="200">Created Day</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td> </td>
                                <td> </td>
                                <td> </td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td> </td>
                                <td> </td>
                                <td> </td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td> </td>
                                <td> </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td> </td>
                                <td> </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td> </td>
                                <td> </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>6</td>
                                <td> </td>
                                <td> </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>7</td>
                                <td> </td>
                                <td> </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>8</td>
                                <td> </td>
                                <td> </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>9</td>
                                <td> </td>
                                <td> </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td> </td>
                                <td> </td>
                                <td></td>
                            </tr>  
                        </tbody>
                    </table>
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">Next</a></li>
                      </ul>
                      
                    </div>
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