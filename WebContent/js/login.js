const sign_in_form = document.querySelector('.sign-in-form');
const register_form = document.querySelector('.register-form');
const title_form = document.querySelector('.title-form span');

const btn_switch_login = document.querySelector('.switch-login-form');
const btn_switch_register = document.querySelector('.switch-register-form');

btn_switch_login.addEventListener('click',()=>{
  title_form.innerHTML = 'Register';
  register_form.classList.remove('hidden');
  sign_in_form.classList.add('hidden');
})
btn_switch_register.addEventListener('click',()=>{
  title_form.innerHTML = 'Please Sign In';
  sign_in_form.classList.remove('hidden');
  register_form.classList.add('hidden');

})


