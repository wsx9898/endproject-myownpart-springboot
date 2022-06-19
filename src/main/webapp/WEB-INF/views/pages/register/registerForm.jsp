<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="author" content="">
<title>測試會員後端介面</title>
<link rel="icon" href="images/favicon.ico" type="image/x-icon" />
<!-- Mobile Specific -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- CSS Style -->
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../../css/font-awesome.css"
	media="all">
<link rel="stylesheet" type="text/css" href="../../css/font-face-css.css">
<link rel="stylesheet" type="text/css" href="../../css/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="../../css/jquery.mobile-menu.css">
<link rel="stylesheet" type="text/css" href="../../css/style.css" media="all">
<link rel="stylesheet" type="text/css" href="../../css/revslider.css">
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">
<script type="text/javascript">
	function clearForm() {
		var inputs = document.getElementsByTagName("input");
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].type == "text") {
				inputs[i].value = "";
			}
		}
	}
</script>
</head>
<body>
<h1>JSP版本</h1>
	<div id="page">
		<!-- main-container -->
		<div class="main-container col2-right-layout">
			<div class="main container">
				<div class="row">
					<section class="col-sm-9">
					<div class="col-main">
						<div class="page-title">
							<h2>註冊</h2>
						</div>
						<div class="static-contain">
						<form action="<c:url value="/api/member/new" />" method="post">
							<fieldset class="group-select">
								<ul>
									<li id="billing-new-address-form">
										<fieldset>
											<ul>
												<li>
													<div class="input-box member-account">
														<label for="memberAccouunt">帳 號<span
															class="required">*</span>
														</label><br> <input type="text" id="memberAccouunt"
															name="memberAccouunt" value="${param.memberAccouunt}"
															title="Account" class="input-text "><br>
															<span class="error">${errors.memberAccouunt}</span>
													</div>
												</li>

												<li>
													<div class="input-box member-password">
														<label for="memberPassword">密 碼<span
															class="required">*</span>
														</label><br> <input type="text" id="memberPassword"
															name="memberPassword" value="${param.memberPassword}"
															title="Password" class="input-text"><br>
															<span class="error">${errors.memberPassword}</span>
													</div>

												</li>
												<hr>
												<li>
													<div class="customer-name">
														<div class="input-box name-lastname">
															<label for="memberLastname">姓 氏<span
																class="required">*</span></label><br> <input type="text"
																id="memberLastname" name="memberLastname"
																value="${param.memberLastname}" title="Last Name"
																class="input-text "><br>
																<span class="error">${errors.memberLastname}</span>
														</div>
														<div class="input-box name-firstname">
															<label for="memberFirstname">名 字<span
																class="required">*</span></label><br> <input type="text"
																id="memberFirstname" name="memberFirstname"
																value="${param.memberFirstname}" title="First Name"
																class="input-text"><br>
																<span class="error">${errors.memberFirstname}</span>
														</div>
													</div>
												</li>

												<li>
													<div class="input-box">
														<label for="memberBirth">生 日</label><br> <input
															type="text" id="memberBirth" name="memberBirth"
															value="${param.memberBirth}" title="Birthday"
															class="input-text"><br>
															<span class="error">${errors.memberBirth}</span>
													</div>

													<div class="input-box">
														<label f>性 別</label><br>
															<input type="radio" id="man" name="memberGender" value="male" checked>
															  <label for="man">男生</label><br>
															  <input type="radio" id="woman" name="memberGender" value="female">
															  <label for="woman">女生</label><br>
															<br>
															<span class="error">${errors.memberGender}</span>
													</div>
												</li>
												<li>
													<div class="input-box">
														<label for="memberNickname">暱 稱</label><br> <input type="text"
															id="memberNickname" name="memberNickname"
															value="${param.memberNickname}" title="NickName"
															class="input-text "><br>
															<span class="error">${errors.memberNickname}</span>
													</div>
												</li>
												<li>
													<div class="input-box">
														<label for="memberEmail">電子信箱 <span
															class="required">*</span></label><br> <input type="text"
															name="memberEmail" id="memberEmail"
															value="${param.memberEmail}" title="Email Address"
															class="input-text validate-email"><br><br>
															<span class="error">${errors.memberEmail}</span>
													</div>
												</li>

												<li>
													<div class="input-box">
														<label for="memberTel">手 機 </label><br>
														<input type="text" name="memberTel" id="memberTel"
															value="${param.memberTel}" title="Cellphone"
															class="input-text required-entry"><br>
															<span class="error">${errors.memberTel}</span>
													</div>
												</li>

												<li><label>地 址 </label><br>
													<input type="text" title="Street Address" id="memberAddr"
													name="memberAddr" value="${param.memberAddr}"
													class="input-text required-entry"></li><br>
													<span class="error">${errors.memberAddr}</span>
											</ul>
										</fieldset>
									</li>
									<li class="require"><em class="required">* </em>必填</li>
									<!-- <li class="buttons-set">
										<button type="submit" name="prodaction" value="Insert">提 交</button>
									</li> -->
								</ul>
								<table>
									<tr>
										<td>
											<!-- <input type="submit" name="prodaction" value="Insert"> -->
											<input type="submit" name="prodaction" value="提交">
											<!-- <input type="submit" name="prodaction" value="Update"> -->
											<!-- <input type="submit" name="prodaction" value="Select"> -->
											<input type="button" value="Clear" onclick="clearForm()">
										</td>
									</tr>
								</table>
							</fieldset>
							</form>
						</div>
					</div>
					</section>
				</div>
			</div>
		</div>
		<!--End main-container -->
		
		<c:if test="${not empty insert}">
<h3>Insert Members Table Success</h3>
<table border="1">
	<tr><td>memberId</td><td>${insert.memberId}</td></tr>
	<tr><td>memberAccouunt</td><td>${insert.memberAccouunt}</td></tr>
	<tr><td>memberPassword</td><td>${insert.memberPassword}</td></tr>
	<tr><td>memberLastname</td><td>${insert.memberLastname}</td></tr>
	<tr><td>memberFirstname</td><td>${insert.memberFirstname}</td></tr>
	<tr><td>memberGender</td><td>${insert.memberGender}</td></tr>
	<tr><td>memberNickname</td><td>${insert.memberNickname}</td></tr>
	<tr><td>memberEmail</td><td>${insert.memberEmail}</td></tr>
	<tr><td>memberTel</td><td>${insert.memberTel}</td></tr>
	<tr><td>memberAddr</td><td>${insert.memberAddr}</td></tr>
	<tr><td>memberBirth</td><td>${insert.memberBirth}</td></tr>
	<tr><td>createUser</td><td>${insert.createUser}</td></tr>
	<tr><td>createDate</td><td>${insert.createDate}</td></tr>
	<tr><td>updateUser</td><td>${insert.updateUser}</td></tr>
	<tr><td>updateDate</td><td>${insert.updateDate}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>
		
		
		
	</div>
	<!-- JavaScript -->
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/bootstrap.min.js"></script>
	<script src="../../js/revslider.js"></script>
	<script src="../../js/common.js"></script>
	<script src="../../js/owl.carousel.min.js"></script>
	<script src="../../js/jquery.mobile-menu.min.js"></script>
</body>
</html>