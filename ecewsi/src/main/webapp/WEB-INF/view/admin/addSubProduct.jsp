<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
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


    <body>

        <!-- Begin page -->
        <div id="wrapper">
        <jsp:include page="header.jsp"></jsp:include>

            <!-- Top Bar Start -->
            
            
            
            
            
            
            
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
                                    <h4 class="page-title float-left">ADD SUBPRODUCT</h4>

                                    <ol class="breadcrumb float-right">
                                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                                        <li class="breadcrumb-item"><a href="#">Manage SubProduct</a></li>
                                        <li class="breadcrumb-item active">Add SubProduct</li>
                                    </ol>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->



                        <div class="row">
                            <div class="col-lg-12">
                                <div class="card-box">
                                    <s:form  modelAttribute="SubProductVO" action="insertSubProduct" method="post" enctype="multipart/form-data">
                                        
                                         <div class="form-group">
                                            <label class="col-4 col-form-label">Add Category-Type<span class="text-danger">*</span></label>
                                                                    <div class="col-md-14">
                                                                       <s:select path="CategoryVO.id" class="form-control">
                                                                           <c:forEach var="i" items="${categoryList}" >
                                                                          <s:option value="${i.id}"> ${i.categoryName}</s:option>
                                                                           </c:forEach>
                                                                        </s:select>
                                                                    </div>
                                        </div>

                                        <div class="form-group">
                                             <label class="col-4 col-form-label">Add SubCategory<span class="text-danger">*</span></label>
                                                                    <div class="col-md-14">
                                                                         <s:select path="SubCategoryVO.id" class="form-control">
                                                                           <c:forEach var="i" items="${subCategoryList}" >
                                                                          <s:option value="${i.id}"> ${i.subCategoryName}</s:option>
                                                                           </c:forEach>
                                                                        </s:select>
                                                                        
                                                                    </div>
                                        </div>
                                        
                                        <div class="form-group">
                                             <label class="col-4 col-form-label">Add Floor<span class="text-danger">*</span></label>
                                                                    <div class="col-md-14">
                                                                         <s:select path="FloorVO.id" class="form-control">
                                                                           <c:forEach var="i" items="${floorList}" >
                                                                          <s:option value="${i.id}"> ${i.floor}</s:option>
                                                                           </c:forEach>
                                                                        </s:select>
                                                                        
                                                                    </div>
                                        </div>
                                        
                                        <div class="form-group">
                                             <label class="col-4 col-form-label">Add Block<span class="text-danger">*</span></label>
                                                                    <div class="col-md-14">
                                                                         <s:select path="BlockVO.id" class="form-control">
                                                                           <c:forEach var="i" items="${blockList}" >
                                                                          <s:option value="${i.id}"> ${i.block}</s:option>
                                                                           </c:forEach>
                                                                        </s:select>
                                                                        
                                                                    </div>
                                        </div>
                           
                                        
                                        
                                        
                                         <div class="form-group">
                                            <label class="col-4 col-form-label">Add SubProductName</label>
                                            <s:input type="text" class="form-control" path="subProductName" />
                                        </div>
                                        
                                          <div class="form-group">
                                            <label class="col-4 col-form-label">Add Price<span class="text-danger">*</span></label>
                                                                    <div class="col-md-14">
                                                                     <s:input type="text" class="form-control" path="price" />
                                                                    </div>
                                       	  </div>
                                       	  
                                       	   <div class="form-group">
                                            <label class="col-4 col-form-label">Add Color<span class="text-danger">*</span></label>
                                                                    <div class="col-md-14">
                                                                     <s:input type="text" class="form-control" path="color" />
                                                                    </div>
                                       	  </div>
                                       	  
                                       	  <div class="form-group">
                                            <label class="col-4 col-form-label">Add Brand Type<span class="text-danger">*</span></label>
                                                                    <div class="col-md-14">
                                                                       <s:select path="ProductVO.id" class="form-control">
                                                                           <c:forEach var="i" items="${productList}" >
                                                                          <s:option value="${i.id}"> ${i.brandName}</s:option>
                                                                           </c:forEach>
                                                                        </s:select>
                                                                    </div>
                                        </div>
                                       
                                        

                                   
                                        
                                         <div class="form-group">
                                           <label class="col-4 col-form-label">Add Rack<span class="text-danger">*</span></label>
                                                                    <div class="col-md-14">
                                                                       <s:select path="RackVO.id" class="form-control">
                                                                           <c:forEach var="i" items="${rackList}" >
                                                                          <s:option value="${i.id}"> ${i.rack}</s:option>
                                                                           </c:forEach>
                                                                        </s:select>
                                                                    </div>
                                        </div>
                                        
                                        <div class="form-group">
                                           <label class="col-4 col-form-label">Add Store<span class="text-danger">*</span></label>
                                                                    <div class="col-md-14">
                                                                       <s:select path="StoreVO.id" class="form-control">
                                                                           <c:forEach var="i" items="${storeList}" >
                                                                          <s:option value="${i.id}"> ${i.storeName}</s:option>
                                                                           </c:forEach>
                                                                        </s:select>
                                                                    </div>
                                        </div>
                                        
                                        
                                        
                                        
                                        <div class="form-group">
                                            <h5>Attach File <span class="text-danger">*</span></h5>
                                           	<input type="file" class="form-control" required="required" name="file"/>
                                        </div>
                                        
                                        <s:hidden path="id"/>
                                        
                                        <div class="form-group">
                                            <label class="col-4 col-form-label">SubProduct Description</label>
                                            <div>
                                                <s:textarea  class="form-control" path="subProductDiscription"></s:textarea>
                                            </div>
                                        </div>
                                        
                                        
                                                    
                                        
                                       
                                          <div class="form-group text-right m-b-0">
                                            <button class="btn btn-primary waves-effect waves-light" type="submit">
                                               Save
                                            </button>
                                        </div>
                                    </s:form>
                                </div>
                            </div>

                            <div class="col-lg-6">
                               
                        </div>
                        <!-- end row -->


                    </div> <!-- container -->

                </div> <!-- content -->

                <jsp:include page="footer.jsp"></jsp:include>

            </div>


            <!-- ============================================================== -->
            <!-- End Right content here -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->



        <!-- jQuery  -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/popper.min.js"></script><!-- Popper for Bootstrap -->
        <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/metisMenu.min.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/waves.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.slimscroll.js"></script>

        <!-- Parsley js -->
        <script type="text/javascript" src="<%=request.getContextPath()%>/adminResources/js/parsley.min.js"></script>

        <!-- App js -->
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.core.js"></script>
        <script src="<%=request.getContextPath()%>/adminResources/js/jquery.app.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('form').parsley();
            });
        </script>

    </body>
</html>