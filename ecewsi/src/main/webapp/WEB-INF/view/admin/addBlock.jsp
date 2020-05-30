<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="m" uri="http://java.sun.com/jstl/core_rt"%>
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

<script
	src="<%=request.getContextPath()%>/adminResources/js/modernizr.min.js"></script>
	
	<script type="text/javascript">
	function SearchSemester() //onchange event that calls this function
	{
		var deptId = document.getElementById("deptId");
		var semesterId = document.getElementById("semesterId");
		alert(deptId.value);

		var htp = new XMLHttpRequest();

		htp.onreadystatechange = function() {

			alert("In Function");

			alert(htp.readyState)
			if (htp.readyState == 4) {
				alert("In If");

				alert(JSON.parse(htp.responseText));

				var op = JSON.parse(htp.responseText);

				semesterId.innerHTML = "";

				for (i = 0; i < op.length; i++) {
					alert("In Loop");
					var o = document.createElement("option");
					o.text = op[i].semesterName;
					o.value = op[i].id;

					semesterId.options.add(o);
				}
			}
		}
		htp.open("GET", "admin/semesterByAjaxz?deptId=" + deptId.value, true);
		htp.send();
	}
</script>
	
	
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
								<h4 class="page-title float-left">ADD BLOCK</h4>

								<ol class="breadcrumb float-right">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item"><a href="#">Manage Product</a></li>
									<li class="breadcrumb-item active">Add Block</li>
								</ol>

								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<!-- end row -->


					<div class="row">
						<div class="col-lg-12">

							<div class="card-box">


								<c:form action="insertBlock" modelAttribute="BlockVO"
									method="post">

									<div class="form-group row">
										<label class="col-4 col-form-label">Add Floor<span
											class="text-danger">*</span></label>
										<div class="col-md-12">
											<c:select path="FloorVO.id" class="form-control">
												<m:forEach var="i" items="${FloorList}">
													<c:option value="${i.id}"> ${i.floor}</c:option>
												</m:forEach>
											</c:select>

										</div>
									</div>
									<div class="form-group">
										<label>Add Block<span class="text-danger">*</span></label>
										<div>
											<c:input data-parsley-type="number" type="text" path="block"
												class="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label for="example-textarea">Add Description<span
											class="text-danger">*</span></label>
										<div>
											<c:textarea class="form-control" rows="5"
												id="example-textarea" spellcheck="false"
												path="blockDiscription"></c:textarea>
										</div>

									</div>
									<div class="form-group">
										<div class="checkbox checkbox-purple">
											<input id="checkbox6a" type="checkbox">
										</div>

									</div>

									<div class="form-group text-right m-b-0">
										<button class="btn btn-primary waves-effect waves-light"
											type="submit">Save</button>

									</div>

								</c:form>
							</div>
						</div>
						<!-- end col -->
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