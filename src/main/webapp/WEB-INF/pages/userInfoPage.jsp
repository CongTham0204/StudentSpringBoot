
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Student</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="js/bootstrap/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="js/jquery/jquery.min.js"></script>
<script src="js/jquery/jquery-1.11.2.min.js"></script>

<script src="js/bootstrap/js/bootstrap.min.js"></script>
<!-- Custom styles for this template -->
<link href="css/shop-homepage.css" rel="stylesheet">

<link href="css/search.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Student</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Đăng
							kí môn học <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Tin tức</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Liên hệ</a>
					</li>
					<li class="nav-item"><c:if
							test="${pageContext.request.userPrincipal.name != null}">


							<a class="nav-link"
								href="${pageContext.request.contextPath}/logout">Logout</a>

						</c:if></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3 ">

				<h1 class="my-4">Thông tin sinh viên</h1>
				<div class="card border border-danger">
					<div class="card-body ">
						<div class="row justify-content-center align-items-center">

							<form id="submitImg">

								<label for="fileInput" class="custom-file-upload"> <i
									class="fa fa-cloud-upload"></i> Chọn ảnh
								</label> <input id="fileInput" name='upload_cont_img' type="file"
									style="display: none;"  class="form-control" />
								<div class="container">
									<div class="row">
										<div class="col text-center">
											<button type="submit" class="btn btn-success btn-sm ">Lưu
												lại</button>
										</div>
									</div>
								</div>
								
								<div>
									<h2  class="text-info">Avatar</h2>
								</div>
							</form>

						
							<table>
							
								<tr>

								</tr>
								<tr>
									<td><img id="imageShow" src="" alt="Girl in a jacket"
										width="200" height="200"></td>
								</tr>
							</table>
							${file.contentType}
						</div>
						<div class="card-title  ">

							<p>
								<b>Mã sinh viên :</b> ${student.id}
							</p>
							<p>
								<b>Họ tên :</b>${student.name}
							</p>
							<p>
								<b>Giới tính :</b> ${student.sex}
							</p>

						</div>

						<div class="row">
							<div class="social">
								<a href="#"><i class="fa fa-dribbble"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-linkedin"></i></a> <a href="https://www.facebook.com/"><i
									class="fa fa-facebook"></i></a>
							</div>
						</div>
					</div>

					<div class="social">
						<button id="subjectRegis"
							class="btn btn-danger btn btn-primary btn-lg btn-block">Môn
							đã đăng kí</button>
						<br>
						<button href="#"
							class="btn btn-warning btn btn-primary btn-lg btn-block">Lịch
							học</button>
						<br>
						<button href="#"
							class="btn btn-info btn btn-primary btn-lg btn-block">Bảng
							điểm</button>


					</div>



				</div>
			</div>


			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div id="carouselExampleIndicators " class="carousel slide my-4 "
					data-ride="carousel">
					<div class="input-group md-form form-sm form-2 pl-0">
						<input class="form-control my-0 py-1 amber-border" type="text"
							placeholder="Gõ tên môn học..." aria-label="Search"
							id="inputsearch">
						<button class="btn btn-outline-warning btn-rounded btn-sm my-0"
							type="submit" id="search">Search</button>
					</div>

				</div>

				<div class="row" id="listSubject">

					<div class="col-lg-4 col-md-6 mb-4 ">

						<div class="card   border border-warning"
							style="max-width: 18rem;">
							<div class="card-header col text-center">
								<h4>
									TOÁN CAO CẤP
									</h3>
							</div>
							<div class="card-body">
								<h5 class="card-title">
									<h4>
										<center>Thông tin môn</center>
									</h4>
									<br> <a>Mã môn:11102222</a> <br>
									<a1>Tên môn:Toán cao cấp</a1>
									<br> <a>Giáo viên:Huấn hoa hồng</a> <br> <a>Thời
										gian:7h00</a> <br> <a>Thời gian kết thúc:9h00</a> <br> <a>Số
										chỗ còn lại:24</a>
								</h5>
								<p class="card-text"></p>
							</div>
							<div class="card-footer col text-center">

								<button type="button" class="btn btn-success ">Đăng kí</button>

							</div>
						</div>


					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card   border border-warning"
							style="max-width: 18rem;">
							<div class="card-header col text-center">
								<h4>
									TOÁN CAO CẤP
									</h3>
							</div>
							<div class="card-body">
								<h5 class="card-title">
									<h4>
										<center>Thông tin môn</center>
									</h4>
									<br> <a>Mã môn:11102222</a> <br>
									<a1>Tên môn:Toán cao cấp</a1>
									<br> <a>Giáo viên:Huấn hoa hồng</a> <br> <a>Thời
										gian:7h00-9h00</a> <br> <a>Số chỗ còn lại:24</a>
								</h5>
								<p class="card-text"></p>
							</div>
							<div class="card-footer col text-center">

								<button type="button" class="btn btn-success ">Đăng kí</button>

							</div>
						</div>

					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card   border border-warning"
							style="max-width: 18rem;">
							<div class="card-header col text-center">
								<h4>
									TOÁN CAO CẤP
									</h3>
							</div>
							<div class="card-body">
								<h5 class="card-title">
									<h4>
										<center>Thông tin môn</center>
									</h4>
									<br> <a>Mã môn:11102222</a> <br>
									<a1>Tên môn:Toán cao cấp</a1>
									<br> <a>Giáo viên:Huấn hoa hồng</a> <br> <a>Thời
										gian:7h00-9h00</a> <br> <a>Số chỗ còn lại:24</a>
								</h5>
								<p class="card-text"></p>
							</div>
							<div class="card-footer col text-center">

								<button type="button" class="btn btn-success ">Đăng kí</button>

							</div>
						</div>

					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card   border border-warning"
							style="max-width: 18rem;">
							<div class="card-header col text-center">
								<h4>
									TOÁN CAO CẤP
									</h3>
							</div>
							<div class="card-body">
								<h5 class="card-title">
									<h4>
										<center>Thông tin môn</center>
									</h4>
									<br> <a>Mã môn:11102222</a> <br>
									<a1>Tên môn:Toán cao cấp</a1>
									<br> <a>Giáo viên:Huấn hoa hồng</a> <br> <a>Thời
										gian:7h00-9h00</a> <br> <a>Số chỗ còn lại:24</a>
								</h5>
								<p class="card-text"></p>
							</div>
							<div class="card-footer col text-center">

								<button type="button" class="btn btn-success ">Đăng kí</button>

							</div>
						</div>

					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card   border border-warning"
							style="max-width: 18rem;">
							<div class="card-header col text-center">
								<h4>
									TOÁN CAO CẤP
									</h3>
							</div>
							<div class="card-body">
								<h5 class="card-title">
									<h4>
										<center>Thông tin môn</center>
									</h4>
									<br> <a>Mã môn:11102222</a> <br>
									<a1>Tên môn:Toán cao cấp</a1>
									<br> <a>Giáo viên:Huấn hoa hồng</a> <br> <a>Thời
										gian:7h00-9h00</a> <br> <a>Số chỗ còn lại:24</a>
								</h5>
								<p class="card-text"></p>
							</div>
							<div class="card-footer col text-center">

								<button type="button" class="btn btn-success ">Đăng kí</button>

							</div>
						</div>

					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card   border border-warning"
							style="max-width: 18rem;">
							<div class="card-header col text-center">
								<h4>
									TOÁN CAO CẤP
									</h3>
							</div>
							<div class="card-body">
								<h5 class="card-title">
									<h4>
										<center>Thông tin môn</center>
									</h4>
									<br> <a>Mã môn:11102222</a> <br>
									<a1>Tên môn:Toán cao cấp</a1>
									<br> <a>Giáo viên:Huấn hoa hồng</a> <br> <a>Thời
										gian:7h00-9h00</a> <br> <a>Số chỗ còn lại:24</a>
								</h5>
								<p class="card-text"></p>
							</div>
							<div class="card-footer col text-center">

								<button type="button" class="btn btn-success ">Đăng kí</button>

							</div>
						</div>

					</div>
					<!-- /.row -->

				</div>
				<!-- /.col-lg-9 -->

			</div>
			<!-- /.row -->

		</div>

		<!-- /.container -->

		<!-- Footer -->
		<footer class="py-5 bg-dark">
			<div class="container">
				<p class="m-0 text-center text-white">Copyright &copy; Your
					Website 2020</p>
			</div>
			<!-- /.container -->
		</footer>
