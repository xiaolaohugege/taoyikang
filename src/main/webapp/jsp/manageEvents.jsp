<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <!-- 添加函数库 -->
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>活动管理</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .manage-events {
            margin-top: 50px;
        }
        .manage-events h2 {
            margin-bottom: 25px;
        }
    </style>
</head>
<body>
<div class="container manage-events">
    <h2 class="text-center"><i class="fas fa-tasks"></i> 活动管理</h2>
    <form action="manageEvents" method="get" class="row g-3 mb-4">
        <input type="hidden" name="action" value="search">
        <div class="col-md-8">
            <input type="text" name="keyword" class="form-control" placeholder="搜索活动" value="${param.keyword}">
        </div>
        <div class="col-md-4">
            <button type="submit" class="btn btn-primary"><i class="fas fa-search"></i> 搜索</button>
            <a href="moduleList" class="btn btn-success"><i class="fas fa-plus-circle"></i> 创建新活动</a>
        </div>
    </form


    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>活动ID</th>
            <th>标题</th>
            <th>时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="event" items="${events}">
            <tr>
                <td>${event.eventID}</td>
                <td>${event.title}</td>
                <td>
                    <fmt:formatDate value="${event.eventTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                    <a href="editEvent?eventID=${event.eventID}" class="btn btn-primary btn-sm">
                        <i class="fas fa-edit"></i> 编辑
                    </a>
                    <a href="manageEvents?action=delete&eventID=${event.eventID}" class="btn btn-danger btn-sm" onclick="return confirm('确定删除吗?');">
                        <i class="fas fa-trash-alt"></i> 删除
                    </a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty events}">
            <tr>
                <td colspan="4" class="text-center">没有找到任何活动。</td>
            </tr>
        </c:if>
        </tbody>
    </table>
    <c:if test="${not empty error}">
        <div class="alert alert-danger mt-3 text-center">${error}</div>
    </c:if>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/js/all.min.js"></script>
</body>
</html>
