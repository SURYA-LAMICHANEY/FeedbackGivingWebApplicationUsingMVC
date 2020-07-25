<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<link href="login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id=header>
		<h1>
			<font color="#DC143C">Welcome to GuideMe</font>
		</h1>
		<form action="loginServelet" method="post">

			<table>
				<tr>
					<td style="color: red;">${message}</td>
                                        <td style="color:greenyellow">${successmessage}</td>
				</tr>
				<tr>
					<td><font color="#008B8B">Username</font></td>
					<td><br>
				<tr>
					<td><input type="text" name="userId" placeholder="userId" /></td>
				</tr>
				<tr>
					<td><font color="#008B8B">Password</font></td>
					<td><br>
				<tr>
					<td><input type="password" name="password"
						placeholder="Password" /></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="login"/></td>
					 <td><a href="register.jsp"><font color="#DC143C">Register</font></a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
