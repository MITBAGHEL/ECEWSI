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

<!-- DataTables -->
<link
	href="<%=request.getContextPath()%>/adminResources/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/adminResources/css/buttons.bootstrap4.min.css"
	rel="stylesheet" type="text/css" />
<!-- Responsive datatable examples -->
<link
	href="<%=request.getContextPath()%>/adminResources/css/responsive.bootstrap4.min.css"
	rel="stylesheet" type="text/css" />

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

</head>


<body>

	<!-- Begin page -->
	<div id="wrapper">






		<jsp:include page="header.jsp"></jsp:include>
		<!-- Top Bar End -->


		<!-- ========== Left Sidebar Start ========== -->




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
								<h4 class="page-title float-left">View SubCategory</h4>

								<ol class="breadcrumb float-right">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item"><a href="#">Manage
											SubCategory</a></li>
									<li class="breadcrumb-item active">View SubCategory</li>
								</ol>

								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<!-- end row -->





					<div class="row">
						<div class="col-12">
							<div class="card-box table-responsive">
								<table id="datatable-buttons"
									class="table table-striped table-bordered" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<th>Sr NO</th>
											<th>Category</th>
											<th>SubCategory</th>
											<th>Description</th>
											<th>Image</th>
											<th>Action</th>
										</tr>
									</thead>

									<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

									<tbody>
										<c:forEach var="i" items="${subCategoryList}" varStatus="j">
											<tr>
												<td>${j.count}</td>
												<td>${i.categoryVO.categoryName}</td>
												<td>${i.subCategoryName }</td>
												<td>${i.subCategoryDiscription }</td>
												<td><img src="${i.link}" height="200px" width="200px"></td>
												<td><a
													href="editSubCategory?id=${i.id}">Edit</a>
													/ <a
													href="deleteSubCategory?id=${i.id}">Delete</a></td>
											</tr>
										</c:forEach>
									</tbody>

								</table>
							</div>
						</div>
					</div>
					<!-- end row -->


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

	<!-- Required datatable js -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/dataTables.bootstrap4.min.js"></script>
	<!-- Buttons examples -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/dataTables.buttons.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/buttons.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jszip.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/pdfmake.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/vfs_fonts.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/buttons.html5.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/buttons.print.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/buttons.colVis.min.js"></script>
	<!-- Responsive examples -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/dataTables.responsive.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/responsive.bootstrap4.min.js"></script>

	<!-- App js -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.core.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.app.js"></script>

	<script type="text/javascript">
		$(document).ready(
				function() {
					$('#datatable').DataTable();

					//Buttons examples
					var table = $('#datatable-buttons').DataTable({
						lengthChange : false,
						buttons : [ 'copy', 'excel', 'pdf', 'colvis' ]
					});

					table.buttons().container().appendTo(
							'#datatable-buttons_wrapper .col-md-6:eq(0)');
				});
	</script>

</body>
</html>
</body>
</html>