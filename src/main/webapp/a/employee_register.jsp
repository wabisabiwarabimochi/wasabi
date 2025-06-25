<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>従業員登録</title>
</head>
<body>
	<h2>従業員登録フォーム</h2>
	<form action="../RegisterServlet" method="post">
		<label>名:</label><input type="text" name="empfname" required><br>
		<label>姓:</label><input type="text" name="emplname" required><br>
		<label>ユーザーID:</label><input type="text" name="empid" required><br>
		<label>パスワード:</label><input type="password" name="emppasswd" required><br>
		<select name="emprole" id="role">
			<option value="0">ロール０</option>
			<option value="1">ロール１</option>
			<option value="2">ロール２</option>
			<option value="3">ロール３</option>
		</select>
		 <input type="hidden" name="boo" value="reg" />
		  <input type="submit" value="登録">
	</form>
</body>
</html>
