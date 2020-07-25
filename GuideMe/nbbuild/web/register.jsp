<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				</tr>
				<tr>
					<td><font color="#008B8B">UserId</font></td>
					<td><br>
				<tr>
					<td><input type="text" name="userId" placeholder="userId" /></td>
				</tr>
				<tr>
					<td><font color="#008B8B">Name</font></td>
					<td><br>
				<tr>
					<td><input type="text" name="username" placeholder="username" /></td>
				</tr>
				<tr>
					<td><font color="#008B8B">Password</font></td>
					<td><br>
				<tr>
					<td><input type="password" name="password" placeholder="Password" /></td>
				</tr>
				<tr>
					<td><font color="#008B8B">Re-password</font></td>
					<td><br>
				<tr>
					<td><input type="password" name="repass" placeholder="Re-password" /></td>
				</tr>
				<tr>
					 <td><input type="submit" name="register" value="register" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>