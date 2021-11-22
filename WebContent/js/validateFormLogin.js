function errorForm(error){
  return `<div class="invalid-check-form" style="
    display: block;
    width: 100%;
    margin-top: 0.25rem;
    margin-left: 0.3rem;
    font-size: .875em;
    color: #dc3545;
">
      ${error}
        </div>`;
}
function successForm(success){
  return `<div class="valid-check-form" style="
  display: block;
  width: 100%;
  margin-top: .25rem;
  margin-left: 0.3rem;
  font-size: .75rem;
  color: #198754;
">${success}</div>`;
}
function outputEmpty(target, notification){
	if(!checkEmpty(target.val().trim())){
		target.css("border-color", "red");
	    target.parent().append(errorForm(notification));
		return false;		
	}
	return true;
}
function outputErrorForm(target, notification){
  if(target){
    target.append(`<div class="alert alert-danger" role="alert" style="
                  margin-top: 12px;
                  font-size: 14px;
                  padding: 10px;">
                          ${notification}
                  </div>`);
    return;
  }
  return;
}
function outputSuccessForm(target, notification){
  if(target){
    target.append(`<div class="alert alert-success" role="alert" style="
                        margin-top: 12px;
                        font-size: 14px;
                        padding: 10px;
                      ">
                    ${notification}
                  </div>`);
    return;
  }
  return;
}
function removeInvalidForm(target){
  if(target){
    target.remove();
    return;
  }
  return;
}
function removeOutputErrorForm(){
  if($("#output_error_form").find(".alert-danger")){
    $("#output_error_form").find(".alert-danger").remove();
  }
}
function isEmail(inputEmail) {
  let regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  return regex.test(inputEmail);
}

function validatePassword(inputPassword){
  if(inputPassword.length >= 8 && inputPassword.length <= 30){
    return true;
  }
  return false;
}

