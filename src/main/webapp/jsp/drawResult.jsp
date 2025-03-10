<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>抽奖结果</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <!-- 自定义 CSS -->
    <style>
        body {
            background-color: #f0f4f8;
        }
        .result-card {
            max-width: 600px;
            margin: 50px auto;
            padding: 30px;
            background: white;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        .result-card img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
        }
        .btn-back {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="result-card text-center">
        <h2 class="mb-4"><i class="fas fa-trophy text-warning"></i> 抽奖结果</h2>

        <c:choose>
            <c:when test="${not empty prize}">
                <div class="mb-4">
                    <img src="${prize.prizeImageURL != null ? prize.prizeImageURL : 'images/default-prize.png'}" alt="${prize.prizeName}" class="img-fluid">
                </div>
                <h4>恭喜您！您赢得了 <strong>${prize.prizeName}</strong></h4>
                <p class="mt-3">${prize.redemptionInstructions != null ? prize.redemptionInstructions : '请按照兑奖说明进行兑奖。'}</p>
                <a href="dashboard" class="btn btn-primary btn-back">
                    <i class="fas fa-home"></i> 返回仪表盘
                </a>
            </c:when>
            <c:otherwise>
                <div class="mb-4">
                    <i class="fas fa-frown text-danger fa-5x"></i>
                </div>
                <h4>很遗憾，您没有中奖。</h4>
                <p class="mt-3">感谢您的参与，祝您下次好运！</p>
                <a href="dashboard" class="btn btn-secondary btn-back">
                    <i class="fas fa-home"></i> 返回仪表盘
                </a>
            </c:otherwise>
        </c:choose>

        <c:if test="${not empty error}">
            <div class="alert alert-danger mt-4">
                    ${error}
            </div>
        </c:if>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/js/all.min.js"></script>
</body>
</html>
