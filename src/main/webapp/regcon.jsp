<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String empid = (String)session.getAttribute("empid");
    String empfname = (String)session.getAttribute("empfname");
    String emplname = (String)session.getAttribute("emplname");
    String emppasswd = (String)session.getAttribute("emppasswd");
    int emprole = (int)session.getAttribute("emprole");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員登録情報確認</title>
</head>
<h1>従業員登録情報確認</h1>
<h2>以下の情報で登録しますか？</h2>
<body>

    <form action="RegisterServlet" method="post">
    
    ID:<%= empid%><br>
    名:<%= empfname%><br>
    性:<%= emplname%><br>
    パスワード:<%= emppasswd%><br>
    役職:<%= emprole%><br><br>
    
    <input type="hidden" value="con" name="boo">
    <input type="hidden" value="<%= empid%>" name="empid">
    <input type="hidden" value="<%= empfname%>" name="empfname">
    <input type="hidden" value="<%= emplname%>" name="emplname">
    <input type="hidden" value="<%= emppasswd%>" name="emppasswd">
    <input type="hidden" value="<%= emprole%>" name="emprole">
    <input type="hidden" name="boo" value="con" />
    <input type="submit" value="登録">
    <a href="empreg.jsp">修正</a>
    </form>
</body>
</html>