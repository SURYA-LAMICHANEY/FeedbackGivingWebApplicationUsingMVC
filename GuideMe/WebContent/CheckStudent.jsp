<%  
    HttpSession sess = request.getSession(true);
    sess.setAttribute("page", "CheckStudent");
    HttpSession sessio=request.getSession();        
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Student</title>
<link href="guideme.css" rel="stylesheet" type="text/css">
</head>
<div id="header"></div>
<div id="navigation">
<font color="white" size="6">CHECK STUDENT</font></div>
<style>
body{
background-image:url(images/bech.jpg);
}
</style>
</head>
<body>
<form action="AdminController" method="post">
 <br>
 ${sorry}
<div class="form__group">
<input type="text" name="userid" class="form__field" required placeholder="Registration number" >
<label for="userId" class="form__label">Enter the Registration number</label>
</div><br>
<input class="btns" type="submit" name="submit" value="Check"/>				 				
</form>
</body>
</html>