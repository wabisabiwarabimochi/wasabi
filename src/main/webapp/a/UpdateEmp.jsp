<%@ page language="java" contentType="text/html; charset=UTF-8"
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
        <label>従業員ID:</label>
        <input type="text" name="empid" required><br><br>
        <label>姓:</label>
        <input type="text" name="fname" required><br><br>
        <label>名:</label>
        <input type="text" name="lname" required><br><br>
        <input type="hidden" name="boo" value="name" />
        <input type="submit" value="更新">
    </form>
</body>
</html>