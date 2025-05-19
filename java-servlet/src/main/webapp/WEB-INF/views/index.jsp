<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${pageTitle}</title>
    <link href="https://lf26-cdn-tos.bytecdntp.com/cdn/expire-1-y/bootstrap/4.5.3/css/bootstrap.css" rel="stylesheet">
</head>
<body>

<!-- 导航栏 (Bootstrap 4 使用 navbar-expand-lg) -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <span class="navbar-brand">${pageTitle}</span>
    </div>
</nav>

<!-- 页面主内容 -->
<div class="container mt-4">
    <!-- Jumbotron (Bootstrap 4 样式) -->
    <div class="jumbotron">
        <h1 class="display-4">欢迎访问！</h1>
        <p class="lead">${pageDesc}</p>
    </div>
</div>

<div class="container">
    <div class="list-group">
        <c:forEach items="${userList}" var="user">
            <div class="list-group-item">
                <c:choose>
                    <c:when test="${user.id % 2 != 0}">
                        <strong>
                                ${user.id}: ${user.name},${user.age}岁,${user.address},${user.job}
                        </strong>
                    </c:when>

                    <c:otherwise>
                        ${user.id}: ${user.name},${user.age}岁,${user.address},${user.job}
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>
    </div>
</div>


<!-- 页脚 -->
<footer class="bg-light py-4 mt-4">
    <div class="container text-center">
        <p class="mb-0">© 2023 我的网站. 版权所有</p>
    </div>
</footer>

<script src="https://lf26-cdn-tos.bytecdntp.com/cdn/expire-1-y/jquery/1.12.4/jquery.js"></script>
<script src="https://lf3-cdn-tos.bytecdntp.com/cdn/expire-1-y/bootstrap/4.5.3/js/bootstrap.js"></script>

</body>
</html>