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
<form action="Reg" method="post">
    患者ID<input type="text" name="patid" required><br>
   	姓 <input type="text" name="patlname" required><br>
   	名<input type="text" name="patfname" requierd><br>
    保険名 <input type="text" name="hokenmeil" required><br>
    有効期限<input type="date" name="hokenxp" required><br>
    <input type="number" name="nouki" required><br>
    <input type="submit" value="登録">
</form>

</body>
</html>

