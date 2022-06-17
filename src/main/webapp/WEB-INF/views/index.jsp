<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

<h1>我成功來到index.jsp了</h1>

<h3>Welcome ${user.custid}</h3>

<h3><a href="<c:url value="/secure/login.view" />">Login</a></h3>
<h3><a href="<c:url value="/pages/register/registerForm.view" />">MembersForm</a></h3>
<h3><a href="<c:url value="loginKevin.view" />">LoginKevin</a></h3>
<h3><a href="<c:url value="/secure/loginTony.view" />">LoginTony</a></h3>

<%--Thymeleaf每次都要去SpringMVCJavaConfig額外標註--%>
<h3><a href="<c:url value="/EndProject/KevinProductInfo.view" />">KevinProductInfo.html</a></h3>
<h3><a href="<c:url value="/EndProject/KevinNewCart.view" />">KevinNewCart.html</a></h3>
<h3><a href="<c:url value="/registerFormHTML.view" />">MembersForm.html</a></h3>
<h3><a href="<c:url value="/KevinDashBoard.view" />">KevinDashBoard.html</a></h3>

</body>
</html>