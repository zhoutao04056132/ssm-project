<%--
  Created by IntelliJ IDEA.
  User: Jason
  Date: 2020/5/15
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = "F:\\work\\upload";
%>
<html>
<head>
    <title>loadFile</title>
</head>
<body>
    <form action="upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" value="upload" />
    </form>
</body>
</html>
