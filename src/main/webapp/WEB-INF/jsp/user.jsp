<%--
  Created by IntelliJ IDEA.
  User: Jason
  Date: 2020/1/4
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userInfo</title>
</head>
<body>
    id:${requestScope.user.id}<br/>
    name:${requestScope.user.name}<br/>
    mobile:${requestScope.user.mobile}<br/>
    realName:${requestScope.user.realName}<br/>
</body>
</html>
