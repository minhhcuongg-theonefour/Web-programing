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
<body>
	<div class="d-flex" id="wrapper">
        <jsp:include page="slidebar.jsp" />
        <!-- Page content wrapper-->
        <div id="page-content-wrapper">
            <jsp:include page="topNavigation.jsp" />
            <!-- Page content-->
            <div class="container-fluid">
				     <h1 class="mt-4">Add Content</h1>
                <div class="card mb-4">
                    <div class="card-header">Enter Content Elements</div>
                    <div class="card-body">
                       <h5> <labe for="Title ">Title </label></h5> 
                        <input type="text" size="161px" name="Title" placeholder=" Enter the title ">
                      <div class="row">
                        <div class="col-25">
                        <h5> <label for="Brief">Brief</label></h5>
                        </div>
                          <textarea name = "Brief" placeholder=" " 
                          style="height:100px"></textarea>
                          </div>
                          <div class="row">
                        <div class="col-25">
                      <h5>  <label for="Content">Content</label></h5>
                        </div>
                          <textarea name = "Content" placeholder=" " 
                          style="height:200px"></textarea>
                          </div>
                     
                      <div class="col-25">
                        <input type="Submit" value="Submit Button"  />
                          <input type="Reset" value="Reset Button" />
                      </div>
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