<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="css/login.css">
<title>Login</title>
</head>
<body>
<%
	String emailSession = (String) session.getAttribute("userLogged");
	if(emailSession != null && emailSession.length() > 0){
		int role = (int) session.getAttribute("role");
		if(role == 1){
					System.out.print("erorrrrr");	
%>
<script>
	window.location.replace("admin");
</script>
<% 
		}else{
			System.out.print("erorrrrr2");
%>
<script>
	window.location.replace("home");
</script>
<% 
		}
	}

%>
<% 
	// processing cookie for the remember me function
	String email = null, password =null, remember =null;
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("cookieEmail")){
				email = cookie.getValue();
			}else if(cookie.getName().equals("cookiePass")){
				password = cookie.getValue();
			}else if(cookie.getName().equals("cookieRemember")){
				remember = cookie.getValue();
			}
		}
	}
%>
<div class="container">
      <div class="row login-form">
        <div class="col-sm-3 wrap-login-form">
          <div class="row title-form">
            <span>Please Sign In</span>
          </div>
          <!-- sign in form -->
          <form class="sign-in-form">
            <div id="output_error_form_login">
          	</div>
            <div class="row element-form mt-3">
              <div class="child-element mb-3">
                <input type="email" class="form-control edit-focus-input" id="email_login" placeholder="E-mail" name="email"
                	<%= email !=null ? "value='"+email+"'" : null %>
                 >
              </div>
              <div class="child-element mb-2">
                <input type="password" class="form-control edit-focus-input" id="password_login" placeholder="Password" name="password"  
                	<%= password !=null ? "value='"+password+"'" : null %>
                >
              </div>
            </div>
            <div class="remember-btn">
                <div class="form-check mb-2">
                  <input class="form-check-input check-box-form" type="checkbox" id="flexCheckDefault"
                  	<%= "1".equals(remember) ? "checked='checked'" : "" %>
                  >
                  <label class="form-check-label" style="font-size:13px;" for="flexCheckDefault">
                    Remember Me
                  </label>
                </div>
            </div>
            <div class="d-grid gap-2">
              <button class="btn btn-success mb-3 btn-submit-form submit-login">Login</button>
            </div>
            <div class="row mb-3">
              <a href="void:()" class="switch-login-form">Click here to Register</a>
            </div>
          </form>
          <!-- register form -->
          <form class="register-form hidden">
          	<div id="output_error_form">
          	</div>
            <div class="row element-form mt-2">
              <div class="child-element mb-3">
                <input type="text" class="form-control edit-focus-input" placeholder="User name" id="username_register" name="username" > 
              </div>
              <div class="child-element mb-3">
                <input type="email" class="form-control edit-focus-input" placeholder="E-mail" id="email_register" name="email_register" >
              </div>
              <div class="child-element mb-3">
                <input type="password" class="form-control edit-focus-input" id="password_register" placeholder="Password" name="password" >
              </div>
              <div class="child-element mb-3">
                <input type="password" class="form-control edit-focus-input" id="confirm_password_register" placeholder="Re Password"  >
              </div>
            </div>
            <div class="d-grid gap-2">
              <button class="btn btn-success mb-3 btn-submit-form submit-register">Register</button>
            </div>
            <p id="output-error" style="color:red;"></p>
            <div class="row mb-3">
              <a href="void:()" class="switch-register-form">Click here to Login</a>
            </div>
          </form>
        </div>
      </div>
      
    </div>
    <!-- JavaScript -->
<script 
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
</script>
  <script src="js/login.js"></script>
  <script src="js/validateFormLogin.js"></script>
</body>
</html>