<%@page import="com.ecewsi.model.RegisterVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
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
</head>
<body>
        <!-- Begin page -->
        <div id="wrapper">

            
            <!-- Topbar Start -->
            <jsp:include page="header.jsp"></jsp:include>
            <jsp:include page="menu.jsp"></jsp:include>
            <!-- end Topbar -->

            
            <!-- ========== Left Sidebar Start ========== -->
            
            <!-- Left Sidebar End -->

            <!-- ============================================================== -->
            <!-- Start Page Content here -->
            <!-- ============================================================== -->

            <div class="content-page">
                <div class="content">
                    
                    <!-- Start Content-->
                    <div class="container-fluid">
                        
                        <!-- start page title -->
                        <div class="row">
						<div class="col-12">
							<div class="page-title-box">
								<h4 class="page-title float-left">Edit Profile</h4>

								<ol class="breadcrumb float-right">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item"><a href="#">Edit Profile
											</a></li>
									
								</ol>

								<div class="clearfix"></div>
							</div>
						</div>
					</div> 
                        <!-- end page title --> 

                        <div class="row">
                           <div class="col-12">
                                <div class="card-box">
                                    
                                 

                                    <f:form action="insertEditProfileData" method="post"
									modelAttribute="registerVO1">
                                        <div class="form-group">
                                            <label>FirstName</label>
                                            <f:input type="text" class="form-control" required="" path="firstName" />
                                        </div>

                                        
										
                                        <div class="form-group">
                                            <label>LastName</label>
                                            <div>
                                                <f:input type="text" class="form-control" required="" path="lastName" parsley-type="email" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                        <label>Gender</label>
                                             <div class="custom-control custom-radio">
                                             
                                                                <f:radiobutton  id="customRadio1" path="gender" class="custom-control-input"  value="male"/>
                                                                <label class="custom-control-label" for="customRadio1">Male</label>
                                             </div>                   
                                                                
                                                           
                                                   <div class="custom-control custom-radio">
                                                      
                                                                <f:radiobutton id="customRadio2" path="gender" class="custom-control-input" value="female"/>
                                                                <label class="custom-control-label" for="customRadio2">Female</label>
                                                            </div>
                                            </div>
                                        
                                        <div class="form-group">
                                            <label>Mobile Number</label>
                                            <div>
                                                <f:input data-parsley-type="number" path="mobileNumber" type="text" class="form-control" required="" />
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Username</label>
                                            <div>
                                                <f:input type="email" path="loginVO.username" class="form-control" required="" />
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Password</label>
                                            <div>
                                                <f:input path="loginVO.password" type="text" class="form-control" required="" />
                                            </div>
                                        </div>
                                                                              
                                       	 <f:hidden path="registerId"/>
                                         <f:hidden path="loginVO.loginId"/>
                                         <f:hidden path="loginVO.enabled"/>
                                         <f:hidden path="loginVO.role"/>
                                         <f:hidden path="loginVO.status"/>
                           				
                                        <div class="form-group">
                                            <label>Address</label>
                                            <div>
                                                <f:textarea required="" path="address" class="form-control"></f:textarea>
                                            </div>
                                        </div>
                                        <div class="form-group mb-0">
                                            <div class="form-group text-right m-b-0">
										<button class="btn btn-primary waves-effect waves-light"
											type="submit">Save</button>
											</div>
                                        </div>
                                    </f:form>
                                </div>
                            </div>
                            <!-- end col -->

                            

                             <!-- end col -->

                        </div>
                        <!-- end row -->
                        
                    </div> <!-- end container-fluid -->

                </div> <!-- end content -->

                

                <!-- Footer Start -->
                <jsp:include page="footer.jsp"></jsp:include>
                <!-- end Footer -->

            </div>

            <!-- ============================================================== -->
            <!-- End Page content -->
            <!-- ============================================================== -->

        </div>
        <!-- END wrapper -->

        <!-- Right Sidebar -->
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
        
    
</body></html>