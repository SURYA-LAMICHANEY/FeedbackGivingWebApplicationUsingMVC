<% response.setHeader("cache-control", "no-store");
    response.setHeader("pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
<%
  String usertype = "";
  String username="";
  HttpSession sess = request.getSession(true); 
    usertype = (String)sess.getAttribute("utype");
    username = (String)sess.getAttribute("username");
   if(usertype==null )
{   
     response.sendRedirect("logout.jsp");
} else{
	if(usertype != "Student")
	response.sendRedirect(usertype+".jsp");	
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student</title>
<link href="guideme.css" rel="stylesheet" type="text/css">
</head>
<script>
history.pushState(null, null, location.href);
window.onpopstate = function () 
{
  history.go(1);
};      
</script>
<style>
body{
background:url(images/3.jpg);
}
</style>
<div id="header"></div>
<div id="navigation">
<ul>         
 <li><div class ="dropdown">
<button  onclick="myFunction()" class="dropbtn">${messageu}</button>
<div id=myDropdown class="dropdown-content">
<a href="ChangePassword.jsp">Change password</a>
<a href="logout.jsp">Logout</a> 
<a href = "${pageContext.request.contextPath}/StudentController?action=StudentProfile"><button class="profilebtn"><b>Profile</b></button></a>
</div></div></li>
 </ul>
</div>
<br>
<br>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
${success}
<a href = "${pageContext.request.contextPath}/StudentController?action=AcademicFeedback"><button class="btn" >ACADEMIC <font color="yellow" size="7">${academic}</font></button></a><br>
<br>
<a href = "${pageContext.request.contextPath}/StudentController?action=SelfRelianceFeedback"><button class ="btn" >SELF RELIANCE   <font color="yellow" size="7">${selfreliance}</font></button></a><br>
<br>
<a href = "${pageContext.request.contextPath}/StudentController?action=MiscellaneousFeedback"><button class ="btn" >MISCELLANEOUS    <font color="yellow" size="7">${miscellaneous}</font></button></a><br>
</body>
</html>