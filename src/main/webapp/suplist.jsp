<%@ page import="model.Sup,java.util.List" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
List<Sup> List = (List<Sup>) session.getAttribute("SupList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=SupList%>
</body>
</html>