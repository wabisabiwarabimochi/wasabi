<%@ page session="true" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>従業員情報の更新</title>
</head>
<body>
    <h2>従業員情報の更新</h2>
    <form action="../UpdateEmpServlet" method="post">
        <input type="hidden" name="id" value=${sessionScope.id}>
        <br>
        <label>パスワード:</label>
        <input type="password" name="emppasswd" required><br><br>
        <input type="hidden" name="boo" value="pass">
        <input type="hidden" name="role" value="admin">
        <input type="submit" value="更新">
    </form>
</body>
</html>