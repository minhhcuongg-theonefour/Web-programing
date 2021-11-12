<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <link rel="stylesheet" href="css/home.css">
    <link rel="stylesheet" href="css/userProfile.css">
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
               	
               	<div class="card mb-4" style="position: relative;
    										height: 1300px;">
                	
                		<div class="wrapper">
            <div class="left">
                <img src="https://file.tinnhac.com/resize/600x-/2016/10/06/1646063g3a1078copy-8bda.jpg" alt="user" width="100">
                <h4>John</h4>
                 <p>Rapper</p>
            </div>
            <div class="right">
                <div class="info">
                    <h3>Infomation</h3>
                    <div class="info_data">
                         <div class="data">
                            <h4>Email</h4>
                            <p>karik@gmail.com</p>
                         </div>
                         <div class="data">
                           <h4>Phone</h4>
                            <p>09123456789</p>
                      </div>
                    </div>
                </div>
              
                <div class="projects">
                  <h3>Account</h3>
                  <div class="projects_data">
                       <div class="data">
                          <h4>Username</h4>
                          <p>karik123</p>
                       </div>
                       <div class="data">
                         <h4>Created at</h4>
                          <p>11/9/2021</p>
                    </div>
                  </div>
              </div>
              
                <div class="social_media">
                    <ul>
                      <li><a href="edit-profile"><i class="fa fa-pencil" aria-hidden="true"></i></a></li>
                  </ul>
              </div>
            </div>
        </div>
                
       			 </div>
                   
 
            </div>
    	</div>
    </div>
    <!-- Core theme JS-->
    <script src="js/userProfile.js"></script>
	
</body>
</html>