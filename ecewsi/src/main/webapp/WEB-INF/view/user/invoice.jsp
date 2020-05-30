<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>ECEWSI</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta
	content="A fully featured admin theme which can be used to build CRM, CMS, etc."
	name="description" />
<meta content="Coderthemes" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<!-- App favicon -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/adminResources/images/favicon.ico">

<!-- App css -->
<link
	href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/adminResources/css/icons.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/adminResources/css/metismenu.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/adminResources/css/style.css"
	rel="stylesheet" type="text/css" />


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<title>ECEWSI</title>
<meta content="Admin Dashboard" name="description" />
<meta content="ThemeDesign" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<link rel="shortcut icon" href="assets/images/favicon.ico">

<link
	href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/adminResources/css/icons.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/adminResources/css/style.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/adminResources/css/star.css"
	rel="stylesheet" type="text/css">

<script
	src="<%=request.getContextPath()%>/adminResources/js/modernizr.min.js"></script>
</head>
<body>

	<!-- Begin page -->
	<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="menu.jsp"></jsp:include>
		<!-- Left Sidebar End -->



		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<!-- ============================================================== -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="container-fluid">

					<div class="row">
						<div class="col-md-12">
							<div class="card-box">
								<div class="clearfix">
									<div class="float-left mb-2">
										<img
											src="<%=request.getContextPath()%>/userResources/images/logo-dark.png"
											alt="" height="28">
									</div>
									<div class="float-right">
										<h3 class="m-0 d-print-none">Invoice</h3>
									</div>
								</div>


								<div class="row">
									<div class="col-md-6">
										<div class="mt-3">
											<p>
												<b>Hello, ${registerList.firstName}
													${registerList.lastName}</b>
											</p>
											<p class="text-muted">Thanks a lot because you keep
												purchasing our products. Our company promises to provide
												high quality products for you as well as outstanding
												customer service for every transaction.</p>
										</div>

									</div>
									<!-- end col -->
									<div class="col-md-6">
										<div class="mt-3 text-md-right">
											<p>
												<strong>Order Date: </strong> ${orderList.purchaseDate}
											</p>
										</div>
									</div>
									<!-- end col -->
								</div>
								<!-- end row -->

								<div class="row mt-3">
									<div class="col-md-6">
										<h5>Billing Address</h5>

										<address class="line-h-24">
											${registerList.address} <abbr title="Phone">P:</abbr>
											${registerList.mobileNumber}
										</address>

									</div>

									<div class="col-md-6"></div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="table-responsive">
											<table class="table mt-4 table-centered">
												<thead>
													<tr>
														<th>#</th>
														<th>Item</th>
														<th class="text-right">Total</th>
													</tr>
												</thead>
												<tbody>
													<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
													<c:forEach var="i" items="${productList}">
														<c:forEach var="j" items="${i}" varStatus="k">
															<tr>
																<td>${k.count}</td>
																<td>${j.subProductName}</td>
																<td class="text-right">${j.price}</td>
															</tr>
														</c:forEach>

													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="clearfix pt-4">
											<h6 class="text-muted">Notes:</h6>

											<small> All accounts are to be paid within 7 days
												from receipt of invoice. To be paid by cheque or credit card
												or direct payment online. If account is not paid within 7
												days the credits details supplied as confirmation of work
												undertaken will be charged the agreed quoted fee noted
												above. </small>
										</div>

									</div>
									<div class="col-md-6">
										<div class="text-md-right">
											<p>
												<b>Sub-total:</b> ${subTotal}
											</p>

											<h3>${subTotal} Rs</h3>
										</div>
										<div class="clearfix"></div>
									</div>
								</div>

								<div class="hidden-print mt-4">
									<div class="text-right d-print-none">
										<a
											href="<%=request.getContextPath()%>/javascript:window.print()"
											class="btn btn-blue waves-effect waves-light"><i
											class="fa fa-print mr-1"></i> Print</a> <a
											href="<%=request.getContextPath()%>/#"
											class="btn btn-info waves-effect waves-light">Submit</a>
									</div>
								</div>
							</div>

						</div>

					</div>

				</div>
				<!-- content -->

				<jsp:include page="footer.jsp"></jsp:include>

			</div>


			<!-- ============================================================== -->
			<!-- End Right content here -->
			<!-- ============================================================== -->


		</div>
		<!-- END wrapper -->



		<!-- jQuery  -->
		<script
			src="<%=request.getContextPath()%>/adminResources/js/jquery.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/popper.min.js"></script>
		<!-- Popper for Bootstrap -->
		<script
			src="<%=request.getContextPath()%>/adminResources/js/bootstrap.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/metisMenu.min.js"></script>
		<script src="<%=request.getContextPath()%>/adminResources/js/waves.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/jquery.slimscroll.js"></script>

		<!-- Parsley js -->
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/adminResources/js/parsley.min.js"></script>

		<!-- App js -->
		<script
			src="<%=request.getContextPath()%>/adminResources/js/jquery.core.js"></script>
		<script
			src="<%=request.getContextPath()%>/adminResources/js/jquery.app.js"></script>

		<script type="text/javascript">
			$(document).ready(function() {
				$('form').parsley();
			});
		</script>
</body>
</html>