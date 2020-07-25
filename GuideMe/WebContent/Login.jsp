<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>GuideMe Login</title>
<link href="login.css" rel="stylesheet" type="text/css">
</head>
<script>
history.pushState(null, null, location.href);
window.onpopstate = function () 
{
   history.go(1);
};     
</script>
<%    
    HttpSession sess = request.getSession(true);
    sess.setAttribute("page", "Login");
 %>
 <%   
    response.setHeader("cache-control", "no-store");
    response.setHeader("pragma", "no-cache");
    response.setDateHeader("Expires", 0);
  %>
  <%
    String usertype = "";
    String username="";
    HttpSession sess1 = request.getSession(true); 
    usertype = (String)sess1.getAttribute("utype");
    
     if( usertype != null)
      {
     response.sendRedirect(usertype+".jsp");
      }    
%>
<style>
body{
background:url(images/bech.jpg);
}
</style>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
<form action="UserController"  method="post" >

${message}	               					
 <br>  
<div class="form__group">
<input type="text" name="userId" class="form__field" placeholder="username"  required onchange="" >
<label for="userId" class="form__label">Username</label>
</div>				
<div class="form__group">
<input type="password" name="password" class="form__field"  placeholder="set password" required >
<label for="password" class="form__label">Password</label>
</div> 				  
<button class ="btns">Login</button>				 
	
</form>	
</body>
</html>
