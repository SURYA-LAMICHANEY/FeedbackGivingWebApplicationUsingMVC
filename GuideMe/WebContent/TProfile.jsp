<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="guideMe.model.Teacher"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="guideme.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>teacher Profile</title>
<style>
body{
background:url(images/3.jpg);
}
</style>
</head>
<body>
<div class="card">
<img src="Tblob.jsp?userid=${tid}" alt="Teacher's Photo" style="width:400px; height:250px;">
<c:forEach items="${list}" var="t">
   <br><font color="white" size="8">${t.name}</font>
	<br><p class="title">${t.userid}</p>
   <br> <p class="title">${t.department}</p>
						
</c:forEach>
<c:forEach items="${list2}" var="tsr">
				 <br><p class="title">${tsr.selfreliance}</p>												
</c:forEach>
<c:forEach items="${list3}" var="tsub">
				 <br><p class="title">${tsub.subid}</p>												
</c:forEach>
</div>				        

</body>
</html>