<%@ page session="true" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h1>ログイン画面</h1>
	<form action="../LoginServlet" method="post">
		ID：<input type="text" name="empid"><br>
		パスワード：<input type="password" name="emppasswd"><br>
		<input type="submit"value="ログイン">
	</form>
</body>
</html>