function validateEmail(inputEmail){

  if(inputEmail.length >= 5 && inputEmail.length <= 50){
    return true;
  }
  return false;
}
function validateUsername(inputUserName){
  if(inputUserName.length >= 3 && inputUserName.length <= 30){
    return true;
  }
  return false;
}
function checkEmpty(input){
	if(input.length){
		return true;
	}
	return false;
}
function processingEmail(email, root){
  if(!validateEmail(email)){
    //add notification
    root.css("border-color", "red");
    root.parent().append(errorForm("Email must be between 5 and 50 characters"));
    return;    
  } 
  if(!isEmail(email)){
    root.css("border-color", "red");
    root.parent().append(errorForm("Email is not valid format"));
    return;
  }
  //add notification
  root.css("border-color", "green");
  root.parent().append(successForm("Format valid"));
  return; 
}
function processingPassword(password, root){
  if(!validatePassword(password)){
    root.css("border-color", "red");
    root.parent().append(errorForm("Password must be between 8 and 30"));
    return;
  }
  //add notification
  root.css("border-color", "green");
  root.parent().append(successForm("Format valid"));
  return;
}
function processingUsername(username, root){
  if(!validateUsername(username)){
    root.css("border-color", "red");
    root.parent().append(errorForm("Password must be between 3 and 30"));
    return;
  }
    //add notification
    root.css("border-color", "green");
    root.parent().append(successForm("Format valid"));
    return;
}
$(document).ready(function(){
	
  $('#email_login').change(function(){
    removeInvalidForm($(this).parent().find(".invalid-check-form"));
    removeInvalidForm($(this).parent().find(".valid-check-form"));
    processingEmail($(this).val().trim(), $(this));
    removeInvalidForm($("#output_error_form_login").find('.alert-success'));
    removeInvalidForm($("#output_error_form_login").find('.alert-danger'));
	$(".submit-form").prop("disabled", false);
  })
  $('#password_login').change(function(){
    removeInvalidForm($(this).parent().find(".invalid-check-form"));
    removeInvalidForm($(this).parent().find(".valid-check-form"));
    processingPassword($(this).val(), $(this));
    removeInvalidForm($("#output_error_form_login").find('.alert-danger'));
	$(".submit-form").prop("disabled", false);
  })

  $('#email_register').change(function(){
    removeInvalidForm($(this).parent().find(".invalid-check-form"));
    removeInvalidForm($(this).parent().find(".valid-check-form"));
    processingEmail($(this).val().trim(), $(this));
    removeOutputErrorForm();
	$(".submit-register").prop('disabled', false);
  })
  
  $('#password_register').change(function(){
    removeInvalidForm($(this).parent().find(".invalid-check-form"));
    removeInvalidForm($(this).parent().find(".valid-check-form"));
    processingPassword($(this).val(), $(this));
	$(".submit-register").prop('disabled', false);
  })
  $('#confirm_password_register').change(function(){
    removeInvalidForm($(this).parent().find(".invalid-check-form"));
    removeInvalidForm($(this).parent().find(".valid-check-form"));
    processingPassword($(this).val(), $(this));
    removeOutputErrorForm();
	$(".submit-register").prop('disabled', false);
  })
  $('#username_register').change(function(){
    removeInvalidForm($(this).parent().find(".invalid-check-form"));
    removeInvalidForm($(this).parent().find(".valid-check-form"));
    processingUsername($(this).val().trim(), $(this));
	$(".submit-register").prop('disabled', false);
  })

  // processing submit form
  $(".register-form").submit(function(event){
    event.preventDefault();
    $(".submit-register").prop('disabled', true);
	let flag = true;
  	let output_error = $("#output_error_form");
	let username= $('#username_register');
	let password = $('#password_register');
	let confirm_password = $('#confirm_password_register');
	let email = $('#email_register');
	if(!outputEmpty(username, "Please enter value")){
		flag = false;
	}
	if(!outputEmpty(password, "Please enter value")){
		flag = false;
	}
	if(!outputEmpty(email,"Please enter value")){
		flag = false;		
	}
	if(!outputEmpty(confirm_password,"Please enter value")){
		flag = false;		
	}
  if(!validateEmail(email.val().trim())){
    flag = false;
  }
  if(!isEmail(email.val().trim())){
    flag = false;
  }
  if(!validatePassword(password.val())){
    flag = false;
  }
  if(!validatePassword(confirm_password.val())){
    flag = false;
  }
  if(!validateUsername(username.val().trim())){
    flag = false;
  }

  if(flag){
    if(confirm_password.val() !== password.val()){
      outputErrorForm(output_error, "Password and confirm password not match");
      confirm_password.focus();
      removeInvalidForm(confirm_password.parent().find(".valid-check-form"));
      confirm_password.css("border-color", "red");
      return;
    }
    $.post(
      'user/register', 
      {
        email:email.val().trim(),
        username:username.val().trim(),
        password:password.val()
      })
    .done(function(msg){ 
      username.val("");
      email.val("");
      password.val("");
      confirm_password.val("");
      removeInvalidForm(username.parent().find(".valid-check-form"));
      removeInvalidForm(email.parent().find(".valid-check-form"));
      removeInvalidForm(password.parent().find(".valid-check-form"));
      removeInvalidForm(confirm_password.parent().find(".valid-check-form"));
      username.css("border-color","#ced4da");
      email.css("border-color","#ced4da");
      password.css("border-color","#ced4da");
      confirm_password.css("border-color","#ced4da");
      $(".sign-in-form").removeClass('hidden');
      $(".register-form").addClass('hidden');
      outputSuccessForm($("#output_error_form_login"),msg);
      $("#email_login").focus();
      $(".submit-register").prop('disabled', false);
    })
    .fail(function(xhr, status, error) {
      console.log(xhr.responseText);
      outputErrorForm(output_error, xhr.responseText);
      removeInvalidForm(email.parent().find(".valid-check-form"));
      email.focus();
      email.css("border-color", "red");
      $(".submit-register").prop('disabled', false);
    });
  }
  })
  $(".sign-in-form").submit(function(event){
    event.preventDefault();
    $(".submit-form").prop("disabled", true);
    let flag = true;
    let output_error = $("#output_error_form_login");
	  let email= $('#email_login');
	  let password = $('#password_login');
    let rememberMe = $(".check-box-form");
    if(!outputEmpty(email, "Please enter value")){
      flag = false;		
    }
    if(!outputEmpty(password, "Please enter value")){
      flag = false;
    }
    if(!validateEmail(email.val().trim())){
      flag = false;
    }
    if(!validatePassword(password.val())){
      flag = false;
    }
    if(!isEmail(email.val().trim())){
      flag = false;
    }
    if(flag){
      $.post(
        'user/sign-in', 
        {
          email:email.val().trim(),
          password:password.val(),
          remember:rememberMe.is(":checked") ? "1" : "0"
        })
      .done(function(msg){
        if(msg == "admin"){
          window.location.replace("admin/home");
        }
        if(msg == "user"){
          window.location.replace("home");
        }
      })
      .fail(function(xhr, status, error) {
		    console.log(xhr.responseText);
        outputErrorForm(output_error, xhr.responseText);
        removeInvalidForm(email.parent().find(".valid-check-form"));
        removeInvalidForm(password.parent().find(".valid-check-form"));
        email.css("border-color", "red");
        password.css("border-color", "red");
        $(".submit-form").prop("disabled", false);
      });
    }
  })
})