<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .registration-form {
            max-width: 500px;
            margin: 50px auto;
            padding: 30px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .registration-form h2 {
            margin-bottom: 25px;
        }
    </style>
</head>
<body>
<div class="registration-form">
    <h2 class="text-center"><i class="fas fa-user-plus"></i> 用户注册</h2>
    <form action="register" method="post" class="needs-validation" novalidate>
        <div class="mb-3">
            <label for="username" class="form-label">用户名</label>
            <input type="text" class="form-control" name="username" id="username" required>
            <div class="invalid-feedback">
                请输入用户名。
            </div>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">邮箱</label>
            <input type="email" class="form-control" name="email" id="email" required>
            <div class="invalid-feedback">
                请输入有效的邮箱地址。
            </div>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">密码</label>
            <input type="password" class="form-control" name="password" id="password" required>
            <div class="invalid-feedback">
                请输入密码。
            </div>
        </div>
        <button type="submit" class="btn btn-primary w-100"><i class="fas fa-paper-plane"></i> 注册</button>
    </form>
    <div class="text-center mt-3">
        已有账号? <a href="login">点击登录</a>
    </div>
    <c:if test="${not empty error}">
        <div class="alert alert-danger mt-3 text-center">${error}</div>
    </c:if>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/js/all.min.js"></script>
<script>
    (function () {
        'use strict'
        var forms = document.querySelectorAll('.needs-validation')
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
</body>
</html>
