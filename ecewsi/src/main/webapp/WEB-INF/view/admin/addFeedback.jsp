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
<title>Upbond - Responsive Admin Dashboard Template</title>
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

<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.rate {
	float: left;
	height: 46px;
	padding: 0 10px;
}

.rate:not (:checked ) >input {
	position: absolute;
	top: -9999px;
}

.rate:not (:checked ) >label {
	float: right;
	width: 1em;
	overflow: hidden;
	white-space: nowrap;
	cursor: pointer;
	font-size: 30px;
	color: #ccc;
}

.rate:not (:checked ) >label:before {
	content: <span class="fa fa-star checked"/>;
}

.rate>input:checked ~ label {
	color: #ffc700;
}

.rate:not (:checked ) >label:hover, .rate:not (:checked ) >label:hover 
	~ label {
	color: #deb217;
}

.rate>input:checked+label:hover, .rate>input:checked+label:hover ~ label,
	.rate>input:checked ~ label:hover, .rate>input:checked ~ label:hover ~
	label, .rate>label:hover ~ input:checked ~ label {
	color: #c59b08;
}
</style>

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
						<div class="col-12">
							<div class="page-title-box">
								<h4 class="page-title float-left">ADD FEEDBACK</h4>

								<ol class="breadcrumb float-right">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item"><a href="#">Manage
											Feedback</a></li>
									<li class="breadcrumb-item active">Add Feedback</li>
								</ol>

								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<!-- end row -->


					<div class="row">
						<div class="col-lg-12">

							<div class="card-box">

								<%@ taglib prefix="f"
									uri="http://www.springframework.org/tags/form"%>
								<f:form action="insertFeedback" modelAttribute="FeedbackVO" method="post" >
									<!-- <div class="form-group">
                                            <label for="userName">User Name<span class="text-danger">*</span></label>
                                            <input type="text" name="nick" parsley-trigger="change" required
                                                   placeholder="Enter user name"   id="userName">
                                        </div> -->
									<div class="form-group">
										<label for="emailAddress">Add Feedback<span
											class="text-danger">*</span></label> <f:input path="feedback"
											name="email" parsley-trigger="change" required=""
											class="form-control" id="emailAddress"/>
									</div>
									<div class="form-group">
										<label for="example-textarea">Rating<span
											class="text-danger">*</span></label>
										<div class="col-lg-4">
											<!-- <div class="mt-4 mt-lg-0">
                                                    <h4 class="form-group">Score</h4> -->
											<div class="form-group">
												<h4>
													<span class="flaticon-house-key"></span>Rating
												</h4>
												<div class="rating">
    														<div class="rate" >
    <input type="radio" id="star5" name="rate" path="rate" value="5" />
    <label for="star5" title="excelent"><span class="fa fa-star checked">5</span></label>
    <input type="radio" id="star4" name="rate" path="rate" value="4" />
    <label for="star4" title="very good"><span class="fa fa-star checked">4</span></label>
    <input type="radio" id="star3" name="rate" path="rate" value="3" />
    <label for="star3" title="Good"><span class="fa fa-star checked">3</span></label>
    <input type="radio" id="star2" name="rate" path="rate" value="2" />
    <label for="star2" title="bad"><span class="fa fa-star checked">2</span></label>
    <input type="radio" id="star1" name="rate" path="rate" value="1" />
    <label for="star1" title="very bad"><span class="fa fa-star checked">1</span></label>
  </div>
									</div>
											</div>


											<!--                                                     <div id="score" class="rating-star" style="cursor: pointer;"><i class="fas fa-star text-danger" title="bad" data-score="1"></i>&nbsp;<i class="fas fa-star text-danger" title="poor" data-score="2"></i>&nbsp;<i class="fas fa-star text-danger" title="regular" data-score="3"></i>&nbsp;<i class="far fa-star" title="good" data-score="4"></i>&nbsp;<i class="far fa-star" title="gorgeous" data-score="5"></i><input type="hidden" name="score" value="3"></div>
 -->
											<!-- </div> -->
										</div>
									</div>
									<!-- <div class="form-group">
                                            <label for="passWord2">Confirm Password <span class="text-danger">*</span></label>
                                            <input data-parsley-equalto="#pass1" type="password" required
                                                   placeholder="Password" class="form-control" id="passWord2">
                                        </div> -->
									<div class="form-group">
										<div class="checkbox checkbox-purple">
											<input id="checkbox6a" type="checkbox">
										</div>

									</div>

									<div class="form-group text-right m-b-0">
										<button class="btn btn-primary waves-effect waves-light"
											type="submit">Save</button>
									</div>

								</f:form>
							</div>
						</div>



					</div>
					<!-- container -->
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