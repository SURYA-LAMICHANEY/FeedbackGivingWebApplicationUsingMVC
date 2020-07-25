<%  
    HttpSession sess = request.getSession(true);
    sess.setAttribute("page", "ChangePassword");
    HttpSession sessio=request.getSession();
    String name= (String) sessio.getAttribute("id");   
    sess.setAttribute("uid", name);
    
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="login.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<style>
body{
background:url(images/bech.jpg);
}
</style>
<body>
<form action="UserController" method="post">
 <br>${message3}<br>	        	
<div class="form__group">
<input type="password" name="cpass" class="form__field" placeholder="Current password" required >
<label for="cpass" class="form__label">Current Password</label>
</div>				
<div class="form__group">
<input type="password" name="npass" class="form__field" placeholder="New password" required >
<label for="npass" class="form__label">New Password</label>
</div>		        																
<button  class="btns" >Change</button>
			        
</form>								
</body>
</html>