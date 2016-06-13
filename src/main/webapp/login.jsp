<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>Racing | 登录 - 用户登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
<link href="${ctx}/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="${ctx}/assets/admin/pages/css/login2.css" rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME STYLES -->
<link href="${ctx}/assets/global/css/components-rounded.css" id="style_components" rel="stylesheet" type="text/css" />
<link href="${ctx}/assets/global/css/plugins.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/assets/admin/layout/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color" />
<link href="${ctx}/assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css" />
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login">
	<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
	<div class="menu-toggler sidebar-toggler"></div>
	<!-- END SIDEBAR TOGGLER BUTTON -->
	<!-- BEGIN LOGO -->
	<div class="logo">
	</div>
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="login-form" action="index.jsp" method="post">
			<div class="form-title">
				<span class="form-title">欢迎.</span> <span class="form-subtitle">请先登录.</span>
			</div>
			<div class="alert alert-danger display-hide">
				<button class="close" data-close="alert"></button>
				<span> 请输入用户名和密码. </span>
			</div>
			<div class="form-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">用户名:</label> <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off"
					placeholder="用户名" name="username" />
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">密码:</label> <input class="form-control form-control-solid placeholder-no-fix" type="password"
					autocomplete="off" placeholder="密码" name="password" />
			</div>
			<div class="form-actions">
				<button type="submit" class="btn btn-primary btn-block uppercase">登录</button>
			</div>
			<div class="form-actions">
				<div class="pull-left">
					<label class="rememberme check"> <input type="checkbox" name="remember" value="1" />记住我
					</label>
				</div>
				<div class="pull-right forget-password-block">
					<a href="javascript:;" id="forget-password" class="forget-password">忘记密码?</a>
				</div>
			</div>
		</form>
		<!-- END LOGIN FORM -->
		<!-- BEGIN FORGOT PASSWORD FORM -->
		<form class="forget-form" action="index.html" method="post">
			<div class="form-title">
				<span class="form-title">Forget Password ?</span> <span class="form-subtitle">Enter your e-mail to reset it.</span>
			</div>
			<div class="form-group">
				<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Email" name="email" />
			</div>
			<div class="form-actions">
				<button type="button" id="back-btn" class="btn btn-default">Back</button>
				<button type="submit" class="btn btn-primary uppercase pull-right">Submit</button>
			</div>
		</form>
		<!-- END FORGOT PASSWORD FORM -->
	</div>
	<div class="copyright hide">2016 © Racing. Admin Dashboard.</div>
	<!-- END LOGIN -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<!--[if lt IE 9]>
<script src="${ctx}/assets/global/plugins/respond.min.js"></script>
<script src="${ctx}/assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
	<script src="${ctx}/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${ctx}/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
	<script src="${ctx}/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${ctx}/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
	<script src="${ctx}/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
	<script src="${ctx}/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="${ctx}/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${ctx}/assets/global/scripts/metronic.js" type="text/javascript"></script>
	<script src="${ctx}/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
	<script src="${ctx}/assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
	<script src="${ctx}/assets/admin/pages/scripts/login.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			Login.init();
			Demo.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>