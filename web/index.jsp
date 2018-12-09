<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>
<body>
	<jsp:include page="header.jsp">
		<jsp:param name="title" value="Home" />
	</jsp:include>
	<main>
		<c:if test="${not empty success}">
			<div class="safe">
				<p>${success}</p>
			</div>
		</c:if>

<c:if test="${errors.size()>0 }">
	<div class="danger">
		<ul>
			<c:forEach var="error" items="${errors }">
				<li>${error }</li>
			</c:forEach>
		</ul>
	</div>
</c:if> <c:choose>
	<c:when test="${user!=null}">
		<p>Welcome ${user.getFirstName()}!</p>
		<form method="post" action="Controller?action=LogOut">
			<p>
				<input type="submit" id="logoutbutton" value="Log Out">
			</p>
		</form>
	</c:when>
	<c:otherwise>

		<p>Log in:</p>
		<form method="post" action="Controller?action=LogIn">
				<p>
					<label for="email">Your email </label>
					<input type="text" id="email" name="email" value="jan@ucll.be">
				</p>
				<p>
					<label for="password">Your password</label>
					<input type="password" id="password" name="password" value="t">
				</p>
				<p>
					<input type="submit" id="loginbutton" value="Log in">
				</p>
		</form>

		<p id="register">Register here!</p>
		<c:if test="${errorsSignUp.size()>0 }">
			<div class="danger">
				<ul>
					<c:forEach var="errorSignUp" items="${errorsSignUp }">
						<li>${errorSignUp }</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<form method="post" action="Controller?action=SignUp" novalidate="novalidate">
			<p>
				<label for="newEmail">Email: </label>
				<input type="text" id="newEmail" name="newEmail" placeholder="jan@ucll.be">
			</p>
			<p>
				<label for="newPassword">Password: </label>
				<input type="password" id="newPassword" name="newPassword">
			</p>
			<p>
				<label for="newPasswordRepeat">Repeat the password: </label>
				<input type="password" id="newPasswordRepeat" name="newPasswordRepeat">
			</p>
			<p>
				<label for="newFirstName">First name: </label>
				<input type="text" id="newFirstName" name="newFirstName">
			</p>
			<p>
				<label for="newLastName">Last name: </label>
				<input type="text" id="newLastName" name="newLastName">
			</p>
			<p>
				<label for="newGender">Gender: </label>
				<input type="text" id="newGender" name="newGender" placeholder="male, female, other, ...">
			</p>
			<p>
				<label for="newAge">Age: </label>
				<input type="number" id="newAge" name="newAge">
			</p>
			<p>
				<input type="submit" id="registerButton" value="Sign Up">
			</p>
		</form>

	</c:otherwise>
</c:choose> </main>

	<jsp:include page="footer.jsp">
		<jsp:param name="title" value="Home" />
	</jsp:include>
</body>
</html>