var delayInMilliseconds = 5000; // 5s 
window.addEventListener("load",function(){
  let load = document.querySelector('.loading-web');
  setTimeout(()=>{
    load.remove();
  },delayInMilliseconds)
})