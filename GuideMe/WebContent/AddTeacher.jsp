<%
    HttpSession sess = request.getSession(true);
    sess.setAttribute("page", "AddTeacher");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add teacher</title>
<link href="guideme.css" rel="stylesheet" type="text/css">
</head>
<style>
body{
background:url(images/bech.jpg);
}
</style>
<body>
<div id="header"></div>
<div id="navigation">
<font color="white" size="6">ADD TEACHER</font></div>
<br>
${sorry}
<form action="AdminController" method="post" enctype="multipart/form-data">	
<div class="scroll">		
<div class="form__group">
<input type="text" name="name" class="form__field" placeholder="fullname" required >
<label for="name" class="form__label">Fullname</label>
</div>
	
<div class="form__group">
<input type="text" name="userid" class="form__field" placeholder="Identity Card Number" required >
<label for="userid" class="form__label">Identity Card Number</label>
</div>	

<div class="form__group">
<input type="password" name="password" class="form__field" placeholder="password" required  >
<label for="password" class="form__label">Password</label>
</div>

<div class="containerr">			
<ul>
<li>
    <input type="radio" id="f-option" name="depart" value="DMACS">
    <label for="f-option">DMACS</label>    
    <div class="check"></div>
</li>
<li>
    <input type="radio" id="s-option" name="depart" value="DMC">
    <label for="s-option">DMC</label>    
    <div class="check"><div class="inside"></div></div>
</li></ul></div>
  
<div class="form__group">
<input type="text" name="sr1" class="form__field" placeholder="self-reliance 1" >
<label for="sr1" class="form__label">Self-Reliance Department 1</label>
</div>	
<div class="form__group">
<input type="text" name="sr2" class="form__field" placeholder="self-reliance 2"  >
<label for="sr2" class="form__label">Self-Reliance Department 2</label>
</div>

<div class="form__group">
<input type="text" name="sr3" class="form__field" placeholder="self-reliance 3"  >
<label for="sr3" class="form__label">Self-Reliance Department 3</label>
</div>

<div class="form__group">
<input type="text" name="subid1" class="form__field" placeholder="subject code 1"  >
<label for="subid1" class="form__label">Subject Code 1</label>
</div>	
<div class="form__group">
<input type="text" name="subname1" class="form__field" placeholder="subject name 1"  >
<label for="subname1" class="form__label">Subject Name 1</label>
</div>	<br>

<div class="form__group">
<input type="text" name="subid2" class="form__field" placeholder="subject code 2" >
<label for="subid2" class="form__label">Subject Code 2</label>
</div>	
<div class="form__group">
<input type="text" name="subname2" class="form__field" placeholder="subject name 2" >
<label for="subname2" class="form__label">Subject Name 2</label>
</div>		<br>

<div class="form__group">
<input type="text" name="subid3" class="form__field" placeholder="subject code 3"  >
<label for="subid3" class="form__label">Subject Code 3</label>
</div>	
<div class="form__group">
<input type="text" name="subname3" class="form__field" placeholder="subject name 3"  >
<label for="subname3" class="form__label">Subject Name 3</label>
</div>		<br>

<div class="form__group">
<input type="text" name="subid4" class="form__field" placeholder="subject code 4" >
<label for="subid4" class="form__label">Subject Code 4</label>
</div>	
<div class="form__group">
<input type="text" name="subname4" class="form__field" placeholder="subject name 4" >
<label for="subname4" class="form__label">Subject Name 4</label>
</div>		<br>

<div class="form__group">
<input type="text" name="subid5" class="form__field" placeholder="subject code 5"  >
<label for="subid5" class="form__label">Subject Code 5</label>
</div>	
<div class="form__group">
<input type="text" name="subname5" class="form__field" placeholder="subject name 5" >
<label for="subname5" class="form__label">Subject Name 5</label>
</div>	<br>

<div class="form__group">
<input type="text" name="subid6" class="form__field" placeholder="subject code 6" >
<label for="subid6" class="form__label">Subject Code 6</label>
</div>	
<div class="form__group">
<input type="text" name="subname6" class="form__field" placeholder="subject name 6" >
<label for="subname6" class="form__label">Subject Name 6</label>
</div><br>			
<div class="file-upload">
    <label for="upload" class="file-upload__label" >Upload Photo</label>
    <input id="upload" class="file-upload__input" type="file" name="photo" >
</div><br><br><br>				
<input class="btns" type="submit" name="submit" value="Create Account">								 					
</div></form>	
</body>
</html>