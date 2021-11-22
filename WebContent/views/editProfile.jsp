<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	

<%--
	<tiles:insertDefinition name="edit-profile" />
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/home.css">
<title>Edit Profile</title>
</head>
<body>
	<div class="d-flex" id="wrapper">
        <jsp:include page="slidebar.jsp" />
        <!-- Page content wrapper-->
        <div id="page-content-wrapper">
            <jsp:include page="topNavigation.jsp" />
            <!-- Page content-->
            <div class="container-fluid">
				 <h1 class="mt-4">Edit profile</h1>

          <div class="card mb-4">
            <div class="card-header">Profile Form Elements</div>
            <div class="card-body">
              <table class="table table-striped table-bordered">
                <thead>
                  <tr>
                    <h6>First name</h6>
                    <input
                      type="text"
                      id="fname"
                      size="80"
                      name="fname"
                      placeholder="Enter the first name"
                    />
                    <h6>Last name</h6>
                    <input
                      type="text"
                      id="lname"
                      size="80"
                      name="lname"
                      placeholder="Enter the last name"
                    />
                    <h6>Email</h6>
                    your_email@gmail.com
                    <h6>Phone</h6>
                    <input
                      type="text"
                      id="phone"
                      size="80"
                      name="phone"
                      placeholder="Enter your phone number"
                    />
                    <h6>Description</h6>
                    <p> 
                    <input
                      type="text"
                      id="descrip"
                      name="descrip"
                      size="80";
                      <textarea name = "Brief" placeholder=" " 

                          style="height:100px"></textarea>
                   	 	/>			
                    </p>
                        <div class="col-25">
                        <input type="Submit" value="Submit Button"  />
                          <input type="Reset" value="Reset Button" />
                  </tr>
                </thead>
                <tbody></tbody>
              </table>
              <ul class="pagination"></ul>
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