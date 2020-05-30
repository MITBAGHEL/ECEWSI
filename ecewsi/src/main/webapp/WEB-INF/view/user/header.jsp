<!-- Top Bar Start -->
<%@page import="com.ecewsi.model.RegisterVO"%>
<%@page import="com.ecewsi.model.LoginVO"%>
<%@page import="javax.imageio.spi.RegisterableService"%>
<%@page import="com.ecewsi.utils.Basemethods"%>
<%@page import="com.ecewsi.model.RegisterVO"%>
<div class="topbar">

	<!-- LOGO -->
	<div class="topbar-left">
		<a href="index.html" class="logo"> <span> <img
				src="<%=request.getContextPath()%>/adminResources/images/logo.png"
				alt="" style="font-size: 10px; height: 34px; margin-top: 14px;">
		</span> <i> <img
				src="<%=request.getContextPath()%>/adminResources/images/logo_sm.png"
				alt="">
		</i>
		</a>
	</div>

	<nav class="navbar-custom">

		<ul class="list-inline float-right mb-0">


			<li class="list-inline-item dropdown notification-list"><a
				class="nav-link dropdown-toggle waves-effect waves-light nav-user"
				data-toggle="dropdown" href="#" role="button" aria-haspopup="false"
				aria-expanded="false"> <img
					src="<%=request.getContextPath()%>/adminResources/images/avatar_admin.png"
					alt="user" class="rounded-circle"
					style="font-size: 10px; height: 34px; margin-top: 14px;">
			</a>
				<div class="dropdown-menu dropdown-menu-right profile-dropdown "
					aria-labelledby="Preview">
					<!-- item-->
					<div class="dropdown-item noti-title">
						<h5 class="text-overflow">
							<small>Welcome</small>
						</h5>
					</div>

					<!-- item-->


					<a href="editProfileData" class="dropdown-item notify-item"> <i
						class="mdi mdi-account-circle"></i> <span>Profile</span>
					</a>

					<!-- item-->

					<a href="/logout" class="dropdown-item notify-item"> <i
						class="mdi mdi-power"></i> <span>Logout</span>
					</a>

				</div></li>

		</ul>

		<ul class="list-inline menu-left mb-0">
			<li class="float-left">
				<button
					class="button-menu-mobile open-left waves-light waves-effect">
					<i class="dripicons-menu"></i>
				</button>
			</li>

		</ul>

	</nav>

</div>
<!-- Top Bar End -->