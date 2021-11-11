<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="css/login.css">
<title>Login</title>
</head>
<body>
<div class="container">
      <div class="row login-form">
        <div class="col-sm-3 wrap-login-form">
          <div class="row title-form">
            <span>Please Sign In</span>
          </div>
          <!-- sign in form -->
          <form class="sign-in-form" action="user/sign-in" method="post">
            <div class="row element-form mt-3">
              <div class="child-element mb-3">
                <input type="email" class="form-control edit-focus-input" placeholder="E-mail" name="email">
              </div>
              <div class="child-element mb-2">
                <input type="password" class="form-control edit-focus-input" placeholder="Password" name="password">
              </div>
            </div>
            <div class="remember-btn">
                <div class="form-check mb-2">
                  <input class="form-check-input check-box-form" type="checkbox" value="" id="flexCheckDefault">
                  <label class="form-check-label" style="font-size:13px;" for="flexCheckDefault">
                    Remember Me
                  </label>
                </div>
            </div>
            <div class="d-grid gap-2">
              <button type="submit" class="btn btn-success mb-3 btn-submit-form">Login</button>
            </div>
            <div class="row mb-3">
              <a href="void:()" class="switch-login-form">Click here to Register</a>
            </div>
          </form>
          <!-- register form -->
          <form class="register-form hidden" action="user/register" method="post">
            <div class="row element-form mt-2">
              <div class="child-element mb-3">
                <input type="text" class="form-control edit-focus-input" placeholder="User name" name="username" >
              </div>
              <div class="child-element mb-3">
                <input type="email" class="form-control edit-focus-input" placeholder="E-mail" name="email">
              </div>
              <div class="child-element mb-3">
                <input type="password" class="form-control edit-focus-input" placeholder="Password" name="password">
              </div>
              <div class="child-element mb-3">
                <input type="password" class="form-control edit-focus-input" placeholder="Re Password">
              </div>
            </div>
            <div class="d-grid gap-2">
              <button type="submit" class="btn btn-success mb-3 btn-submit-form">Register</button>
            </div>
            <div class="row mb-3">
              <a href="void:()" class="switch-register-form">Click here to Login</a>
            </div>
          </form>
        </div>
      </div>
      
    </div>
  <script src="js/login.js"></script>
</body>
</html>