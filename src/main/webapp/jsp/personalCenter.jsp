<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>个人中心</title
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet"
    <styl
        body {
            background-color: #f8f9fa;
        }
        .personal-center {
            margin-top: 50px;
        }
        .personal-center h2 {
            margin-bottom: 25px;
        }
        .avatar-img {
            width: 150px;
            height: 150px;
            object-fit: cover;
            border-radius: 50%;
        }
    </style>
</head>
<body>
<div class="container personal-center">
    <h2 class="text-center"><i class="fas fa-user-circle"></i> 个人中心</h2>
    <div class="row">
        <!-- 账户设置 -->
        <div class="col-md-6 mb-4">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <i class="fas fa-cog"></i> 账户设置
                </div>
                <div class="card-body">
                    <form action="personalCenter" method="post" enctype="multipart/form-data" class="needs-validation" novalidate>
                        <input type="hidden" name="action" value="updateAvatar">
                        <div class="mb-3 text-center">
                            <img src="${user.avatarURL != null ? user.avatarURL : 'images/default-avatar.png'}" alt="头像" class="avatar-img mb-3">
                        </div>
                        <div class="mb-3">
                            <label for="avatar" class="form-label">更换头像</label>
                            <input type="file" class="form-control" name="avatar" id="avatar" accept="image/*">
                            <div class="form-text">请选择一张图片作为头像。</div>
                        </div>
                        <button type="submit" class="btn btn-primary w-100"><i class="fas fa-upload"></i> 更新头像</button>
                    </form>
                </div>
            </div>
        </div>
        <!-- 密码修改 -->
        <div class="col-md-6 mb-4">
            <div class="card shadow-sm">
                <div class="card-header bg-success text-white">
                    <i class="fas fa-key"></i> 密码修改
                </div>
                <div class="card-body">
                    <form action="personalCenter" method="post" class="needs-validation" novalidate>
                        <input type="hidden" name="action" value="updatePassword">
                        <div class="mb-3">
                            <label for="oldPassword" class="form-label">旧密码</label>
                            <input type="password" class="form-control" name="oldPassword" id="oldPassword" required>
                            <div class="invalid-feedback">
                                请输入旧密码。
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="newPassword" class="form-label">新密码</label>
                            <input type="password" class="form-control" name="newPassword" id="newPassword" required>
                            <div class="invalid-feedback">
                                请输入新密码。
                            </div>
                        </div>
                        <button type="submit" class="btn btn-success w-100"><i class="fas fa-sync"></i> 修改密码</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- 显示消息 -->
    <c:if test="${not empty message}">
        <div class="alert alert-success text-center">${message}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-danger text-center">${error}</div>
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
