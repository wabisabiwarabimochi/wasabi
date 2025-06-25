<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>仕入れ先登録</title>
</head>
<body>
<h2>仕入れ先登録</h2>
<form action="RegShiire" method="post">
    仕入れID <input type="text" name="shiireid" required><br>
    仕入れ先名 <input type="text" name="shiiremei" required><br>
    仕入れ先住所<input type="text" name="shiireaddress" requierd><br>
    電話番号 <input type="text" name="shiiretel" required><br>
    資本金 <input type="number" name="shihonkin" required><br>
    納期 <input type="number" name="nouki" required><br>
    <input type="submit" value="登録">
</form>

</body>
</html>

