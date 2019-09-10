<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div align="center">
        <a href="/input">新增</a>
        <form id="commit" action="/list" method="post" style="display: inline">
            <input id="currentPage" name="currentPage" value="1" type="hidden">
            <input id="pageSize" name="pageSize" value="${pageResult.pageSize}" type="hidden">
            name: <input type="text" name="name" value="${qo.name}">
            beginDate - endDate: <input type="text" name="beginDate" value="<fmt:formatDate value="${qo.beginDate}" pattern="yyyy-MM-dd"/>"> -
            <input type="text" name="endDate" value="<fmt:formatDate value="${qo.endDate}" pattern="yyyy-MM-dd"/>">
            <input type="submit" value="查询">
        </form>
    </div>

    <hr>
    <table border="1" cellpadding="2qu" cellspacing="0" width="70%" align="center">
        <tr>
            <th>ID</th>
            <th>HEAD_IMG</th>
            <th>NAME</th>
            <th>BORN_DATE</th>
            <th>OP</th>
        </tr>
        <c:forEach items="${pageResult.list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>
                    <img src="${user.headImg}" width="100px">
                    <a href="/download?imgPath=${user.headImg}">下载头像</a>
                </td>
                <td>${user.name}</td>
                <td><fmt:formatDate value="${user.bornDate}" pattern="yyyy-MM-dd"/></td>
                <td>
                    <a href="/input?id=${user.id}">编辑</a> |
                    <a href="/delete?id=${user.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div align="center">
        <%--翻页时使用js提交表单, 解决高级查询参数丢失--%>
        <a href="javascript:goto(${pageResult.prevPage})">上页</a>
        <a href="javascript:goto(${pageResult.nextPage})">下页</a>
        一共${pageResult.totalCount}条数据, 当前第${pageResult.currentPage}/${pageResult.totalPage}页
        每页显示
        <select id="pageSizeItems" onchange="goto(1)">
            <c:forEach items="${pageResult.pageSizeItems}" var="items">
                <option ${pageResult.pageSize == items ? 'selected' : ''}>${items}</option>
            </c:forEach>
        </select>
    </div>
</body>
</html>
<script src="/js/page.js"></script>
