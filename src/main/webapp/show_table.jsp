<%@ page import="model.ShiireBean,java.util.List" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
List<ShiireBean> List = (List<ShiireBean>) session.getAttribute("List");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>仕入れ業者一覧</title>
</head>
<body>
<h2>仕入れ先業者一覧</h2>
<form action="ShowTableServlet" method="post">
    資本金が<input type="text" name="shihon" required>以上
        <button type="submit">検索</button>
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>名称</th>
        <th>住所</th>
        <th>電話番号</th>
        <th>資本金</th>
        <th>納期</th>
    </tr>
	<%
	if (List != null) {
		for (ShiireBean s : List) {
	%>
	<tr>
		<td><%=s.getShiireid()%></td>
		<td><%=s.getShiiremei()%></td>
		<td><%=s.getShiireaddress()%></td>
		<td><%=s.getShiiretel()%></td>
		<td><%=s.getShihonkin()%></td>
		<td><%=s.getNouki()%></td><br>
	</tr>
	<%
	}
	} else {
	%>
	<tr>
		<td colspan="6">データが見つかりません</td>
	</tr>
	<%
	}
	%>
	</table>
</body>
</html>