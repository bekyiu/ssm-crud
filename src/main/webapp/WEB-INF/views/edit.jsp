<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/saveOrUpdate" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="headImg" value="${user.headImg}">
        username: <input type="text" name="name" value="${user.name}"> <br>
        bornDate: <input type="text" name="bornDate" value="<fmt:formatDate value="${user.bornDate}" pattern="yyyy-MM-dd"/>"><br>
        <c:if test="${user.id != null}">
            <img src="${user.headImg}" width="100px">
        </c:if>
        headImg:  <input type="file" name="pic"> <br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