</body>
<script>
	$(document).ready(function() {

		loadAvatar();
		$("#listSubject").empty();
		$(document).on('click', '#search', function() {

			searchSubject();
		});

		$("#submitImg").submit(function(event) {

			event.preventDefault();
			submitImg();

		});

	});

	function submitImg() {

		var file = document.getElementById("fileInput").files[0];
		var form = new FormData();
		form.append('file', file);

		$.ajax({
			type : "POST",
			contentType : false,
			processData : false,
			url : "http://localhost:8080/uploadFile",
			data : form,
			timeout : 100000,
			success : function(response) {
				$("#imageShow").attr('src',
						'data:image/jpeg;base64,' + response);

			}
		});

	}

	function loadAvatar() {
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "http://localhost:8080/uploadFile/",
			timeout : 100000,
			success : function(response) {

				$("#imageShow").attr('src',
						'data:image/jpeg;base64,' + response);
			}
		});

	}

	//////////////////////

	$(document).on('click', '#subjectRegis', function() {
		$("#listSubject").empty();
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "http://localhost:8080/regisSubjects/",
			timeout : 100000,
			success : function(response) {

				response.forEach(function(subject) {
					var card = createCardNoButton(subject);
					$("#listSubject").append(card);

				});
			}
		});
	});

	/////////////////
	$(document).on('click', '#buttonregis', function() {
		var button = $(this).parent().parent();
		var id = button.find("#idSub").html();
		console.log(id);
		var url = "http://localhost:8080/registerSubject/" + id;
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : url,
			timeout : 100000,
			success : function(response) {
				if (response == true) {
					alert("Đăng kí thành công");
				} else {
					alert("Bạn đã đăng kí môn này hoặc hết chỗ");
				}
			},
			error : function(error) {
				alert("Bạn đã đăng kí môn này");

			}
		});
	});

	function searchSubject() {
		var data = {}
		data["nameSubject"] = $("#inputsearch").val();
		console.log(data);
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "http://localhost:8080/search",
			data : JSON.stringify(data),
			dataType : 'json',
			timeout : 100000,

			success : function(response) {
				console.log(response.length);
				if (response.length == 0) {
					alert("Không tìm thấy môn nào");
					return;
				}

				console.log("SUCCESS: ", response);
				alert("Tìm thấy thành công ");
				$("#listSubject").empty();
				response.forEach(function(subject) {

					var card = createCardView(subject);
					$("#listSubject").append(card);

				});
			},
		});
	}

	function createCardView(subject) {
		var startTime = subject.startTime.replace("T", " ");
		var stopTime = subject.stopTime.replace("T", " ");
		var card = "<div class='col-lg-4 col-md-6 mb-4'>"
				+ "<div class='card   border border-warning' style='max-width: 18rem;'>"
				+ "<div class='card-header col text-center'>" + "<h4>"
				+ subject.nameSubject
				+ "</h3></div>"
				+ "<div class='card-body'>"
				+ "<h5 class='card-title'>"
				+ "<h4><center>Thông tin môn</center> </h4><br>"
				+ "<a><b>Mã môn:</b><p id='idSub'>"
				+ subject.idSubject
				+ "</p></a> <br>"
				+ "<a><b>Tên môn:</b>"
				+ subject.nameSubject
				+ "</a>"
				+ "<br>"
				+ "<a><b>Giáo viên:</b>"
				+ subject.nameTeacher
				+ "</a> <br>"
				+ "<a><b>Thời gian bắt đầu:</b>"
				+ startTime
				+ "</a> <br>"
				+ "<a><b>Thời gian kết thúc:</b>"
				+ stopTime
				+ "</a><br>"
				+ "<a><b>Số chỗ còn lại:</b>"
				+ subject.numberSeats
				+ "</a></h5>"
				+ "</div><div class='card-footer col text-center'>"
				+ "<button id='buttonregis' type='button' class='btn btn-success'>Đăng kí</button></div></div></div>"

		return card;
	};

	function createCardNoButton(subject) {
		var startTime = subject.startTime.replace("T", " ");
		var stopTime = subject.stopTime.replace("T", " ");
		var card = "<div class='col-lg-4 col-md-6 mb-4'>"
				+ "<div class='card   border border-warning' style='max-width: 18rem;'>"
				+ "<div class='card-header col text-center'>" + "<h4>"
				+ subject.nameSubject
				+ "</h3></div>"
				+ "<div class='card-body'>"
				+ "<h5 class='card-title'>"
				+ "<h4><center>Thông tin môn</center> </h4><br>"
				+ "<a><b>Mã môn:</b><p id='idSub'>"
				+ subject.idSubject
				+ "</p></a> <br>"
				+ "<a><b>Tên môn:</b>"
				+ subject.nameSubject
				+ "</a>"
				+ "<br>"
				+ "<a><b>Giáo viên:</b>"
				+ subject.nameTeacher
				+ "</a> <br>"
				+ "<a><b>Thời gian bắt đầu:</b>"
				+ startTime
				+ "</a> <br>"
				+ "<a><b>Thời gian kết thúc:</b>"
				+ stopTime
				+ "</a><br>"
				+ "<a><b>Số chỗ còn lại:</b>"
				+ subject.numberSeats
				+ "</a></h5>"
				+ "</div><div class='card-footer col text-center'>"
				+ "<button id='buttonnotregister' type='button' class='btn btn-danger'>Hủy đăng kí</button></div></div></div>"

		return card;
	};
</script>
</html>
