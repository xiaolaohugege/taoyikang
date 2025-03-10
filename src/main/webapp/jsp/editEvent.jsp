<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>${event != null ? '编辑活动' : '创建活动'}</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
        }
        .event-form {
            max-width: 800px;
            margin: 50px auto;
            padding: 30px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .event-form h2 {
            margin-bottom: 25px;
        }
    </style>
</head>
<body>
<div class="event-form">
    <h2 class="text-center"><i class="fas fa-edit"></i> ${event != null ? '编辑活动' : '创建活动'}</h2>
    <form action="editEvent" method="post" class="needs-validation" novalidate>
        <c:if test="${event != null}">
            <input type="hidden" name="eventID" value="${event.eventID}">
        </c:if>
        <c:if test="${moduleID != null}">
            <input type="hidden" name="moduleID" value="${moduleID}">
        </c:if>
        <div class="mb-3">
            <label for="moduleID" class="form-label">模板ID</label>
            <input type="text" class="form-control" name="moduleID" id="moduleID"
                   value="${event != null ? event.moduleID : moduleID}" >
        </div>
        <div class="mb-3">
            <label for="title" class="form-label">活动标题</label>
            <input type="text" class="form-control" name="title" id="title"
                   value="${event != null ? event.title : ''}" required>
            <div class="invalid-feedback">
                请输入活动标题。
            </div>
        </div>
        <div class="mb-3">
            <label for="eventTime" class="form-label">活动时间</label>
            <input type="text" class="form-control" name="eventTime" id="eventTime"
                   value="${event != null ? fn:replace(fn:substringBefore(fn:substringAfter(event.eventTime, ' '), '.'), ' ', 'T') : ''}"
                   placeholder="yyyy-MM-dd HH:mm:ss"
                   pattern="\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}"
                   required>
            <div class="invalid-feedback">
                请选择活动时间。
            </div>
        </div>
        <div class="mb-3">
            <label for="announcement" class="form-label">公告</label>
            <textarea class="form-control" name="announcement" id="announcement" rows="3">${event != null ? event.announcement : ''}</textarea>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">描述</label>
            <textarea class="form-control" name="description" id="description" rows="5" required>${event != null ? event.description : ''}</textarea>
            <div class="invalid-feedback">
                请输入活动描述。
            </div>
        </div>
        <button type="submit" class="btn btn-primary w-100"><i class="fas fa-save"></i> ${event != null ? '更新' : '创建'}</button>
    </form>
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
