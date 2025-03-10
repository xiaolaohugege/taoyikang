<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <title>奖品列表</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
  <style>
    body
      background-color: #f8f9fa;
    }
    .prize-table img {
      height: 50px;
      object-fit: cover;
    }
  </style>
</head>
<body>
<div class="container mt-5">
  <h2 class="mb-4 text-center"><i class="fas fa-award"></i> 奖品列表</h2>
<%--  <a href="prizes?action=edit&eventID=${eventID}" class="btn btn-success mb-3"><i class="fas fa-plus-circle"></i> 添加奖品</a>--%>
  <table class="table table-striped table-bordered prize-table">
    <thead class="table-dark">
    <tr>
      <th>奖品ID</th>
      <th>级别</th>
      <th>名称</th>
      <th>图片</th>
      <th>类型</th>
      <th>概率 (%)</th>
      <th>兑奖码</th>
      <th>兑奖说明</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="prize" items="${prizes}">
      <tr>
        <td>${prize.prizeID}</td>
        <td>${prize.prizeLevel}</td>
        <td>${prize.prizeName}</td>
        <td>
          <c:choose>
            <c:when test="${not empty prize.prizeImageURL}">
              <img src="${prize.prizeImageURL}" alt="${prize.prizeName}">
            </c:when>
            <c:otherwise>
              无
            </c:otherwise>
          </c:choose>
        </td>
        <td>${prize.prizeType}</td>
        <td>${prize.probability}</td>
        <td>${prize.redemptionCode != null ? prize.redemptionCode : '无'}</td>
        <td>${prize.redemptionInstructions != null ? prize.redemptionInstructions : '无'}</td>
        <td>
          <a href="prizes?action=edit&prizeID=${prize.prizeID}&eventID=${prize.eventID}" class="btn btn-primary btn-sm">
            <i class="fas fa-edit"></i> 编辑
          </a>
          <a href="prizes?action=delete&prizeID=${prize.prizeID}&eventID=${prize.eventID}" class="btn btn-danger btn-sm" onclick="return confirm('确定删除吗?');">
            <i class="fas fa-trash-alt"></i> 删除
          </a>
        </td>
      </tr>
    </c:forEach>
    <c:if test="${empty prizes}">
      <tr>
        <td colspan="9" class="text-center">没有找到任何奖品。</td>
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
