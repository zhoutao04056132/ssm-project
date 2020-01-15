<%--
  Created by IntelliJ IDEA.
  User: Jason
  Date: 2020/1/4
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login success</title>
</head>
<body>
    <p>Login success, and welcom,${requestScope.user.name}!</p>
    <p>your user info:</p>
    id:${requestScope.user.id}<br/>
    name:${requestScope.user.name}<br/>
    mobile:${requestScope.user.mobile}<br/>
    realName:${requestScope.user.realName}<br/>
    token:${requestScope.token}<br/>
</body>
</html>
