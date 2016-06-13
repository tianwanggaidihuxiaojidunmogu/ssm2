<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<!-- 
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>Racing | 主页</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
<link href="${ctx }/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="${ctx }/assets/global/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/assets/global/plugins/morris/morris.css" rel="stylesheet" type="text/css">
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN PAGE STYLES -->
<link href="${ctx }/assets/admin/pages/css/tasks.css" rel="stylesheet" type="text/css" />
<!-- END PAGE STYLES -->
<!-- BEGIN THEME STYLES -->
<!-- DOC: To use 'rounded corners' style just load 'components-rounded.css' stylesheet instead of 'components.css' in the below style tag -->
<link href="${ctx }/assets/global/css/components-rounded.css" id="style_components" rel="stylesheet" type="text/css" />
<link href="${ctx }/assets/global/css/plugins.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/assets/admin/layout4/css/layout.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/assets/admin/layout4/css/themes/light.css" rel="stylesheet" type="text/css" id="style_color" />
<link href="${ctx }/assets/admin/layout4/css/custom.css" rel="stylesheet" type="text/css" />
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-sidebar-closed-hide-logo page-sidebar-closed-hide-logo">
	<c:import url="/inc/header.jsp" />
	<div class="clearfix"></div>
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar-wrapper">
			<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
			<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
			<c:import url="/inc/menu.jsp" />
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<div class="page-content">
				<c:import url="/inc/page-head.jsp" />
				<!-- BEGIN PAGE CONTENT INNER -->
				<div class="row margin-top-10">
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="dashboard-stat2">
							<div class="display">
								<div class="number">
									<h3 class="font-green-sharp">
										7800<small class="font-green-sharp">$</small>
									</h3>
									<small>TOTAL PROFIT</small>
								</div>
								<div class="icon">
									<i class="icon-pie-chart"></i>
								</div>
							</div>
							<div class="progress-info">
								<div class="progress">
									<span style="width: 76%;" class="progress-bar progress-bar-success green-sharp"> <span class="sr-only">76% progress</span>
									</span>
								</div>
								<div class="status">
									<div class="status-title">progress</div>
									<div class="status-number">76%</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="dashboard-stat2">
							<div class="display">
								<div class="number">
									<h3 class="font-red-haze">1349</h3>
									<small>NEW FEEDBACKS</small>
								</div>
								<div class="icon">
									<i class="icon-like"></i>
								</div>
							</div>
							<div class="progress-info">
								<div class="progress">
									<span style="width: 85%;" class="progress-bar progress-bar-success red-haze"> <span class="sr-only">85% change</span>
									</span>
								</div>
								<div class="status">
									<div class="status-title">change</div>
									<div class="status-number">85%</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="dashboard-stat2">
							<div class="display">
								<div class="number">
									<h3 class="font-blue-sharp">567</h3>
									<small>NEW ORDERS</small>
								</div>
								<div class="icon">
									<i class="icon-basket"></i>
								</div>
							</div>
							<div class="progress-info">
								<div class="progress">
									<span style="width: 45%;" class="progress-bar progress-bar-success blue-sharp"> <span class="sr-only">45% grow</span>
									</span>
								</div>
								<div class="status">
									<div class="status-title">grow</div>
									<div class="status-number">45%</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<div class="dashboard-stat2">
							<div class="display">
								<div class="number">
									<h3 class="font-purple-soft">276</h3>
									<small>NEW USERS</small>
								</div>
								<div class="icon">
									<i class="icon-user"></i>
								</div>
							</div>
							<div class="progress-info">
								<div class="progress">
									<span style="width: 57%;" class="progress-bar progress-bar-success purple-soft"> <span class="sr-only">56% change</span>
									</span>
								</div>
								<div class="status">
									<div class="status-title">change</div>
									<div class="status-number">57%</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 col-sm-12">
						<!-- BEGIN PORTLET-->
						<div class="portlet light ">
							<div class="portlet-title">
								<div class="caption caption-md">
									<i class="icon-bar-chart theme-font-color hide"></i> <span class="caption-subject theme-font-color bold uppercase">Sales Summary</span> <span
										class="caption-helper hide">weekly stats...</span>
								</div>
								<div class="actions">
									<div class="btn-group btn-group-devided" data-toggle="buttons">
										<label class="btn btn-transparent grey-salsa btn-circle btn-sm active"> <input type="radio" name="options" class="toggle" id="option1">Today
										</label> <label class="btn btn-transparent grey-salsa btn-circle btn-sm"> <input type="radio" name="options" class="toggle" id="option2">Week
										</label> <label class="btn btn-transparent grey-salsa btn-circle btn-sm"> <input type="radio" name="options" class="toggle" id="option2">Month
										</label>
									</div>
								</div>
							</div>
							<div class="portlet-body">
								<div class="row list-separated">
									<div class="col-md-3 col-sm-3 col-xs-6">
										<div class="font-grey-mint font-sm">Total Sales</div>
										<div class="uppercase font-hg font-red-flamingo">
											13,760 <span class="font-lg font-grey-mint">$</span>
										</div>
									</div>
									<div class="col-md-3 col-sm-3 col-xs-6">
										<div class="font-grey-mint font-sm">Revenue</div>
										<div class="uppercase font-hg theme-font-color">
											4,760 <span class="font-lg font-grey-mint">$</span>
										</div>
									</div>
									<div class="col-md-3 col-sm-3 col-xs-6">
										<div class="font-grey-mint font-sm">Expenses</div>
										<div class="uppercase font-hg font-purple">
											11,760 <span class="font-lg font-grey-mint">$</span>
										</div>
									</div>
									<div class="col-md-3 col-sm-3 col-xs-6">
										<div class="font-grey-mint font-sm">Growth</div>
										<div class="uppercase font-hg font-blue-sharp">
											9,760 <span class="font-lg font-grey-mint">$</span>
										</div>
									</div>
								</div>
								<ul class="list-separated list-inline-xs hide">
									<li>
										<div class="font-grey-mint font-sm">Total Sales</div>
										<div class="uppercase font-hg font-red-flamingo">
											13,760 <span class="font-lg font-grey-mint">$</span>
										</div>
									</li>
									<li></li>
									<li class="border">
										<div class="font-grey-mint font-sm">Revenue</div>
										<div class="uppercase font-hg theme-font-color">
											4,760 <span class="font-lg font-grey-mint">$</span>
										</div>
									</li>
									<li class="divider"></li>
									<li>
										<div class="font-grey-mint font-sm">Expenses</div>
										<div class="uppercase font-hg font-purple">
											11,760 <span class="font-lg font-grey-mint">$</span>
										</div>
									</li>
									<li class="divider"></li>
									<li>
										<div class="font-grey-mint font-sm">Growth</div>
										<div class="uppercase font-hg font-blue-sharp">
											9,760 <span class="font-lg font-grey-mint">$</span>
										</div>
									</li>
								</ul>
								<div id="sales_statistics" class="portlet-body-morris-fit morris-chart" style="height: 260px"></div>
							</div>
						</div>
						<!-- END PORTLET-->
					</div>
					<div class="col-md-6 col-sm-12">
						<!-- BEGIN PORTLET-->
						<div class="portlet light ">
							<div class="portlet-title">
								<div class="caption caption-md">
									<i class="icon-bar-chart theme-font-color hide"></i> <span class="caption-subject theme-font-color bold uppercase">Member Activity</span> <span
										class="caption-helper hide">weekly stats...</span>
								</div>
								<div class="actions">
									<div class="btn-group btn-group-devided" data-toggle="buttons">
										<label class="btn btn-transparent grey-salsa btn-circle btn-sm active"> <input type="radio" name="options" class="toggle" id="option1">Today
										</label> <label class="btn btn-transparent grey-salsa btn-circle btn-sm"> <input type="radio" name="options" class="toggle" id="option2">Week
										</label> <label class="btn btn-transparent grey-salsa btn-circle btn-sm"> <input type="radio" name="options" class="toggle" id="option2">Month
										</label>
									</div>
								</div>
							</div>
							<div class="portlet-body">
								<div class="row number-stats margin-bottom-30">
									<div class="col-md-6 col-sm-6 col-xs-6">
										<div class="stat-left">
											<div class="stat-chart">
												<!-- do not line break "sparkline_bar" div. sparkline chart has an issue when the container div has line break -->
												<div id="sparkline_bar"></div>
											</div>
											<div class="stat-number">
												<div class="title">Total</div>
												<div class="number">2460</div>
											</div>
										</div>
									</div>
									<div class="col-md-6 col-sm-6 col-xs-6">
										<div class="stat-right">
											<div class="stat-chart">
												<!-- do not line break "sparkline_bar" div. sparkline chart has an issue when the container div has line break -->
												<div id="sparkline_bar2"></div>
											</div>
											<div class="stat-number">
												<div class="title">New</div>
												<div class="number">719</div>
											</div>
										</div>
									</div>
								</div>
								<div class="table-scrollable table-scrollable-borderless">
									<table class="table table-hover table-light">
										<thead>
											<tr class="uppercase">
												<th colspan="2">MEMBER</th>
												<th>Earnings</th>
												<th>CASES</th>
												<th>CLOSED</th>
												<th>RATE</th>
											</tr>
										</thead>
										<tr>
											<td class="fit"><img class="user-pic" src="${ctx }/assets/admin/layout3/img/avatar4.jpg"></td>
											<td><a href="javascript:;" class="primary-link">Brain</a></td>
											<td>$345</td>
											<td>45</td>
											<td>124</td>
											<td><span class="bold theme-font-color">80%</span></td>
										</tr>
										<tr>
											<td class="fit"><img class="user-pic" src="${ctx }/assets/admin/layout3/img/avatar5.jpg"></td>
											<td><a href="javascript:;" class="primary-link">Nick</a></td>
											<td>$560</td>
											<td>12</td>
											<td>24</td>
											<td><span class="bold theme-font-color">67%</span></td>
										</tr>
										<tr>
											<td class="fit"><img class="user-pic" src="${ctx }/assets/admin/layout3/img/avatar6.jpg"></td>
											<td><a href="javascript:;" class="primary-link">Tim</a></td>
											<td>$1,345</td>
											<td>450</td>
											<td>46</td>
											<td><span class="bold theme-font-color">98%</span></td>
										</tr>
										<tr>
											<td class="fit"><img class="user-pic" src="${ctx }/assets/admin/layout3/img/avatar7.jpg"></td>
											<td><a href="javascript:;" class="primary-link">Tom</a></td>
											<td>$645</td>
											<td>50</td>
											<td>89</td>
											<td><span class="bold theme-font-color">58%</span></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<!-- END PORTLET-->
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 col-sm-12">
						<!-- BEGIN PORTLET-->
						<div class="portlet light">
							<div class="portlet-title">
								<div class="caption caption-md">
									<i class="icon-bar-chart theme-font-color hide"></i> <span class="caption-subject theme-font-color bold uppercase">Customer Support</span> <span class="caption-helper">45 pending</span>
								</div>
								<div class="inputs">
									<div class="portlet-input input-inline input-small ">
										<div class="input-icon right">
											<i class="icon-magnifier"></i> <input class="form-control form-control-solid" placeholder="search..." type="text">
										</div>
									</div>
								</div>
							</div>
							<div class="portlet-body">
								<div style="position: relative; overflow: hidden; width: auto; height: 305px;" class="slimScrollDiv"><div data-initialized="1" class="scroller" style="height: 305px; overflow: hidden; width: auto;" data-always-visible="1" data-rail-visible1="0" data-handle-color="#D7DCE2">
									<div class="general-item-list">
										<div class="item">
											<div class="item-head">
												<div class="item-details">
													<img class="item-pic" src="/ssm2/assets/admin/layout3/img/avatar4.jpg"> <a href="" class="item-name primary-link">Nick Larson</a> <span class="item-label">3 hrs ago</span>
												</div>
												<span class="item-status"><span class="badge badge-empty badge-success"></span> Open</span>
											</div>
											<div class="item-body">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam
												erat volutpat.</div>
										</div>
										<div class="item">
											<div class="item-head">
												<div class="item-details">
													<img class="item-pic" src="/ssm2/assets/admin/layout3/img/avatar3.jpg"> <a href="" class="item-name primary-link">Mark</a> <span class="item-label">5
														hrs ago</span>
												</div>
												<span class="item-status"><span class="badge badge-empty badge-warning"></span> Pending</span>
											</div>
											<div class="item-body">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam
												erat volutpat tincidunt ut laoreet.</div>
										</div>
										<div class="item">
											<div class="item-head">
												<div class="item-details">
													<img class="item-pic" src="/ssm2/assets/admin/layout3/img/avatar6.jpg"> <a href="" class="item-name primary-link">Nick Larson</a> <span class="item-label">8 hrs ago</span>
												</div>
												<span class="item-status"><span class="badge badge-empty badge-primary"></span> Closed</span>
											</div>
											<div class="item-body">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh.</div>
										</div>
										<div class="item">
											<div class="item-head">
												<div class="item-details">
													<img class="item-pic" src="/ssm2/assets/admin/layout3/img/avatar7.jpg"> <a href="" class="item-name primary-link">Nick Larson</a> <span class="item-label">12 hrs ago</span>
												</div>
												<span class="item-status"><span class="badge badge-empty badge-danger"></span> Pending</span>
											</div>
											<div class="item-body">Consectetuer adipiscing elit Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
												laoreet dolore magna aliquam erat volutpat.</div>
										</div>
										<div class="item">
											<div class="item-head">
												<div class="item-details">
													<img class="item-pic" src="/ssm2/assets/admin/layout3/img/avatar9.jpg"> <a href="" class="item-name primary-link">Richard Stone</a> <span class="item-label">2 days ago</span>
												</div>
												<span class="item-status"><span class="badge badge-empty badge-danger"></span> Open</span>
											</div>
											<div class="item-body">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, ut laoreet dolore magna aliquam erat volutpat.</div>
										</div>
										<div class="item">
											<div class="item-head">
												<div class="item-details">
													<img class="item-pic" src="/ssm2/assets/admin/layout3/img/avatar8.jpg"> <a href="" class="item-name primary-link">Dan</a> <span class="item-label">3
														days ago</span>
												</div>
												<span class="item-status"><span class="badge badge-empty badge-warning"></span> Pending</span>
											</div>
											<div class="item-body">Lorem ipsum dolor sit amet, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</div>
										</div>
										<div class="item">
											<div class="item-head">
												<div class="item-details">
													<img class="item-pic" src="/ssm2/assets/admin/layout3/img/avatar2.jpg"> <a href="" class="item-name primary-link">Larry</a> <span class="item-label">4
														hrs ago</span>
												</div>
												<span class="item-status"><span class="badge badge-empty badge-success"></span> Open</span>
											</div>
											<div class="item-body">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam
												erat volutpat.</div>
										</div>
									</div>
								</div><div style="background: rgb(215, 220, 226) none repeat scroll 0% 0%; width: 7px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px; height: 128.665px;" class="slimScrollBar"></div><div style="width: 7px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(234, 234, 234) none repeat scroll 0% 0%; opacity: 0.2; z-index: 90; right: 1px;" class="slimScrollRail"></div></div>
							</div>
						</div>
						<!-- END PORTLET-->
					</div>
					<div class="col-md-6 col-sm-6">
						<!-- BEGIN PORTLET-->
						<div class="portlet light">
							<div class="portlet-title tabbable-line">
								<div class="caption caption-md">
									<i class="icon-globe theme-font-color hide"></i> <span class="caption-subject theme-font-color bold uppercase">Feeds</span>
								</div>
								<ul class="nav nav-tabs">
									<li class="active"><a href="#tab_1_1" data-toggle="tab"> System </a></li>
									<li><a href="#tab_1_2" data-toggle="tab"> Activities </a></li>
								</ul>
							</div>
							<div class="portlet-body">
								<!--BEGIN TABS-->
								<div class="tab-content">
									<div class="tab-pane active" id="tab_1_1">
										<div class="scroller" style="height: 337px;" data-always-visible="1" data-rail-visible1="0" data-handle-color="#D7DCE2">
											<ul class="feeds">
												<li>
													<div class="col1">
														<div class="cont">
															<div class="cont-col1">
																<div class="label label-sm label-success">
																	<i class="fa fa-bell-o"></i>
																</div>
															</div>
															<div class="cont-col2">
																<div class="desc">
																	You have 4 pending tasks. <span class="label label-sm label-info"> Take action <i class="fa fa-share"></i>
																	</span>
																</div>
															</div>
														</div>
													</div>
													<div class="col2">
														<div class="date">Just now</div>
													</div>
												</li>
												<li><a href="javascript:;">
														<div class="col1">
															<div class="cont">
																<div class="cont-col1">
																	<div class="label label-sm label-success">
																		<i class="fa fa-bell-o"></i>
																	</div>
																</div>
																<div class="cont-col2">
																	<div class="desc">New version v1.4 just lunched!</div>
																</div>
															</div>
														</div>
														<div class="col2">
															<div class="date">20 mins</div>
														</div>
												</a></li>
											</ul>
										</div>
									</div>
									<div class="tab-pane" id="tab_1_2">
										<div class="scroller" style="height: 337px;" data-always-visible="1" data-rail-visible1="0" data-handle-color="#D7DCE2">
											<ul class="feeds">
												<li><a href="javascript:;">
														<div class="col1">
															<div class="cont">
																<div class="cont-col1">
																	<div class="label label-sm label-success">
																		<i class="fa fa-bell-o"></i>
																	</div>
																</div>
																<div class="cont-col2">
																	<div class="desc">New user registered</div>
																</div>
															</div>
														</div>
														<div class="col2">
															<div class="date">Just now</div>
														</div>
												</a></li>
												<li><a href="javascript:;">
														<div class="col1">
															<div class="cont">
																<div class="cont-col1">
																	<div class="label label-sm label-success">
																		<i class="fa fa-bell-o"></i>
																	</div>
																</div>
																<div class="cont-col2">
																	<div class="desc">New order received</div>
																</div>
															</div>
														</div>
														<div class="col2">
															<div class="date">10 mins</div>
														</div>
												</a></li>
											</ul>
										</div>
									</div>
								</div>
								<!--END TABS-->
							</div>
						</div>
						<!-- END PORTLET-->
					</div>
				</div>
				<!-- END PAGE CONTENT INNER -->
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
	<!-- END CONTAINER -->
	<c:import url="/inc/footer.jsp" />
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<!--[if lt IE 9]>
<script src="${ctx }/assets/global/plugins/respond.min.js"></script>
<script src="${ctx }/assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
	<script src="${ctx }/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="${ctx }/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="${ctx }/assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
	<script src="${ctx }/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${ctx }/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
	<script src="${ctx }/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="${ctx }/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
	<script src="${ctx }/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
	<script src="${ctx }/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
	<script src="${ctx }/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- IMPORTANT! fullcalendar depends on jquery-ui.min.js for drag & drop support -->
	<script src="${ctx }/assets/global/plugins/morris/morris.min.js" type="text/javascript"></script>
	<script src="${ctx }/assets/global/plugins/morris/raphael-min.js" type="text/javascript"></script>
	<script src="${ctx }/assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${ctx }/assets/global/scripts/metronic.js" type="text/javascript"></script>
	<script src="${ctx }/assets/admin/layout4/scripts/layout.js" type="text/javascript"></script>
	<script src="${ctx }/assets/admin/layout4/scripts/demo.js" type="text/javascript"></script>
	<script src="${ctx }/assets/admin/pages/scripts/index3.js" type="text/javascript"></script>
	<script src="${ctx }/assets/admin/pages/scripts/tasks.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core componets
			Layout.init(); // init layout
			Demo.init(); // init demo features 
			Index.init(); // init index page
			Tasks.initDashboardWidget(); // init tash dashboard widget  
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>