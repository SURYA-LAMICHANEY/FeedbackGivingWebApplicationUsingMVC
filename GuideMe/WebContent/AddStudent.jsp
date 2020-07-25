<%
    HttpSession sess = request.getSession(true);
    sess.setAttribute("page", "AddStudent");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add student</title>
<link href="guideme.css" rel="stylesheet" type="text/css">
</head>
<div id="header"></div>
<div id="navigation">
<font color="white" size="6">ADD SUTDENT</font></div>
<style>
body{
background-image:url(images/bech.jpg); 
}
</style>
<body>
<br>	
${sorry}					
<form action="AdminController" method="post" enctype="multipart/form-data">
<div class="scroll">
<div class="form__group">
<input type="text" name="name" class="form__field" placeholder="fullname"  required>
<label for="name" class="form__label">Fullname</label>
</div>				

<div class="form__group">
<input type="text" name="userid" class="form__field" placeholder="Registration number" required >
<label for="userid" class="form__label">Registration Number</label>
</div>				
<div class="form__group">
<input type="password" name="password" class="form__field" placeholder="set password" required >
<label for="password" class="form__label">Password</label>
</div>	
			
<div class="containerr">			
  <ul>
  <li>
    <input type="radio" id="f-option" name="depart" value="DMACS" required>
    <label for="f-option">DMACS</label>    
    <div class="check"></div>
  </li>
  <li>
    <input type="radio" id="s-option" name="depart" value="DMC" required>
    <label for="s-option">DMC</label>    
    <div class="check"><div class="inside"></div></div>
  </li></ul></div>
			
<div class="form__group">
<input type="text" name="course" class="form__field" placeholder="eg: III BCA"  required>
<label for="course" class="form__label">Class</label>
</div>				
					
<div class="form__group">
<input type="text" name="semester" class="form__field" placeholder="current semester" required >
<label for="semester" class="form__label">Semester</label>
</div>				
					
<div class="form__group">
<input type="text" name="self" class="form__field" placeholder="self-reliance department" required >
<label for="course" class="form__label">Self-Reliance Department</label>
</div>	<br>
<div class="file-upload">
<label for="upload" class="file-upload__label">Upload Photo</label>
<input id="upload" class="file-upload__input" type="file" name="photo">
</div><br><br><br>	
<input class="btns" type="submit" name="submit" value="Create Account">										 							
		</div></form>	
</body>
</html>