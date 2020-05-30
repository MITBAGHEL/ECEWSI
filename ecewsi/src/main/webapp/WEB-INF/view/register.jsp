<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8" />
        <title>ECEWSI</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

        <!-- App favicon -->
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/images/favicon.ico">

        <!-- App css -->
        <link href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/adminResources/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/adminResources/css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/adminResources/css/style.css" rel="stylesheet" type="text/css" />

        <script src="<%=request.getContextPath()%>/adminResources/js/modernizr.min.js"></script>

    </head>


    <body class="bg-accpunt-pages">

        <!-- HOME -->
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">

                        <div class="wrapper-page">

                            <div class="account-pages">
                                <div class="account-box">
                                    <div class="account-logo-box">
                                        <h2 class="text-uppercase text-center">
                                            <a href="index.html" class="text-success">
                                                <span><img src="<%=request.getContextPath()%>/adminResources/images/logo_dark.png" alt="" height="30"></span>
                                            </a>
                                        </h2>
                                        <h5 class="text-uppercase font-bold m-b-5 m-t-50">Register</h5>
                                      
                                    </div>
                                    <div class="account-content">
                                        <f:form class="form-horizontal" action="insert" modelAttribute="registerVO" method="post">

                                            <div class="form-group row m-b-20">
                                                <div class="col-12">
                                                    <label for="username">First Name</label>
                                                    <f:input class="form-control" type="text" path="firstName" id="username" required="" />
                                                </div>
                                            </div>
                                            
                                             <div class="form-group row m-b-20">
                                                <div class="col-12">
                                                    <label for="username">Last Name</label>
                                                    <f:input class="form-control" type="text" path="lastName" id="username" required=""/>
                                                </div>
                                            </div>

                                            <div class="form-group row m-b-20">
                                                <div class="col-12">
                                                    <label for="emailaddress">Email address</label>
                                                    <f:input class="form-control" type="email" path="loginVO.username" id="username" required="" />
                                                </div>
                                            </div>
                                            <div class="mt-3">
                                             <div class="custom-control custom-radio">
                                             <label for="emailaddress">Gender</label><br>
                                                                <f:radiobutton  id="customRadio1" path="gender" class="custom-control-input" value="male"/>
                                                                <label class="custom-control-label" for="customRadio1">Male</label>
                                                            </div>
                                                            <div class="custom-control custom-radio">
                                                                <f:radiobutton id="customRadio2" path="gender" class="custom-control-input" value="female"/>
                                                                <label class="custom-control-label" for="customRadio2">Female</label>
                                                            </div>
                                            </div>
                                            
                                            <div class="form-group row m-b-20">
                                                <div class="col-12">
                                                    <label for="username">Mobile Number</label>
                                                    <f:input class="form-control" type="number" path="mobileNumber" id="username" required=""/>
                                                </div>
                                            </div>
                                            

                                            <div class="form-group row m-b-20">
                                                <div class="col-12">
                                                    <label for="password">Password</label>
                                                    <f:input class="form-control" type="password" path="loginVO.password" required="" id="password"/>
                                                </div>
                                            </div>

                                            <div class="form-group row m-b-20">
                                                <div class="col-12">

                                                    <div class="checkbox checkbox-success">
                                                        <input id="remember" type="checkbox" checked="">
                                                        <label for="remember">
                                                            I accept <a href="#">Terms and Conditions</a>
                                                        </label>
                                                    </div>

                                                </div>
                                            </div>

                                            <div class="form-group row text-center m-t-10">
                                                <div class="col-12">
                                                    <button class="btn btn-md btn-block btn-primary waves-effect waves-light" type="submit">REGISTER</button>
                                                </div>
                                            </div>

                                        </f:form>

                                        <div class="row">
                                            <div class="col-12">
                                                <div class="text-center">
                                                    <button type="button" class="btn m-r-5 btn-facebook waves-effect waves-light">
                                                        <i class="fa fa-facebook"></i>
                                                    </button>
                                                    <button type="button" class="btn m-r-5 btn-googleplus waves-effect waves-light">
                                                        <i class="fa fa-google"></i>
                                                    </button>
                                                    <button type="button" class="btn m-r-5 btn-twitter waves-effect waves-light">
                                                        <i class="fa fa-twitter"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row m-t-50">
                                            <div class="col-12 text-center">
                                                <p class="text-muted">Already have an account?  <a href="login" class="text-dark m-l-5"><b>Sign In</b></a></p>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <!-- end card-box-->
                            </div>


                        </div>
                        <!-- end wrapper -->

                    </div>
                </div>
            </div>
          </section>
          <!-- END HOME -->



        <script>
            var resizefunc = [];
        </script>

        <!-- jQuery  -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/popper.min.js"></script><!-- Popper for Bootstrap -->
        <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/metisMenu.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/waves.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.slimscroll.js"></script>

        <!-- App js -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.core.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.app.js"></script>

    </body>
</html>

</body>
</html>