<%@ page import="com.gsm.bean.User" %>
<!-- src/main/webapp/jsp/dashboard.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%

    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>仪表盘</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f0f4f8;
        }
        .dashboard {
            margin-top: 50px;
        }
        .dashboard h2 {
            margin-bottom: 30px;
        }
        .dashboard .card {
            transition: transform 0.2s;
        }
        .dashboard .card:hover {
            transform: scale(1.05);
        }
        .dashboard .card i {
            font-size: 50px;
            margin-bottom: 15px;
            color: #0d6efd;
        }
    </style>
</head>
<body>
<div class="container dashboard">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2><i class="fas fa-tachometer-alt"></i> 仪表盘</h2>
        <div>
            <span class="me-3">欢迎, <strong>${sessionScope.user.userName}</strong>!</span>
            <a href="logout" class="btn btn-outline-danger"><i class="fas fa-sign-out-alt"></i> 注销</a>
        </div>
    </div>
    <div class="row">
        <!-- 个人中心 -->
        <div class="col-md-4 mb-4">
            <div class="card text-center shadow-sm">
                <div class="card-body">
                    <i class="fas fa-user-circle"></i>
                    <h5 class="card-title mt-3">个人中心</h5>
                    <p class="card-text">管理您的个人信息和账户设置。</p>
                    <a href="personalCenter" class="btn btn-primary"><i class="fas fa-cog"></i> 进入</a>
                </div>
            </div>
        </div>
        <!-- 活动管理 -->
        <div class="col-md-4 mb-4">
            <div class="card text-center shadow-sm">
                <div class="card-body">
                    <i class="fas fa-tasks"></i>
                    <h5 class="card-title mt-3">活动管理</h5>
                    <p class="card-text">创建、编辑和管理您的抽奖活动。</p>
                    <a href="manageEvents" class="btn btn-success"><i class="fas fa-clipboard-list"></i> 进入</a>
                </div>
            </div>
        </div>
        <!-- 奖品管理 -->
        <div class="col-md-4 mb-4">
            <div class="card text-center shadow-sm">
                <div class="card-body">
                    <i class="fas fa-award"></i>
                    <h5 class="card-title mt-3">奖品管理</h5>
                    <p class="card-text">设置和管理活动中的奖品信息。</p>
                    <a href="prizes?action=list&eventID=1" class="btn btn-warning"><i class="fas fa-gift"></i> 进入</a>

                </div>
            </div>
        </div>

        <div class="col-md-4 mb-4">
            <div class="card text-center shadow-sm">
                <div class="card-body">
                    <i class="fas fa-ticket-alt"></i>
                    <h5 class="card-title mt-3">开始抽奖</h5>
                    <p class="card-text">点击按钮参与抽奖，看看您能赢得什么奖品！</p>
                    <form action="drawResult" method="post">
                        <c:if test="${not empty defaultEventID}">
                            <input type="hidden" name="eventID" value="${defaultEventID}">
                        </c:if>
                        <button type="submit" class="btn btn-info"><i class="fas fa-ticket-alt"></i> 抽奖</button>
                    </form>


                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle (包含 Popper) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Font Awesome JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/js/all.min.js"></script>
</body>
</html>
