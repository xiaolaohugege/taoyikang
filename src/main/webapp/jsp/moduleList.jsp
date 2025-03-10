<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>模板列表</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .module-card img {
            height: 200px;
            object-fit: cover;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4 text-center"><i class="fas fa-th-large"></i> 可选模板</h2>
<%--    <form action="modules" method="get" class="row g-3 mb-4">--%>
<%--        <input type="hiden" name="action" value="search">--%>
<%--        <div class="col-md-10">--%>
<%--            <input type="text" name="keyword" class="form-control" placeholder="搜索模板" value="${param.keyword}">--%>
<%--        </div>--%>
<%--        <div class="col-md-2">--%>
<%--            <button type="submit" class="btn btn-primary w-100"><i class="fas fa-search"></i> 搜索</button>--%>
<%--        </div>--%>
<%--    </form>--%>
    <div class="row">
        <c:forEach var="module" items="${modules}">
            <div class="col-md-4 mb-4">
                <div class="card module-card shadow-sm h-100">
                    <img src="${module.photoURL}" class="card-img-top" alt="${module.moduleName}">
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title">${module.moduleName}</h5>
                        <p class="card-text">${module.description}</p>
                        <a href="editEvent?moduleID=${module.moduleID}" class="btn btn-success mt-auto">
                            <i class="fas fa-check"></i> 选择模板
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
        <c:if test="${empty modules}">
            <div class="col-12">
                <div class="alert alert-info text-center">没有找到匹配的模板。</div>
            </div>
        </c:if>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/js/all.min.js"></script>
</body>
</html>
