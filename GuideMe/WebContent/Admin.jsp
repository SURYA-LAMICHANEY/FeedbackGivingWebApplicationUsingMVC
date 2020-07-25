<% response.setHeader("cache-control", "no-store");
    response.setHeader("pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
    <%
    String usertype = "";
    String username="";
    HttpSession sess = request.getSession(true); 
    usertype = (String)sess.getAttribute("utype");
    
     if(usertype==null || usertype != "Admin")
      {
     response.sendRedirect("logout.jsp");
      }    
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrator</title>

<link href="guideme.css" rel="stylesheet" type="text/css">
</head>
<script>
function myFunction(){
	document.getElementById("myDropdown").classList.toggle("show");
}
window.onclick= function(event){
	if(!event.target.matches('.dropbtn')){
		var dropdowns=document.getElementByClassName("dropdown-content");
		var i;
		for(i=0;i<dropdown.length;i++){
			var openDropdown=dropdowns[i];
			if(openDropdown.classList.contains('show')){
				openDropdown.classList.remove('show');
			}
		}
	}
}
</script>
<script>
history.pushState(null, null, location.href);
window.onpopstate = function () 
{
  history.go(1);
};  
</script>
<div id="header"></div>
<div id="navigation">
 <ul>   
 <li><div class ="dropdown">
<button  onclick="myFunction()" class="dropbtn">${messageu}</button>
<div id=myDropdown class="dropdown-content">
<a href="ChangePassword.jsp">Change password</a>
<a href="logout.jsp">Logout</a> 
</div></div></li>
 </ul>
</div>
<style>
body{
background:url(images/bech.jpg);
}
</style>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
<br>
${message2}
${success}
${success2}
<br>
<a href="AddTeacher.jsp"><button class ="btn">ADD TEACHER</button></a><br><br>
<a href="AddStudent.jsp"><button class ="btn">ADD STUDENT</button></a><br><br>
<a href="CheckTeacher.jsp"><button class ="btn">CHECK TEACHER</button></a><br><br>
<a href="CheckStudent.jsp"><button class ="btn">CHECK STUDENT</button></a><br><br>
<a href="GenerateReport.jsp"><button class ="btn">GENERATE REPORT</button></a><br><br>
</body>
</html>
