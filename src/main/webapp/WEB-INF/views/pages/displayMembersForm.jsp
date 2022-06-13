<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Display</title>
</head>
<body>

<h3>Select Members Table Result : ${fn:length(select)} row(s) selected</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>memberId</th>
		<th>memberAccouunt</th>
		<th>memberPassword</th>
		<th>memberLastname</th>
		<th>memberFirstname</th>
		<th>memberGender</th>
		<th>memberNickname</th>
		<th>memberEmail</th>
		<th>memberTel</th>
		<th>memberAddr</th>
		<th>memberBirth</th>
		<th>createUser</th>
		<th>createDate</th>
		<th>updateUser</th>
		<th>updateDate</th>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="row" items="${select}">
		<c:url value="/pages/register/registerForm.view" var="path">
			<c:param name="memberId" value="${row.memberId}" />
			<c:param name="memberAccouunt" value="${row.memberAccouunt}" />
			<c:param name="memberPassword" value="${row.memberPassword}" />
			<c:param name="memberLastname" value="${row.memberLastname}" />
			<c:param name="memberFirstname" value="${row.memberFirstname}" />
			<c:param name="memberGender" value="${row.memberGender}" />
			<c:param name="memberNickname" value="${row.memberNickname}" />
			<c:param name="memberEmail" value="${row.memberEmail}" />
			<c:param name="memberTel" value="${row.memberTel}" />
			<c:param name="memberAddr" value="${row.memberAddr}" />
			<c:param name="memberBirth" value="${row.memberBirth}" />
			<c:param name="createUser" value="${row.createUser}" />
			<c:param name="createDate" value="${row.createDate}" />
			<c:param name="updateUser" value="${row.updateUser}" />
			<c:param name="updateDate" value="${row.updateDate}" />
		</c:url>
	<tr>
		<td><a href="${path}">${row.memberId}</a></td>
		<td>${row.memberAccouunt}</td>
		<td>${row.memberPassword}</td>
		<td>${row.memberLastname}</td>
		<td>${row.memberFirstname}</td>
		<td>${row.memberGender}</td>
		<td>${row.memberNickname}</td>
		<td>${row.memberEmail}</td>
		<td>${row.memberTel}</td>
		<td>${row.memberAddr}</td>
		<td>${row.memberBirth}</td>
		<td>${row.createUser}</td>
		<td>${row.createDate}</td>
		<td>${row.updateUser}</td>
		<td>${row.updateDate}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/pages/members.jsp" />">Members Table</a></h3>

</body>
</html>