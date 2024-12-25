<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>课程增加</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back/plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back/css/style.css">
<script
	src="<%=request.getContextPath()%>/back/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
	src="<%=request.getContextPath()%>/back/plugins/bootstrap/js/bootstrap.min.js"></script>

<!-- 富文本编辑器 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back/plugins/kindeditor/themes/default/default.css" />
<script charset="utf-8"
	src="<%=request.getContextPath()%>/back/plugins/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8"
	src="<%=request.getContextPath()%>/back/plugins/kindeditor/lang/zh_CN.js"></script>


</head>

<body class="hold-transition skin-red sidebar-mini">

	<!-- 正文区域 -->
	<section class="content">
		<form
			action="<%=request.getContextPath()%>/CollegesServlet"
			method="post"
			class="sui-form" >

			<input type="hidden" name="requestMethod" value="add">

			<div class="box-body">

				<!--tab页-->
				<div class="nav-tabs-custom">

					<!--tab头-->

					<!--tab头/-->

					<!--tab内容-->
					<div class="tab-content">

						<!--表单内容-->
						<div class="tab-pane active" id="home">
							<div class="row data-type">

								<!-- <div class="col-md-2 title">用户ID</div>
		                           	<div class="col-md-10 data">
		                               <input type="text" class="form-control"  name="id"  placeholder="用户ID" value="">
		                           </div>  -->

								<div class="col-md-2 title">名称</div>
								<div class="col-md-10 data">
									<input type="text" class="form-control" name="name" placeholder="name" value="">
								</div>
								<div class="col-md-2 title">代码</div>
								<div class="col-md-10 data">
									<input type="text" class="form-control" name="schoolCode"
										placeholder="schoolCode" value="">
								</div>
								<div class="col-md-2 title">主管部门</div>
								<div class="col-md-10 data">
									<input type="text" class="form-control" name="department"
										placeholder="department" value="">
								</div>
								<div class="col-md-2 title">城市</div>
								<div class="col-md-10 data">
									<input type="text" class="form-control" name="location"
										   placeholder="location" value="">
								</div>
								<div class="col-md-2 title">地址</div>
								<div class="col-md-10 data">
									<input type="text" class="form-control" name="address"
										   placeholder="address" value="">
								</div>
								<div class="col-md-2 title">办学层次</div>
								<div class="col-md-10 data">
									<input type="text" class="form-control" name="educationLevel"
										   placeholder="educationLevel" value="">
								</div>
								<div class="col-md-2 title">联系人</div>
								<div class="col-md-10 data">
									<input type="text" class="form-control" name="contactInfo"
										   placeholder="contactInfo" value="">
								</div>
								<div class="col-md-2 title">备注</div>
								<div class="col-md-10 data">
									<input type="text" class="form-control" name="remarks"
										   placeholder="remarks" value="">
								</div>

								<%--
								   <div class="col-md-2 title">教师id</div>
		                           <div class="col-md-10 data">
		                               <select  class="form-control" name="teacher_id"  >
		                               		<option>请选择</option>
		                               		<c:forEach items="${teachers }" var="teacher">
		                               			<option value="${teacher.id }">${teacher.teacherName }</option>
		                               		</c:forEach>
		                               </select>
		                           </div>
		                        --%>
							</div>
						</div>

					</div>

				</div>
				<div class="btn-toolbar list-toolbar">
					<!-- <button class="btn btn-primary" ><i class="fa fa-save"></i>保存</button> -->
					<input type="submit" class="btn btn-primary" value="保存">
				</div>
		</form>
	</section>

	<!-- 正文区域 /-->
	<script type="text/javascript">
		var editor;
		KindEditor.ready(function(K) {
			editor = K.create('textarea[name="content"]', {
				allowFileManager : true
			});
		});
	</script>

</body>

</html>