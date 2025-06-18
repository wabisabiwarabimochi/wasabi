<%@ page session="true" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>front</title>
</head>
<body>
	<h1>フロント画面</h1>
	<p>${id }</p>
	<p>ユーザーID：${sessionScope.id}</p>
	<br>
	<a href="../ShowTableServlet?paramName=value">仕入れ先TBL</a>

	<a href="/a/UpdatePassEmp.jsp">管理者のパスワード変更</a>
	<a href="test.jsp">テスト</a>
	<a href="a/UpdatePassEmp.jsp">従業員のパスワード変更</a>

</body>
</html>