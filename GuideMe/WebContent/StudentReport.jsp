<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="guideMe.model.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Report</title>
</head>
<body>
<center><h2>Sri Satya Sai Institute of Higher Learning<br>Muddenahalli Campus</h2><p>Student Feedback for semester -${sem}</p>
<p>Name: ${name}<br>Roll No: ${userid}<br>Class: ${clas}<br></p></center>
<center><h2>Academic Feedbacks</h2></center>
<table cellspacing='30'>
<tr>
<th></th>
<th></th>
<th></th>
<th></th>

<th>Date</th>
<th>Subject</th>
<th>Teacher</th>
<th>Feedback</th>
<th>Marks</th>
</tr>
<c:forEach items="${list}" var="ac">				                  
<td></td>
<td></td>
<td></td>
<td></td>
<td>${ac.date}</td>
<td>${ac.subid}</td>
<td>${ac.tid}</td>
<td>${ac.remarks}</td>
<c:if test = "${ac.marks == '0.0'}">
<td>----</td><tr>
</c:if> 
<c:if test = "${ac.marks != '0.0'}">
<td>${ac.marks}</td><tr>
</c:if>				       
</c:forEach>
</table>
<center><h2>SeflReliance Feedbacks</h2></center>
<table cellspacing='30'>
<tr>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th>Date</th>
<th>Teacher</th>
<th>Feedback</th>
<th>Marks</th>
</tr>

<c:forEach items="${list2}" var="ac">				                  
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>${ac.date}</td>
<td>${ac.tid}</td>
<td>${ac.remarks}</td>
<c:if test = "${ac.marks == '0.0'}">
<td>----</td><tr>
</c:if> 
<c:if test = "${ac.marks != '0.0'}">
<td>${ac.marks}</td><tr>
</c:if>				       
</c:forEach>
</table>
<center><h2>Miscellaneous Feedbacks</h2></center>
<table cellspacing='30'>
<tr>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th>Date</th>
<th>Teacher</th>
<th>Feedback</th>
<th>Marks</th>
</tr>

<c:forEach items="${list3}" var="ac">				                  
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td>${ac.date}</td>
<td>${ac.tid}</td>
<td>${ac.remarks}</td>
<c:if test = "${ac.marks == 0}">
<td>----</td><tr>
</c:if> 
<c:if test = "${ac.marks != 0}">
<td>${ac.marks}</td><tr>
</c:if>				       
</c:forEach>

</table>
</body>
</html>